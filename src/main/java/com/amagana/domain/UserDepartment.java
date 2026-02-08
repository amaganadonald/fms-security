package com.amagana.domain;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "department")
public class UserDepartment extends BaseEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    @SequenceGenerator(name = "department_seq", allocationSize = 1)
    private Long id;

    private String code;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    private UserDepartment parent;

    @OneToMany(mappedBy = "parent")
    private Set<UserDepartment> children;

    @ManyToOne
    private UserEntity manager;

    public UserDepartment() {
    }

    public UserDepartment(Long id, String code, String name, String description, UserDepartment parent, Set<UserDepartment> children, UserEntity manager) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.parent = parent;
        this.children = children;
        this.manager = manager;
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

    public UserDepartment getParent() {
        return parent;
    }

    public void setParent(UserDepartment parent) {
        this.parent = parent;
    }

    public Set<UserDepartment> getChildren() {
        return children;
    }

    public void setChildren(Set<UserDepartment> children) {
        this.children = children;
    }


    public UserEntity getManager() {
        return manager;
    }

    public void setManager(UserEntity manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserDepartment that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(parent, that.parent) && Objects.equals(children, that.children) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, description, parent, children, manager);
    }
}
