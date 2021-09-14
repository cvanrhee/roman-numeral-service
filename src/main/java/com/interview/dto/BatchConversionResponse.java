package com.interview.dto;

import com.interview.model.Conversion;

import java.util.List;

/**
 * DTO to wrap a batch of conversions.
 */
public class BatchConversionResponse {
  private List<Conversion> conversions;

  public BatchConversionResponse(List<Conversion> conversions) {
    this.conversions = conversions;
  }

  public List<Conversion> getConversions() {
    return this.conversions;
  }
}

