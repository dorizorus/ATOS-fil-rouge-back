package atos.bdd.dao;

import atos.bdd.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByLogin(String login);
    Optional<Utilisateur> findById(long id);
}
