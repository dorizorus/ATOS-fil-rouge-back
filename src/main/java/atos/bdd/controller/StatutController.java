package atos.bdd.controller;

import atos.bdd.dao.IStatutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class StatutController {

    IStatutDao iStatutDao;

    @Autowired
    public StatutController(IStatutDao iStatutDao) {
        this.iStatutDao = iStatutDao;
    }
}
