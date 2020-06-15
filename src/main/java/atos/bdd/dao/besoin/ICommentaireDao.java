package atos.bdd.dao;

import atos.bdd.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentaireDao extends JpaRepository<Commentaire, Integer> {
}
