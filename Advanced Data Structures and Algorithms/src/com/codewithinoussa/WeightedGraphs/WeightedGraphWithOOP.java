package com.codewithinoussa.WeightedGraphs;

import com.sun.source.tree.*;

import java.util.*;

/*
Nodes and Edges are directly related. It'll be good if we can navigated to edges directly from a node
 */
public class WeightedGraphWithOOP {
    private class Node {
        private String label;
        private List<Edge> edges =  new ArrayList<>();//when we create a node its edges auto init to a new ArrayList

        public Node(String label) {
            this.label = label;
        }
        @Override
        public String toString(){
            return label;
        }

        //addEdge class
        public void addNode(Node to, int weight){
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges(){
            return edges;
        }
    }

    //Edges
    private class Edge {
        private Node from;
        private Node  to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return from + "->" + to; // A->B
        }
    }

    //Node Entry
    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    public void addNode(String label){
        //var node = new Node(label);
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        fromNode.addNode(toNode, weight);
        toNode.addNode(fromNode, weight);
    }

    public void print(){
        for (var node : nodes.values()){
            var edgeLists = node.getEdges();
            if (!edgeLists.isEmpty())
                System.out.println(node + " is linked to " + edgeLists);
        }
    }

    public Path getShortestPath(String from, String to){

        // 1-Input validation
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null) // Validation
            throw new IllegalArgumentException();

        // 2- Initialization
        // 2-a) Initialize the distance of all nodes to MAX and set the value of the starting node to zero
        Map<Node, Integer> distance = new HashMap<>();
        for (var node : nodes.values())
            distance.put(node, Integer.MAX_VALUE);

        //2- b) set the value of the starting node to 0
        distance.replace(fromNode, 0);
        //2- b) We use Map to track the previous nodes and Set to track all visited nodes
        Map<Node, Node> previousNodes = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        // 2- c) Initialize the queue for the Breadth-first search (visit node and all its neighbors - first)
        //As order/min dist did matter, let's use PriorityQueue and use distance as a measure
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
          Comparator.comparingInt(ne -> ne.priority)
        );

        // 2 -d) add our starting node to the queue //  var ne = new NodeEntry(fromNode, 0)
        queue.add(new NodeEntry(fromNode, 0));

        //3-a) Launch BFS to visit nodes and their neighbors
        while (!queue.isEmpty()){
            var current = queue.remove().node;
            visited.add(current);

            // 3-b) Visit all its unvisited neighbors: edge.to is a neighboring node
            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                // 3-c) compute a new distance
                var newDistance = distance.get(current) + edge.weight;
                // 3-d) Update the distance table with a new dist if less than the previous value,
                // update the previousNode column and add new nodes/neighbors to the queue
                if (newDistance < distance.get(edge.to)){
                    distance.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        //return distance.get(nodes.get(to)) //shortest distance
        //4 - Build the path

        return buildPath(previousNodes, toNode);
    }

    private Path buildPath(Map<Node, Node> previousNodes, Node toNode){
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        // 1- Initially add the ending node to the stack
        var previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            //1-b) get the previous node of this node
            previous = previousNodes.get(previous);
        }

        var path = new Path();
        while (!stack.isEmpty())
            path.add(stack.pop().label);

        return path;
    }

    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();

        for (var node : nodes.values()){
            if (!visited.contains(node) && hasCycle(node, null, visited))
                    return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited){
        visited.add(node);

        for (var edge : node.getEdges()) {
            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to) || hasCycle(edge.to, node, visited))
                return true;
        }
        return false;
    }

    //Prim's Algo
    public WeightedGraphWithOOP getMinimunSpanningTree(){

        var tree = new WeightedGraphWithOOP();

        if (nodes.isEmpty())
            return tree;
        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );

        // 2- pick a node and add all its edges to this PQ
        // .iterator().next(); => convert to a list and pick the first obj

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());

        //3- Add the start node to our spanning tree.
        tree.addNode(startNode.label);
        if (edges.isEmpty())
            return tree;

        // As long as our tree does not contain all nodes from our graph then ...
        while (tree.nodes.size() < nodes.size()){
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            //have we visited the target node?
            if (tree.containsNode(nextNode.label))
                continue;

            //add the next node and edge to our tree
            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

            // 4- Add all unvisited edges connected to nextNode to our PQ
            for (var edge : nextNode.getEdges())
                if (!tree.containsNode(edge.to.label))
                    edges.add(edge);
        }

        return tree;
    }

    public boolean containsNode(String label){
        return nodes.containsKey(label);
    }

}
