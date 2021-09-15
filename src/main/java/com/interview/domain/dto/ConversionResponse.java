package com.interview.domain.dto;

/**
 * Holds a Number to RomanNumeral conversion.
 */
public class ConversionResponse {
  private int input;
  private String output;

  public ConversionResponse(int input, String output) {
    this.input = input;
    this.output = output;
  }

  public int getInput() {
    return input;
  }

  public String getOutput() {
    return output;
  }

}
