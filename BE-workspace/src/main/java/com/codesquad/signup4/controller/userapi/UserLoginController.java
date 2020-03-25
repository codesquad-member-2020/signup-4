package com.codesquad.signup4.controller.userapi;

import com.codesquad.signup4.domain.Interest;
import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.Result;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserLoginController {

  @Autowired
  private UserRepository userRepository;

  private void insertTestUser() {
    User javajigi = User.create("javajigi", "password", "javajigi@gmail.com", "여자", "testUserName", "2020-01-01", "01012341234");
    List<Interest> interest = new ArrayList<>();
    interest.add(new Interest("soccer"));
    interest.add(new Interest("shopping"));
    javajigi.addInterest(interest);
    userRepository.save(javajigi);
  }

  @PostMapping("/login")
  public Result login(String userId, String password, HttpSession httpSession) {
    insertTestUser();
    User user = (User) userRepository.findAll();
    if (userId.equals("javajigi") && password.equals("password")) {
      httpSession.setAttribute("sessionUser", user);
      return Result.ok();
    }
    return Result.fail("로그인에 실패하였습니다.");
  }
}