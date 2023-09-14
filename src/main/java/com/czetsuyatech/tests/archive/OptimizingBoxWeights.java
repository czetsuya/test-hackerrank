package com.czetsuyatech.tests.archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.atomic.LongAccumulator;

class OptimizingBoxWeights {

  public static void main(String[] args) {

    List<Integer> input = Arrays.asList(6, 7, 8, 8, 9, 10, 10, 10, 10);
//    List<Integer> input = Arrays.asList(5, 3, 2, 4, 1, 2); // 4, 5
//    List<Integer> input = Arrays.asList(4, 2, 5, 1, 6); // 5, 6

    System.out.println(minimalHeaviestSetA(input));
  }

  /*
   * Complete the 'minimalHeaviestSetA' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */
  public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {

    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    LongAccumulator valuesAccumulator = new LongAccumulator(Long::sum, 0);

    for (Integer i : arr) {
      queue.offer(i);
      valuesAccumulator.accumulate(i);
    }

    System.out.println("sum=" + valuesAccumulator.get());
    System.out.println("queue=" + queue);

    List<Integer> optimizedWeights = new ArrayList<>();
    Long totalWeight = valuesAccumulator.get();
    Long accumulatedWeight = 0L;

    for (Integer i : arr) {
      int currentWeight = queue.poll();
      accumulatedWeight += currentWeight;
      optimizedWeights.add(currentWeight);

      if (accumulatedWeight > totalWeight - accumulatedWeight) {
        break;
      }
    }

    Collections.reverse(optimizedWeights);

    return optimizedWeights;
  }
}
