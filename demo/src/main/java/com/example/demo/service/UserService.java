package com.example.demo.service;

import com.example.demo.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    private List<UserModel> userModelList = new ArrayList<>();


    public void addUser(UserModel user) {
        userModelList.add(user);
    }
    public List<UserModel> getUserModelList() {
        return userModelList;
    }
}
