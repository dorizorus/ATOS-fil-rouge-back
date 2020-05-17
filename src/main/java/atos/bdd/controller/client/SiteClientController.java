package atos.bdd.controller.client;

import atos.bdd.dao.client.ISiteClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteClientController {

    ISiteClientDao iSiteClientDao;

    @Autowired
    public SiteClientController(ISiteClientDao iSiteClientDao) {
        this.iSiteClientDao = iSiteClientDao;
    }
}
