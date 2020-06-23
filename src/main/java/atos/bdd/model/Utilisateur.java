package atos.bdd.model;

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
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({
            MyJsonView.Utilisateur.class,
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private long id;

    @JsonView({
            MyJsonView.Utilisateur.class,
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private String nom;

    @JsonView({
            MyJsonView.Utilisateur.class,
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private String prenom;

    @JsonView(MyJsonView.Utilisateur.class)
    private String login;

    @JsonView(MyJsonView.Utilisateur.class)
    private String password;

    @JsonView(MyJsonView.Utilisateur.class)
    private boolean estActif;

    @ManyToOne
    @JoinColumn(name = "id_role")
    @JsonView(MyJsonView.Utilisateur.class)
    private Role role;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Proposition> propositions;
}
