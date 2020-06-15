package atos.bdd.dao;

import atos.bdd.model.ContactClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactClientDao extends JpaRepository<ContactClient, Integer> {
}
