package com.codesquad.signup4.exception;

import com.codesquad.signup4.dto.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ExceptionController {
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class)
    public Result BadRequestException() {
        return Result.fail("요청을 잘못 보내셨습니다. ");
    }

    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnauthorizedException.class)
    public Result UnauthorizedException() {
        return Result.fail("권한이 없습니다.");
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = UserNotFoundException.class)
    public Result UserNotFoundException() {
        return Result.fail("사용자가 존재하지 않습니다.");
    }
}
