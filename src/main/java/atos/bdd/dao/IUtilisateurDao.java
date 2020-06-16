package atos.bdd.dao;

import atos.bdd.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {
}