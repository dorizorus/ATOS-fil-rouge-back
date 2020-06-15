package atos.bdd.dao;

import atos.bdd.model.Demarche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDemarcheDao extends JpaRepository<Demarche,Integer> {
    Optional<Demarche> findById(long id);
}
