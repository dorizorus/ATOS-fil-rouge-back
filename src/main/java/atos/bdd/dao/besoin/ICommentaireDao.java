package atos.bdd.dao.besoin;

import atos.bdd.model.besoin.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentaireDao extends JpaRepository<Commentaire, Integer> {
}
