package com.interview.controller;

import com.interview.domain.dto.BatchConversionResponse;
import com.interview.domain.dto.ConversionResponse;
import com.interview.domain.error.InvalidQueryRangeException;
import com.interview.service.IConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romannumeral")
public class RomanNumeralController {

  private final IConversionService conversionService;
  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public RomanNumeralController(IConversionService conversionService) {
    this.conversionService = conversionService;
  }

  /**
   * Converts all numbers between min and max into their corresponding Roman Numeral. Ò
   *
   * @param max start of query
   * @param max end of query
   * @return {@link BatchConversionResponse} of all the conversions.
   */
  @GetMapping(params = {"min", "max"})
  public ResponseEntity<BatchConversionResponse> convertRange(
      @RequestParam int min, @RequestParam int max) {
    if (min > max) {
      throw new InvalidQueryRangeException("Max number greater than min numbers");
    }

    if (min < 1 || max > 3999) {
      throw new InvalidQueryRangeException(
          "Invalid query range. Numbers must be between 1 and 3999");
    }

    return ResponseEntity.ok(this.conversionService.convertRange(min, max));
  }

  @GetMapping(params = {"query"})
  public ResponseEntity<ConversionResponse> convertIndex(@RequestParam int query) {
    if (query < 1 || query > 3999) {
      throw new InvalidQueryRangeException("Query number must be between 1 and 3999");
    }

    return ResponseEntity.ok(this.conversionService.convertIndex(query));
  }
}
