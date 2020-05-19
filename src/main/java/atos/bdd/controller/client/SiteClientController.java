package atos.bdd.controller.client;

import atos.bdd.dao.client.ISiteClientDao;
import atos.bdd.model.client.Client;
import atos.bdd.model.client.SiteClient;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiteClientController {

    ISiteClientDao iSiteClientDao;

    @Autowired
    public SiteClientController(ISiteClientDao iSiteClientDao) {
        this.iSiteClientDao = iSiteClientDao;
    }


    //récupérer tous les sites clients
    @GetMapping("/sitesclients")
    @JsonView(MyJsonView.SiteClient.class)
    public List<SiteClient> getSitesClients() {
        return iSiteClientDao.findAll();
    }

    //récupérer un site client spécifique par son id
    @GetMapping("/sitesclients/{id}")
    @JsonView(MyJsonView.SiteClient.class)
    public SiteClient getClient(@PathVariable int id) {
        return iSiteClientDao.findById(id).orElse(null);
    }

    //ajouter un nouveau site client
    @PutMapping("/addsiteclient")
    public String saveSiteClient(@RequestBody SiteClient siteClient) {
        iSiteClientDao.save(siteClient);
        return "client saved with id= " + siteClient.getId();
    }
}
