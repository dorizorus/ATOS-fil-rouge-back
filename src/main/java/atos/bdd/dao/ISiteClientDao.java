package atos.bdd.dao;

import atos.bdd.model.SiteClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiteClientDao extends JpaRepository<SiteClient, Integer> {

    SiteClient findByAdresse(String adresse);
}
