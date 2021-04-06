package com.example.demo.model;

import java.util.UUID;

public class UserModel {
    private UUID uuid;
    private String name;
    private String mail;

    public UserModel(UUID uuid, String name, String mail) {
        this.uuid = uuid;
        this.name = name;
        this.mail = mail;
    }

    public UserModel() {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
