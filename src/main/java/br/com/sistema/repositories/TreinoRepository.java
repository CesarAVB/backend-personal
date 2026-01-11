package br.com.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.models.Treino;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
    List<Treino> findByAlunoId(Long alunoId);
    List<Treino> findByAlunoIdAndAtivo(Long alunoId, Boolean ativo);
}