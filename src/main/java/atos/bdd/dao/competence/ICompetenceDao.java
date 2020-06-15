package atos.bdd.dao;

import atos.bdd.model.Competence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompetenceDao extends JpaRepository<Competence, Integer> {
	
	List<Competence> findAllByTypeOrderByLibelleAsc(String type);
	
}
