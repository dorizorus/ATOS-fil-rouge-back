package atos.bdd.model.relation;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Getter
@Setter
@Embeddable // Marque la classe comme étant "intégrable". Le but de cette classe est de créer une clé primaire à partir des id marqué par @EmbeddedId 
// puis les joindre en une seule clé. 
public class Cle_collab_competence implements Serializable {

	
	// Afin que cela fonctionne, il faut implémenter Serializable, mettre des constructeurs, générer les getters&setters 
	// ainsi que les méthodes hashcode et equals. J'ai enlevé les @getter et @setter dans le doute et remplacer par les méthodes de base.
	
	@Column(name = "id_collaborateur") // Le nom de la colonne qui possède la clé étrangère pour le collaborateur
	private long idCollaborateur;
	
	@Column(name = "id_competence")
	private int idCompetence;
	
	public Cle_collab_competence() // Constructeur no arg (sans arguments)
	{
		
	}
	
	public Cle_collab_competence(long idCollaborateur, int idCompetence)
	{
		this.idCollaborateur = idCollaborateur;
		this.idCompetence = idCompetence;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cle_collab_competence that = (Cle_collab_competence) obj;
        return Objects.equals(getIdCollaborateur(), that.getIdCollaborateur()) && 
            	Objects.equals(getIdCompetence(), that.getIdCompetence());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getIdCollaborateur(), getIdCompetence());
	}
	
	

}
