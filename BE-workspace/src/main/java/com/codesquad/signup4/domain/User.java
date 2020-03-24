package com.codesquad.signup4.domain;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;

public class User {

  @Id
  private Long id;
  private String userId;
  private String password;
  private String email;
  //private Set<Interest> interest = new HashSet<>();

  User(Long id, String userId, String password, String email) {
    this.id = id;
    this.userId = userId;
    this.password = password;
    this.email = email;
  }

  public static User create(String userId, String password, String email) {
    return new User(null, userId, password, email);
  }

//  public void addInterest(Interest interest) {
//    this.interest.add(interest);
//  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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

//  public Set<Interest> getInterest() {
//    return interest;
//  }
//
//  public void setInterest(Set<Interest> interest) {
//    this.interest = interest;
//  }
}
