package com.women.spring.controller;

import com.women.spring.model.Charity;
import com.women.spring.model.Jackpot;
import com.women.spring.service.CharityService;
import com.women.spring.service.CharityServiceInt;
import com.women.spring.service.JackpotServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CharityController {
    @Autowired
    private CharityServiceInt service;
    @PostMapping("/charity")

    public ResponseEntity<String> saveCharity(@RequestBody Charity charity)
    {
        Integer id = service.saveCharity(charity);
        return new ResponseEntity<String>("charity with "+id+"has been saved", HttpStatus.OK);
    }

    @GetMapping("/charityList")
    public ResponseEntity<List<Charity>> getAllCharity()
    {
        List<Charity> list=service.getAllCharity();
        return new ResponseEntity<List<Charity>>(list,HttpStatus.OK);
    }

    @GetMapping("/getcharitybyid/{id}")
    public ResponseEntity<Charity> getCharityById(@PathVariable("id") Integer id)
    {
        Charity ch= service.getCharityById(id);
        return new ResponseEntity<Charity>(ch,HttpStatus.OK);

    }
    @PutMapping ("/updatecharity/{idC}")

    Charity UpdateCharity (@RequestBody Charity c , @PathVariable Integer idC){
        return service.UpdateCharity(c, idC);
    }


   /* public ResponseEntity<String>updateCharity(@PathVariable("id") Integer id, @RequestBody Charity charity)
    {
        Charity chFromDb= service.getCharityById(id);
        chFromDb.setObjective(charity.getObjective());
        chFromDb.setPictureTraining(charity.getPictureTraining());
        chFromDb.setStatistical(charity.getStatistical());
        chFromDb.setPictureWomen(charity.getPictureWomen());
        chFromDb.setUser_donation(charity.getUser_donation());


        return new ResponseEntity<String>("charity with"+id+"has been updated",HttpStatus.OK);

    }*/
    @DeleteMapping("deletcharity/{id}")
    public ResponseEntity<String> deleteCharity(@PathVariable("id") Integer id)
    {
        service.deleteCharity(id);
        return  new ResponseEntity<String>("charity with"+id+"has deleted",HttpStatus.OK);
    }

}
