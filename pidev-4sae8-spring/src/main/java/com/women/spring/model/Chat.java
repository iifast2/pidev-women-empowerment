package com.women.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Chat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chat {
    @Id
    @Column(name="idMessage")
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long idMessage ;
    private String message;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMsg;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    Groups ChatGroup;

    @ManyToOne
    User MessageUser;

    @ManyToMany(mappedBy="etatMessage")
    private Set<User> etat;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy="ChatReact")
    @JsonIgnore
    private Set<ChatReact> react;
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationdate;

    }

