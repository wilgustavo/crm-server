package com.crm.core.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Usuario {
    
    @Id @GeneratedValue
    private UUID id;
    private String nombre;
    private String apellido;
    private String email;

}
