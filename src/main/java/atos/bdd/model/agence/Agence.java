package atos.bdd.model.agence;

import atos.bdd.model.besoin.Besoin;
import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.model.soustraitant.ContactSoustraitant;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView({MyJsonView.Besoin.class, MyJsonView.Collaborateur.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @JsonView({ MyJsonView.Besoin.class, MyJsonView.Collaborateur.class})
    private String nom;

    @OneToMany(mappedBy = "agence")
    private Set<Besoin> besoins;
    
    @OneToMany(mappedBy = "agence")
    private Set<Collaborateur> collaborateurs;

    @OneToMany(mappedBy = "agence")
    private Set<ContactSoustraitant> contacts_soustraitant;


}
