package atos.bdd.dao;

import atos.bdd.model.relation.Cle_collab_competence;
import atos.bdd.model.relation.Collaborateurs_Competences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceDao extends JpaRepository<Collaborateurs_Competences, Cle_collab_competence> {
}
