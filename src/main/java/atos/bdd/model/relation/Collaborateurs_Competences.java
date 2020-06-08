package atos.bdd.model.relation;

import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.model.competence.Competence;
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
@Entity(name = "collaborateurs_competences") // Créer une entité qui va être utilisé pour modeler la table (de jointure)
@EntityListeners(AuditingEntityListener.class)
public class Collaborateurs_Competences implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @EmbeddedId // Marque la variable qui sera la clé primaire. Chaque entité à besoin d'une clé primaire. Ici id, qui est une instanciation de cle_collab_compet
	Integer id;
	
	@ManyToOne // Un many to many n'existe techniquement pas dans la BDD. Ici, nous avons transformé le ManyToMany afin qu'il soit
    		// possible de faire une clé composite. Ici du coup, on va faire une relation entre la table de jointure (qui est une entité)
			// avec la table collaborateur, puis une autre avec competence.
    @MapsId("id_collaborateur") // Permet de lier ces champs comme étant une "partie" de la clé primaire.
    @JoinColumn(name = "id_collaborateur") // Vu qu'on fait une association avec une entité, on utilisera ça afin de faire le lien.
    @JsonView(MyJsonView.Competence.class)
    Collaborateur collaborateur;

	@ManyToOne
    @MapsId("id_competence") // Accessoirement, cela permet de les marquer en tant que clé etrangère de la relation many to one. Le many possède la fk.
    @JoinColumn(name = "id_competence")
    @JsonView(MyJsonView.Collaborateur.class)
    // @Column(name = "id_competence", insertable = false, updatable = false)
    Competence competence;

    @Enumerated(EnumType.STRING)
    @JsonView(MyJsonView.Collaborateur.class) 
    private Experience experience;
    
    @JsonView(MyJsonView.Collaborateur.class)
    private int anneesExperience;
    
    
}
