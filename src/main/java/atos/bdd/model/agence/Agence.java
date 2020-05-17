package atos.bdd.model.agence;

import atos.bdd.model.besoin.Besoin;
import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.model.soustraitant.ContactSoustraitant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;

    @OneToMany(mappedBy = "agence")
    private Set<Besoin> besoins;

    @OneToMany(mappedBy = "agence")
    private Set<Collaborateur> collaborateurs;

    @OneToMany(mappedBy = "agence")
    private Set<ContactSoustraitant> contacts_soustraitant;


}
