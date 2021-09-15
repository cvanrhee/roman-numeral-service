package com.interview.service;

import com.interview.dto.BatchConversionResponse;
import com.interview.dto.ConversionResponse;

public interface IConversionService {
  BatchConversionResponse convertRange(int start, int end);
  ConversionResponse convertIndex(int idx);
}
