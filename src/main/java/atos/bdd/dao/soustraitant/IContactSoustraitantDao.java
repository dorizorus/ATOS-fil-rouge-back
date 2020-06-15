package atos.bdd.dao;

import atos.bdd.model.ContactSoustraitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactSoustraitantDao extends JpaRepository<ContactSoustraitant, Integer> {
}
