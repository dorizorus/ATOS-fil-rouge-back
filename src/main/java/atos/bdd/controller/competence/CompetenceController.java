package atos.bdd.controller.competence;

import atos.bdd.dao.competence.ICompetenceDao;
import atos.bdd.model.competence.Competence;
import atos.bdd.view.MyJsonView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class CompetenceController {

    ICompetenceDao iCompetenceDao;

    @Autowired
    public CompetenceController(ICompetenceDao iCompetenceDao) {
        this.iCompetenceDao = iCompetenceDao;
    }
    

    
    @JsonView(MyJsonView.Competence.class)
    @GetMapping("/competence/listecompetence") // renvoie une liste de compétences peu importe le type
    public List<Competence> listeCompetence()
    {
    	return iCompetenceDao.findAll();
    }
    
    @JsonView(MyJsonView.Competence.class)
    @GetMapping("/competence/listecompetencepartype/{type}") // renvoie une liste de compétence par le type spécifié. Préférable à un /metier, /outils, etc..
    public List<Competence> listeCompetenceParType(@PathVariable String type)
    {
    	return iCompetenceDao.findAllByTypeOrderByLibelleAsc(type);
    }
    
    @PutMapping("/competence/ajoutercompetence") // Ajoute une compétence. Ne vérifie pas l'objet donc ne renvoie que du true.
    public boolean ajouterCompetence(Competence competence)
    {
    	iCompetenceDao.saveAndFlush(competence);
    	return true;
    }
    
    @GetMapping("/competence/supprimercompetence")
    public boolean supprimerCompetence(Competence competence)
    {
    	iCompetenceDao.delete(competence);
    	return true;
    }
    
    @PostMapping("/competence/modifiercompetence")
    public boolean modifierCompetence(Competence competence) 
    {
    	iCompetenceDao.save(competence);
    	return true;
    }
    
    
}
