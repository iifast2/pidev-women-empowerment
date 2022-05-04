package com.pidevteam.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @Column
    private String description;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "USER_ID") })
    private List<Role> users = new ArrayList<>();




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Role> getUsers() {
        return users;
    }

    public void setUsers(List<Role> users) {
        this.users = users;
    }

    public Role() {
    }


    public Role(RoleEnum s, String s1) {

        name = s;
        description= s1;
    }

}
