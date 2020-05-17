package atos.bdd.controller.client;

import atos.bdd.dao.client.IContactClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactClientController {

    IContactClientDao iContactClientDao;

    @Autowired
    public ContactClientController(IContactClientDao iContactClientDao) {
        this.iContactClientDao = iContactClientDao;
    }
}
