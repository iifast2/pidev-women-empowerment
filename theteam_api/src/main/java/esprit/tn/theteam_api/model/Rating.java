package esprit.tn.theteam_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.jayway.jsonpath.internal.function.numeric.Min;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.*;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "iduser", "publication_id	" }) })
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Max(5)
    @Min(2)
    int note ;


    int iduser ;

    @ManyToOne()
           @JsonIgnore
    Publication publication ;

}
