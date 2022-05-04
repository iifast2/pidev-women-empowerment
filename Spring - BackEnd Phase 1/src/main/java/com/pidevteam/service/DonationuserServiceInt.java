package com.pidevteam.service;

import com.pidevteam.entity.Donationuser;

import java.util.List;

public interface DonationuserServiceInt {
    public Integer saveDonation(Donationuser donationuser);
    public List<Donationuser> getAllDonation();

    public Donationuser getdonationById(Integer id);

    public Donationuser UpdateDonation (Donationuser d , Integer id);

    //public void updateCharity(Integer id) ;

    public void deleteDonation(Integer id);
}
