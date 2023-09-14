package com.czetsuyatech.tests.cake;

import java.util.Collections;
import java.util.List;

public class UniqueProduct {
  public static String firstUniqueProduct(String[] products) {

    var listOfProducts = List.of(products);

    var dup = listOfProducts.stream()
        .filter(e -> Collections.frequency(listOfProducts, e) == 1)
        .findFirst()
        .orElse(null);

    return dup;
  }

  public static void main(String[] args) {
    System.out.println(firstUniqueProduct(new String[]{"Apple", "Computer", "Apple", "Bag"}));
  }
}
