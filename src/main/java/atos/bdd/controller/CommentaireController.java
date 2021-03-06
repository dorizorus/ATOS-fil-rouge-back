package atos.bdd.controller;

import atos.bdd.dao.ICommentaireDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CommentaireController {

    ICommentaireDao iCommentaireDao;

    @Autowired
    public CommentaireController(ICommentaireDao iCommentaireDao) {
        this.iCommentaireDao = iCommentaireDao;
    }
}
