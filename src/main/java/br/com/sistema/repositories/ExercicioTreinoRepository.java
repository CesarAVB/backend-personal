package br.com.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.models.ExercicioTreino;

@Repository
public interface ExercicioTreinoRepository extends JpaRepository<ExercicioTreino, Long> {
    List<ExercicioTreino> findByTreinoIdOrderByOrdem(Long treinoId);
    void deleteByTreinoId(Long treinoId);
}