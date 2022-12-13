package com.czetsuyatech.tests;

import java.util.HashSet;
import java.util.Set;

public class SlidingWindow {

  public static String getLongestSubstring(String input) {

    char[] elements = input.toCharArray();
    String longestSubstring = "";
    Set<Character> windowElements = new HashSet<>();

    int windowIndex = 0;
    for (int i = windowIndex; i < elements.length; i++) {
      char current = elements[i];
      if (windowElements.contains(current)) {
        for (int j = windowIndex; j < i; j++) {
          if (elements[j] == current) {
            windowIndex = j + 1;
            break;

          } else {
            windowElements.remove(elements[j]);
          }
        }
      } else {
        windowElements.add(elements[i]);
      }

      longestSubstring = input.substring(windowIndex, i + 1);
    }

    return longestSubstring;
  }

  private static String getLongerSubstr(String longestSubstring, String windowSubstr) {
    return longestSubstring.length() > windowSubstr.length() ? longestSubstring : windowSubstr;
  }
}