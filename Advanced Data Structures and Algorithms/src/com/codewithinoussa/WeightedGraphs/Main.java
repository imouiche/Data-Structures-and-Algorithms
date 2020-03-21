package com.codewithinoussa.WeightedGraphs;

public class Main {
    public static void  main(String[] args){
        var graph = new WeightedGraphWithOOP();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 2);
       // var path = graph.getShortestPath("A", "C");
        var tree = graph.getMinimunSpanningTree();
        tree.print();
       // graph.print();
    }
}
