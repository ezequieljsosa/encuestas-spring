package ar.cpci.encuestasspring;

import ar.cpci.encuestasspring.model.Encuesta;
import ar.cpci.encuestasspring.model.Usuario;
import ar.cpci.encuestasspring.repo.EncuestaRepository;
import ar.cpci.encuestasspring.repo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@EnableWebMvc
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class EncuestasSpringApplication  {

    public static void main(String[] args) {

        SpringApplication.run(EncuestasSpringApplication.class, args);
    }


    //Recordar que con la configuracion actual esta linea solo funciona cuando
    // EnableGlobalMethodSecurity esta comentado
    @Bean
    public CommandLineRunner demo(UsuarioRepository repository, PasswordEncoder passwordEncoder) {

        return (args) -> {
//            for (Integer i = 0; i < 10; ++i) {
//
//                Encuesta s = new Encuesta();
//                s.setNombre("encuesta" + i.toString());
//                repository.save(s);
//
//            }
//              Crear usuaro de prueba
//            Usuario usuario = new Usuario();
//            usuario.setUsername("admin");
//            usuario.setPassword(passwordEncoder.encode("123"));
//            repository.save(usuario);
        };
    }



}
