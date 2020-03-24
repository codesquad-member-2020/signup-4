package com.codesquad.signup4.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;
import java.util.Objects;

public class User {

  @Id
  private Long id;
  private String userId;
  private String password;
  private String email;


  @MappedCollection(idColumn = "user_id", keyColumn = "interest_key")
  private List<Interest> interest;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  User(String userId, String password, String email) {
    this.userId = userId;
    this.password = password;
    this.email = email;
  }

  public static User create(String userId, String password, String email) {
    return new User(userId, password, email);
  }

  public void addInterest(List<Interest> interest) {
    this.interest = interest;
  }

  public List<Interest> getInterest() {
    return interest;
  }

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

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", userId='" + userId + '\'' +
            ", password='" + password + '\'' +
            ", email='" + email + '\'' +
            ", interest=" + interest +
            '}';
  }
}
