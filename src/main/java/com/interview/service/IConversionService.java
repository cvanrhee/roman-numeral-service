package com.interview.service;

import com.interview.dto.BatchConversionResponse;

public interface IConversionService {
  BatchConversionResponse convertRange(int min, int max) throws Exception;
}
