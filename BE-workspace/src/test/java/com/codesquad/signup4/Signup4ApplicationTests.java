package com.codesquad.signup4;

import com.codesquad.signup4.domain.Interest;
import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class Signup4ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void H2_데이터베이스에_USER가_저장된다() {
		User javajigi = User.create("javajigi", "password", "javajigi@gmail.com", "여자", "testUserName", "2020-01-01", "01012341234");
		List<Interest> interest = new ArrayList<>();
		interest.add(new Interest("soccer"));
		interest.add(new Interest("shopping"));
		javajigi.addInterest(interest);

		userRepository.save(javajigi);
		User user = userRepository.findById(javajigi.getId()).get();
		System.out.println(user);
		Assertions.assertEquals(javajigi, user);

	}
}
