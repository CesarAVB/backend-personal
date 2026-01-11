package br.com.sistema.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.models.AgendaTreino;

@Repository
public interface AgendaTreinoRepository extends JpaRepository<AgendaTreino, Long> {
    List<AgendaTreino> findByAlunoId(Long alunoId);
    List<AgendaTreino> findByAlunoIdAndDataHoraBetween(Long alunoId, LocalDateTime inicio, LocalDateTime fim);
    List<AgendaTreino> findByDataHoraBetweenOrderByDataHora(LocalDateTime inicio, LocalDateTime fim);
    long countByAlunoPersonalIdAndDataHoraBetween(Long personalId, LocalDateTime inicio, LocalDateTime fim);
}