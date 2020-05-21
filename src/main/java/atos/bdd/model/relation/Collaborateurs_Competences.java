package atos.bdd.model.relation;

import atos.bdd.model.relation.enums.Experience;
import atos.bdd.view.MyJsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "collaborateurs_competences")
@EntityListeners(AuditingEntityListener.class)
public class Collaborateurs_Competences implements Serializable {

    @Id
    @Column(name = "id_collaborateur", insertable = false, updatable = false)
    private long idCollaborateur;

    @Id
    @Column(name = "id_competence", insertable = false, updatable = false)
    private int idCompetence;

    @Enumerated(EnumType.STRING)
    private Experience experience;
    
    private int anneesExperience;
}
