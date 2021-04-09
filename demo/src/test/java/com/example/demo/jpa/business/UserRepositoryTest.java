package com.example.demo.jpa.business;

import com.example.demo.DemoApplication;
import com.example.demo.jpa.model.UserModelEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = {DemoApplication.class})
@Transactional
public class UserRepositoryTest {

  @Autowired private UserRepository sut;

  private UserModelEntity subject;
  private UUID uuid = UUID.randomUUID();

  @BeforeEach
  void setup() {
    subject = new UserModelEntity(uuid, "TestName", "TestMail");
  }
  // CRUD Testen + Alles selbst geschriebene


  @Test
  void save_test_success(){
    subject= sut.save(subject);
    assertFalse(sut.findAll().isEmpty());
  }

  @Test
  void save_test_exception(){
    subject = sut.saveAndFlush(subject);

    subject.setUuid(null);
    assertThrows(JpaSystemException.class, () -> sut.saveAndFlush(subject));
  }
}
