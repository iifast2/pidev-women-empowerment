package com.women.spring.controller;

import com.women.spring.model.Reclamation;
import com.women.spring.service.IReclamationService;

import com.women.spring.service.ReclamationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@RequestMapping()
public class ReclamationController {
    @Autowired
    ReclamationServiceImpl reclamationService;
    @PostMapping("/reclamation")

    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {

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
