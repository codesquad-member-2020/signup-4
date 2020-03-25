package com.codesquad.signup4.controller.testdummydata;

import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.Result;
import com.codesquad.signup4.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test/users")
public class TestAPIUserCreateController {

  private static final Logger log = LoggerFactory.getLogger(TestAPIUserCreateController.class);

  @Autowired
  UserRepository userRepository;

  @PostMapping("/create")
  public Result create(User newUser) {
//        Todo 일단 이렇게 작성만 해놓음
    if (newUser.getUserId() == null) {
      throw new BadRequestException();
    }
    return Result.ok();
  }

  @GetMapping("/duplicate/checkId")
  public Result checkId(@RequestParam String id) {
    if (id == null) {
      throw new BadRequestException();
    }

    if (id.equals("testUserId")) {
      return Result.fail("중복된 아이디입니다.");
    }
    return Result.ok();
  }

  @GetMapping("/duplicate/checkEmail")
  public Result checkEmail(@RequestParam String email) {
    if (email == null) {
      throw new BadRequestException();
    }
    if (email.equals("javajigi@gmail.com")) {
      return Result.fail("중복된 이메일입니다.");
    }
    return Result.ok();
  }

  @GetMapping("/duplicate/checkMobile")
  public Result checkMobile(@RequestParam String mobileNumber) {
    if (mobileNumber == null) {
      throw new BadRequestException();
    }

    if (mobileNumber.equals("01012341234")) {
        return Result.fail("중복된 번호입니다.");
    }
    return Result.ok();
  }
}