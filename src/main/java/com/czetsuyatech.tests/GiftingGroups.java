package com.czetsuyatech.tests;

import java.util.Arrays;
import java.util.List;

/**
 * Input: 1100, 1110, 0110, 0001
 */
class GiftingGroups {

  public static void main(String[] args) {

    int result = countGroups(Arrays.asList("110", "110", "001"));
    System.out.println("result=" + result);

    result = countGroups(Arrays.asList("1100", "1110", "0110", "0001"));
    System.out.println("result=" + result);

    result = countGroups(Arrays.asList("11100", "11001", "10100", "00011", "01011"));
    System.out.println("result=" + result);

    result = countGroups(Arrays.asList("11100", "11100", "11100", "00011", "00011"));
    System.out.println("result=" + result);

    result = countGroups(Arrays.asList("10100", "01010", "10100", "01010", "00001"));
    System.out.println("result=" + result);
  }

  /*
   * Complete the 'countGroups' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING_ARRAY related as parameter.
   */

  public static int countGroups(List<String> related) {

    int count = 0;
    int length = related.size();
    int[][] matrix = convertToArray(related);

    for (int i = 0; i < length; i++) {
      if (matrix[i][i] == 1) {
        count += 1;
        dfs(i, length, matrix);
      }
    }

    return count;
  }

  private static void dfs(int i, int length, int[][] matrix) {

    if (matrix[i][i] == 0) {
      return;
    }

    for (int j = 0; j < length; j++) {
      if (matrix[i][j] == 1) {
        matrix[i][j] = 0;
        dfs(j, length, matrix);
      }
    }
  }

  private static int[][] convertToArray(List<String> input) {

    int result[][] = new int[input.size()][input.get(0).length()];

    for (int i = 0; i < input.size(); i++) {
      char[] charArr = input.get(i).toCharArray();
      for (int j = 0; j < charArr.length; j++) {
        result[i][j] = Character.getNumericValue(charArr[j]);
      }
    }

    return result;
  }
}