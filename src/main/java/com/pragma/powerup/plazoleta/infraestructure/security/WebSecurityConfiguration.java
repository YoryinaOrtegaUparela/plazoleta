package com.pragma.powerup.plazoleta.infraestructure.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class WebSecurityConfiguration {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //Se desabilita csrf para evitar configuraciones adicionales ante ataques de seguridad
        http.cors().and().csrf().disable().authorizeRequests()

                .antMatchers("/api/v1/plazoleta/restaurante/creaRestaurante").hasRole("ADMIN")
                .antMatchers("/api/v1/plazoleta/restaurante/listaRestaurantes").hasRole("CLIENT")
                .antMatchers("/api/v1/plazoleta/plato/menu").hasRole("CLIENT")
                .antMatchers("/api/v1/plazoleta/plato/creaPlato").hasRole("PROP")
                .antMatchers("/api/v1/plazoleta/plato/modificaPlato").hasRole("PROP")
                .antMatchers("/api/v1/plazoleta/plato/estadoPlato").hasRole("PROP")


                .and().httpBasic();
        return http.build();
    }

}
