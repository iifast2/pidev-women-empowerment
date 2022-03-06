package com.women.spring.service;

import com.women.spring.model.Certificat;
import com.women.spring.model.Etat;
import com.women.spring.model.Formation;
import com.women.spring.model.User;
import com.women.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public User findById(Long id) {
        return userRepository.findById(id).get() ;
    }


        public User virer (Long id) {
          User user =  userRepository.findById(id).get();
       user.setEtat(Etat.viré);

            return userRepository.save(user);
    }
    public User avertire (Long id) {
        User user =  userRepository.findById(id).get();
        user.setEtat(Etat.Averti);

        return userRepository.save(user);

    }
    public User sactionner (Long id) {
        User user =  userRepository.findById(id).get();
        user.setEtat(Etat.Sactionné);

        return userRepository.save(user);
    }
}
