package com.codesquad.signup4.domain;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public class Interest {

  @Id
  public Long id;

  @NotNull
  public String interestName;

  @NotNull
  public String userId;
}
