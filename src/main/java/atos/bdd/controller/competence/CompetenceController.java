package atos.bdd.controller.competence;

import atos.bdd.dao.competence.ICompetenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompetenceController {

    ICompetenceDao iCompetenceDao;

    @Autowired
    public CompetenceController(ICompetenceDao iCompetenceDao) {
        this.iCompetenceDao = iCompetenceDao;
    }
}
