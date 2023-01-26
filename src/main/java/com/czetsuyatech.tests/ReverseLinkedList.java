package com.czetsuyatech.tests;

public class ReverseLinkedList {

  public static void main(String[] args) {

    new ReverseLinkedList();
  }

  ReverseLinkedList() {
    Node n3 = new Node(3);
    Node n2 = new Node(n3, 2);
    Node n1 = new Node(n2, 1);

    printNode(n1);

    n1 = reverseLinkedList(n1);

    System.out.println();

    printNode(n1);
  }

  private Node reverseLinkedList(Node n1) {

    // 1 -> 2 -> 3
    Node current = n1;
    Node next;
    Node prev = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    return prev;
  }

  private void printNode(Node n1) {

    Node current = n1;
    while (current != null) {
      System.out.print(current.value + " -> ");
      current = current.next;
    }
  }

   static class Node {

    Node next;
    int value;

    Node(int value) {
      this.value = value;
    }

    Node(Node next, int value) {
      this.next = next;
      this.value = value;
    }
  }
}
