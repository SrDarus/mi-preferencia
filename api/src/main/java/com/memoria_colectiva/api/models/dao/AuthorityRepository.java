package com.memoria_colectiva.api.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.memoria_colectiva.api.models.entity.Authority;
import com.memoria_colectiva.api.utils.AuthorityName;

public interface AuthorityRepository extends JpaRepository <Authority, Long> {
	Optional<Authority> findByName(AuthorityName name);
}
