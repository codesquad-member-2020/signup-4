package com.codesquad.signup4.controller.utils;

import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.exception.BadRequestException;
import javax.servlet.http.HttpSession;

public class HttpSessionUtil {
  public static final String USER_SESSION_KEY = "sessionUser";

  public static boolean isLoggedIn(HttpSession httpSession) {
    Object user = httpSession.getAttribute(USER_SESSION_KEY);
    return user != null;
  }

  public static User getUserFromSession(HttpSession httpSession) {
    if (!isLoggedIn(httpSession)) {
      throw new BadRequestException();
    }
    return (User) httpSession.getAttribute(USER_SESSION_KEY);
  }

}
