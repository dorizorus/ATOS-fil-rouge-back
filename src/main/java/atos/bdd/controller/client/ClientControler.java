package atos.bdd.controller.client;

import atos.bdd.dao.client.IClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientControler {

    IClientDao iClientDao;

    @Autowired
    public ClientControler(IClientDao iClientDao) {
        this.iClientDao = iClientDao;
    }
}
