package atos.bdd.model.competence;

import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.view.MyJsonView;
import atos.bdd.model.besoin.Besoin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MyJsonView.Competence.class, MyJsonView.Collaborateur.class})
    private int id;
    
    @JsonView({MyJsonView.Competence.class, MyJsonView.Collaborateur.class})
    private String type;
    
    @JsonView({MyJsonView.Competence.class, MyJsonView.Collaborateur.class})
    private String libelle;
    
    @ManyToMany(mappedBy = "competences")
    Set<Collaborateur> collaborateurs;


    @ManyToMany(mappedBy = "competences")
    Set<Besoin> besoins;

}
