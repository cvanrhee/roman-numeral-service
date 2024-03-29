package com.interview.service;

import com.interview.domain.dto.ConversionResponse;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Service manages all things related to roman numerals
 *
 * <p>Each instance of this service keeps an in-memory {@link ConcurrentHashMap} for faster lookups.
 *
 * <p>@see <a
 * href="https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java">Referenced
 * this for the conversion to Roman Numerals</a>
 */
@Service
public class RomanNumeralService {

  // Tree map tracks keys natural order
  private static final TreeMap<Integer, String> map = new TreeMap<Integer, String>();

  // thread safe in-memory cache to speed up lookups
  private final Map<Integer, String> cache = new ConcurrentHashMap();

  static {
    map.put(1000, "M");
    map.put(900, "CM");
    map.put(500, "D");
    map.put(400, "CD");
    map.put(100, "C");
    map.put(90, "XC");
    map.put(50, "L");
    map.put(40, "XL");
    map.put(10, "X");
    map.put(9, "IX");
    map.put(5, "V");
    map.put(4, "IV");
    map.put(1, "I");
  }

  /**
   * Converts an int into a {@link ConversionResponse}. Will first check in-memory cache for value before
   * running conversion.
   *
   * @throws IllegalArgumentException if the number is not between 1-3999
   * @param idx to convert to Roman Numeral
   * @return {@link CompletableFuture} with idx to Roman Numeral
   */
  @Async
  public CompletableFuture<ConversionResponse> convertIndex(int idx) {
    if (idx < 1 || idx > 3999) {
      return CompletableFuture.failedFuture(
          new IllegalArgumentException("Number not within range of 1 and 3999"));
    }

    var value = cache.get(idx);
    if (value == null) {
      value = RomanNumeralService.toRoman(idx);
      cache.put(idx, value);
    }

    return CompletableFuture.completedFuture(new ConversionResponse(idx, value));
  }

  /**
   * Recursive function that removes numbers until it has completed the roman numeral.
   *
   * @see <a href="https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java">Solution</a>
   * @param number to convert
   * @return corresponding Roman Numeral
   */
  static String toRoman(int number) {
    int floorKey = map.floorKey(number);

    if (number == floorKey) {
      return map.get(number);
    }

    return map.get(floorKey) + toRoman(number - floorKey);
  }
}
