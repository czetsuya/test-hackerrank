package com.czetsuyatech.tests.owens;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxIndex {

  static class ArrElement {

    int x;
    int y;
    int z;

    public String toString() {
      return x + ", " + y + ", " + z;
    }
  }

  public static int maxIndex(int N, int[] A) {

//    System.out.println(Arrays.toString(A));
    //this is default OUTPUT. You can change it.
    int result = -404;

    //write your Logic here:
    List<ArrElement> allSets = new ArrayList<>();
    for (int i = 0; i < N - 2; i++) {
      for (int j = i + 1; j < N - 1; j++) {
        for (int k = j + 1; k < N; k++) {
          if (A[i] > A[j] && A[j] > A[k]) {
            ArrElement arr = new ArrElement();
            arr.x = A[i];
            arr.y = A[j];
            arr.z = A[k];
            allSets.add(arr);
          }
        }
      }
    }

//    printDoubleArr(allSets);

    result = getIndex(N, A, getTop(findMostMatches(allSets)));

    return result;
  }

  private static int getIndex(int N, int[] A, List<Entry<Integer, Long>> top) {

    if (top == null) {
      return -1;
    }

    for (int i = 0; i < N; i++) {
      for (Entry<Integer, Long> t : top) {
        if (A[i] == t.getKey()) {
          return i;
        }
      }
    }

    return -1;
  }

  private static List<Entry<Integer, Long>> getTop(List<Entry<Integer, Long>> mostMatches) {

    if (mostMatches.isEmpty()) {
      return null;
    }

    List<Entry<Integer, Long>> topMatches = new ArrayList<>();
    long maxValue = mostMatches.get(0).getValue();
    for (Entry<Integer, Long> e : mostMatches) {
      if (e.getValue() >= maxValue) {
        topMatches.add(e);
      }
    }

    return topMatches;
  }

  static List<Entry<Integer, Long>> findMostMatches(List<ArrElement> A) {

    Function<ArrElement, Integer> classificationFunction = arr -> arr.y;
    return A.stream()
        .collect(Collectors.groupingBy(classificationFunction, Collectors.counting()))
        .entrySet().stream()
        .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    int N = 10;
    int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(maxIndex(N, A));
  }
}
