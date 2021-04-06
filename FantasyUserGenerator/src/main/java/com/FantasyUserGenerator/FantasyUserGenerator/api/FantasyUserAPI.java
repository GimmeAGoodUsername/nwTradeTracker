package com.FantasyUserGenerator.FantasyUserGenerator.api;

import com.FantasyUserGenerator.FantasyUserGenerator.model.UserModel;
import com.FantasyUserGenerator.FantasyUserGenerator.service.FantasyUserGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class FantasyUserAPI {

    @Autowired
    private FantasyUserGenerator fantasyUserGenerator;

    @RequestMapping(value = "genUser", method = RequestMethod.POST)
    public UserModel generateUser(@RequestBody String name) {
        return fantasyUserGenerator.generateUser(name);
    }
}
