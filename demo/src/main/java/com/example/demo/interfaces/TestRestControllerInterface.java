package com.example.demo.interfaces;

import com.example.demo.test.TestObject;
import org.springframework.web.bind.annotation.*;


public interface TestRestControllerInterface {
    TestObject getMessage();


    void setTestObject(@RequestBody TestObject test);
}
