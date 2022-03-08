package com.czetsuyatech.tests;

import java.util.Map;

public class RomanNumeralsConverter {

  private static Map<Character, Integer> symbolsAndValues;

  static {
    symbolsAndValues = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
  }

  private RomanNumeralsConverter() {

  }

  public static Integer toInt(String input) {

    var totalValue = 0;
    var symbolsArr = input.toCharArray();
    var prevSymbol = symbolsArr[0];
    for (int i = 0; i < symbolsArr.length; i++) {
      var currVal = symbolsAndValues.get(symbolsArr[i]);

      if (i >= 1) {
        var prevVal = symbolsAndValues.get(prevSymbol);

        if (prevVal < currVal) {
          totalValue = totalValue - prevVal * 2;
        }
      }

      prevSymbol = symbolsArr[i];
      totalValue += currVal;
    }

    return totalValue;
  }
}
