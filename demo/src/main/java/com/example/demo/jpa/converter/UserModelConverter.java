package com.example.demo.jpa.converter;

import com.example.demo.jpa.model.UserModelEntity;
import com.example.demo.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserModelConverter implements ConverterInterface<UserModelEntity, UserModel> {

  @Override
  public UserModelEntity convertToEntity(UserModel m) {
    return new UserModelEntity(m.getUuid(), m.getName(), m.getMail());
  }

  @Override
  public UserModel convertToModel(UserModelEntity e) {
    return new UserModel(e.getUuid(), e.getName(), e.getEmail());
  }
}
