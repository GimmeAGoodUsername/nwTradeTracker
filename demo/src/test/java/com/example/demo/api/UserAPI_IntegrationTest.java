package com.example.demo.api;

import com.example.demo.DemoApplication;
import com.example.demo.jpa.business.UserModelService;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.test.TestObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(
    classes = {DemoApplication.class, UserAPI.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserAPI_IntegrationTest {
  @MockBean private UserService userService;
  @MockBean private UserModelService userModelService;
  @MockBean private UserFantasyAPI userFantasyAPI;
  @Autowired private WebApplicationContext webApplicationContext;

  @InjectMocks private UserAPI subject;

  @LocalServerPort private int port;

  private UserModel sus = new UserModel(UUID.randomUUID(), "Test", "Test");

  @BeforeEach
  void setup() {
    Mockito.when(userFantasyAPI.call_generateUser(Mockito.anyString())).thenReturn(sus);
    Mockito.doNothing().when(userService).addUser(Mockito.any(UserModel.class));
    MockitoAnnotations.openMocks(this);
    this.subject = new UserAPI(userService, userModelService, userFantasyAPI);
  }

  @Test
  void test_genUser() {

    ResponseEntity<UserModel> userModel =
        restTemplate().postForEntity(buildUriString("/test/genUser"), "Test", UserModel.class);
    assertEquals(sus.getUuid(), userModel.getBody().getUuid());
  }

  @Test
  void test_getAll() {

    ResponseEntity<TestObject> userModel =
        restTemplate().getForEntity(buildUri("/test/hey"), TestObject.class);
    assertNotNull(userModel.getBody());
    assertEquals(userModel.getBody().getName(), "Lineas");
  }

  private RestTemplate restTemplate() {
    return new RestTemplate();
  }

  private URI buildUri(String path) {
    String s = UriComponentsBuilder.fromUriString("http://localhost:" + port + path).toUriString();
    return URI.create(s);
  }

  private String buildUriString(String path) {
    return "http://localhost:" + port + path;
  }
}
