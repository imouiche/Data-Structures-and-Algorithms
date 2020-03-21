package com.codewithinoussa.Graphs;

import java.util.*;

public class Graph {
    private int INITIALIZER = 10;

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalArgumentException();

        //unidirected graph
        adjacencyList.get(fromNode).add(toNode);
        //adjacencyList.get(toNode).add(fromNode); // reverse to ensure bidirectionality
    }

    public void print(){
        for (var source : adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connected to " + targets);
        }
    }

    public void removeNode(String label){
        //validation
        var node = nodes.get(label);
        if (node == null)
            return;

        //remove all connections to this node
        for (var n : adjacencyList.keySet())
            adjacencyList.get(n).remove(node);

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjacencyList.get(fromNode).remove(toNode);
    }

    //Depth-First traversal, use Set to keep track of visited nodes
    public void traverseDepthFirstRec(String root){
        var node = nodes.get(root);
        if (node == null)
            return;

        traverseDepthFirstRec(nodes.get(root), new HashSet<>());
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited){
        //visit the root
        System.out.println(root);
        visited.add(root); //add visited node to the set
        // visit all neighbor of the root -> adjacencyList
        for (var node : adjacencyList.get(root))
            if (!visited.contains(node))
                traverseDepthFirstRec(node, visited);
    }

    //Depth-First traversal Iterative approach
    public void traverseDepthFirstIter(String root){
        var node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()){
            var current = stack.pop();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);
            for (var neighbor : adjacencyList.get(current))
                if (!visited.contains(neighbor))
                    stack.push(neighbor);
        }


    }

    //Depth-First traversal Iterative approach
    public void traverseBreadthFirst(String root){
        var node = nodes.get(root);
        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
       // Stack<Node> queue = new Stack<>();
        queue.add(node);

        while (!queue.isEmpty()){
            var current = queue.remove();
            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);
            for (var neighbor : adjacencyList.get(current))
                //only unvisited nodes shall be considered
                if (!visited.contains(neighbor))
                    queue.add(neighbor);
        }


    }

    //Topological Sorting
    public List<String> topologicalSorting(){
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        //depth first traversal for each and every node
        for (var node : nodes.values())
            topologicalSorting(node, visited, stack);
        //after this for loop, our stack will be populated with node in a reverse order
        List<String> sorted = new ArrayList<>();
        while(!stack.empty())
            sorted.add(stack.pop().label);
        return sorted;
    }
    private void topologicalSorting(Node node, Set<Node> visited, Stack<Node> stack){
        if (visited.contains(node))
            return;

        visited.add(node);
        // we now go deeper to find nodes that do not have any outgoing edges
        for (var neighbor : adjacencyList.get(node))
            topologicalSorting(neighbor, visited, stack);

        // we're sure to only have that node with no outgoing edges
        stack.push(node);
    }

    //Cycle Detection
    public boolean hasCycle(){
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        while (!all.isEmpty()){
           // var current = all.toArray(new Node[0])[0]; //or
            var current = all.iterator().next();
            if(hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;

    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){
        all.remove(node);
        visiting.add(node);

        for (var neighbor : adjacencyList.get(node)){
            if (visited.contains(neighbor))
                continue;
            if (visiting.contains(neighbor))
                return true;

            if (hasCycle(neighbor, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }
}
