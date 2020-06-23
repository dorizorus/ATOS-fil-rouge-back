package atos.bdd.Securite.service;

import atos.bdd.Securite.UtilisateurDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class JwtUtil {

    @Value("${jwt.secret}") //server secret
    private String secret;

    //Retourne le corps(payload) du token. Format Claims imposé.
    public Claims extractTokenPayload(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    //on retourne un token
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> tokenData = new HashMap<>();
        //ici on peut rajouter tout ce qu'on veut
        tokenData.put("roles", userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","))
        );

        return Jwts.builder()
                .setClaims(tokenData)
                .setSubject(userDetails.getUsername()) //sujet = identifiant unique de l'utilisateur dans la BDD (sub)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // h -> min -> s -> ms
                .signWith(SignatureAlgorithm.HS256, secret) //la signature avec l'algo + secret
                .compact(); //format [header].[payload].[signature]
    }

    //méthode pour check si token est expiré
    private Boolean isTokenExpired(String token) {
        return extractTokenPayload(token)
                .getExpiration()
                .before(new Date());
    }

    //Retourne vrai si le nom de l'utilisateur tentant de se connecter correspond
    //au subject du payload du token et si la date d'expiration n'est pas passée.
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractTokenPayload(token).getSubject();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


}
