package atos.bdd.controller;

import atos.bdd.dao.ISiteClientDao;
import atos.bdd.model.SiteClient;
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
        return "site client ajouté avec id= " + siteClient.getId();
    }

    //modification d'un site client
    @PutMapping("/updatesiteclient")
    public String updateSiteClient(@RequestBody SiteClient siteClient){
        if (siteClient!=null){
            iSiteClientDao.save(siteClient);
            return "Site client modifié";
        }else{
            return "Site client non trouvé";
        }
    }

    //suppression d'un site client
    @DeleteMapping("/deletesiteclient")
    public String deleteSiteClient(@RequestBody SiteClient siteClient){
        if (siteClient!=null){
            iSiteClientDao.delete(siteClient);
            return "Site client supprimé";
        }else{
            return "Site client non trouvé";
        }
    }


}
