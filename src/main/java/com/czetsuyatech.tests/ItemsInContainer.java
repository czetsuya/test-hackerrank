package com.czetsuyatech.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ItemsInContainer {

  public static void main(String[] args) {

    String input = "|**|*|*";
//    String input = "*|*|*|";

    List<Integer> result = numberOfItems(input, List.of(1, 1), List.of(5, 6)); // 2, 3
//    List<Integer> result = numberOfItems(input, List.of(1), List.of(6)); // 1

    System.out.println(result);
  }

  /*
   * Complete the 'numberOfItems' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER_ARRAY startIndices
   *  3. INTEGER_ARRAY endIndices
   */
  static List<Integer> countItems(String s, List<Integer> startIndices, List<Integer> endIndices) {

    int n = s.length();
    int[] dp = new int[n];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '|') {
        dp[i] = count;
      } else {
        count++;
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < startIndices.size(); i++) {
      int start = startIndices.get(i) - 1;
      int end = endIndices.get(i) - 1;

      while (s.charAt(start) != '|') {
        start++;
      }
      while (s.charAt(end) != '|') {
        end--;
      }
      if (start < end) {
        ans.add(dp[end] - dp[start]);
      } else {
        ans.add(0);
      }
    }

    return ans;
  }

  static List<Integer> numberOfItems(String str, List<Integer> startIndicesX, List<Integer> endIndicesX) {

    int[] startIndices = startIndicesX.stream().mapToInt(Integer::intValue).toArray();
    int[] endIndices = endIndicesX.stream().mapToInt(Integer::intValue).toArray();

    Map<Integer, Integer> pipeStarCntMap = new HashMap<>();
    List<Integer> pipeIndexList = new ArrayList<>();
    int stars = 0;

    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '|') {
        pipeStarCntMap.put(i, stars);
        pipeIndexList.add(i);

      } else if (!pipeIndexList.isEmpty()) {
        stars++;
      }
    }

    if (pipeIndexList.isEmpty()) {
      return new ArrayList<>();
    }

    // answer queries using dp: O(1)
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < startIndices.length; ++i) {
      int[] pipeIdxArr = pipeIndexList.stream().mapToInt(Integer::intValue).toArray();
      int lftPipeIdx = bisect_left(pipeIdxArr, startIndices[i] - 1);
      int rgtPipeIdx = bisect_right(pipeIdxArr, endIndices[i] - 1) - 1;
      ans.add(pipeStarCntMap.get(pipeIndexList.get(rgtPipeIdx)) - pipeStarCntMap.get(pipeIndexList.get(lftPipeIdx)));
    }

    return ans;
  }

  public static int bisect_right(int[] A, double x) {
    return bisect_right(A, x, 0, A.length);
  }

  public static int bisect_right(int[] A, double x, int lo, int hi) {

    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (x < A[mid]) {
        hi = mid;

      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  public static int bisect_left(int[] A, int x) {
    return bisect_left(A, x, 0, A.length);
  }

  public static int bisect_left(int[] A, int x, int lo, int hi) {
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (x <= A[mid]) {
        hi = mid;

      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }
}
