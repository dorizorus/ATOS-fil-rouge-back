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
    @JsonView(MyJsonView.Utilisateur.class)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateProposition;

    @Temporal(TemporalType.DATE)
    private Date dateRelance;

    private long prixAchat;
    private long prixVente;

    @ManyToOne
    @JoinColumn(name = "id_besoin")
    private Besoin besoin;

    @ManyToOne
    @JoinColumn(name = "id_collaborateur")
    private Collaborateur collaborateur;

    @ManyToOne
    @JoinColumn(name = "id_statut")
    private Statut statut;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "proposition")
    private Set<Commentaire> commentaires;

}
