package com.amagana.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity extends BaseEntity {


    private String code;
    private String firstName;
    private String lastName;
    private String fullName;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "roles_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private List<UserProfile> userProfiles;
    @ManyToMany
    private List<UserDepartment> userDepartments;

    public UserEntity() {}

    public UserEntity(String code, String firstName, String lastName, String fullName, String password) {
        super();
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName= fullName;
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public List<UserDepartment> getUserDepartments() {
        return userDepartments;
    }

    public void setUserDepartments(List<UserDepartment> userDepartments) {
        this.userDepartments = userDepartments;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
