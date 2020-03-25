package com.codesquad.signup4;

import com.codesquad.signup4.domain.Interest;
import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	void USER가_저장된다() throws JsonProcessingException {
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

	@Test
	void USER가_JSON으로_변환된다() throws JsonProcessingException {
		User javajigi = User.create("javajigi", "password", "javajigi@gmail.com", "여자", "testUserName", "2020-01-01", "01012341234");
		List<Interest> interest = new ArrayList<>();
		interest.add(new Interest("soccer"));
		interest.add(new Interest("shopping"));
		javajigi.addInterest(interest);
		userRepository.save(javajigi);

		User savedJavajigi = userRepository.findById(javajigi.getId()).get();

		ObjectMapper objectMapper = new ObjectMapper();
		String savedjavajigiAsString = objectMapper.writeValueAsString(savedJavajigi);
		String expected = "{\"userId\":\"javajigi\",\"password\":\"password\",\"email\":\"javajigi@gmail.com\",\"gender\":\"여자\",\"username\":\"testUserName\",\"birthDate\":\"2020-01-01\",\"mobile\":\"01012341234\",\"interest\":[{\"id\":1,\"interestName\":\"soccer\"},{\"id\":2,\"interestName\":\"shopping\"}]}\n";

		Assertions.assertEquals(expected, savedjavajigiAsString);
	}
}
