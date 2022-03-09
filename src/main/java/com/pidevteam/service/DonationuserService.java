package com.pidevteam.service;

import com.pidevteam.entity.Donationuser;
import com.pidevteam.repository.DonationuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationuserService implements DonationuserServiceInt{
    @Autowired
    private DonationuserRepository repository;

   @Override
    public Integer saveDonation(Donationuser donationuser) {
        return repository.save(donationuser).getId();
    }

    @Override
    public List<Donationuser> getAllDonation() {
        return (List<Donationuser>) repository.findAll();
    }

@Override
    public Donationuser getdonationById(Integer id) {
        return repository.findById(id).get();
    }

   @Override
    public void deleteDonation(Integer id){
        repository.deleteById(id);

    }
    // @Override
    //public void updateCharity(Integer id) {
    // repository.findById(id).get();

    //}

    @Override
   public  Donationuser UpdateDonation (Donationuser d , Integer id){
        // TODO Auto-generated method stub
        d.setId(id);
        return repository.save(d);
    }
}
