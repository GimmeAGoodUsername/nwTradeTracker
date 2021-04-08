package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TestClassTest {
    private TestClass subject = new TestClass();

    @ParameterizedTest
    @ValueSource(ints = {11,4,3,54,5123,123,123,123,123,54, Integer.MAX_VALUE},strings = {""})
    void add_test(int number, String s){
        System.out.println(number);
        assertTrue(subject.add(number)==(number+1));
    }
}
