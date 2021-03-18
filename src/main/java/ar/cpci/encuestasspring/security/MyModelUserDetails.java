package ar.cpci.encuestasspring.security;

import ar.cpci.encuestasspring.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/***
 * Los objetos de esta clase se crean a partir de un Usuario del modelo.
 * En definitiva la empaqueta para que implemente UserDetails, que es lo que
 * spring security usa para Autenticar
 */
public class MyModelUserDetails implements UserDetails {
    private Usuario user;
    public MyModelUserDetails(Usuario user) {
        this.user = user;
    }

    // Para mapear los roles hay que mapearlos en el Usuario y convertirlos en esta coleccion
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Esto no esta bien, es solo por motivos de prueba
        Collection<GrantedAuthority> roles = new ArrayList<>();
        if (this.user.getUsername().equals("admin")){
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword() ;
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
        return true;
    }
}
