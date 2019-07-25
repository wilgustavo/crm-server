package com.crm.api.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.crm.core.model.Direccion;

import lombok.Data;

@Data
public class ContactoDto {

    private UUID id;
    private String nombre;
    private String apellido;
    private String email;
    private String movil;
    private String telefono;
    private LocalDate nacimiento;
    private Direccion direccion;
    
}
