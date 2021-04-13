package com.example.demo.test;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TestObject {

  @NotBlank
  @Size(min = 0, max = 20)
  private String name;

  private int age;

  public TestObject(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public TestObject() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
