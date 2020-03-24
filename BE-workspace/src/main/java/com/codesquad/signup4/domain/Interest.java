package com.codesquad.signup4.domain;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Interest {

  @Id
  public Long id;

  @NotNull
  public String interestName;

  public Interest(String interestName) {
    this.interestName = interestName;
  }

  public Long getId() {
    return id;
  }

  public String getInterestName() {
    return interestName;
  }

  @Override
  public String toString() {
    return "Interest{" +
            "id=" + id +
            ", interestName='" + interestName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Interest interest = (Interest) o;
    return Objects.equals(id, interest.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
