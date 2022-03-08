package com.women.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idUser;
    private String nom;
    private String prenom;
    private String mailAdress;
    private String password;
    private String pdp;


    @ManyToMany(cascade = CascadeType.ALL)

    private Set<Chat> etatMessage;

}