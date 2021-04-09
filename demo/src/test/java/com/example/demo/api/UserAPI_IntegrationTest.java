package com.example.demo.api;

import com.example.demo.DemoApplication;
import com.example.demo.jpa.business.UserModelService;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.test.TestObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
    classes = {DemoApplication.class, UserAPI.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserAPI_IntegrationTest {
  @SpyBean UserFantasyAPI userFantasyAPI;
  @LocalServerPort private int port;

  @Autowired UserService userService;
  private UserModel sus = new UserModel(UUID.randomUUID(), "Test", "Test");

  @Test
  void test_genUser() {
    Mockito.doReturn(generateResponeEntity(HttpStatus.OK))
        .when(userFantasyAPI)
        .callFantasyAPI(Mockito.anyString());

    ResponseEntity<UserModel> userModel =
        restTemplate().postForEntity(buildUriString("/test/genUser"), "Test", UserModel.class);
    assertEquals(sus.getUuid(), userModel.getBody().getUuid());
    assertFalse(userService.getUserModelList().isEmpty());
    Mockito.verify(userFantasyAPI, Mockito.times(1)).call_generateUser(Mockito.anyString());
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
    return "http://localhost:" + this.port + path;
  }

  private ResponseEntity<UserModel> generateResponeEntity(HttpStatus status) {
    return new ResponseEntity<UserModel>(sus, status);
  }
}
