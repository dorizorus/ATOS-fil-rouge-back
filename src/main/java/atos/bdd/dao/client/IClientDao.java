package atos.bdd.dao;

import atos.bdd.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientDao extends JpaRepository<Client, Integer> {

}
