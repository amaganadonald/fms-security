package com.amagana.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserProfile extends BaseEntity {

    private String name;

    private String description;

    @ManyToMany(mappedBy = "userProfiles")
    private List<UserEntity> userEntities;

    public UserProfile() {
    }

    public UserProfile(String name, String description) {
        super();
        this.name = name;
        this.description = description;
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
