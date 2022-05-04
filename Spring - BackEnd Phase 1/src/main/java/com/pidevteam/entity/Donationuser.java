package com.pidevteam.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity


public class Donationuser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    private String firstName;
    private String lastName;
    private float monthlyincome;
    private int nbPersFamily;
    private int nbStudentsInFamily;
    private String medicalNeed;
    private String socialNeed;
    private String needy;
    private String unemployed ;
    private double amoutwon;
}
