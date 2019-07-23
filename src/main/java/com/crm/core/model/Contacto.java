package com.crm.core.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
public class Contacto {
    
    @Id @GeneratedValue
    private UUID id;
    private String nombre;
    private String apellido;
    private String email;
    private String movil;
    private String telefono;
    private LocalDate nacimiento;
    
    @Embedded
    private Direccion direccion;
    
    @ManyToOne
    private Usuario asignado;
    
}
