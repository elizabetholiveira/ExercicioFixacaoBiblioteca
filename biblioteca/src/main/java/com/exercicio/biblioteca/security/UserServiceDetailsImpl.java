package com.exercicio.biblioteca.security;

import com.exercicio.biblioteca.model.UsuarioModel;
import com.exercicio.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceDetailsImpl implements UserDetailsService {
@Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel usuarioModel =repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("usuário não encontrado!"));
        return new User(usuarioModel.getUsername(), usuarioModel.getPassword(), true, true, true, true, usuarioModel.getAuthorities());
    }
}
