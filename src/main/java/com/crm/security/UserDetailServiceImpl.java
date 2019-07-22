package com.crm.security;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crm.common.exception.NotFoundException;
import com.crm.core.model.Usuario;
import com.crm.core.service.UsuarioService;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UsuarioService usuarioService;
    
    public UserDetailServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            Usuario usuario = usuarioService.consultarPorEmail(username);
            return new UserPrincipal(usuario);
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
    
    public UserDetails loadUserByID(UUID id) {
        try {
            Usuario usuario = usuarioService.consultar(id);
            return new UserPrincipal(usuario);
        } catch (NotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

}
