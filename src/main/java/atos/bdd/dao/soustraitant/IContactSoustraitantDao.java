package atos.bdd.dao.soustraitant;

import atos.bdd.model.soustraitant.ContactSoustraitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactSoustraitantDao extends JpaRepository<ContactSoustraitant, Integer> {
}
