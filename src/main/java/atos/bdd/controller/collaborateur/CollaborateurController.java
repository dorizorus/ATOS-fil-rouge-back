package atos.bdd.controller.collaborateur;

import atos.bdd.dao.collaborateur.ICollaborateurDao;
import atos.bdd.model.collaborateur.Collaborateur;
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
public class CollaborateurController {

    ICollaborateurDao iCollaborateurDao;

    @Autowired
    public CollaborateurController(ICollaborateurDao iCollaborateurDao) {
        this.iCollaborateurDao = iCollaborateurDao;
    }

    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/{id}")
    public Collaborateur getCollaborateur(@PathVariable long id)
    {
    	return iCollaborateurDao.findById(id);
    }
    
    @PutMapping("/collaborateur/ajoutercollaborateur") // Ajoute une compétence. Ne vérifie pas l'objet donc ne renvoie que du true.
    public boolean ajouterCollaborateur(Collaborateur collaborateur)
    {
    	iCollaborateurDao.saveAndFlush(collaborateur);
    	return true;
    }
    
    @GetMapping("/collaborateur/supprimercollaborateur")
    public boolean supprimerCollaborteur(Collaborateur collaborateur)
    {
    	iCollaborateurDao.delete(collaborateur);
    	return true;
    }
    
    @PostMapping("/collaborateur/modifiercollaborateur")
    public boolean modifierCollaborateur(Collaborateur collaborateur) 
    {
    	iCollaborateurDao.save(collaborateur);
    	return true;
    }
    
    
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listepartitrecroissant")
    public List<Collaborateur> ListeCollaborateurTitreCro() // Renvoie une liste complète de collabo trié par Titre (croissant)
    {
    	return iCollaborateurDao.findAllByOrderByTitreAsc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listepartitredecroissant")
    public List<Collaborateur> ListeCollaborateurTitreDec() // Renvoie une liste compléte de collabo trié par Titre (décroissant)
    {
    	return iCollaborateurDao.findAllByOrderByTitreDesc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listeparnomcroissant")
    public List<Collaborateur> ListeCollaborateurNomCro() // Renvoie une liste complète de collabo trié par Nom (croissant)
    {
    	return iCollaborateurDao.findAllByOrderByNomAsc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listeparnomdecroissant")
    public List<Collaborateur> ListeCollaborateurNomDec() // Renvoie une liste complète de collabo trié par Nom (décroissant)
    {
    	return iCollaborateurDao.findAllByOrderByNomDesc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listeparprenomcroissant")
    public List<Collaborateur> ListeCollaborateurPrenomCro() // Renvoie une liste complète de collabo trié par Prenom (croissant)
    {
    	return iCollaborateurDao.findAllByOrderByPrenomAsc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listeparprenomdecroissant")
    public List<Collaborateur> ListeCollaborateurPrenomDec() // Renvoie une liste complète de collabo trié par Prenom (décroissant)
    {
    	return iCollaborateurDao.findAllByOrderByPrenomDesc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listeparidentifiantcroissant")
    public List<Collaborateur> ListeCollaborateurIdentifiantCro() // Renvoie une liste complète de collabo trié par Identifiant (croissant)
    {
    	return iCollaborateurDao.findAllByOrderByIdentifiantAsc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listeparidentifiantdecroissant")
    public List<Collaborateur> ListeCollaborateurIdentifiantDec() // Renvoie une liste complète de collabo trié par Identifiant (décroissant)
    {
    	return iCollaborateurDao.findAllByOrderByIdentifiantDesc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listeparbenchcroissant")
    public List<Collaborateur> ListeCollaborateurBenchCro() // Renvoie une liste complète de collabo trié par Bench (croissant)
    {
    	return iCollaborateurDao.findAllByOrderByBenchAsc(); 
    }
    
    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/listeparbenchdecroissant")
    public List<Collaborateur> ListeCollaborateurBenchDec() // Renvoie une liste complète de collabo trié par Bench (decroissant)
    {
    	return iCollaborateurDao.findAllByOrderByBenchDesc(); 
    }
}
