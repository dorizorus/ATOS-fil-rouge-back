package atos.bdd.model.besoin;

import atos.bdd.model.client.SiteClient;
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
public class Demarche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(MyJsonView.Demarche.class)
    private long id;

    @JsonView(MyJsonView.Demarche.class)
    private String libelle;

    @Temporal(TemporalType.DATE)
    @JsonView(MyJsonView.Demarche.class)
    private Date datePlanification;

    @Temporal(TemporalType.DATE)
    @JsonView(MyJsonView.Demarche.class)
    private Date dateDemarche;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_site_client")
    private SiteClient siteClient;

    @OneToMany(mappedBy = "demarche")
    private Set<Commentaire> commentaires;
}
