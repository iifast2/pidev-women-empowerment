package com.pidevteam.controller;

import java.util.Map;
import java.util.TreeMap;

import com.pidevteam.entity.Role;
import com.pidevteam.entity.RoleEnum;
import com.pidevteam.repository.RoleRepository;
import com.pidevteam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.pidevteam.entity.dto.UserDto;
import com.pidevteam.entity.User;

import javax.management.relation.RoleNotFoundException;

@Controller
public class GoogleChartsController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public int  nbofrole(RoleEnum roleEnum){
        int nb = 0 ;
        for (User user: userRepository.findAll()) {
            for (Role r: user.getRoles()) {
                if (r.getName().equals(roleEnum)){
                    nb++ ;
                }

            }
        }
        return nb ;

    }

    @GetMapping("/dashboard")
    public String getPieChart(Model model) {
        //     User user = userRepository.count();


        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("ADMIN", nbofrole(RoleEnum.ADMIN));
        graphData.put("USER", nbofrole(RoleEnum.USER));
        graphData.put("MANAGER", nbofrole(RoleEnum.MANAGER));
        graphData.put("USERADMIN", nbofrole(RoleEnum.USERADMIN));
        model.addAttribute("chartData", graphData);
        return "google-charts";
    }



}