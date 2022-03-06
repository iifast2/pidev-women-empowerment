package com.women.spring.model;

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
    private String description;
    private Float amount ;
    private Integer rib;
    private String mail;
    private Integer number_phone;

    @OneToOne
    private Events events;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="jackpot")
    private Set<Charity> charity;


}
