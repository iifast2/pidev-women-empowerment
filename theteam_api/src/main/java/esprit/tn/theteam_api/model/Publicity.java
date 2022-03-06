package esprit.tn.theteam_api.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Publicity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    String name ;
    @Temporal(TemporalType.DATE)
    Date dateStart ;
    @Temporal(TemporalType.DATE)
    Date dateEnd  ;
    int nbInitTarget ;
    int  nbFinalViews ;
    double  cost ;
    String type ;
    @ManyToOne()
    User user ;

}
