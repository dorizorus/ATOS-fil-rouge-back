package atos.bdd.model;


import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
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
    @JsonView(MyJsonView.ContactClient.class)
    private int id;

    @JsonView(MyJsonView.ContactClient.class)
    private String nom;

    @JsonView(MyJsonView.ContactClient.class)
    private String prenom;

    @JsonView(MyJsonView.ContactClient.class)
    private String position;

    @JsonView(MyJsonView.ContactClient.class)
    private String email;

    @JsonView(MyJsonView.ContactClient.class)
    private String numTelPerso;

    @JsonView(MyJsonView.ContactClient.class)
    private String numTelPro;

    @JsonView(MyJsonView.ContactClient.class)
    private String numFax;

    @ManyToOne
    @JoinColumn(name = "id_site")
    private SiteClient siteClient;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

}
