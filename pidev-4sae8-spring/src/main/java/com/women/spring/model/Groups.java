package com.women.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Groups implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idGroup")

    private Long idGroup;
    private String groupeName;


    @Temporal(TemporalType.TIMESTAMP)
    private Date dateGroupe;

    private String imageGroup;

    @ManyToMany
    @JsonIgnore
    private Set<User> GroupUser;

    @OneToMany(mappedBy = "ChatGroup", cascade = CascadeType.REMOVE)
    @JsonIgnore

    private Set<Chat> ChatMessage;

    @Enumerated(EnumType.STRING)
    private GroupeType groupeSecuritytype;
}
