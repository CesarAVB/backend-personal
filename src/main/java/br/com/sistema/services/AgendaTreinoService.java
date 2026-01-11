package br.com.sistema.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.models.AgendaTreino;
import br.com.sistema.repositories.AgendaTreinoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgendaTreinoService {
    
    private final AgendaTreinoRepository agendaTreinoRepository;
    
    @Transactional
    public AgendaTreino save(AgendaTreino agendaTreino) {
        return agendaTreinoRepository.save(agendaTreino);
    }
    
    @Transactional(readOnly = true)
    public List<AgendaTreino> findAll() {
        return agendaTreinoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<AgendaTreino> findById(Long id) {
        return agendaTreinoRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public List<AgendaTreino> findByAlunoId(Long alunoId) {
        return agendaTreinoRepository.findByAlunoId(alunoId);
    }
    
    @Transactional(readOnly = true)
    public List<AgendaTreino> findByAlunoIdAndPeriodo(Long alunoId, LocalDateTime inicio, LocalDateTime fim) {
        return agendaTreinoRepository.findByAlunoIdAndDataHoraBetween(alunoId, inicio, fim);
    }
    
    @Transactional(readOnly = true)
    public List<AgendaTreino> findByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return agendaTreinoRepository.findByDataHoraBetweenOrderByDataHora(inicio, fim);
    }
    
    @Transactional(readOnly = true)
    public long countByPersonalIdAndPeriodo(Long personalId, LocalDateTime inicio, LocalDateTime fim) {
        return agendaTreinoRepository.countByAlunoPersonalIdAndDataHoraBetween(personalId, inicio, fim);
    }
    
    @Transactional
    public void deleteById(Long id) {
        agendaTreinoRepository.deleteById(id);
    }
}