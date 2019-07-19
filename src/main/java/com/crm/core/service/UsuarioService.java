package com.crm.core.service;

import java.util.UUID;

import com.crm.core.model.Usuario;

public interface UsuarioService {
    
    Usuario consultar(UUID id);
    Usuario crear(Usuario usuario);

}
