package com.czetsuyatech.tests.archive;

public class MultiplicationTableTest {

  public static void main(String[] args) {
    simple();
    for (int k = 0; k < 3; k++) {
      int i = 3 * k + 1;
      for (int j = 1; j < 10; j++) {
        System.out
            .println(String.format("%d*%d=%d\t%d*%d=%d\t%d*%d=%d", i, j, (i * j), i + 1, j, ((i + 1) * j), i + 2, j,
                ((i + 2) * j)));
      }
      System.out.println();
    }
  }

  public static void simple() {
    System.out.println("************ Simple Answer **********");
    for (int p = 0; p < 9; p += 3) {
      for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= 3; j++) {
          System.out.print((p + j) + "*" + i + "=" + i * (p + j) + "   ");
        }
        System.out.println();
      }
      System.out.println();
    }
  }
}
