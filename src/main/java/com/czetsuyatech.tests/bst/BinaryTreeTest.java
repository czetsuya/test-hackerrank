package com.czetsuyatech.tests.bst;

public class BinaryTreeTest {

  public static void main(String[] args) {

    BinaryTree binaryTree = new BinaryTree();
    binaryTree.add(6);
    binaryTree.add(4);
    binaryTree.add(8);
    binaryTree.add(3);
    binaryTree.add(5);
    binaryTree.add(7);
    binaryTree.add(9);

    printInOrder(binaryTree.root);
    System.out.println();
    printPreOrder(binaryTree.root);
    System.out.println();
    printPostOrder(binaryTree.root);
  }

  static void printInOrder(Node node) {

    if (node != null) {
      printInOrder(node.left);
      System.out.print(node.value + ", ");
      printInOrder(node.right);
    }
  }

  static void printPreOrder(Node node) {

    if (node != null) {
      System.out.print(node.value + ", ");
      printPreOrder(node.left);
      printPreOrder(node.right);
    }
  }

  static void printPostOrder(Node node) {

    if (node != null) {
      printPostOrder(node.left);
      printPostOrder(node.right);
      System.out.print(node.value + ", ");
    }
  }
}
