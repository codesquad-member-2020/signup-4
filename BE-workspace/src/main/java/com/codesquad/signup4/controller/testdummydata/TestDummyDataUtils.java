package com.codesquad.signup4.controller.testdummydata;

import com.codesquad.signup4.dto.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDummyDataUtils {
  static ObjectMapper objectMapper = new ObjectMapper();

  public static String okResultProvider() throws JsonProcessingException {
    Result okResult = Result.ok();
    return objectMapper.writeValueAsString(okResult);
  }

  public static String failResultProvider(String errorMessage) throws JsonProcessingException {
    Result failResult = Result.fail(errorMessage);
    return objectMapper.writeValueAsString(failResult);
  }
}
