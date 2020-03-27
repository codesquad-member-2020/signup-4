package com.codesquad.signup4.controller.userapi;

import com.codesquad.signup4.controller.utils.HttpSessionUtil;
import com.codesquad.signup4.controller.utils.LoginDataVerifyUtil;
import com.codesquad.signup4.domain.Interest;
import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.Result;
import com.codesquad.signup4.exception.PasswordFormatException;
import com.codesquad.signup4.exception.UnauthorizedException;
import com.codesquad.signup4.exception.UserNotFoundException;
import com.codesquad.signup4.exception.userIDFormatException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserLoginController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/login")
  public ResponseEntity<Result> login(@RequestBody Map<String, String> userData, HttpSession httpSession) {
    String userID = userData.get("userID");
    String password = userData.get("password");

    User user = userRepository.findByUserID(userID); //TODO orElseThrow가 왜 안먹지?

    if (!LoginDataVerifyUtil.checkUserIDformat(userID)) {
      throw new userIDFormatException("아이디가 올바른 형태로 작성되지 아니하였습니다.");
    }

    if (!LoginDataVerifyUtil.checkUserPasswordformat(password)) {
      throw new PasswordFormatException("비밀번호가 올바른 형태로 작성되지 아니하였습니다.");
    }

    if (user == null) {
      throw new UserNotFoundException("입력하신 아이디의 사용자가 존재하지 않습니다."); // orElseThrow 에러가 먹지 않아 별도의 null 체크 로직을 추가함
    }

    if (!user.checkPassword(password)) {
      throw new UnauthorizedException("입력하신 비밀번호가 일치하지 않습니다.");
    }

    httpSession.setAttribute(HttpSessionUtil.USER_SESSION_KEY, user);
    return new ResponseEntity<>(Result.ok(), HttpStatus.OK);
  }
}
