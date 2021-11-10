package com.czetsuyatech;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *   For example:
 *   input: 7
 *   output:
 *   1
 *   1 1
 *   2 1
 *   1 2 1 1
 *   1 1 1 2 2 1
 *   3 1 2 2 1 1
 *   1 3 1 1 2 2 2 1
 * </pre>
 * <p>In the given example, we have initial value 1.</p>
 * <p>The next line we say we have one 1 that's why 1 1.</p>
 * <p>In the next line.</p>
 * <p>we have two 1. And in the fourth, we have one 2 and one 1.</p>
 */
public class SumOfNSeries {

  public static void main(String[] args) {
    new SumOfNSeries().init();
  }

  private void init() {
    List<Integer> arrState = new ArrayList<>();
    arrState.add(1);

    int i = 0;
    while (i++ < 7) {
      printArr(arrState);
      arrState = computerArr(arrState);
    }
  }

  private void printArr(List<Integer> arr) {
    arr.forEach(e -> System.out.print(e + " "));
    System.out.println();
  }

  private List computerArr(List<Integer> arr) {
    if (arr.size() == 1) {
      arr.add(1);
      return arr;
    }

    List<Integer> newArr = new ArrayList<>();
    int currentVal = arr.get(0);
    int currentCount = 1;

    for (int i = 1; i < arr.size(); i++) {
      if (currentVal != arr.get(i)) {
        newArr.add(currentCount);
        newArr.add(currentVal);
        currentCount = 1;
        currentVal = arr.get(i);

      } else {
        currentCount++;
      }
    }

    newArr.add(currentCount);
    newArr.add(currentVal);

    return newArr;
  }
}
