package com.czetsuyatech.tests.owens;

import java.util.Arrays;

public class SortShelf {

  public static void sortShelf(int N, char[] A) {

    //this is default OUTPUT. You can change it.
    int result = -404;

    //write your Logic here:
    Arrays.sort(A);
    for (int i = 0; i < N; i++) {
      System.out.print(A[i] + " ");
    }
  }

  void printArr(char[] A) {
    for (char e : A) {
      System.out.print(e);
    }
  }

  public static void main(String[] args) {

    char[] A = {'X', 'X', 'Y', 'Z', 'Y', 'X', 'Z'};
    sortShelf(7, A);
  }
}
