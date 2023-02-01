package com.czetsuyatech.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSum {

  public static int findMaxSum(List<Integer> list) {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    list.stream()
        .forEach(e -> priorityQueue.add(e));

    return priorityQueue.poll() + priorityQueue.poll();
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(5, 9, 7, 11);
    // Should return 20, since 9 and 11 are the largest elements
    // and their sum is 20
    System.out.println(findMaxSum(list));
  }
}