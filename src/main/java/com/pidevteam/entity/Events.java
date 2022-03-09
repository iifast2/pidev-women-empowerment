package com.pidevteam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idE ;
    private String nom;
    private String description;
    private String image;
    private Date dateD;
    private Date dateF;
    private String localisation;
    //private String map;
    private Float tarif;
    private Integer nbreDePlaces;
   // @Enumerated(EnumType.STRING)
   // private Etat etat;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne(mappedBy = "events")
    private Jackpot jackpot;
    @ManyToMany()
    @JoinTable(name = "USER_EVENT", joinColumns = {
            @JoinColumn(name = "EVENT_ID") }, inverseJoinColumns = {
              @JoinColumn(name = "USER_ID") })
    private List<User> users ;


}
