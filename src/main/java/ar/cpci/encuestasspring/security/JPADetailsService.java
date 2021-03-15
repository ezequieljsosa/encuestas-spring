package ar.cpci.encuestasspring.security;


import ar.cpci.encuestasspring.exception.UsuarioNotFoundException;
import ar.cpci.encuestasspring.model.Usuario;
import ar.cpci.encuestasspring.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class JPADetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Usuario user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsuarioNotFoundException(username);
        }
        return new MyModelUserDetails(user);
    }
}
