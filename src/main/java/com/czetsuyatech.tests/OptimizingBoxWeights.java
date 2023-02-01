package com.czetsuyatech.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/discuss/interview-question/1184534/amazon-oa-sde2-optimizing-box-weight-gift-grouping
 */
class OptimizingBoxWeights {

  public static void main(String[] args) {

//    List<Integer> input = Arrays.asList(6, 7, 8, 8, 9, 10, 10, 10, 10);
//    List<Integer> input = Arrays.asList(5, 3, 2, 4, 1, 2); // 4, 5
    List<Integer> input = Arrays.asList(4, 2, 5, 1, 6); // 5, 6

    System.out.println(OptimizingBoxWeights.minimalHeaviestSetA(input));
  }

  /*
   * Complete the 'minimalHeaviestSetA' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> minimalHeaviestSetA2(List<Integer> arr) {

    // sort the array
    arr = arr.stream().sorted().collect(Collectors.toList());

    int pointer = 1;
    int size = arr.size() - 1;

    List<Integer> lowerSet = arr.subList(0, size - pointer);
    List<Integer> higherSet = arr.subList(size - pointer, arr.size());

    while (higherSet.size() < lowerSet.size()) {
      int higherSetSum = sumInt(higherSet);
      int lowerSetSum = sumInt(lowerSet);

      if (higherSetSum > lowerSetSum) {
        return higherSet;

      } else {
        pointer++;
        lowerSet = arr.subList(0, size - pointer);
        higherSet = arr.subList(size - pointer, arr.size());
      }
    }

    return null;
  }

  // MaxQueue, PriorityQueue
  public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    long totalWeight = 0;

    for (Integer integer : arr) {
      totalWeight += integer;
      pq.offer(integer);
    }

    List<Integer> boxAElement = new ArrayList<>();
    long currentWeight = 0;
    for (int i = 0; i < arr.size(); i++) {
      int highWeight = pq.poll();
      currentWeight += highWeight;
      boxAElement.add(highWeight);
      if (currentWeight > totalWeight - currentWeight) {
        break;
      }
    }

    Collections.reverse(boxAElement);
    return boxAElement;
  }

  private static int sumInt(List<Integer> ints) {

    return ints.stream().collect(Collectors.summingInt(Integer::intValue));
  }
}