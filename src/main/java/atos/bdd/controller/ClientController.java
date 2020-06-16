package atos.bdd.controller;

import atos.bdd.dao.IClientDao;
import atos.bdd.model.Client;
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

    @Autowired
    public ClientController(IClientDao iClientDao) {
        this.iClientDao = iClientDao;
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
    @PutMapping("/addclient")
    public String saveClient(@RequestBody Client client) {
        iClientDao.save(client);
        return "client ajouté avec id= " + client.getId();
    }

    //modification d'un client
    @PutMapping("/updateclient")
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
