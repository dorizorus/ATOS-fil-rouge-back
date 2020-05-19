package atos.bdd.model.collaborateur;

import atos.bdd.model.agence.Agence;
import atos.bdd.model.competence.Competence;
import atos.bdd.model.besoin.Proposition;
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
public class Collaborateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({
            MyJsonView.Besoin.class,
    MyJsonView.Proposition.class
    })
    private long id;

    private int bench;

    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private String nom;

    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private String prenom;

    @JsonView(MyJsonView.Proposition.class)
    private String cvUrl;

    @ManyToMany(cascade = CascadeType.MERGE)
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
