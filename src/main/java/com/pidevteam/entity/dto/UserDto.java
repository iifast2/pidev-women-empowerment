//UserDto.java

package com.pidevteam.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pidevteam.entity.RoleEnum;
import com.pidevteam.entity.Subscription;
//import com.pidevteam.entity.UserProject;

import java.util.List;

public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    //  private long salary;
    private String birthdate;
    private String address;
    //  private Long leaveBalance;
    // private String cin;
    private String email;

    private List<RoleEnum> roles;
    private String phone;
    private  Subscription subscriptions ;
    public UserDto(Long id, String username, String password, String birthdate, String address,String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;

    }
    public Subscription getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Subscription subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserDto(Long id, String firstName, String lastName, String username, String password, String birthdate, String address, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
    }

    public UserDto(Long id, String firstName, String lastName, String username, String password, String birthdate, String address, String email, List <RoleEnum> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthdate = birthdate;
        this.address = address;

        this.email = email;
        this.roles = roles;

    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
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
}