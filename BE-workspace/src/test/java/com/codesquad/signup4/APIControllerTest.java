package com.codesquad.signup4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class APIControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @LocalServerPort
  private int port;

  @Autowired
  private UserRepository userRepository;

  ObjectMapper objectMapper = new ObjectMapper();

  //동작하지 않는 테스트입니다.
  @Test
  public void CreateAPITest() throws JsonProcessingException {
    String posturl = "http://localhost:" + port + "create";
    String inputJSON = "{\"userId\":\"javajigi\",\"password\":\"password\",\"email\":\"javajigi@gmail.com\",\"gender\":\"여자\",\"username\":\"testUserName\",\"birthDate\":\"2020-01-01\",\"mobile\":\"01012341234\",\"interest\":[{\"id\":1,\"interestName\":\"soccer\"},{\"id\":2,\"interestName\":\"shopping\"}]}\n";
    //여기서 실제로는 어떻게 interest를 받아서 처리할 지 고민해야 할 것 같습니다.
    User expectedJavajigi = User.create("javajigi", "password", "javajigi@gmail.com", "여자", "testUserName", "2020-01-01", "01012341234");
    User javajigi = objectMapper.readValue(inputJSON, User.class);
    ResponseEntity<Object> createResponseEntity = testRestTemplate.postForEntity(posturl, javajigi, Object.class);

    //{
    //	“userId” : “javajigi”,
    //	“password” : “password”,
    //	“email” : “javajigi@gmail.com”,
    //	“gender” : “여자”,
    //	“username” : “testUserName”,
    //	“birthDate” : “2020-01-01”,
    //	“mobile” : “01012341234”,
    //	“interest” : “??”
    //}

    assertEquals(javajigi, expectedJavajigi);
    assertNotNull(createResponseEntity);
    System.out.println(createResponseEntity);
  }
}
