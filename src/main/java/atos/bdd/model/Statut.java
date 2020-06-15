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
public class Statut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private int id;

    @JsonView({
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private String libelle;

    @OneToMany(mappedBy = "statut")
    private Set<Proposition> propositions;
}
