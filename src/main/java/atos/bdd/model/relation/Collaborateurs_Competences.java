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
	
	@EmbeddedId // Marque la variable qui sera la clé primaire. Chaque entité à besoin d'une clé primaire. Ici id, qui est une instanciation de cle_collab_compet
	Cle_collab_competence id;
	
    @ManyToOne // Au final un many to many n'existe pas dans la BDD, ce sont des many to one qui sont fait au niveau de la base de donnée.
    		// Ici du coup, on va faire une relation entre la table de jointure (qui est une entité) avec la table collaborateur, puis une autre avec competence.
    @MapsId("id_collaborateur") // Permet de lier ces champs comme étant une "partie" de la clé primaire.
    @JoinColumn(name = "id_collaborateur") // Vu qu'on fait une association avec une entité, on utilisera ça afin de faire le lien.
 // @Column(name = "id_collaborateur", insertable = false, updatable = false)
    Collaborateur collaborateur;

    @ManyToOne
    @MapsId("id_competence") // Accessoirement, cela permet de les marquer en tant que clé etrangère de la relation many to one. Le many possède la fk.
    @JoinColumn(name = "id_competence")
    // @Column(name = "id_competence", insertable = false, updatable = false)
    Competence competence;

    @Enumerated(EnumType.STRING)
    @JsonView(MyJsonView.Collaborateur.class) 
    private Experience experience;
    
    @JsonView(MyJsonView.Collaborateur.class)
    private int anneesExperience;

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public int getAnneesExperience() {
		return anneesExperience;
	}

	public void setAnneesExperience(int anneesExperience) {
		this.anneesExperience = anneesExperience;
	}

	public Cle_collab_competence getId() {
		return id;
	}

	public void setId(Cle_collab_competence id) {
		this.id = id;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
    
    
}
