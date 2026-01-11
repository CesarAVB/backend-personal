package br.com.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.models.Anamnese;
import br.com.sistema.repositories.AnamneseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnamneseService {
    
    private final AnamneseRepository anamneseRepository;
    
    @Transactional
    public Anamnese save(Anamnese anamnese) {
        return anamneseRepository.save(anamnese);
    }
    
    @Transactional(readOnly = true)
    public List<Anamnese> findAll() {
        return anamneseRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Anamnese> findById(Long id) {
        return anamneseRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Anamnese> findByAlunoId(Long alunoId) {
        return anamneseRepository.findByAlunoIdOrderByDataAvaliacaoDesc(alunoId);
    }
    
    @Transactional
    public void deleteById(Long id) {
        anamneseRepository.deleteById(id);
    }
}