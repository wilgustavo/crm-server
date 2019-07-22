package com.crm.core.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.crm.common.exception.NotFoundException;
import com.crm.core.model.Usuario;
import com.crm.core.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final String NOT_FOUND_ERROR = "No existe el usuario ";
    
    private UsuarioRepository usuarioRepository;
    
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario consultar(UUID id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException(NOT_FOUND_ERROR + id.toString()));
    }

    @Override
    public Usuario consultarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new NotFoundException(NOT_FOUND_ERROR + email));
    }
    
    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
