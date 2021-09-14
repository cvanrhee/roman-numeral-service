package com.interview.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class RomanNumeralService_UT {

  @Test
  public void testRomanNumeral_toRoman_MaxNumber(){
    assertThat(RomanNumeralService.toRoman(3999))
        .isEqualTo("MMMCMXCIX")
        .as("Did the max number equal the expected output?");
  }

  @Test
  public void testRomanNumeral_toRoman_MinNumber(){
    assertThat(RomanNumeralService.toRoman(1))
        .isEqualTo("I")
        .as("Did the min number equal the expected output?");
  }

}
