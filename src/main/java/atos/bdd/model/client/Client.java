package atos.bdd.model.client;


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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(MyJsonView.Client.class)
    private int id;

    @JsonView(MyJsonView.Client.class)
    private String nom;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<SiteClient> sites;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<ContactClient> contacts;
}
