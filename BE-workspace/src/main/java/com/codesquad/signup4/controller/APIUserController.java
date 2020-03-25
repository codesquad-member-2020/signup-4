package com.codesquad.signup4.controller;

import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.Result;
import com.codesquad.signup4.exception.BadRequestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class APIUserController {

  @Autowired
  UserRepository userRepository;

  ObjectMapper objectMapper = new ObjectMapper();

  @PostMapping("/create")
  public String create(User newUser) throws JsonProcessingException {
//        Todo 일단 이렇게 작성만 해놓음
    if (newUser.getUserId() == null) {
      throw new BadRequestException();
    }
    return okResultProvider();
  }

  @GetMapping("/checkId")
  public String checkId(@RequestParam String id) throws JsonProcessingException {
    if (id == null) {
      throw new BadRequestException();
    }

    if (id.equals("testUserId")) {
      return failResultProvider("중복된 아이디입니다.");
    }
    return okResultProvider();
  }

  @GetMapping("/checkMobile")
  public String checkMobile(@RequestParam String mobileNumber) throws JsonProcessingException {
    if (mobileNumber == null) {
      throw new BadRequestException();
    }

    if (mobileNumber.equals("01012341234")) {
        return failResultProvider("중복된 번호입니다.");
    }
    return okResultProvider();
  }

  public String okResultProvider() throws JsonProcessingException {
    Result okResult = Result.ok();
    return objectMapper.writeValueAsString(okResult);
  }

  public String failResultProvider(String errorMessage) throws JsonProcessingException {
      Result failResult = Result.fail(errorMessage);
      return objectMapper.writeValueAsString(failResult);
  }
}