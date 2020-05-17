package atos.bdd.dao.utilisateur;

import atos.bdd.model.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {
}
