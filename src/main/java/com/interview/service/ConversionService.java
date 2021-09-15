package com.interview.service;

import com.interview.domain.dto.BatchConversionResponse;
import com.interview.domain.dto.ConversionResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service is used to create and manage conversion jobs. This was created due of limitations with
 * Spring calling @Async from the same class.
 *
 * <p>@see <a
 * href="https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java">Referenced
 * this for the conversion to Roman Numerals</a>
 */
@Service
public class ConversionService implements IConversionService {

  private final RomanNumeralService converterService;

  @Autowired
  public ConversionService(RomanNumeralService converter) {
    this.converterService = converter;
  }

  /**
   * Method the kicks off async conversions for every number between start and end.
   *
   * @param start of range.
   * @param end of range
   * @return all conversion for indexes between range.
   */
  @Override
  public BatchConversionResponse convertRange(int start, int end) {
    List<ConversionResponse> conversions = Collections.synchronizedList(new ArrayList<>());

    List<CompletableFuture<ConversionResponse>> futures = new ArrayList<>();
    for (int idx = start; idx <= end; idx++) {
      futures.add(converterService.convertIndex(idx));
    }

    // Block and get the result of the Futures
    for (CompletableFuture<ConversionResponse> future : futures) {
      conversions.add(future.join());
    }

    return new BatchConversionResponse(conversions);
  }

  @Override
  public ConversionResponse convertIndex(int index) {

    var result = converterService.convertIndex(index);

    return result.join();
  }
}
