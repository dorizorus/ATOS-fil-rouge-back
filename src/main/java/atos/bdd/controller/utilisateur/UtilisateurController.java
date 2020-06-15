package atos.bdd.controller;

import atos.bdd.dao.IUtilisateurDao;
import atos.bdd.model.Utilisateur;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController {

    IUtilisateurDao iUtilisateurDao;

    @Autowired
    public UtilisateurController(IUtilisateurDao iUtilisateurDao) {
        this.iUtilisateurDao = iUtilisateurDao;
    }

    @RequestMapping("/utilisateurs")
    @JsonView(MyJsonView.Utilisateur.class)
    public List<Utilisateur> getUtilisateurs() {
        return iUtilisateurDao.findAll();
    }
}
