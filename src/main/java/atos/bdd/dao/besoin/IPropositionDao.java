package atos.bdd.dao.besoin;

import atos.bdd.model.besoin.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropositionDao extends JpaRepository<Proposition,Integer> {
}
