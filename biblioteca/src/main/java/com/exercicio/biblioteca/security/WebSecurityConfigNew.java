package com.exercicio.biblioteca.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfigNew {
    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
http.httpBasic().and().authorizeHttpRequests() .antMatchers(HttpMethod.POST,  "/api/livros").hasRole("BIBLIOTECARIO")
        .antMatchers(HttpMethod.GET, "/api/livros").hasAnyRole("USER", "BIBLIOTECARIO")
        .antMatchers(HttpMethod.PUT, "/api/livros").hasRole("BIBLIOTECARIO")
        .antMatchers(HttpMethod.DELETE, "/api/livros").hasRole("BIBLIOTECARIO")
        .anyRequest().authenticated().and().csrf().disable();
return  http.build();
    }
    @Bean
public PasswordEncoder encode(){

        return  new BCryptPasswordEncoder();
    }
}
