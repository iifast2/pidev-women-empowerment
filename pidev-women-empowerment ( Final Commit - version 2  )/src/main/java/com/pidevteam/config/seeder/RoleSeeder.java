package com.pidevteam.config.seeder;

import com.pidevteam.entity.Role;
import com.pidevteam.entity.RoleEnum;
import com.pidevteam.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder {

    @Autowired
    private RoleRepository roleRepository;

    public  void seed(){

        if(roleRepository.findAll().isEmpty()){

            roleRepository.save(new Role( RoleEnum.ADMIN, "ADMIN"));
            roleRepository.save(new Role( RoleEnum.USER, "USER"));
            roleRepository.save(new Role( RoleEnum.MANAGER, "MANAGER"));
            roleRepository.save(new Role( RoleEnum.USERADMIN, "USERADMIN"));
            roleRepository.save(new Role( RoleEnum.TRAINER, "TRAINER"));

            // roleRepository.save(new Role( "USERADMIN", "USER"));
        }
    }
}
