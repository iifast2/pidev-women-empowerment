package com.pidevteam.service;

import com.pidevteam.entity.Reclamation;
import com.pidevteam.repository.ReclamationRepo;
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
        emailSenderService.sendMail(reclamation.getUser().getEmail() , "this is an email", "claim");
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
