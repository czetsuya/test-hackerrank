package com.czetsuyatech.tests.owens;

public class FinalPriceOfProduct {

  public static int finalPrice(int N, int C) {
    int result = C;

    if (N > 0) {
      // increment by 1
      result = result + ((N > 3) ? 3 : N);
    }

    if (N > 3) {
      // decrement by 2
      result = result - ((N > 6) ? 6 : (N - 3) * 2);
    }

    if (N > 6) {
      // increment by 3
      result = result + ((N > 9) ? 9 : (N - 6) * 3);
    }

    if (N > 9) {
      // decrement by 4
      result = result - ((N > 12) ? 12 : (N - 9) * 4);
    }

    if (N > 12) {
      int remainingDays = (N - 12);
      int plusDays = remainingDays / 2;
      int minusDays = remainingDays - plusDays;
      result = result + plusDays - minusDays;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(FinalPriceOfProduct.finalPrice(4, 2));
    ;
  }
}
