package atos.bdd.dao.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import atos.bdd.model.relation.Cle_collab_competence;
import atos.bdd.model.relation.Collaborateurs_Competences;

@Repository
public interface ICollaborateur_CompetencesDao extends JpaRepository<Collaborateurs_Competences, Integer> {
	
}
