package atos.bdd.controller.client;

import atos.bdd.dao.client.IContactClientDao;
import atos.bdd.model.client.ContactClient;
import atos.bdd.model.client.SiteClient;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactClientController {

    IContactClientDao iContactClientDao;

    @Autowired
    public ContactClientController(IContactClientDao iContactClientDao) {
        this.iContactClientDao = iContactClientDao;
    }

    //récupérer tous les contacts clients
    @GetMapping("/contactsclients")
    @JsonView(MyJsonView.ContactClient.class)
    public List<ContactClient> getContactsClients() {
        return iContactClientDao.findAll();
    }

    //récupérer un contact client spécifique par son id
    @GetMapping("/contactsclients/{id}")
    @JsonView(MyJsonView.ContactClient.class)
    public ContactClient getContactClient(@PathVariable int id) {
        return iContactClientDao.findById(id).orElse(null);
    }

    //ajouter un nouveau contact client
    @PutMapping("/addcontactclient")
    public String saveSiteClient(@RequestBody ContactClient contactClient) {
        iContactClientDao.save(contactClient);
        return "contact client ajouté avec id= " + contactClient.getId();
    }


}
