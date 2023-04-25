package com.czetsuyatech.tests.archive;

import java.util.BitSet;

public class SmallestMissingNo {

  public static void main(String[] args) {

//    int[] input = {1, 3, 6, 4, 1, 2};
    int[] input = {98, 85, 91, 96, 100};
    int output = findSmallestMissingNo(input);
    System.out.println("result=" + output);
  }

  public static int findSmallestMissingNo(int[] input) {

    BitSet bs = new BitSet();
    for (int e : input) {
      if (e > 0) {
        bs.set(e);
      }
    }

    return bs.nextClearBit(1);
  }
}
