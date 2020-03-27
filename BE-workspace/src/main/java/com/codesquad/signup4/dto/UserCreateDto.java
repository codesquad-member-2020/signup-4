package com.codesquad.signup4.dto;

import java.util.List;

public class UserCreateDto {
    private String userID;
    private String password;
    private String email;
    private String gender;
    private String userName;
    private String birthDate;
    private String mobile;
    private List<String> interest;

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

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public boolean isValid() {
        return this.userID != null
                && this.userName != null
                && this.password != null
                && this.email != null
                && this.gender != null
                && this.birthDate != null
                && this.mobile != null
                && this.interest != null;
    }
}
