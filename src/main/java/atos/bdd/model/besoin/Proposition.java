package atos.bdd.model.besoin;

import atos.bdd.model.collaborateur.Collaborateur;
import atos.bdd.model.utilisateur.Utilisateur;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Proposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({
            MyJsonView.Utilisateur.class,
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private long id;

    @Temporal(TemporalType.DATE)
    @JsonView({
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private Date dateProposition;

    @Temporal(TemporalType.DATE)
    @JsonView({
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private Date dateRelance;

    @JsonView({
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private long prixAchat;

    @JsonView({
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private long prixVente;

    @ManyToOne
    @JoinColumn(name = "id_besoin")
    @JsonView(MyJsonView.Proposition.class)
    private Besoin besoin;

    @ManyToOne
    @JoinColumn(name = "id_collaborateur")
    @JsonView({
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private Collaborateur collaborateur;

    @ManyToOne
    @JoinColumn(name = "id_statut")
    @JsonView({
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private Statut statut;


    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    @JsonView({
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "proposition")
    @JsonView({
            MyJsonView.Proposition.class,
            MyJsonView.Besoin.class
    })
    private Set<Commentaire> commentaires;

}
