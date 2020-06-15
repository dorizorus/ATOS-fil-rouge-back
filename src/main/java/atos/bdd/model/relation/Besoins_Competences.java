package atos.bdd.model.relation;


import atos.bdd.model.Besoin;
import atos.bdd.model.Competence;
import atos.bdd.model.relation.enums.Experience;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Besoins_Competences implements Serializable {

    @EmbeddedId //marque la clé primaire
    Cle_Besoins_Competences id;

    @ManyToOne
    @MapsId("id_besoin") //indique que c'est une partie de la clé
    @JoinColumn(name= "id_besoin")
    private Besoin besoin;

    @ManyToOne
    @MapsId("id_competence")
    @JoinColumn(name= "id_competence")
    @JsonView(MyJsonView.Besoin.class)
    private Competence competence;

    @Enumerated(EnumType.STRING)
    @JsonView(MyJsonView.Besoin.class)
     private Experience experience;

}
