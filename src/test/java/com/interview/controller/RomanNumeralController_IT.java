package com.interview.controller;

import com.interview.controller.error.InvalidQueryRangeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RomanNumeralController_IT {

  private RomanNumeralController romanNumeralController;

  @Autowired
  RomanNumeralController_IT(RomanNumeralController romanNumeralController) {
    this.romanNumeralController = romanNumeralController;
  }

  @Test
  public void convertRange_InvalidMinQuery () throws Exception {
    assertThatExceptionOfType(InvalidQueryRangeException.class)
        .isThrownBy(() ->{
          romanNumeralController.convertRange(0,10);
        })
        .as("Do we throw error when there is invalid min input");

  }

  @Test
  public void convertRange_InvalidMaxQuery () throws Exception {
    assertThatExceptionOfType(InvalidQueryRangeException.class)
        .isThrownBy(() ->{
          romanNumeralController.convertRange(1, 4000);
        })
        .as("Do we throw error when there is invalid max input");

  }


  @Test
  public void convertRange_MinHigherThanMax () throws Exception {
    assertThatExceptionOfType(InvalidQueryRangeException.class)
        .isThrownBy(() ->{
          romanNumeralController.convertRange(10, 9);
        })
        .as("Do we throw error when min value higher than max");

  }
}
