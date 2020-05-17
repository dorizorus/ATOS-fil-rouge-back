package atos.bdd.dao.client;

import atos.bdd.model.client.ContactClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactClientDao extends JpaRepository<ContactClient, Integer> {
}
