package com.codesquad.signup4.controller.userapi;

import com.codesquad.signup4.domain.Interest;
import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.UserInfoDto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class APIUserDetailController {

  @Autowired
  private UserRepository userRepository;

  private void insertTestUser() {
    User javajigi = User
        .create("javajigi", "password", "javajigi@gmail.com", "여자", "testUserName", "2020-01-01",
            "01012341234");
    List<Interest> interest = new ArrayList<>();
    interest.add(new Interest("soccer"));
    interest.add(new Interest("shopping"));
    javajigi.addInterest(interest);
    userRepository.save(javajigi);
  }

  @GetMapping("/checkmyinfo")
  public UserInfoDto checkMyInfo(HttpSession httpSession) {
    insertTestUser();
    User user = (User) userRepository.findAll();
    return UserInfoDto.createUserInfoDto(
            user.getUserID(), user.getPassword(), user.getEmail(), user.getGender(),
            user.getUserName(), user.getBirthDate(), user.getMobile(), user.getInterest()
    );
  }
}
