package com.czetsuyatech.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralsConverterTest {

  @Test
  public void convertStringIToInteger1() {

    var input = "I";
    var output = 1;

    Assertions.assertThat(RomanNumeralsConverter.toInt(input)).isEqualTo(output);
  }

  @Test
  public void convertStringIIToInteger2() {

    var input = "II";
    var output = 2;

    Assertions.assertThat(RomanNumeralsConverter.toInt(input)).isEqualTo(output);
  }

  @Test
  public void convertStringVIToInteger6() {

    var input = "VI";
    var output = 6;

    Assertions.assertThat(RomanNumeralsConverter.toInt(input)).isEqualTo(output);
  }

  @Test
  public void convertStringIVToInteger4() {

    var input = "IV";
    var output = 4;

    Assertions.assertThat(RomanNumeralsConverter.toInt(input)).isEqualTo(output);
  }

  @Test
  public void convertStringXIVToInteger14() {

    var input = "XIV";
    var output = 14;

    Assertions.assertThat(RomanNumeralsConverter.toInt(input)).isEqualTo(output);
  }

  @Test
  public void convertStringXCIXToInteger99() {

    var input = "XCIX";
    var output = 99;

    Assertions.assertThat(RomanNumeralsConverter.toInt(input)).isEqualTo(output);
  }
}
