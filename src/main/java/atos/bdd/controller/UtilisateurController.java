package atos.bdd.controller;

import atos.bdd.Securite.service.JwtUtil;
import atos.bdd.dao.IUtilisateurDao;
import atos.bdd.model.Utilisateur;
import atos.bdd.view.MyJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UtilisateurController {

    IUtilisateurDao iUtilisateurDao;
    private AuthenticationManager authenticationManager;
    private UtilisateurDetailsService utilisateurDetailsService;
    private JwtUtil jwtUtil;

    @Autowired
    public UtilisateurController(IUtilisateurDao iUtilisateurDao, AuthenticationManager authenticationManager,
                                 UtilisateurDetailsService utilisateurDetailsService, JwtUtil jwtUtil) {
        this.iUtilisateurDao = iUtilisateurDao;
        this.authenticationManager = authenticationManager;
        this.utilisateurDetailsService = utilisateurDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping("/authentification")
    @JsonView(MyJsonView.Utilisateur.class)
    public ResponseEntity authentification(@RequestBody Utilisateur utilisateur) throws Exception {
        try {
            //on tente d'authentifier
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            utilisateur.getLogin(), utilisateur. getPassword()));

            //si oui on créer un token avec les détails utilisateurs
            final UserDetails userDetails = utilisateurDetailsService.loadUserByUsername(utilisateur.getLogin());
            return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
        }
        catch (BadCredentialsException e) {
            new ResponseEntity("Utilisateur non trouvé, peut-être que le " +
                   "login ou le mot de passe est incorrect", HttpStatus.NOT_FOUND);
            throw new Exception("Pseudo ou mot de passe incorrect", e);
        }
    }

    @PostMapping("/utilisateur/ajout")
    @JsonView(MyJsonView.Utilisateur.class)
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur) {
        return ResponseEntity.ok(iUtilisateurDao.save(utilisateur));
    }


    @RequestMapping("/utilisateurs")
    @JsonView(MyJsonView.Utilisateur.class)
    public List<Utilisateur> getUtilisateurs() {
        return iUtilisateurDao.findAll();
    }


    @RequestMapping("/utilisateur/byid/{id}")
    @JsonView(MyJsonView.Utilisateur.class)
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable long id) {

        Optional<Utilisateur> utilisateur = iUtilisateurDao.findById(id);

        if (utilisateur.isPresent())
            return ResponseEntity.ok(utilisateur.get());
        else
            return ResponseEntity.noContent().build();
    }

    @RequestMapping("/utilisateur/bylogin/{login}")
    @JsonView(MyJsonView.Utilisateur.class)
    public ResponseEntity<Utilisateur> getUtilisateurByLogin(@PathVariable String login) {

        Optional<Utilisateur> utilisateur = iUtilisateurDao.findByLogin(login);

        if (utilisateur.isPresent())
            return ResponseEntity.ok(utilisateur.get());
        else
            return ResponseEntity.noContent().build();
    }
}
