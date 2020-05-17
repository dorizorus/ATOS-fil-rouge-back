package atos.bdd.dao.utilisateur;

import atos.bdd.model.utilisateur.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends JpaRepository<Role, Integer> {
}
