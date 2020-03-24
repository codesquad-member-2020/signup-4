package com.codesquad.signup4;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Signup4ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void H2_데이터베이스에_USER가_저장된다() {
		User javajigi = User.create("javajigi", "password", "javajigi@gmail.com");
		userRepository.save(javajigi);
		assertNotNull(userRepository.findByUserId("javajigi"));
	}
}