package atos.bdd.controller.soustraitant;

import atos.bdd.dao.soustraitant.IContactSoustraitantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactSoutraitantController {

    IContactSoustraitantDao iContactSoustraitantDao;

    @Autowired
    public ContactSoutraitantController(IContactSoustraitantDao iContactSoustraitantDao) {
        this.iContactSoustraitantDao = iContactSoustraitantDao;
    }
}
