package com.codesquad.signup4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.codesquad.signup4.domain.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserLoginControllerTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @LocalServerPort
  private int port;

  @Test
  public void 로그인이_성공한다() {
    String postURL = "http://localhost:" + port + "/api/auth/login";
    String sentJSON = "{\"userID\":\"testUserId\",\"password\":\"testPassword\"}";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<>(sentJSON, headers);
    ResponseEntity<Object> responseEntity = testRestTemplate.postForEntity(postURL, entity, Object.class);
    assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
  }

  @Test
  public void 로그인이_실패한다() {
    String postURL = "http://localhost:" + port + "api/auth/login";
    String sentJSON = "{\"userID\":\"sigrid\",\"password\":\"ilovesigrid\"}";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> entity = new HttpEntity<>(sentJSON, headers);
    ResponseEntity<Object> responseEntity = testRestTemplate.postForEntity(postURL, entity, Object.class);
    assertNotEquals(responseEntity.getStatusCode(), HttpStatus.OK);
  }

}
