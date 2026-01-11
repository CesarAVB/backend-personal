package br.com.sistema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.models.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long> {
    Optional<Personal> findByUsuarioId(Long usuarioId);
}