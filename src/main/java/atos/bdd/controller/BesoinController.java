package atos.bdd.controller;

import atos.bdd.dao.IBesoinDao;
import atos.bdd.model.Besoin;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BesoinController {

    IBesoinDao iBesoinDao;

    @Autowired
    public BesoinController(IBesoinDao iBesoinDao) {
        this.iBesoinDao = iBesoinDao;
    }

    /**
     * Méthode qui affiche tous les besoins,
     * ouverts en premier, avec date d'échance arrivant à son terme en premier
     * @return liste de tous les besoins
     */

    @GetMapping("/besoins/tous")
    @JsonView(MyJsonView.Besoin.class)
    public List<Besoin> getBesoinsTousTriOuvertEtDate() {
        return iBesoinDao.findAllByOrderByEstOuvertDescDateEcheanceAsc();
    }

    /**
     * Méthode qui affiche tous les besoins ouverts (en cours),
     * avec date d'échance arrivant à son terme en premier
     * @return liste des besoins ouverts
     */

    @GetMapping("/besoins/en-cours")
    @JsonView(MyJsonView.Besoin.class)
    public List<Besoin> getBesoinsOuvertsTriDateEcheance() {
        return iBesoinDao.findAllByEstOuvertTrueOrderByDateEcheanceAsc();
    }

    /**
     * Méthode qui affiche tous les besoins fermés (terminés),
     * avec date d'échance au plus proche de la date du jour J en premier
     * @return liste des besoins fermés
     */

    @GetMapping("/besoins/termines")
    @JsonView(MyJsonView.Besoin.class)
    public List<Besoin> getBesoinsTerminesTriDateEchance() {
        return iBesoinDao.findAllByEstOuvertFalseOrderByDateEcheanceDesc();
    }

    /**
     * Méthode qui affiche tous les besoins ouverts,
     * dont le nom du client contient ce qu'entre l'utilisateur
     * @return liste des besoins ouverts avec critère de recherche
     */

    @GetMapping("/besoins/en-cours/{search}")
    @JsonView(MyJsonView.Besoin.class)
    public List<Besoin> getBesoinEnCoursTriNomRecherche(@PathVariable String search) {
        return iBesoinDao.findAllByEstOuvertTrueAndClientNomLike("%"+search+"%");
    }

    /**
     * Méthode qui energistre un nouveau besoin dans la BDD.
     * @return Un String qui confirme ou infirme la réussite de l'enregistrement (pour l'instant)
     */

    @PostMapping("/besoin/ajout/enregistrer")
    public String saveBesoin(@RequestBody Besoin besoin) {
        try {
            iBesoinDao.save(besoin);
        } catch (Exception e) {
            e.printStackTrace();
            return "Nope, ça n'a pas marché";
        }
        return "yep, c'est bon !";
    }

    /**
     * Méthode qui affiche un besoin en particulier via son ID, en vu de l'éditer
     * @return Un besoin
     */

    @GetMapping("/besoin/modifier/{id}")
    @JsonView(MyJsonView.Besoin.class)
    public Besoin getBesoinToEdit(@PathVariable long id) {
        return iBesoinDao.findById(id);
    }

    /**
     * Méthode qui energistre (update) un besoin modifié dans la BDD.
     * @return Un String qui confirme ou infirme la réussite de l'enregistrement (pour l'instant)
     */

    @PostMapping("/besoin/modifier/{id}/enregistrer")
    public String saveEditedBesoin(@PathVariable long id, @RequestBody Besoin besoin) {
        try {
            iBesoinDao.save(besoin);
        } catch (Exception e) {
            e.printStackTrace();
            return "Edition a échoué";
        }
        return "yep, c'est bon !";
    }
}
