package atos.bdd.dao;

import atos.bdd.model.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPropositionDao extends JpaRepository<Proposition,Integer> {

    // choppe les propositions
    // dont les besoins auxquels elles sont liées sont encore ouverts
    List<Proposition> findAllByBesoinEstOuvertTrue();

    Proposition findById(long id);

    List<Proposition> findAllByOrderByBesoinEstOuvertDescDateRelanceAsc();

}
