package com.codesquad.signup4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.codesquad.signup4.controller.utils.LoginDataVerifyUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginDataVerifyUtilTest {

  @Test
  public void 아이디검사_테스트통과() {
    String expectedPass = "javajigi";
    String expectedFail = "자바지기";

    assertTrue(LoginDataVerifyUtil.checkUserIDformat(expectedPass));
    assertFalse(LoginDataVerifyUtil.checkUserIDformat(expectedFail));
  }

  @Test
  public void 비밀번호검사_테스트통과() {
    String expectedPass = "1test!dA";
    String expectedFail = "비밀번호";

    assertTrue(LoginDataVerifyUtil.checkUserPasswordformat(expectedPass));
    assertFalse(LoginDataVerifyUtil.checkUserPasswordformat(expectedFail));
  }
}
