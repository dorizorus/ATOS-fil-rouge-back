package atos.bdd.controller;

import atos.bdd.dao.IClientDao;
import atos.bdd.dao.IContactClientDao;
import atos.bdd.dao.ISiteClientDao;
import atos.bdd.model.Client;
import atos.bdd.model.ContactClient;
import atos.bdd.model.SiteClient;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClientController {

    IClientDao iClientDao;
    ISiteClientDao iSiteClientDao;
    IContactClientDao iContactClientDao;

    @Autowired
    public ClientController(IClientDao iClientDao, ISiteClientDao iSiteClientDao, IContactClientDao iContactClientDao) {
        this.iClientDao = iClientDao;
        this.iSiteClientDao = iSiteClientDao;
        this.iContactClientDao = iContactClientDao;
    }

    //récupérer tous les clients
    @GetMapping("/clients")
    @JsonView(MyJsonView.Client.class)
    public List<Client> getClients() {
        return iClientDao.findAll();
    }

    //récupérer un client spécifique par son id
    @GetMapping("/clients/{id}")
    @JsonView(MyJsonView.Client.class)
    public Client getClient(@PathVariable int id) {
        return iClientDao.findById(id).orElse(null);
    }

    //ajouter un nouveau client
    @PostMapping("/addclient")
    @JsonView(MyJsonView.Client.class)
    public Client saveClient(@RequestBody Client client) {

        //on enregistre le client et on le récup directement derrière.
        iClientDao.saveAndFlush(client);


        if (client.getSites() != null) {
            for (SiteClient site : client.getSites()) {
                site.setClient(client);
                iSiteClientDao.save(site);
            }
        }

        if (client.getContacts() != null) {
            for (ContactClient contact : client.getContacts()) {
                contact.setClient(client);
                SiteClient site = iSiteClientDao.findByAdresse(contact.getSiteClient().getAdresse());
                contact.setSiteClient(site);
                iContactClientDao.save(contact);
            }
        }
        
        return iClientDao.findById(client.getId()).orElse(null);
    }

    //modification d'un client
    @PostMapping("/updateclient")
    public String updateClient(@RequestBody Client client) {
        if (client!=null){
            iClientDao.save(client);
            return "Client modifié";
        }else{
            return "Client non trouvé";
        }
    }

    //suppression d'un client
    @DeleteMapping("/deleteclient/{id}")
    public ResponseEntity  deleteClient(@PathVariable int id) {
        Client client = iClientDao.findById(id).orElse(null);

        if(client == null){
            return ResponseEntity.noContent().build();
        }

        iClientDao.deleteById(id);

        return ResponseEntity.ok().build();

    }
}
