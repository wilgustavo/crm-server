package com.crm.core.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
public class Usuario {
    
    @Id @GeneratedValue
    private UUID id;
    private String nombre;
    private String apellido;
    private String email;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name ="grupo_usuario", 
               joinColumns = @JoinColumn(name = "usuario_id"),
               inverseJoinColumns = @JoinColumn(name = "grupo_nombre"))
    @EqualsAndHashCode.Exclude
    private Set<Grupo> grupos;

}
