package com.codesquad.signup4.controller.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginDataVerifyUtil {

  public static boolean checkUserIDformat(String userID) {
    String checkFormat = "(?i)^(?=.*[a-z])[a-z0-9]{8,20}$";
    return checkFormatAuditor(checkFormat, userID);
  }

  public static boolean checkUserPasswordformat(String password) {
    String checkFormat = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$";

    return checkFormatAuditor(checkFormat, password);
  }

  public static boolean checkFormatAuditor(String pattern, String auditee) {
    Pattern password = Pattern.compile(pattern);
    Matcher matcher = password.matcher(auditee);
    if (!matcher.find()) {
      return false;
    }
    return matcher.group().equals(auditee);
  }
}