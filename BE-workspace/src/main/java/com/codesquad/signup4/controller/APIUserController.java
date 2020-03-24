package com.codesquad.signup4.controller;

import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.codesquad.signup4.dto.Result;
import com.codesquad.signup4.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class APIUserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public Result create(User newUser) {
//        Todo 일단 이렇게 작성만 해놓음
        if(newUser.getUserId() == null) {
            throw new BadRequestException();
        }
        return Result.ok();
    }
}
