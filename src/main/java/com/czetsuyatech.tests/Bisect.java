package com.czetsuyatech.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bisect {

  public static void main(String[] args) {
    List<Integer> al = new ArrayList<Integer>();
    al.add(1);
    al.add(2);
    al.add(3);
    al.add(10);
    al.add(20);

    // 10 is present at index 3.
    int index = Collections.binarySearch(al, 10);
    System.out.println(index);

    // 13 is not present. 13 would have been inserted
    // at position 4. So the function returns (-4-1)
    // which is -5.
    index = Collections.binarySearch(al, 13);
    System.out.println(index);

    al = new ArrayList<Integer>();
    al.add(100);
    al.add(50);
    al.add(30);
    al.add(10);
    al.add(2);

    // The last parameter specifies the comparator
    // method used for sorting.
    index = Collections.binarySearch(al, 50, Collections.reverseOrder());

    System.out.println("Found at index " + index);
  }

  public static int bisect_right(double[] A, double x) {
    return bisect_right(A, x, 0, A.length);
  }

  public static int bisect_right(double[] A, double x, int lo, int hi) {

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
