package com.pidevteam.entity;

//import com.sun.istack.internal.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Resource implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
         Long id;
        @NotNull
         String name ;
         String url;
    @ManyToOne
    @JoinColumn(name = "publication_id")
     Publication publication ;

    public Resource(String name, String url, Publication publication) {
        this.name = name;
        this.url = url;
        this.publication = publication;
    }
}
