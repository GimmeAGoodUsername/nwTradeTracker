package com.example.demo.jpa.business;

import com.example.demo.jpa.converter.UserModelConverter;
import com.example.demo.jpa.model.UserModelEntity;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserModelService {
  @Autowired private UserModelConverter userConverter;
  @Autowired private UserRepository userRepository;

  public List<UserModel> getAllUsers() {
    List<UserModel> models = new ArrayList<>();
    for (UserModelEntity entity : userRepository.findAll()) {
      models.add(userConverter.convertToModel(entity));
    }
    return models;
  }

  public void saveUser(UserModel model) {
    userRepository.saveAndFlush(userConverter.convertToEntity(model));
  }

  public List<UserModel> getAllUsersByMail(String mail){
    List<UserModel> models = new ArrayList<>();
    for (UserModelEntity entity : userRepository.findByEmailQuery(mail)) {
      models.add(userConverter.convertToModel(entity));
    }
    return models;
  }
}
