package com.crm.core.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Grupo {

    @Id
    private String nombre;
    private String descripcion;
    
    @ManyToMany(mappedBy = "grupos")
    private Set<Usuario> usuarios;

}
