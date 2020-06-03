package atos.bdd.model.collaborateur;

import atos.bdd.model.agence.Agence;
import atos.bdd.model.besoin.Proposition;
import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.model.relation.Collaborateurs_Competences;
import atos.bdd.view.MyJsonView;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MyJsonView.Collaborateur.class, MyJsonView.Besoin.class, MyJsonView.Proposition.class})
    private long id;
    
    @JsonView(MyJsonView.Collaborateur.class)
    private int bench;
    
    @JsonView(MyJsonView.Collaborateur.class)
    private String titre; // a ajouter dans l'uml
    
    @JsonView(MyJsonView.Collaborateur.class)
    private String identifiant; // a ajouter dans l'uml

    @JsonView({MyJsonView.Collaborateur.class, MyJsonView.Besoin.class, MyJsonView.Proposition.class})
    private String nom;

    @JsonView({MyJsonView.Collaborateur.class, MyJsonView.Besoin.class, MyJsonView.Proposition.class})
    private String prenom;

    @JsonView({MyJsonView.Proposition.class, MyJsonView.Collaborateur.class})
    private String cvUrl;
    
    @OneToMany(mappedBy = "collaborateur")
    private Set<Proposition> propositions;

    @ManyToOne(cascade = CascadeType.PERSIST) 
    @JsonView(MyJsonView.Collaborateur.class) // Fait apparaitre l'agence lors d'un appel de la vue collaborateur
    @JoinColumn(name = "id_agence")
    private Agence agence;
   
    
    @OneToMany(mappedBy = "collaborateur") // Relation entre la table collaborateur et la table de jointure où est stocké l'experience
    @JsonView(MyJsonView.Collaborateur.class) // Un collaborateur a plusieurs experience (qui est définit par la compétence), possible avec la clé composite.
    private Set<Collaborateurs_Competences> experiences;


}
