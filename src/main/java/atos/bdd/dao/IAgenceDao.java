package atos.bdd.dao;

import atos.bdd.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAgenceDao extends JpaRepository<Agence, Integer> {
}
