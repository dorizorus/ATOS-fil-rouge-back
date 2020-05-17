package atos.bdd.model.utilisateur;

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
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(MyJsonView.Utilisateur.class)
    private int id;

    @JsonView(MyJsonView.Utilisateur.class)
    private String libelle;

    @OneToMany(mappedBy = "role")
    private Set<Utilisateur> utilisateurs;
}
