package atos.bdd.model;

import atos.bdd.model.relation.Besoins_Competences;
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
public class Besoin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private long id;

    @Temporal(TemporalType.DATE)
    @JsonView(MyJsonView.Besoin.class)
    private Date dateEmission;

    @Temporal(TemporalType.DATE)
    @JsonView(MyJsonView.Besoin.class)
    private Date dateEcheance;

    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private boolean estOuvert;

    @JsonView(MyJsonView.Besoin.class)
    private boolean estSatisfait;

    @JsonView(MyJsonView.Besoin.class)
    private boolean estRecurrent;

    @OneToMany(mappedBy = "besoin", cascade = CascadeType.MERGE)
    @JsonView(MyJsonView.Besoin.class)
    private Set<Besoins_Competences> competences;

    @ManyToOne
    @JoinColumn(name = "id_client")
    @JsonView(MyJsonView.Besoin.class)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_site")
    @JsonView(MyJsonView.Besoin.class)
    private SiteClient siteClient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contact")
    @JsonView(MyJsonView.Besoin.class)
    private ContactClient contactClient;


    @OneToMany(mappedBy = "besoin")
    @JsonView(MyJsonView.Besoin.class)
    private Set<Proposition> propositions;


    @JsonView(MyJsonView.Besoin.class)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "id_agence")
    @JsonView(MyJsonView.Besoin.class)
    private Agence agence;

    @OneToMany(mappedBy = "besoin")
    @JsonView(MyJsonView.Besoin.class)
    private Set<Commentaire> commentaires;

}
