package com.example.demo.jpa.business;

import com.example.demo.jpa.model.UserModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModelEntity, UUID> {
  UserModelEntity findByEmail(String email);
}
