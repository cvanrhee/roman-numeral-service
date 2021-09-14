package com.interview.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Custom error to handle invalid requests for conversion. */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidQueryRangeException extends RuntimeException {
  private static final long serialVersionUID = 2701983180820632702L;

  public InvalidQueryRangeException(String message) {
    super(message);
  }
}
