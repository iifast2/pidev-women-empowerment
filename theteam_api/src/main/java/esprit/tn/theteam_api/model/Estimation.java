package esprit.tn.theteam_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "iduser", "comment_id" }) })
public class Estimation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Enumerated(value = EnumType.STRING)
    Emoji emoji ;
    int iduser ;
    @ManyToOne()
     @JsonIgnore
    Comment comment ;

}
