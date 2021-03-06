package atos.bdd.controller;

import atos.bdd.dao.IContactSoustraitantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ContactSoutraitantController {

    IContactSoustraitantDao iContactSoustraitantDao;

    @Autowired
    public ContactSoutraitantController(IContactSoustraitantDao iContactSoustraitantDao) {
        this.iContactSoustraitantDao = iContactSoustraitantDao;
    }
}
