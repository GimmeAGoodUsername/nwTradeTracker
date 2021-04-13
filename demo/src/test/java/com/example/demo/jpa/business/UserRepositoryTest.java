package com.example.demo.jpa.business;

import com.example.demo.DemoApplication;
import com.example.demo.jpa.model.UserModelEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {DemoApplication.class})
@Transactional
public class UserRepositoryTest {

  private static final String MAIL = "test@test.mail";
  private static final String NAME = "test";

  @Autowired private UserRepository sut;

  private UserModelEntity subject;
  private UUID uuid = UUID.randomUUID();

  @BeforeEach
  void setup() {
    subject = new UserModelEntity(uuid, NAME, MAIL);
  }

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

  @Test
  void update_test_success() {
    subject = sut.saveAndFlush(subject);
    subject.setName("new");
    sut.saveAndFlush(subject);
    UserModelEntity changedEntity = sut.getOne(uuid);
    assertEquals("new", changedEntity.getName());
  }

  @Test
  void update_test_exception() {
    subject = sut.saveAndFlush(subject);
    subject.setName(null);
    assertThrows(DataIntegrityViolationException.class, () -> sut.saveAndFlush(subject));
  }

  @Test
  void delete_test_success() {
    subject = sut.saveAndFlush(subject);
    assertFalse(sut.findAll().isEmpty());
    sut.delete(subject);
    sut.flush();
    assertEquals(0, sut.count());
  }

  @Test
  void delete_test_exception_when_null_entity() {
    assertThrows(org.springframework.dao.InvalidDataAccessApiUsageException.class,
            () ->sut.delete(null));
  }

  @Test
  void findById_test_success() {
    subject = sut.saveAndFlush(subject);
    Optional<UserModelEntity> entity = sut.findById(uuid);
    assertTrue(entity.isPresent());
    assertEquals(subject, entity.get());
  }

  @Test
  void findById_test_exception() {
    subject = sut.saveAndFlush(subject);
    Optional<UserModelEntity> optional = sut.findById(UUID.randomUUID());
    assertFalse(optional.isPresent());
  }

  @Test
  void findByEmail_test_success() {
    subject = sut.saveAndFlush(subject);
    UserModelEntity users = sut.findByEmail(MAIL);
    assertNotNull(users);
  }

  @Test
  void findByEmail_test_empty_on_non_existing_email() {
    subject = sut.saveAndFlush(subject);
    assertNull(sut.findByEmail("unknown@email"));
  }

  @Test
  void save_test_exception_when_email_is_null() {
    subject.setEmail(null);
    assertThrows(DataIntegrityViolationException.class, () -> sut.saveAndFlush(subject));
  }

  @Test
  void save_test_exception_when_name_is_null() {
    subject.setName(null);
    assertThrows(DataIntegrityViolationException.class, () -> sut.saveAndFlush(subject));
  }

}
