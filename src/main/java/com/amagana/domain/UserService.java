package com.amagana.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "services")
public class UserService extends BaseEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_seq")
    @SequenceGenerator(name = "service_seq", allocationSize = 1)
    private Long id;

    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne(optional = false)
    private UserDepartment department;

    @ManyToOne
    private UserEntity manager;

    @OneToMany(mappedBy = "service")
    private Set<UserEntity> members;

    public UserService() {
    }

    public UserService(Long id, String code, String name, String description, UserDepartment department, UserEntity manager, Set<UserEntity> members) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.department = department;
        this.manager = manager;
        this.members = members;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDepartment getDepartment() {
        return department;
    }

    public void setDepartment(UserDepartment department) {
        this.department = department;
    }

    public UserEntity getManager() {
        return manager;
    }

    public void setManager(UserEntity manager) {
        this.manager = manager;
    }

    public Set<UserEntity> getMembers() {
        return members;
    }

    public void setMembers(Set<UserEntity> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserService that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(department, that.department) && Objects.equals(manager, that.manager) && Objects.equals(members, that.members);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, description, department, manager, members);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", department=" + department +
                ", manager=" + manager +
                ", members=" + members +
                '}';
    }
}
