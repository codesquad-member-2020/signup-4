package com.codesquad.signup4.controller.userapi;

import com.codesquad.signup4.controller.utils.HttpSessionUtil;
import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.UserInfoDto;
import com.codesquad.signup4.exception.UnauthorizedException;
import com.codesquad.signup4.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class APIUserDetailController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/checkmyinfo")
  public UserInfoDto checkMyInfo(@RequestParam String userID, HttpSession httpSession) {
    if (!HttpSessionUtil.isLoggedIn(httpSession)) {
      throw new UnauthorizedException("로그인을 하지 않으셨습니다.");
    }
    if (!HttpSessionUtil.getUserFromSession(httpSession).checkUserID(userID)) {
      throw new UnauthorizedException("현재 아이디와 접근하려는 아이디의 정보가 서로 상이합니다.");
    }
    User user = userRepository.findByUserID(userID);
    if (user == null) {
      throw new UserNotFoundException("사용자가 존재하지 않습니다.");
    }
    return UserInfoDto.createUserInfoDto(
            user.getUserID(), user.getPassword(), user.getEmail(), user.getGender(),
            user.getUserName(), user.getBirthDate(), user.getMobile(), user.getInterest()
    );
  }
}
