package com.czetsuyatech.tests.archive.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

  private Map<Vertex, List<Vertex>> adjVertices = new LinkedHashMap<>();

  public void addVertex(String label) {
    adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
  }

  public void removeVertex(String label) {

    Vertex v = new Vertex(label);
    adjVertices.values().stream().forEach(e -> e.remove(v));
    adjVertices.remove(v);
  }

  public void addEdge(String label1, String label2) {

    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    adjVertices.get(v1).add(v2);
    adjVertices.get(v2).add(v1);
  }

  public void removeEdge(String label1, String label2) {

    Vertex v1 = new Vertex(label1);
    Vertex v2 = new Vertex(label2);
    List<Vertex> eV1 = adjVertices.get(v1);
    if (eV1 != null) {
      eV1.remove(v2);
    }
    List<Vertex> eV2 = adjVertices.get(v2);
    if (eV2 != null) {
      eV2.remove(v2);
    }
  }

  public Set<String> dfs(String root) {

    Set<String> visited = new LinkedHashSet<>();
    Stack<String> stack = new Stack<>();
    stack.push(root);

    while (!stack.empty()) {
      String vertex = stack.pop();
      if (!visited.contains(vertex)) {
        visited.add(vertex);
        adjVertices.get(new Vertex(vertex)).forEach(e -> stack.push(e.label));
      }
    }

    return visited;
  }

  public Set<String> bfs(String root) {

    Set<String> visited = new LinkedHashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(root);
    visited.add(root);

    while (!queue.isEmpty()) {
      String vertex = queue.poll();
      for (Vertex v : adjVertices.get(new Vertex(vertex))) {
        if (!visited.contains(v.label)) {
          visited.add(v.label);
          queue.add(v.label);
        }
      }
    }

    return visited;
  }

  @Override
  public String toString() {
    return "Graph{" +
        "adjVertices=" + adjVertices +
        '}';
  }
}
