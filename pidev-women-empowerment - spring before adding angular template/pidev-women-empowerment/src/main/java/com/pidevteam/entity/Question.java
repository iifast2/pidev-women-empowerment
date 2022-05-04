package com.pidevteam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String question ;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "question")
    List<Response> responses;
    @ManyToOne()
    Quiz quiz ;
}
