package com.pidevteam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Jackpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJ ;
    private String name ;
    //private String description;
    private Integer amount ;
   // private Integer rib;
    private String mail;
    private Integer number_phone;
    @Enumerated(EnumType.STRING)
    private Etat_J etat_J;


    @OneToOne
    @JsonIgnore
    private Events events;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="jackpot")
    @JsonIgnore

    private Set<Charity> charity;


}
