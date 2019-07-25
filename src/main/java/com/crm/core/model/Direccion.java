package com.crm.core.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Direccion {
    
    private String domicilio;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String pais;
    

}
