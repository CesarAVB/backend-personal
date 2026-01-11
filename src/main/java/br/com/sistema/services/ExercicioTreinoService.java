package br.com.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.models.ExercicioTreino;
import br.com.sistema.repositories.ExercicioTreinoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExercicioTreinoService {
    
    private final ExercicioTreinoRepository exercicioTreinoRepository;
    
    @Transactional
    public ExercicioTreino save(ExercicioTreino exercicioTreino) {
        return exercicioTreinoRepository.save(exercicioTreino);
    }
    
    @Transactional(readOnly = true)
    public List<ExercicioTreino> findAll() {
        return exercicioTreinoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<ExercicioTreino> findById(Long id) {
        return exercicioTreinoRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<ExercicioTreino> findByTreinoId(Long treinoId) {
        return exercicioTreinoRepository.findByTreinoIdOrderByOrdem(treinoId);
    }
    
    @Transactional
    public void deleteById(Long id) {
        exercicioTreinoRepository.deleteById(id);
    }
    
    @Transactional
    public void deleteByTreinoId(Long treinoId) {
        exercicioTreinoRepository.deleteByTreinoId(treinoId);
    }
}