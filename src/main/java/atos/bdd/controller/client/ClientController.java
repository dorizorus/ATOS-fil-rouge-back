package atos.bdd.controller.client;

import atos.bdd.dao.client.IClientDao;
import atos.bdd.model.client.Client;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Client> getClients(){
        return iClientDao.findAll();
    }

    //récupérer un client spécifique par son id
    @GetMapping("/clients/{id}")
    @JsonView(MyJsonView.Client.class)
    public Client getClient(@PathVariable int id){
        return iClientDao.findById(id).orElse(null);
    }

    //ajouter un nouveau client
    @PutMapping("/addclient")
    public String saveClient(@RequestBody Client client) {
        iClientDao.save(client);
        return "client saved with id= "+client.getId();
    }










}