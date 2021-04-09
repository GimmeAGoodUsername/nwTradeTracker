package com.FantasyUserGenerator.FantasyUserGenerator.service;

import com.FantasyUserGenerator.FantasyUserGenerator.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FantasyUserGenerator {

    public UserModel generateUser(String name) {
        return new UserModel(UUID.randomUUID(), name, name + "@+.de");
    }
}
