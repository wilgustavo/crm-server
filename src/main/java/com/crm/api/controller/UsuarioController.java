package com.crm.api.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.api.dto.UsuarioDto;
import com.crm.core.model.Usuario;
import com.crm.core.service.UsuarioService;

/**
 * Servicio web de usuario
 */
@RestController
public class UsuarioController {
    
    private UsuarioService usuarioService;


    private ModelMapper modelMapper;

    /**
     * Instantiates a new usuario controller.
     *
     * @param usuarioService the usuario service
     * @param modelMapper the model mapper
     */
    public UsuarioController(UsuarioService usuarioService, ModelMapper modelMapper) {
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    /**
     * Consultar los datos de un usuario.
     *
     * @param identificador del usuario
     * @return datos del usuario
     */
    @GetMapping("/usuarios/{id}")
    public UsuarioDto consultar(@PathVariable("id") UUID id) {
        return modelMapper.map(usuarioService.consultar(id), UsuarioDto.class);
    }
    
    /**
     * Crear un usuario
     *
     * @param datos de usuario
     * @return datos del usuario
     */
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/usuarios")
    public UsuarioDto crear(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = usuarioService.crear(modelMapper.map(usuarioDto, Usuario.class));
        return modelMapper.map(usuario, UsuarioDto.class);
    }

}
