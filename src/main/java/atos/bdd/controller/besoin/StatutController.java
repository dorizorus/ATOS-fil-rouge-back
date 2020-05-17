package atos.bdd.controller.besoin;

import atos.bdd.dao.besoin.IStatutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatutController {

    IStatutDao iStatutDao;

    @Autowired
    public StatutController(IStatutDao iStatutDao) {
        this.iStatutDao = iStatutDao;
    }
}
