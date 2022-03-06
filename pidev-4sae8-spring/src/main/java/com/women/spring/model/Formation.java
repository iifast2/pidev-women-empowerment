package com.women.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String nom;
    Integer nombreParticipant;


    @OneToMany(mappedBy = "formation",cascade = CascadeType.REMOVE)
    List<File > files;

    @OneToOne()
    Quiz quiz ;

    @OneToMany(mappedBy = "formation", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
    List<Certificat> certificats;

    @ManyToMany(cascade = CascadeType.ALL)
    List<User> user;
}
