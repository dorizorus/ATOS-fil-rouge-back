package atos.bdd.dao;

import atos.bdd.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatutDao extends JpaRepository<Statut, Integer> {
}
