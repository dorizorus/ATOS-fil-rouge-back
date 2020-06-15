package atos.bdd.model;

import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private long id;

    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private String commentaire;

    @Temporal(TemporalType.DATE)
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
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
