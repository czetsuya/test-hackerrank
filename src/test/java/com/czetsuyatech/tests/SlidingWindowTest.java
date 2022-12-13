package com.czetsuyatech.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SlidingWindowTest {

  @Test
  void getLongestSubstring1Ok() {

    String input = "abcde";

    String output = SlidingWindow.getLongestSubstring(input);

    assertEquals(input, output);
  }

  @Test
  void getLongestSubstring2Ok() {

    String input = "abcdec";

    String output = SlidingWindow.getLongestSubstring(input);

    assertEquals("dec", output);
  }

  @Test
  void getLongestSubstring3Ok() {

    String input = "abcdecfghijklm";

    String output = SlidingWindow.getLongestSubstring(input);

    assertEquals("decfghijklm", output);
  }

  @Test
  void getLongestSubstring4Ok() {

    String input = "xyzabcdefghxyzxyz";

    String output = SlidingWindow.getLongestSubstring(input);

    assertEquals("xyz", output);
  }
}