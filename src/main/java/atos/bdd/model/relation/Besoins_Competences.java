package atos.bdd.model.relation;

import atos.bdd.model.relation.enums.Experience;
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

    @Id
    @Column(name = "id_besoin", insertable = false, updatable = false)
    private long idBesoin;

    @Id
    @Column(name = "id_competence", insertable = false, updatable = false)
    private int idCompetence;

    @Enumerated(EnumType.STRING)
     private Experience experience;

}
