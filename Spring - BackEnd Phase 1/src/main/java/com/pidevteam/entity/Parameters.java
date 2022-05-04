package com.pidevteam.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data


public class Parameters{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int id;
    private int monthlyincome_420;
    private int monthlyincome_800;
    private int nbPersFamily_4;
    private int nbPersFamily_5;
    private int nbStudentsInFamily_1;
    private int nbStudentsInFamily_2;
    private int nbStudentsInFamily_3;
    private int medicalNeed;
    private int socialNeed;
    private int needy;
    private int unemployed;
    private int alreadywon;
}
