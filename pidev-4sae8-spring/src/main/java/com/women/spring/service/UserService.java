package com.women.spring.service;


import com.women.spring.model.User;
import com.women.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User addUser(User user) {

        return userRepository.save(user);
    }
}
