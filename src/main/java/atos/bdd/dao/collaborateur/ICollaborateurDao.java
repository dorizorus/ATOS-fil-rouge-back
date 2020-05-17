package atos.bdd.dao.collaborateur;

import atos.bdd.model.collaborateur.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICollaborateurDao extends JpaRepository<Collaborateur, Integer> {
}
