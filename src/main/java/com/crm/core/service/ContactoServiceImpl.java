package com.crm.core.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.crm.common.exception.NotFoundException;
import com.crm.core.model.Contacto;
import com.crm.core.repository.ContactoRepository;

@Service
public class ContactoServiceImpl implements ContactoService {

    private static final String NOT_FOUND_ERROR = "No existe el contacto ";
    
    private ContactoRepository contactoRepository;
    
    public ContactoServiceImpl(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    @Override
    public Contacto consultar(UUID id) {
        return contactoRepository.findById(id).orElseThrow(() -> new NotFoundException(NOT_FOUND_ERROR + id));
    }

    @Override
    public Contacto crear(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

}
