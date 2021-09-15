package com.interview.domain.dto;

import java.util.List;

/**
 * DTO to wrap a batch of conversions.
 */
public class BatchConversionResponse {
  private List<ConversionResponse> conversions;

  public BatchConversionResponse(List<ConversionResponse> conversions) {
    this.conversions = conversions;
  }

  public List<ConversionResponse> getConversions() {
    return this.conversions;
  }
}

