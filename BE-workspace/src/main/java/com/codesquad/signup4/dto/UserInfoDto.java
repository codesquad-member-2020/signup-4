package com.codesquad.signup4.dto;

import com.codesquad.signup4.domain.Interest;
import java.util.List;

public class UserInfoDto {
  private String userID;
  private String password;
  private String email;
  private String gender;
  private String userName;
  private String birthDate;
  private String mobile;
  private List<Interest> interest;

  public UserInfoDto(String userID,
      String password,
      String email,
      String gender,
      String userName,
      String birthDate,
      String mobile,
      List<Interest> interest) {

    this.userID = userID;
    this.password = password;
    this.email = email;
    this.gender = gender;
    this.userName = userName;
    this.birthDate = birthDate;
    this.mobile = mobile;
    this.interest = interest;
  }

  public UserInfoDto() {
  }

  public static UserInfoDto createUserInfoDto(String userId, String password, String email, String gender, String userName, String birthDate, String mobile, List<Interest> interest) {
    return new UserInfoDto(userId, password, email, gender, userName, birthDate, mobile, interest);
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public List<Interest> getInterest() {
    return interest;
  }

  public void setInterest(List<Interest> interest) {
    this.interest = interest;
  }
}
