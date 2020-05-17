package atos.bdd.model.client;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class ContactClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String nom;
    private String prenom;
    private String position;
    private String email;
    private String numTelPerso;
    private String numTelPro;
    private String numFax;

    @ManyToOne
    @JoinColumn(name = "id_site")
    private SiteClient siteClient;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

}
