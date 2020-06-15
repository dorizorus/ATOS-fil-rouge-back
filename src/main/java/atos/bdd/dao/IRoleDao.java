package atos.bdd.dao;

import atos.bdd.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends JpaRepository<Role, Integer> {
}
