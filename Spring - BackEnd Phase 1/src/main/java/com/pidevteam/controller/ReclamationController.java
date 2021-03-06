package com.pidevteam.controller;

import com.pidevteam.entity.Reclamation;
import com.pidevteam.service.ReclamationServiceImpl;
import com.pidevteam.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@RequestMapping()
public class ReclamationController {
    @Autowired
    ReclamationServiceImpl reclamationService;
    @Autowired
    UserServiceImpl userService ;
    @PostMapping("/reclamation")

    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        reclamation.setUser(userService.findOne(SecurityContextHolder.getContext().getAuthentication().getName()));

        return reclamationService.addReclamation(reclamation);
    }
    @GetMapping("/reclamation")
    public List<Reclamation> GetReclamations(){
        return reclamationService.GetReclamations();
    }

    @DeleteMapping("/reclamation/{id}")
    public void deleteReclamations(@PathVariable("id") long id){
        reclamationService.deleteReclamation(id);

    }
    @PutMapping("/reclamation")

    public Reclamation updateReclamation(@RequestBody Reclamation reclamation) {

        return reclamationService.updateReclamation(reclamation);
    }
}
