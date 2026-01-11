package br.com.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.enums.GrupoMuscular;
import br.com.sistema.models.Exercicio;
import br.com.sistema.repositories.ExercicioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExercicioService {
    
    private final ExercicioRepository exercicioRepository;
    
    @Transactional
    public Exercicio save(Exercicio exercicio) {
        return exercicioRepository.save(exercicio);
    }
    
    @Transactional(readOnly = true)
    public List<Exercicio> findAll() {
        return exercicioRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Exercicio> findById(Long id) {
        return exercicioRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Exercicio> findByGrupoMuscular(GrupoMuscular grupoMuscular) {
        return exercicioRepository.findByGrupoMuscular(grupoMuscular);
    }
    
    @Transactional(readOnly = true)
    public List<Exercicio> findByNome(String nome) {
        return exercicioRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    @Transactional
    public void deleteById(Long id) {
        exercicioRepository.deleteById(id);
    }
}