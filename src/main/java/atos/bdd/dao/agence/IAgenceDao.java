package atos.bdd.dao.agence;

import atos.bdd.model.agence.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgenceDao extends JpaRepository<Agence, Integer> {
}
