package atos.bdd.model.besoin;

import atos.bdd.model.client.SiteClient;
import atos.bdd.model.utilisateur.Utilisateur;
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
    private long id;

    private String libelle;

    @Temporal(TemporalType.DATE)
    private Date datePlanification;

    @Temporal(TemporalType.DATE)
    private Date dateDemarche;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_site_client")
    private SiteClient siteClient;

    @OneToMany(mappedBy = "demarche")
    private Set<Commentaire> commentaires;
}
