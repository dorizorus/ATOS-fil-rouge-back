package atos.bdd.model.collaborateur;

import atos.bdd.model.agence.Agence;
import atos.bdd.model.competence.Competence;
import atos.bdd.view.MyJsonView;
import atos.bdd.model.besoin.Proposition;
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
public class Collaborateur {

    @Id
    @JsonView(MyJsonView.Collaborateur.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @JsonView(MyJsonView.Collaborateur.class)
    private int bench;
    
    @JsonView(MyJsonView.Collaborateur.class)
    private String nom;
    
    @JsonView(MyJsonView.Collaborateur.class)
    private String prenom;
    
    @JsonView(MyJsonView.Collaborateur.class)
    private String titre; // a ajouter dans l'uml
    
    @JsonView(MyJsonView.Collaborateur.class)
    private String identifiant; // a ajouter dans l'uml
    
    @JsonView(MyJsonView.Collaborateur.class)
    private String cvUrl;

    @ManyToMany(cascade = CascadeType.PERSIST) // La cascade ici permet d'avoir accés à la table compétences afin d'attribuer des compétences au collab
    @JsonView(MyJsonView.Collaborateur.class) // Fait apparaitre les compétences lié au collaborateur
    @JoinTable(
            name = "collaborateurs_competences",
            joinColumns = @JoinColumn(name = "id_collaborateur"),
            inverseJoinColumns = @JoinColumn(name = "id_competence")
    )
    private Set<Competence> competences;

    @OneToMany(mappedBy = "collaborateur")
    private Set<Proposition> propositions;

    @ManyToOne(cascade = CascadeType.PERSIST) // Pareil qu'au dessus, on pourra attribuer une agence directement comme cela.
    @JsonView(MyJsonView.Collaborateur.class) // Fait apparaitre l'agence lors d'un appel de la vue collaborateur
    @JoinColumn(name = "id_agence")
    private Agence agence;


}
