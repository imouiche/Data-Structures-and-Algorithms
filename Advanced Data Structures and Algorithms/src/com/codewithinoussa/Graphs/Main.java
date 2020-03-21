package com.codewithinoussa.Graphs;

public class Main {
    public static void main(String[] args){
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");

        //graph.traverseDepthFirstRec("A");
       // graph.traverseBreadthFirst("A");
        //graph.print();
      // var list = graph.topologicalSorting();
        System.out.println(graph.hasCycle());
    }
}
