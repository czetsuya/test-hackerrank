package com.czetsuyatech.tests.archive;

public class CountSumCarry {

  public static void main(String[] args) {
    new CountSumCarry();
  }

  CountSumCarry() {

    System.out.println("TopTal Test");
    int result = 0;

    result = numberOfCarryOperations(65, 55); // 2
    System.out.println("result=" + result);

    result = numberOfCarryOperations(123, 456); // 0
    System.out.println("result=" + result);

    result = numberOfCarryOperations(555, 555);// 3
    System.out.println("result=" + result);

    result = numberOfCarryOperations(900, 11);// 0
    System.out.println("result=" + result);

    result = numberOfCarryOperations(145, 55); // 2
    System.out.println("result=" + result);

    result = numberOfCarryOperations(0, 0); // 0
    System.out.println("result=" + result);

    result = numberOfCarryOperations(1, 99999); // 5
    System.out.println("result=" + result);

    result = numberOfCarryOperations(999045, 1055); // 5
    System.out.println("result=" + result);

    result = numberOfCarryOperations(101, 809); // 1
    System.out.println("result=" + result);

    result = numberOfCarryOperations(189, 209); // 1
    System.out.println("result=" + result);
  }

  private static int numberOfCarryOperations(int a, int b) {

    String s1 = String.valueOf(a);
    String s2 = String.valueOf(b);

    char[] arrX = s1.toCharArray();
    char[] arrY = s2.toCharArray();

    int count = 0;
    int carry = 0;

    int l1 = arrX.length - 1;
    int l2 = arrY.length - 1;

    while (l1 >= 0 || l2 >= 0) {

      int x1 = 0, y1 = 0;

      if (l1 >= 0) {
        x1 = arrX[l1--] - '0';
      }

      if (l2 >= 0) {
        y1 = arrY[l2--] - '0';
      }

      int sum = x1 + y1 + carry;

      if (sum >= 10) {
        count++;
        carry++;

      } else {
        carry = 0;
      }
    }

    return count;
  }
}
