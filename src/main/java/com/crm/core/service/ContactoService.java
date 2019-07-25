package com.crm.core.service;

import java.util.UUID;

import com.crm.core.model.Contacto;

public interface ContactoService {
    
    Contacto consultar(UUID id);
    Contacto crear(Contacto contacto);

}
