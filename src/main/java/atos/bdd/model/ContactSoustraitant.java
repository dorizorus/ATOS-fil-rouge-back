package atos.bdd.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ContactSoustraitant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String prenom;
    private String email;
    private String numTelPerso;
    private String numTelPro;

    @ManyToOne
    @JoinColumn(name = "id_agence")
    private Agence agence;

}
