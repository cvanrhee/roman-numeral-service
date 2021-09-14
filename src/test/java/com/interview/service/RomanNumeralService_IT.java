package com.interview.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.ExecutionException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RomanNumeralService_IT {

  private final RomanNumeralService romanNumeralService;

  // Wire in all of spring dependencies
  @Autowired
  RomanNumeralService_IT(RomanNumeralService romanNumeralService) {
    this.romanNumeralService = romanNumeralService;
  }

  @Test
  public void testRomanNumeral_convertIndex_ExpectedResult() throws Exception {

    var result = romanNumeralService.convertIndex(1);

    assertThat(result.get().getInput()).isEqualTo(1);
    assertThat(result.get().getOutput()).isEqualTo("I");

    result = romanNumeralService.convertIndex(3999);

    assertThat(result.get().getInput()).isEqualTo(3999);
    assertThat(result.get().getOutput()).isEqualTo("MMMCMXCIX");
  }

  @Test
  public void testRomanNumeral_toRoman_InvalidHighInput(){
   var supplyAsync = romanNumeralService.convertIndex(4000);

   try {
      fail("convertIndex completed, expected failure", supplyAsync.get()); //Blocking
    } catch (ExecutionException | InterruptedException e) {
      assertThat(e.getCause().getMessage())
          .isEqualTo("Number not within range of 1 and 3999")
          .as("Did we get the error message we expected?");
    }
  }

  @Test
  public void testRomanNumeral_toRoman_InvalidZeroInput(){
    var supplyAsync = romanNumeralService.convertIndex(0);

    try {
      fail("convertIndex completed, expected failure", supplyAsync.get()); //Blocking
    } catch (ExecutionException | InterruptedException e) {
      assertThat(e.getCause().getMessage())
          .isEqualTo("Number not within range of 1 and 3999")
          .as("Did we get the error message we expected?");
    }
  }

}
