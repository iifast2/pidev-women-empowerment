package esprit.tn.theteam_api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.internal.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
@Column(nullable = false)
 String topic ;
    @Temporal(TemporalType.TIMESTAMP)
    Date  dateCreation ;
    String location ;
    String mood ;
    ArrayList<Long> idUserIden = new ArrayList<>()  ;
    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("publication")
     List<Resource> resources;
    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("publication")
    List<Rating> ratings;
    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("publication")
    List<Comment> comments ;

   @ManyToOne()
    User user ;
   @OneToOne ()
    Survey survey ;


    public Publication(Long id) {
        this.id = id ;
    }
}
