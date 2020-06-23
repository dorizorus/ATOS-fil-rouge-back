package atos.bdd.controller;

import atos.bdd.dao.ICollaborateurDao;
import atos.bdd.dao.IExperienceDao;
import atos.bdd.model.Collaborateur;
import atos.bdd.model.relation.Cle_collab_competence;
import atos.bdd.model.relation.Collaborateurs_Competences;

import atos.bdd.view.MyJsonView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;

@CrossOrigin
@RestController
public class CollaborateurController {

    ICollaborateurDao iCollaborateurDao;
    IExperienceDao iExperienceDao;

    @Autowired
    public CollaborateurController(ICollaborateurDao iCollaborateurDao, IExperienceDao iExperienceDao) {
        this.iCollaborateurDao = iCollaborateurDao;
        this.iExperienceDao = iExperienceDao;
    }

    @JsonView(MyJsonView.Collaborateur.class)
    @GetMapping("/collaborateur/{id}") // Renvoie un collaborateur
    public Collaborateur getCollaborateur(@PathVariable long id)
    {
    	return iCollaborateurDao.findById(id);
    }
    
    @PostMapping("/collaborateur/ajoutercollaborateur") // Ajoute une compétence. Ne vérifie pas l'objet donc ne renvoie que du true.
    public boolean ajouterCollaborateur(@RequestBody Collaborateur collaborateur)
    {

    	iCollaborateurDao.save(collaborateur);

    	iCollaborateurDao.saveAndFlush(collaborateur); //flush car récup id du collab
        for (Collaborateurs_Competences experience: collaborateur.getExperiences())
        {
            Cle_collab_competence cle = new Cle_collab_competence();
            cle.setIdCollaborateur(collaborateur.getId());
            cle.setIdCompetence(experience.getCompetence().getId());
            experience.setId(cle);
            experience.setCollaborateur(collaborateur);
            iExperienceDao.save(experience);
        }

//        collaborateur.getExperiences().forEach(
//                (experience) -> {
//                    Cle_collab_competence cle = new Cle_collab_competence();
//                    cle.setIdCollaborateur(collaborateur.getId());
//                    cle.setIdCompetence(experience.getCompetence().getId());
//                    experience.setId(cle);
//                    experience.setCollaborateur(collaborateur);
//                    iExperienceDao.save(experience);
//                }
//        );

    	return true;
    }
    
    @GetMapping("/collaborateur/supprimercollaborateur")
    public boolean supprimerCollaborteur(@RequestBody Collaborateur collaborateur) // Supprimer collaborateur. Ne vérifie pas s'il est la ou non.
    {
    	iCollaborateurDao.delete(collaborateur);
    	return true;
    }
    
    @PostMapping("/collaborateur/modifiercollaborateur/{id}") // Modifier collaborateur sans vraiment check d'autres trucs
    public boolean modifierCollaborateur(@PathVariable long id, @RequestBody Collaborateur collaborateur) 
    {
    	if (iCollaborateurDao.findById(id) != null) {
    		iCollaborateurDao.save(collaborateur);
    		return true;
    	} else
    		return false;
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
