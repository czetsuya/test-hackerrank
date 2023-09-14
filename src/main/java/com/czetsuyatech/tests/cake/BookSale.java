package com.czetsuyatech.tests.cake;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookSale {
  public static int nthLowestSelling(int[] sales, int n) {

    var listOfSales = Arrays.stream(sales)
        .boxed()
        .collect(Collectors.toList());

    // group by key
    var result = listOfSales.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    // order asc
    sortByValue(result);

    // find nth element
    return result.get(n - 1).intValue();
  }

  public static Map<Integer, Long> sortByValue(Map<Integer, Long> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<Integer, Long>> list =
        new LinkedList<>(hm.entrySet());

    // Sort the list
    Collections.sort(list, (o1, o2) -> (o1.getValue()).compareTo(o2.getValue()));

    // put data from sorted list to hashmap
    HashMap<Integer, Long> temp = new LinkedHashMap<>();
    for (Map.Entry<Integer, Long> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }

    return temp;
  }

  public static void main(String[] args) {
    int x = nthLowestSelling(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5}, 2);
    System.out.println(x);
  }
}
