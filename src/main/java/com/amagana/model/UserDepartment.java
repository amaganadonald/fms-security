package com.amagana.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserDepartment extends BaseEntity {

    private String code;

    private String name;

    private String description;
    @ManyToMany
    private List<UserEntity> userEntities;


    public UserDepartment() {
    }

    public UserDepartment(String name, String code, String description) {
        super();
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
