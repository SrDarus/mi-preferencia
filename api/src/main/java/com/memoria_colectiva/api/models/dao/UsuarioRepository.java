package com.memoria_colectiva.api.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.memoria_colectiva.api.models.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);
}
