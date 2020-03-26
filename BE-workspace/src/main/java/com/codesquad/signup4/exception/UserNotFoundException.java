package com.codesquad.signup4.exception;

public class UserNotFoundException extends BasicException {

  public UserNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
