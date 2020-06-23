package atos.bdd.controller;

import atos.bdd.Securite.UtilisateurDetails;
import atos.bdd.dao.IUtilisateurDao;
import atos.bdd.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Service
public class UtilisateurDetailsService implements UserDetailsService {

    IUtilisateurDao iUtilisateurDao;

    @Autowired
    public UtilisateurDetailsService(IUtilisateurDao iUtilisateurDao) {
        this.iUtilisateurDao = iUtilisateurDao;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Utilisateur utilisateur = iUtilisateurDao.findByLogin(login).orElseThrow( () -> new UsernameNotFoundException("Inconnu : " + login));
        return new UtilisateurDetails(utilisateur);
    }
}
