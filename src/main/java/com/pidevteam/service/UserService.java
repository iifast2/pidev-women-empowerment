package com.pidevteam.service;

import com.pidevteam.entity.User;
import com.pidevteam.entity.dto.UserDto;
import com.pidevteam.entity.util.ChangePasswordVM;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);
    User update(User user);
    User findById(Long id);
    public boolean changePassword(ChangePasswordVM vm , String username);
    public User virer (Long id) ;
    public User avertire (Long id);
    public User sactionner (Long id) ; 
}
