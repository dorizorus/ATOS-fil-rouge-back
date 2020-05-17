package atos.bdd.model.competence;

import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.model.besoin.Besoin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;
    private String libelle;

    @ManyToMany(mappedBy = "competences")
    Set<Collaborateur> collaborateurs;


    @ManyToMany(mappedBy = "competences")
    Set<Besoin> besoins;

}
