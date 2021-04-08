package com.example.demo.jpa.business;

import com.example.demo.jpa.model.UserModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModelEntity, UUID> {

  UserModelEntity findByEmail(String email);

  @Query(value = "SELECT * FROM UserModel u WHERE u.email = :email", nativeQuery = true)
  List<UserModelEntity> findByEmailQuery(@Param("email") String email);
}
