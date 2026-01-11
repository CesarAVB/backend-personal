package br.com.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.models.Anamnese;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {
    List<Anamnese> findByAlunoIdOrderByDataAvaliacaoDesc(Long alunoId);
}