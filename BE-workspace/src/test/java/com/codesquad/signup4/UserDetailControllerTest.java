package com.codesquad.signup4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import com.codesquad.signup4.domain.User;
import com.codesquad.signup4.domain.UserRepository;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserDetailControllerTest {

  private MockHttpSession httpSession;

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Autowired
  private UserRepository userRepository;

  @Before
  public void HttpSession을_설정한다() {
    User testUser = userRepository.findByUserID("testUserId");
    httpSession = new MockHttpSession();
    httpSession.setAttribute("sessionUser", testUser);
  }

  @Test
  public void 사용자정보가_리턴된다() throws Exception {
    String getURL = "http://localhost:" + port + "/checkmyinfo";
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getURL);
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("userID", "javajigi");
    builder.queryParams(params);
    ResponseEntity<Object> responseEntity = testRestTemplate.getForEntity(getURL, Object.class);
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isNotNull();
  }

}
