package com.interview.service;

import com.interview.domain.dto.BatchConversionResponse;
import com.interview.domain.dto.ConversionResponse;

public interface IConversionService {
  BatchConversionResponse convertRange(int start, int end);
  ConversionResponse convertIndex(int idx);
}
