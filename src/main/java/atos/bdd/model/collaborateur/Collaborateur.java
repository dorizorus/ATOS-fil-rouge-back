package atos.bdd.model.collaborateur;

import atos.bdd.model.agence.Agence;
import atos.bdd.model.competence.Competence;
import atos.bdd.model.besoin.Proposition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Collaborateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int bench;

    private String nom;
    private String prenom;
    private String cvUrl;

    @ManyToMany
    @JoinTable(
            name = "collaborateurs_competences",
            joinColumns = @JoinColumn(name = "id_collaborateur"),
            inverseJoinColumns = @JoinColumn(name = "id_competence")
    )
    private Set<Competence> competences;

    @OneToMany(mappedBy = "collaborateur")
    private Set<Proposition> propositions;

    @ManyToOne
    @JoinColumn(name = "id_agence")
    private Agence agence;


}
