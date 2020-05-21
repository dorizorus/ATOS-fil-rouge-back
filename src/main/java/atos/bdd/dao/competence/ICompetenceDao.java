package atos.bdd.dao.competence;

import atos.bdd.model.competence.Competence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetenceDao extends JpaRepository<Competence, Integer> {
	
	List<Competence> findAllByTypeOrderByLibelleAsc(String type);
	
}
