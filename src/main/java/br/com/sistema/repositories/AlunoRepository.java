package br.com.sistema.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.enums.StatusAluno;
import br.com.sistema.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByUsuarioId(Long usuarioId);
    List<Aluno> findByPersonalId(Long personalId);
    List<Aluno> findByStatus(StatusAluno status);
    List<Aluno> findByPersonalIdAndStatus(Long personalId, StatusAluno status);
    long countByPersonalIdAndStatus(Long personalId, StatusAluno status);
}