package com.crm.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

}
