package br.com.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sistema.enums.GrupoMuscular;
import br.com.sistema.models.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    List<Exercicio> findByGrupoMuscular(GrupoMuscular grupoMuscular);
    List<Exercicio> findByNomeContainingIgnoreCase(String nome);
}