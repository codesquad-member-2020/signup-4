package com.codesquad.signup4.exception;

public class BasicException extends RuntimeException {
  private String errorMessage;

  public BasicException(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
