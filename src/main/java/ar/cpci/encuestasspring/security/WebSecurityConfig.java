package ar.cpci.encuestasspring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/**").permitAll()
                .and()
                    .formLogin().loginPage("/login").permitAll()
                .and()
                    .logout().permitAll()
                .and()
                    .authorizeRequests().antMatchers("/encuesta/edit").hasRole("ADMIN")
                .and()
                    .authorizeRequests().antMatchers("/").permitAll()
                .and()
                    .authorizeRequests().antMatchers("/**").authenticated()
                .and()
                    .csrf().ignoringAntMatchers("/api/**");

    }

    // Para testing, ahora esta funcionando con ar.cpci.encuestasspring.security.JPADetailsService
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())
//                    .withUser("admin").roles("ADMIN").password(passwordEncoder().encode("123"))
//                .and()
//                    .withUser("pepe").roles("OP").password(passwordEncoder().encode("321"));
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




}