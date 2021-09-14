package com.interview.model;

/**
 * <p> Holds a Number to RomanNumeral conversion.
 */
public class Conversion {
  private int input;
  private String output;

  public Conversion(int input, String output) {
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
