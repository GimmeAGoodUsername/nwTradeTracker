package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class UserModelList {
    public List<UserModel> getList() {
        return list;
    }

    public void setList(List<UserModel> list) {
        this.list = list;
    }

    private List<UserModel> list = new ArrayList<>();

    public UserModelList(List<UserModel> list) {
        this.list = list;
    }

    public UserModelList() {
    }
}
