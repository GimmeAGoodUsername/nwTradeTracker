package com.example.demo.jpa.model;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name ="USERMODEL")
public class UserModelEntity {
    @Id
    @Type(type="uuid-char")
    private UUID uuid;
    private String name;
    private String email;

    public UserModelEntity(UUID uuid, String name, String mail) {
        this.uuid = uuid;
        this.name = name;
        this.email = mail;
    }

    public UserModelEntity() {
        super();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", mail='" + email + '\'' +
                '}';
    }
}
