package com.interview.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ConversionService_IT {

  private final ConversionService conversionService;

  // Wire in all of spring dependencies
  @Autowired
  ConversionService_IT(ConversionService conversionService) {
    this.conversionService = conversionService;
  }

  @Test
  public void testRomanNumeral_convertRange_BatchSize() throws Exception {
    var result = conversionService.convertRange(1, 10);

    assertThat(result.getConversions().size())
        .isEqualTo(10)
        .as("Did we get the expected number of conversions");

    assertThat(result.getConversions().get(0).getOutput())
        .isEqualTo("I")
        .as("Is the first conversion we got, the conversion we expected?");

    assertThat(result.getConversions().get(0).getInput())
        .isEqualTo(1)
        .as("Is the first conversion we got, the conversion we expected?");
  }

  @Test
  public void testRomanNumeral_convertRange_BatchOrder() throws Exception {
    var result = conversionService.convertRange(1, 10);

    // Check first conversion
    assertThat(result.getConversions().get(0).getOutput())
        .isEqualTo("I")
        .as("Is the first conversion we got, the conversion we expected?");

    assertThat(result.getConversions().get(0).getInput())
        .isEqualTo(1)
        .as("Is the first conversion we got, the conversion we expected?");

    // Check middle conversion
    assertThat(result.getConversions().get(4).getOutput())
        .isEqualTo("V")
        .as("Is the first conversion we got, the conversion we expected?");

    assertThat(result.getConversions().get(4).getInput())
        .isEqualTo(5)
        .as("Is the first conversion we got, the conversion we expected?");


    // Check last conversion
    assertThat(result.getConversions().get(9).getOutput())
        .isEqualTo("X")
        .as("Is the last conversion, the conversion we expected?");

    assertThat(result.getConversions().get(9).getInput())
        .isEqualTo(10)
        .as("Is the last conversion, the conversion we expected?");
  }
}
