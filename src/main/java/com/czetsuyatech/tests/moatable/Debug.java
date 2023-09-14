package com.czetsuyatech.tests.moatable;

public class Debug {

  public static void main(String[] args) {

    int[] nums = {};
    System.out.println(makeAdditionExpression(nums));

    nums = new int[]{8};
    System.out.println(makeAdditionExpression(nums));

    nums = new int[]{8, 10, 6};
    System.out.println(makeAdditionExpression(nums));
  }

  /**
   * The following method doesn’t work. The method comment describes what it is supposed to do. Creates a String
   * containing the elements of the array, nums, in an addition expression. If nums has just one element, the String
   * just has that one number. If nums.length = 0, returns an empty string. Example Strings for various calls (shows
   * return value for arrays with 1, 2, and 3 elements, respectively): "5" "4 + 9" "8 + 10 + 6"
   */
  public static String makeAdditionExpression(int[] nums) {

    String expr = "";

    for (int i = 0; i < nums.length; i++) {
      String operation = (i < nums.length - 1) ? " + " : "";
      expr = expr + nums[i] + operation;
    }

    return expr;
  }
}
