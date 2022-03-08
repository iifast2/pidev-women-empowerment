package com.women.spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "ChatReact")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatReact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReact")

    private Long idReact;


    @ManyToOne
    User userReact;

    @ManyToOne
    Chat ChatReact;

    @Enumerated(EnumType.STRING)
    private React react;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfReact;
}
