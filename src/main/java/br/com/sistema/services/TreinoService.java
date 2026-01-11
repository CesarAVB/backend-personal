package br.com.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.models.Treino;
import br.com.sistema.repositories.TreinoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TreinoService {
    
    private final TreinoRepository treinoRepository;
    
    @Transactional
    public Treino save(Treino treino) {
        return treinoRepository.save(treino);
    }
    
    @Transactional(readOnly = true)
    public List<Treino> findAll() {
        return treinoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Treino> findById(Long id) {
        return treinoRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Treino> findByAlunoId(Long alunoId) {
        return treinoRepository.findByAlunoId(alunoId);
    }
    
    @Transactional(readOnly = true)
    public List<Treino> findByAlunoIdAndAtivo(Long alunoId, Boolean ativo) {
        return treinoRepository.findByAlunoIdAndAtivo(alunoId, ativo);
    }
    
    @Transactional
    public void deleteById(Long id) {
        treinoRepository.deleteById(id);
    }
}