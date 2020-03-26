package com.codesquad.signup4.exception;

public class UnauthorizedException extends BasicException {
  public UnauthorizedException( String errorMessage) {
    super(errorMessage);
  }
}