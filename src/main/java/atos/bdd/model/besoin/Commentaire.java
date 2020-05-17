package atos.bdd.model.besoin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String commentaire;

    @Temporal(TemporalType.DATE)
    private Date dateEmission;

    @ManyToOne
    @JoinColumn(name = "id_besoin")
    private Besoin besoin;

    @ManyToOne
    @JoinColumn(name = "id_demarche")
    private Demarche demarche;

    @ManyToOne
    @JoinColumn(name = "id_proposition")
    private Proposition proposition;
}
