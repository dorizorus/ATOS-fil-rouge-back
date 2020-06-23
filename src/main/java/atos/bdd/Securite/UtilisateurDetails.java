package atos.bdd.Securite;

import atos.bdd.model.Utilisateur;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class UtilisateurDetails implements UserDetails {


    private long id;
    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public UtilisateurDetails(Utilisateur utilisateur) {
        this.id = utilisateur.getId();
        this.userName = utilisateur.getLogin();
        this.password = utilisateur.getPassword();
        this.active = utilisateur.isEstActif();
        this.authorities = new ArrayList<>();
        this.authorities.add(new SimpleGrantedAuthority(utilisateur.getRole().getLibelle().toUpperCase()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
