package atos.bdd.controller.besoin;

import atos.bdd.dao.besoin.IDemarcheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemarcheController {

    IDemarcheDao iDemarcheDao;

    @Autowired
    public DemarcheController(IDemarcheDao iDemarcheDao) {
        this.iDemarcheDao = iDemarcheDao;
    }
}
