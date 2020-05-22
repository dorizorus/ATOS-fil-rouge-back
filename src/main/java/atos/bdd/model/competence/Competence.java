package atos.bdd.model.competence;

import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.model.relation.Cle_collab_competence;
import atos.bdd.model.relation.Collaborateurs_Competences;
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
    
    @OneToMany(mappedBy = "competence") // Relation entre la table collaborateur et la table de jointure où est stocké l'experience
    @JsonView(MyJsonView.Collaborateur.class) // Une compétence a plusieurs experiences (qui est définit par la compétence), possible avec la clé composite.
    private Set<Collaborateurs_Competences> experience; // Je suis censé mettre un s a experience mais bon, ça marche sans aussi a priori.

}
