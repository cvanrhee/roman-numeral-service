package com.interview.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.interview.domain.error.InvalidQueryRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RomanNumeralController_IT {

  private RomanNumeralController romanNumeralController;

  @Autowired
  RomanNumeralController_IT(RomanNumeralController romanNumeralController) {
    this.romanNumeralController = romanNumeralController;
  }

  @Test
  public void convertRange_InvalidMinQuery() {
    assertThatExceptionOfType(InvalidQueryRangeException.class)
        .isThrownBy(
            () -> {
              romanNumeralController.convertRange(0, 10);
            })
        .as("Do we throw error when there is invalid min input");
  }

  @Test
  public void convertRange_InvalidMaxQuery() {
    assertThatExceptionOfType(InvalidQueryRangeException.class)
        .isThrownBy(
            () -> {
              romanNumeralController.convertRange(1, 4000);
            })
        .as("Do we throw error when there is invalid max input");
  }

  @Test
  public void convertRange_MinHigherThanMax() {
    assertThatExceptionOfType(InvalidQueryRangeException.class)
        .isThrownBy(
            () -> {
              romanNumeralController.convertRange(10, 9);
            })
        .as("Do we throw error when min value higher than max");
  }

  @Test
  public void convertRange_InvalidQuery_Low() {
    assertThatExceptionOfType(InvalidQueryRangeException.class)
        .isThrownBy(
            () -> {
              romanNumeralController.convertIndex(0);
            })
        .as("Do we throw error when there is invalid min input");
  }

  @Test
  public void convertRange_InvalidQuery_High() {
    assertThatExceptionOfType(InvalidQueryRangeException.class)
        .isThrownBy(
            () -> {
              romanNumeralController.convertIndex(4000);
            })
        .as("Do we throw error when there is invalid max input");
  }

  @Test
  public void convertRange_ValidQuery() {
    var result = romanNumeralController.convertIndex(1);

    assertThat(result.getBody().getInput()).isEqualTo(1).as("Did we get the input we expected?");

    assertThat(result.getBody().getOutput())
        .isEqualTo("I")
        .as("Did we get the output we expected?");
  }
}
