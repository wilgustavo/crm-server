package com.crm.core.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.core.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

}
