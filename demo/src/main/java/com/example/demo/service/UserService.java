package com.example.demo.service;

import com.example.demo.jpa.business.UserModelService;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserModelService userModelService;

    public void addUser(UserModel user) {
        userModelService.saveUser(user);
    }

    public List<UserModel> getUserModelList() {
        return userModelService.getAllUsers();
    }
}
