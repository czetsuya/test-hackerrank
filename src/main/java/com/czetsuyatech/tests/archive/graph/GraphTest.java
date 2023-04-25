package com.czetsuyatech.tests.archive.graph;

public class GraphTest {

  public static void main(String[] args) {

    GraphTest gt = new GraphTest();
    Graph g = gt.createGraph();

    System.out.println(g);
    System.out.println("dfs: " + g.dfs("Bob"));
    System.out.println("bfs: " + g.bfs("Bob"));
  }

  Graph createGraph() {

    Graph graph = new Graph();
    graph.addVertex("Bob");
    graph.addVertex("Alice");
    graph.addVertex("Mark");
    graph.addVertex("Rob");
    graph.addVertex("Maria");
    graph.addEdge("Bob", "Alice");
    graph.addEdge("Bob", "Rob");
    graph.addEdge("Alice", "Mark");
    graph.addEdge("Rob", "Mark");
    graph.addEdge("Alice", "Maria");
    graph.addEdge("Rob", "Maria");

    return graph;
  }
}
