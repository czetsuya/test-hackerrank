package com.czetsuyatech.tests.archive;

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

    for (int row = 0; row < length; row++) {
      if (matrix[row][row] == 1) {
        count++;
        dfs(row, length, matrix);
      }
    }

    return count;
  }

  private static void dfs(int row, int length, int[][] matrix) {

    if (matrix[row][row] == 0) {
      return;
    }

    for (int col = 0; col < length; col++) {
      if (matrix[row][col] == 1) {
        matrix[row][col] = 0;
        dfs(col, length, matrix);
      }
    }
  }

  private static int[][] convertToArray(List<String> input) {

    int length = input.size();
    int result[][] = new int[length][length];

    for (int i = 0; i < length; i++) {
      char[] charArr = input.get(i).toCharArray();
      for (int j = 0; j < charArr.length; j++) {
        result[i][j] = Character.getNumericValue(charArr[j]);
      }
    }

    return result;
  }
}
