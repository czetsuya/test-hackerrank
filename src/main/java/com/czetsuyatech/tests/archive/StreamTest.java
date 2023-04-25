package com.czetsuyatech.tests.archive;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

  public static void main(String[] args) {

    String[] input = {"B$u$i$ld", "$t$$h$e", "N$e$x$t", "E$$ra", "$$o$f$", "S$$of$t$wa$r$e", "De$$ve$l$op$me$n$t"};

    String result = Stream.of(input)
        .map(s -> s.replace("$", ""))
        .collect(Collectors.joining(" "))
        .toUpperCase();

    System.out.println(result);
  }
}
