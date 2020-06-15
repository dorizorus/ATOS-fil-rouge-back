package atos.bdd.dao;

import atos.bdd.model.Besoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface IBesoinDao extends JpaRepository<Besoin, Integer> {

    //choppe tous les besoin, ouverts en premier et ensuite tri par date d'échéance (la plus proche (urgente) en premier)
    List<Besoin> findAllByOrderByEstOuvertDescDateEcheanceAsc();

    //choppe tous les besoins ouverts, les tri par date d'échance (la plus proche en premier)
    List<Besoin> findAllByEstOuvertTrueOrderByDateEcheanceAsc();

    //choppe tous les besoins fermés, les tri par date d'échance (la plus proche en premier)
    List<Besoin> findAllByEstOuvertFalseOrderByDateEcheanceDesc();

    //choppe les besoin ouverts et affiche ceux dont le nom du client contient ce qu'entre l'utilisateur
    List<Besoin> findAllByEstOuvertTrueAndClientNomLike(String search);

    Besoin findById(long id);

}
