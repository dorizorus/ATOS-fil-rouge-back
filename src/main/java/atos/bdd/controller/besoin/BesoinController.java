package atos.bdd.controller.besoin;

import atos.bdd.dao.besoin.IBesoinDao;
import atos.bdd.model.besoin.Besoin;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BesoinController {

    IBesoinDao iBesoinDao;

    @Autowired
    public BesoinController(IBesoinDao iBesoinDao) {
        this.iBesoinDao = iBesoinDao;
    }

    @GetMapping("/besoin/tous")
    @JsonView(MyJsonView.Besoin.class)
    public List<Besoin> getBesoinsTousTriOuvertEtDate() {
        return iBesoinDao.findAllByOrderByEstOuvertDescDateEcheanceAsc();
    }

    @GetMapping("/besoin/en-cours")
    @JsonView(MyJsonView.Besoin.class)
    public List<Besoin> getBesoinsEnCoursTriDateEcheance() {
        return iBesoinDao.findAllByEstOuvertTrueOrderByDateEcheanceAsc();
    }

    @GetMapping("/besoin/termines")
    @JsonView(MyJsonView.Besoin.class)
    public List<Besoin> getBesoinsTerminesTriDateEchance() {
        return iBesoinDao.findAllByEstOuvertFalseOrderByDateEcheanceAsc();
    }
}
