package atos.bdd.controller;

import atos.bdd.dao.IPropositionDao;
import atos.bdd.model.Proposition;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PropositionController {

    IPropositionDao iPropositionDao;

    @Autowired
    public PropositionController(IPropositionDao iPropositionDao) {
        this.iPropositionDao = iPropositionDao;
    }


    /**
     * Méthode qui affiche toutes les propositions
     * dont les besoins auxquels elles sont liées sont encore ouvert (en cours)
     * @return liste des propositions avec besoins ouverts
     */
    @GetMapping("/propositions/besoins-ouverts")
    @JsonView(MyJsonView.Proposition.class)
    public List<Proposition> getPropositionsBesoinOuverts() {
        return iPropositionDao.findAllByBesoinEstOuvertTrue();
    }


    /**
     * Méthode qui affiche toutes les propositions
     * en premier dont les besoins sont ouverts
     * @return liste de toutes les propositions
     */
    @GetMapping("/propositions/tous")
    @JsonView(MyJsonView.Proposition.class)
    public List<Proposition> getPropositionsTousBesoinsTriOuvertsEtDateRelance() {
        return iPropositionDao.findAllByOrderByBesoinEstOuvertDescDateRelanceAsc();
    }

    /**
     * Méthode qui affiche une proposition en particulier via son ID,
     * en vu de l'éditer
     * @return Une proposition
     */
    @GetMapping("/proposition/modifier/{id}")
    @JsonView(MyJsonView.Proposition.class)
    public Proposition getPropositionToEditById(@PathVariable long id) {
        return iPropositionDao.findById(id);
    }

    /**
     * Méthode qui energistre (update) une proposition modifiée dans la BDD.
     * @return Un String qui confirme ou infirme la réussite de l'enregistrement (pour l'instant)
     */
    @PostMapping("/proposition/modifier/{id}/enregistrer")
    @JsonView(MyJsonView.Proposition.class)
    public String saveEditedProposition(@PathVariable long id, @RequestBody Proposition proposition) {
        try {
            iPropositionDao.save(proposition);
        } catch (Exception e) {
            e.printStackTrace();
            return "Nope, l'enregistrement de l'édition a déconné";
        }
        return "yep, c'est bon !";
    }

    /**
     * Méthode qui energistre une nouvelle proposition dans la BDD.
     * @return Un String qui confirme ou infirme la réussite de l'enregistrement (pour l'instant)
     */
    @PostMapping("/proposition/ajouter/enregistrer")
    @JsonView(MyJsonView.Proposition.class)
    public String saveNewProposition(@RequestBody Proposition proposition) {
        try {
            iPropositionDao.save(proposition);
        } catch (Exception e) {
            e.printStackTrace();
            return "Nope, l'enregistrement a déconné";
        }
        return "yep, c'est bon !";
    }

}
