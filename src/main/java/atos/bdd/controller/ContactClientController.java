package atos.bdd.controller;

import atos.bdd.dao.IContactClientDao;
import atos.bdd.model.ContactClient;
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
    public String saveContactClient(@RequestBody ContactClient contactClient) {
        iContactClientDao.save(contactClient);
        return "contact client ajouté avec id= " + contactClient.getId();
    }

    //modification d'un contact client
    @PutMapping("/updatecontactclient")
    public String updateContactClient(@RequestBody ContactClient contactClient){
        if (contactClient!=null){
            iContactClientDao.save(contactClient);
            return "Contact client modifié";
        }else{
            return "Contact client non trouvé";
        }
    }

    //suppression d'un contact client
    @DeleteMapping("/deletecontactclient")
    public String deleteContactClient(@RequestBody ContactClient contactClient){
        if (contactClient!=null){
            iContactClientDao.delete(contactClient);
            return "Contact Client supprimé";
        }else{
            return "Contact Client non trouvé";
        }
    }


}
