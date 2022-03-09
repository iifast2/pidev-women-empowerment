package com.pidevteam.controller;

import com.pidevteam.entity.Donationuser;
import com.pidevteam.service.DonationuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class DonatipnuserController {
    @Autowired
    private DonationuserService service;
    @PostMapping("/Donation")

    public ResponseEntity<String> saveDonation(@RequestBody Donationuser donation)
    {
        Integer id = service.saveDonation(donation);
        return new ResponseEntity<String>("donation with "+id+"has been saved", HttpStatus.OK);
    }

    @GetMapping("/donationyList")
    public ResponseEntity<List<Donationuser>> getAllDonation()
    {
        List<Donationuser> list=service.getAllDonation();
        return new ResponseEntity<List<Donationuser>>(list,HttpStatus.OK);
    }

    @GetMapping("/getDonationybyid/{id}")
    public ResponseEntity<Donationuser> getDonationById(@PathVariable("id") Integer id)
    {
        Donationuser d= service.getdonationById(id);
        return new ResponseEntity<Donationuser>(d,HttpStatus.OK);

    }
    @PutMapping("/updateDonation/{idC}")

    public Donationuser UpdateDonation (@RequestBody Donationuser d , @PathVariable Integer id){
        return service.UpdateDonation(d, id);
    }



    @DeleteMapping("deletDonation/{id}")
    public ResponseEntity<String> deleteDonation(@PathVariable("id") Integer id)
    {
        service.deleteDonation(id);
        return  new ResponseEntity<String>("Donation with"+id+"has deleted",HttpStatus.OK);
    }

}
