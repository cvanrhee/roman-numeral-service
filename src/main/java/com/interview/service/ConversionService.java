package com.interview.service;

import com.interview.dto.BatchConversionResponse;
import com.interview.model.Conversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class ConversionService implements IConversionService {

  private final RomanNumeralService converterService;

  @Autowired
  public ConversionService(RomanNumeralService converter) {
    this.converterService = converter;
  }

  /**
   * Method the kicks off async conversions for every number between start and end
   *
   * @param start of range.
   * @param end of range
   * @return all conversion for indexes between range.
   */
  @Override
  public BatchConversionResponse convertRange(int start, int end) {
    List<Conversion> conversions = Collections.synchronizedList(new ArrayList<>());

    List<CompletableFuture<Conversion>> futures = new ArrayList<>();
    for (int idx = start; idx <= end; idx++) {
      futures.add(converterService.convertIndex(idx));
    }

    // Block and get the result of the Futures
    for (CompletableFuture<Conversion> future : futures) {
      conversions.add(future.join());
    }

    return new BatchConversionResponse(conversions);
  }
}

