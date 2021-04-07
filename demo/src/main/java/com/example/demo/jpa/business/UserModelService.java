package com.example.demo.jpa.business;

import com.example.demo.jpa.model.UserModelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Transactional
@Service
public class UserModelService{

    @Autowired
    private UserRepository userRepository;

    public List<UserModelEntity> getAllUsers(){
        return userRepository.findAll();
    }
}
