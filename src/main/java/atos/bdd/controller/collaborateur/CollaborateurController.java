package atos.bdd.controller.collaborateur;

import atos.bdd.dao.collaborateur.ICollaborateurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollaborateurController {

    ICollaborateurDao iCollaborateurDao;

    @Autowired
    public CollaborateurController(ICollaborateurDao iCollaborateurDao) {
        this.iCollaborateurDao = iCollaborateurDao;
    }
}
