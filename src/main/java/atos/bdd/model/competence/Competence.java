package atos.bdd.model;

<<<<<<< Updated upstream
import atos.bdd.model.besoin.Besoin;
import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.model.relation.Besoins_Competences;
import atos.bdd.model.relation.Cle_collab_competence;
=======
import atos.bdd.model.relation.Besoins_Competences;
>>>>>>> Stashed changes
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
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({MyJsonView.Competence.class, MyJsonView.Collaborateur.class, MyJsonView.Besoin.class})
    private int id;
    
    @JsonView({MyJsonView.Competence.class, MyJsonView.Collaborateur.class, MyJsonView.Besoin.class})
    private String type;

    @JsonView({MyJsonView.Competence.class, MyJsonView.Collaborateur.class, MyJsonView.Besoin.class})
    private String libelle;
    

    @OneToMany(mappedBy = "competence")
    Set<Besoins_Competences> competencesBesoin;
    
    @OneToMany(mappedBy = "competence") // Relation entre la table collaborateur et la table de jointure où est stocké l'experience
    private Set<Collaborateurs_Competences> competencesCollaborateur; // On peut le renommer compétences si on veut aussi. Cela liste les experiences par compétence

}
