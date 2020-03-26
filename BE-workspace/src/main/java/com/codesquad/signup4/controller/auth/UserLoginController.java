package com.codesquad.signup4.controller.auth;

import com.codesquad.signup4.controller.utils.HttpSessionUtil;
import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.Result;
import com.codesquad.signup4.exception.BadRequestException;
import com.codesquad.signup4.exception.UnauthorizedException;
import com.codesquad.signup4.exception.UserNotFoundException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserLoginController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/login")
  public ResponseEntity<Result> login(@RequestBody Map<String, String> userData, HttpSession httpSession) {
    String userID = userData.get("userID");
    String password = userData.get("password");

    // TODO: 인터셉터를 활용하여 유저 아이디와 비밀번호가 포맷에 맞는 지 검증하는 로직 추가 필요

    User user = userRepository.findByUserID(userID); //TODO orElseThrow가 왜 안먹지?

    if (user == null) {
      throw new UserNotFoundException(); // orElseThrow 에러가 먹지 않아 별도의 null 체크 로직을 추가함
    }

    if (!user.checkPassword(password)) {
      throw new UnauthorizedException();
    }

    httpSession.setAttribute(HttpSessionUtil.USER_SESSION_KEY, user);
    return new ResponseEntity<>(Result.ok(), HttpStatus.OK);
  }
}