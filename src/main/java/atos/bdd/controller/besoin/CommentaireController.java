package atos.bdd.controller.besoin;

import atos.bdd.dao.besoin.ICommentaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentaireController {

    ICommentaireDao iCommentaireDao;

    @Autowired
    public CommentaireController(ICommentaireDao iCommentaireDao) {
        this.iCommentaireDao = iCommentaireDao;
    }
}
