package com.pidevteam.controller;


import com.pidevteam.entity.Donationuser;
import com.pidevteam.entity.Jackpot;
import com.pidevteam.repository.DonationuserRepository;
import com.pidevteam.service.JackpotServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController

public class JackpotController {
    @Autowired
    private JackpotServiceInt service;
    @Autowired
    DonationuserRepository dr;
    @PostMapping("/jackpot")

    public ResponseEntity<String> saveJackpot(@RequestBody Jackpot jackpot)
    {
        Integer id = service.saveJackpot(jackpot);
        return new ResponseEntity<String>("JACKPOT with "+id+"has been saved", HttpStatus.OK);
    }

    @GetMapping("/JackpotList")
    public ResponseEntity<List<Jackpot>> getAllJackpotdetails()
    {
        List<Jackpot> list=service.getAllJackpots();
        return new ResponseEntity<List<Jackpot>>(list,HttpStatus.OK);
    }

    @GetMapping("/getJackpotbyid/{id}")
    public ResponseEntity<Jackpot> getJackpotById(@PathVariable("id") Integer id)
    {
        Jackpot jk= service.getJackpotById(id);
        return new ResponseEntity<Jackpot>(jk,HttpStatus.OK);

    }
    /*@PutMapping ("/updateJackpot/{idJ}")
    public Jackpot UpdateJacpot (@RequestBody Jackpot j , @PathVariable Integer idJ){
        return service.UpdateJacpot(j, idJ);
    }*/


    /*
    public ResponseEntity<String>updateJackpot(@PathVariable("id") Integer id, @RequestBody Jackpot jackpot)
    {
        Jackpot jkFromDb= service.getJackpotById(id);
        jkFromDb.setName(jackpot.getName());
        jkFromDb.setDescription(jackpot.getDescription());
        jkFromDb.setAmount(jackpot.getAmount());
        jkFromDb.setRib(jackpot.getRib());
        jkFromDb.setMail(jackpot.getMail());
        jkFromDb.setNumber_phone(jackpot.getNumber_phone());

        return new ResponseEntity<String>("Jackpot with"+id+"has been updated",HttpStatus.OK);

    }*/
    @DeleteMapping("deletJackpot/{id}")
    public ResponseEntity<String> deleteJackpot(@PathVariable("id") Integer id)
    {
        service.deleteJackpot(id);
        return  new ResponseEntity<String>("Jackpot with"+id+"has deleted",HttpStatus.OK);
    }

    @GetMapping("/score/{id}")
    public int calculer (@PathVariable("id")int id) {
        Donationuser u = dr.findById(id).orElse(null);
        return service.calculerscore(u);
    }

    @GetMapping("/jackpots-encours")
    public List<Jackpot> getalljackpotsencours()
    {
        return service.jackpotencrs();
    }

    @GetMapping("/listegangant")
    public Map<Integer, Integer> listegagants()
    {
        return service.afficherlisteneedy();
    }
    @GetMapping("/att/{id}")
    public Map<Integer, Integer> attribuerjackpot(@PathVariable("id") int i)
    {
        return service.attribuerjackpot(i);
    }
}
