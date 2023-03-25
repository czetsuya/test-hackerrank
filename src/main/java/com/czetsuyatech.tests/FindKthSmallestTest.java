package com.czetsuyatech.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindKthSmallestTest {

  public static void main(String[] args) {

    int[] input = {1, 5, 2, 4, 3};
    int k = 10;

    int output = findKthSmallest(input, k);

    System.out.println(output);
  }

  public static int findKthSmallest(int[] input, int k) {

    List<Integer> sortedInput = Arrays.stream(input)
        .boxed()
        .collect(Collectors.toList());

    Collections.sort(sortedInput);

    int result = sortedInput.get(k - 1);

    return result;
  }
}
