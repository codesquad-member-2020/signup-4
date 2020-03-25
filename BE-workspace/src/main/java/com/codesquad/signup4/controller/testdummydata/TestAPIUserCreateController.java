package com.codesquad.signup4.controller;

import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.Result;
import com.codesquad.signup4.exception.BadRequestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class TestAPIUserController {

  private static final Logger log = LoggerFactory.getLogger(TestAPIUserController.class);

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

  @GetMapping("/duplicate/checkId")
  public String checkId(@RequestParam String id) throws JsonProcessingException {
    if (id == null) {
      throw new BadRequestException();
    }

    if (id.equals("testUserId")) {
      return failResultProvider("중복된 아이디입니다.");
    }
    return okResultProvider();
  }

  @GetMapping("/duplicate/checkEmail")
  public String checkEmail(@RequestParam String email) throws JsonProcessingException {
    if (email == null) {
      throw new BadRequestException();
    }
    if (email.equals("javajigi@gmail.com")) {
      return failResultProvider("중복된 이메일입니다.");
    }
    return okResultProvider();
  }

  @GetMapping("/duplicate/checkMobile")
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