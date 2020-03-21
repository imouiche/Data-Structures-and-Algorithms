package com.codewithinoussa.WeightedGraphs;

import java.util.*;

public class WeightedGraph {

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }
        @Override
        public String toString(){
            return label;
        }
    }

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

   private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Edge>> adjancyList = new HashMap<>();

    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjancyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjancyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjancyList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print(){
        for (var source : adjancyList.keySet()){
            var edgeLists = adjancyList.get(source);
            if (!edgeLists.isEmpty())
                System.out.println(source + " is linked to " + edgeLists);
        }
    }

}
