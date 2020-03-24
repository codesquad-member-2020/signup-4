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

    private String gender;

    private String username;

    private String birthDay;

    private String mobile;

    @MappedCollection(idColumn = "user_id", keyColumn = "interest_key")
    private List<Interest> interest;

    public User(String userId, String password, String email, String gender, String username, String birthDay, String mobile) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.birthDay = birthDay;
        this.mobile = mobile;
    }

    public static User create(String userId, String password, String email, String gender, String username, String birthDay, String mobile) {
        return new User(userId, password, email, gender, username, birthDay, mobile);
    }

    public void addInterest(List<Interest> interest) {
        this.interest = interest;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getMobile() {
        return mobile;
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
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", mobile='" + mobile + '\'' +
                ", interest=" + interest +
                '}';
    }

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
}
