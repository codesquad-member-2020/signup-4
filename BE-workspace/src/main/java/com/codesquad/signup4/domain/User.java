package com.codesquad.signup4.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonInclude(Include.NON_NULL)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public User() {
        super();
    }

    @Id
    private Long id;

    private String userID;

    private String password;

    private String email;

    private String gender;

    private String userName;

    private String birthDate;

    private String mobile;

    @MappedCollection(idColumn = "user_id", keyColumn = "interest_key")
    private List<Interest> interest;

    public User(String userID, String password, String email, String gender, String userName, String birthDate, String mobile) {
        super();
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.userName = userName;
        this.birthDate = birthDate;
        this.mobile = mobile;
    }

    public static User create(String userID, String password, String email, String gender, String userName, String birthDate, String mobile) {
        return new User(userID, password, email, gender, userName, birthDate, mobile);
    }

    public void addInterest(List<Interest> interest) {
        this.interest = interest;
    }

    public String getGender() {
        return gender;
    }

    public String getUserName() {
        return userName;
    }

    public String getBirthDate() {
        return birthDate;
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

    public String getUserID() {
        return userID;
    }

    public boolean checkUserID(String userID) {
        return this.userID.equals(userID);
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", userName='" + userName + '\'' +
                ", birthDate='" + birthDate + '\'' +
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
