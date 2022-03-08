package com.pidevteam.config.seeder;

//import com.pidevteam.entity.Mail;
import com.pidevteam.entity.RoleEnum;
import com.pidevteam.entity.dto.UserDto;
//import com.pidevteam.service.MailService;
import com.pidevteam.service.UserService;
import com.sun.javafx.fxml.BeanAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsersSeeder {

    @Autowired
    private UserService userService;

    public void seed(){
                if(userService.findAll().isEmpty()){
            ArrayList<RoleEnum> rolesAdmin = new ArrayList<RoleEnum>();
            rolesAdmin.add(RoleEnum.ADMIN);
         // ;

    ArrayList<RoleEnum> rolesM= new ArrayList<RoleEnum>();
    rolesM.add(RoleEnum.MANAGER);



UserDto user2 = new UserDto(null,"admin" ,"admin"  ,
    "1997/6/7","address" ,
    "admin@gmail.com");
user2.setRoles(rolesAdmin);
userService.save(user2);

        UserDto user3 = new UserDto(null,"med amine" ,"ben taieb" ,"admin1" ,
                "admin1","1997/6/7" ,"cité olympique , Rue 123" ,
                "anonymousmega04@gmail.com");
        user3.setRoles(rolesAdmin);
        userService.save(user3);


   // MANAGER
UserDto user4 = new UserDto(null,"wafa" ,"AAA" ,"manager" ,
        "manager","1997/6/7" ,"cité ghazela - Rue 321" ,
        "mangerrrr123@gmail.com");
user4.setRoles(rolesAdmin);
userService.save(user4);



/*
        UserDto user3 = new UserDto(null,"admin1" ,"admin1" ,1150L ,
                "1997/6/7","address" ,30L ,
                "07898878", "wafabenyahia71@gmail.com");
        user3.setRoles(rolesAdmin);
userService.save(user3);


    UserDto user4 = new UserDto(null,"manager" ,"manager" ,1150L ,
        "1999/6/7","address" ,30L , "07887877",
        "adminnnnn@gmail.com");
    user4.setRoles(rolesM);
    userService.save(user4);
*/






                 /*   UserDto user1 = new UserDto(null,"Degla" ,"degla123" ,1150L ,
                            "1997/6/7","address" ,30L ,
                            "13014570", "melek@gmail.com");
                    user1.setRoles(rolesAdmin);
                    userService.save(user1);

        */

        }

             }
}
