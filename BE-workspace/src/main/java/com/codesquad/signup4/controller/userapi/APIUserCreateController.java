package com.codesquad.signup4.controller.userapi;

import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.Result;
import com.codesquad.signup4.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class APIUserCreateController {

    private static final Logger log = LoggerFactory.getLogger(APIUserCreateController.class);

    @Autowired
    UserRepository userRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }

    @PostMapping("/create")
    public Result create(User newUser) {
        if (!newUser.isValid()) {
            throw new BadRequestException();
        }

        return Result.ok();
    }

    @GetMapping("/duplicate/checkID")
    public Result checkId(@RequestParam String id) {
        if (id == null || id.equals("")) {
            throw new BadRequestException();
        }

        if (userRepository.findByUserID(id) != null) {
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

        if (mobileNumber == null || mobileNumber.equals("")) {
            throw new BadRequestException();
        }

        if (userRepository.findByMobile(mobileNumber) != null) {
            return Result.fail("중복된 번호입니다.");
        }
        return Result.ok();
    }
}
