package com.crm.api.dto;

import java.util.Set;
import java.util.UUID;

import lombok.Data;

@Data
public class UsuarioDto {
    
    private UUID id;
    private String nombre;
    private String apellido;
    private String email;
    private Set<GrupoDto> grupos;

}
