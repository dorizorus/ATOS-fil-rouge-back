package atos.bdd.model;

import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SiteClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({
            MyJsonView.Client.class,
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private int id;

    @JsonView({
            MyJsonView.Client.class,
            MyJsonView.Besoin.class,
            MyJsonView.Proposition.class
    })
    private String nomVille;

    private String adresse;

    @JsonView(MyJsonView.SiteClient.class)
    private boolean estActif;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToMany(mappedBy = "siteClient")
    @JsonIgnore
    private Set<ContactClient> contactsClient;
}
