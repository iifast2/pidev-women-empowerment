package com.women.spring.service;

import com.women.spring.model.Reclamation;
import com.women.spring.repository.ReclamationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReclamationServiceImpl {
    @Autowired
    ReclamationRepo reclamationRepo;

    @Autowired
    EmailSenderService emailSenderService;

    public Reclamation addReclamation(Reclamation reclamation) {
        emailSenderService.sendMail("yosser.snoussi@esprit.tn" , "this is an email", "claim");
        return reclamationRepo.save(reclamation);
    }
    public List <Reclamation> GetReclamations(){
        return reclamationRepo.findAll();
    }
    public void deleteReclamation(Long id){
        reclamationRepo.deleteById(id);
    }
    public Reclamation updateReclamation(Reclamation reclamation){
        return reclamationRepo.save(reclamation);
    }
}
