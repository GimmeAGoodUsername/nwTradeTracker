package com.example.demo.api;

import com.example.demo.jpa.business.UserModelService;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import com.example.demo.test.TestObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

  @Operation(summary = "Test the api")
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

  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Generated User",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserModel.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Could not generate User",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = UserModel.class))
            })
      })
  @RequestMapping(value = "genUser", method = RequestMethod.POST, produces = "application/json")
  public UserModel generateUser(
      @Parameter(description = "Name of the generated User") @RequestBody String name) {
    UserModel userModel = userFantasyAPI.call_generateUser(name);
    userService.addUser(userModel);
    return userModel;
  }

  @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
  public List<UserModel> getAllUsers() {
    List<UserModel> allUsers = userModelService.getAllUsers();
    if (allUsers.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "No Users have been found",
          new EmptyResultDataAccessException(1));
    }
    return allUsers;
  }

  @RequestMapping(value = "getAllUsersByMail", method = RequestMethod.GET)
  public List<UserModel> getAllUsersByMail(@RequestBody String mail) {
    List<UserModel> allUsers = userModelService.getAllUsersByMail(mail);
    return allUsers;
  }
}
