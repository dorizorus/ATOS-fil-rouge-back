package atos.bdd.dao.collaborateur;

import atos.bdd.model.collaborateur.Collaborateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICollaborateurDao extends JpaRepository<Collaborateur, Integer> {
	
	Collaborateur findById(long id);
	
	List<Collaborateur> findAllByOrderByTitreAsc();
	List<Collaborateur> findAllByOrderByTitreDesc();
	
	List<Collaborateur> findAllByOrderByAgenceAsc();
	List<Collaborateur> findAllByOrderByAgenceDesc();
	
	List<Collaborateur> findAllByOrderByNomAsc();
	List<Collaborateur> findAllByOrderByNomDesc();
	
	List<Collaborateur> findAllByOrderByPrenomAsc();
	List<Collaborateur> findAllByOrderByPrenomDesc();
	
	List<Collaborateur> findAllByOrderByIdentifiantAsc();
	List<Collaborateur> findAllByOrderByIdentifiantDesc();
	
	List<Collaborateur> findAllByOrderByBenchAsc();
	List<Collaborateur> findAllByOrderByBenchDesc();
}
