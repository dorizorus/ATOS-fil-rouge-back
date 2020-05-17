package atos.bdd.dao.besoin;

import atos.bdd.model.besoin.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatutDao extends JpaRepository<Statut, Integer> {
}
