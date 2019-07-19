package com.crm.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.crm.common.exception.NotFoundException;
import com.crm.model.Usuario;
import com.crm.repository.UsuarioRepository;

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
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
