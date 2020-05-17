package atos.bdd.dao.client;

import atos.bdd.model.client.SiteClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiteClientDao extends JpaRepository<SiteClient, Integer> {
}
