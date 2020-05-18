package atos.bdd.dao.besoin;

import atos.bdd.model.besoin.Demarche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDemarcheDao extends JpaRepository<Demarche,Integer> {
}