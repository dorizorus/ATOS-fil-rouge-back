package atos.bdd.controller.besoin;

import atos.bdd.dao.besoin.IPropositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropositionController {

    IPropositionDao iPropositionDao;

    @Autowired
    public PropositionController(IPropositionDao iPropositionDao) {
        this.iPropositionDao = iPropositionDao;
    }
}
