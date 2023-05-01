package com.czetsuyatech.tests.archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

class ShortestPathNonWeighted {

  public static void main(String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    var input = new String[]{"5", "A", "B", "C", "D", "F", "A-B", "A-C", "B-C", "C-D", "D-F"};
    String output = new ShortestPathNonWeighted().computeShortestPath(input);
    System.out.println(output);
  }

  ShortestPathNonWeighted() {

  }

  private String computeShortestPath(String strArr[]) {

    int nodesLength = Integer.parseInt(strArr[0]);
    List<String> allNodes = Arrays.asList(strArr);
    List<String> strNodes = allNodes.subList(1, nodesLength + 1);
    List<String> strAdjacentNodes = allNodes.subList(nodesLength + 1, allNodes.size());
    List<String[]> adjacentNodes = getAdjacentNodes(strAdjacentNodes);
    String startNodeName = strArr[1];
    String endNodeName = strArr[nodesLength];
    Map<String, Node> nodes = new HashMap<>();

    log("startNode=" + startNodeName + ", endNode=" + endNodeName);

    // create the nodes
    for (String strNode : strNodes) {
      Node node = new Node(strNode);
      nodes.put(strNode, node);
    }

    // find adjacency
    for (Entry<String, Node> entry : nodes.entrySet()) {

      Node node = entry.getValue();

      for (String[] sArr : adjacentNodes) {
        if (node.getName().equals(sArr[0])) {
          log(node.getName() + "-" + sArr[1]);
          node.addNeighbor(nodes.get(sArr[1]));
        }
      }
    }

    Node startNode = nodes.get(startNodeName);
    Node endNode = nodes.get(endNodeName);

    List<Node> result = new ShortestPath(startNode, endNode).bfs();

    return result.stream()
        .map(Node::getName)
        .collect(Collectors.joining("-"));
  }

  private void log(String str) {
    // System.out.println(str);
  }

  private List<String[]> getAdjacentNodes(List<String> input) {

    List<String[]> result = new ArrayList<>();
    for (String s : input) {
      String[] pair = getPair(s);
      result.add(pair);
    }

    return result;
  }

  private String[] getPair(String input) {
    return input.split("-");
  }

  class ShortestPath {

    Node start, end;

    ShortestPath(Node start, Node end) {
      this.start = start;
      this.end = end;
    }

    // Baeldung
    public List<Node> bfs() {

      Queue<Node> queue = new LinkedList<>();

      start.visited = true;
      queue.add(start);

      while (!queue.isEmpty()) {
        Node currentNode = queue.poll();
        // traverse along the node's breadth
        for (Node node : currentNode.neighbors) {
          if (!node.visited) {
            node.visited = true;
            queue.add(node);
            node.prev = currentNode;
            if (node == end) {
              queue.clear();
              break;
            }
          }
        }
      }

      return findShortestPath();
    }

    private List<Node> findShortestPath() {

      Node node = end;
      List<Node> route = new ArrayList<>();
      while (node != null) {
        route.add(node);
        node = node.prev;
      }
      Collections.reverse(route);

      return route;
    }
  }

  class Node {

    String name;
    List<Node> neighbors;
    boolean visited = false;
    Node prev = null;

    Node(String name) {
      this.name = name;
      this.neighbors = new ArrayList<>();
    }

    void addNeighbor(Node node) {
      this.neighbors.add(node);
      node.neighbors.add(this);
    }

    public String toString() {
      return this.name;
    }

    public String getName() {
      return name;
    }
  }
}
