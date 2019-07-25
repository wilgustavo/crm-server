package com.crm.api.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.crm.api.dto.ContactoDto;
import com.crm.core.service.ContactoService;

@RestController
public class ContactoController {
    
    private ContactoService contactoService;
    private ModelMapper modelMapper;
    
    public ContactoController(ContactoService contactoService, ModelMapper modelMapper) {
        this.contactoService = contactoService;
        this.modelMapper = modelMapper;
    }
    
    @GetMapping("/contactos/{id}")
    public ContactoDto consultar(@PathVariable("id") UUID id) {
        return modelMapper.map(contactoService.consultar(id), ContactoDto.class);
    }
    
    

}
