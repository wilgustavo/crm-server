package com.crm.service;

import java.util.UUID;

import com.crm.model.Usuario;

public interface UsuarioService {
    
    Usuario consultar(UUID id);
    Usuario crear(Usuario usuario);

}
