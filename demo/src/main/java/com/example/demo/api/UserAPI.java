package com.example.demo.api;

import com.example.demo.interfaces.TestRestControllerInterface;
import com.example.demo.jpa.business.UserModelService;
import com.example.demo.jpa.model.UserModelEntity;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.test.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/")
public class UserAPI {

  private UserService userService;
  private UserModelService userModelService;
  private UserFantasyAPI userFantasyAPI;

  @Autowired
  public UserAPI(
      UserService userService, UserModelService userModelService, UserFantasyAPI userFantasyAPI) {
    this.userService = userService;
    this.userModelService = userModelService;
    this.userFantasyAPI = userFantasyAPI;
  }

  @RequestMapping(value = "hey", method = RequestMethod.GET)
  public TestObject getMessage() {
    TestObject test = new TestObject("Lineas", 4);

    System.out.println("Test");
    return test;
  }

  @RequestMapping(
      value = "putHey",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(code = HttpStatus.LOCKED)
  public void setTestObject(@RequestBody TestObject test) {
    System.out.println(test);
  }

  @RequestMapping(value = "genUser", method = RequestMethod.POST, produces = "application/json")
  public UserModel generateUser(@RequestBody String name) {
    UserModel userModel = userFantasyAPI.call_generateUser(name);
    userService.addUser(userModel);
    return userModel;
  }

  @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
  public List<UserModel> getAllUsers() {
    List<UserModel> allUsers = userModelService.getAllUsers();
    return allUsers;
  }

  @RequestMapping(value = "getAllUsersByMail", method = RequestMethod.GET)
  public List<UserModel> getAllUsersByMail(@RequestBody String mail) {
    List<UserModel> allUsers = userModelService.getAllUsersByMail(mail);
    return allUsers;
  }
}
