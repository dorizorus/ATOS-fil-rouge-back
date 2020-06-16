package atos.bdd.controller;

import atos.bdd.dao.IDemarcheDao;
import atos.bdd.model.Client;
import atos.bdd.model.Demarche;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DemarcheController {

    IDemarcheDao iDemarcheDao;

    @Autowired
    public DemarcheController(IDemarcheDao iDemarcheDao) {
        this.iDemarcheDao = iDemarcheDao;
    }

    //récupérer toutes les démarches
    @GetMapping("/demarches")
    @JsonView(MyJsonView.Demarche.class)
    public List<Demarche> getDemarches() {
        return iDemarcheDao.findAll();
    }

    //récupérer une démarche spécifique par son id
    @GetMapping("/demarches/{id}")
    @JsonView(MyJsonView.Demarche.class)
    public Demarche getDemarche(@PathVariable long id) {
        return iDemarcheDao.findById(id).orElse(null);
    }

    //ajouter une nouvelle démarche
    @PutMapping("/adddemarche")
    public String saveDemarche(@RequestBody Demarche demarche) {
        iDemarcheDao.save(demarche);
        return "Démarche ajoutée avec id= " + demarche.getId();
    }

    //modification d'une démarche
    @PutMapping("/updatedemarche")
    public String updateDemarche(@RequestBody Demarche demarche){
        if (demarche!=null){
            iDemarcheDao.save(demarche);
            return "Démarche modifiée";
        }else{
            return "Démarche non trouvée";
        }
    }

    //suppression d'une démarche
    @DeleteMapping("/deletedemarche/{id}")
    public ResponseEntity deleteDemarche(@PathVariable int id){
        Demarche demarche = iDemarcheDao.findById(id).orElse(null);

        if(demarche == null){
            return ResponseEntity.noContent().build();
        }

        iDemarcheDao.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
