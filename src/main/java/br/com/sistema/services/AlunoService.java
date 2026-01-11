package br.com.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.enums.StatusAluno;
import br.com.sistema.models.Aluno;
import br.com.sistema.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {
    
    private final AlunoRepository alunoRepository;
    
    @Transactional
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    @Transactional(readOnly = true)
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public Optional<Aluno> findByUsuarioId(Long usuarioId) {
        return alunoRepository.findByUsuarioId(usuarioId);
    }
    
    @Transactional(readOnly = true)
    public List<Aluno> findByPersonalId(Long personalId) {
        return alunoRepository.findByPersonalId(personalId);
    }
    
    @Transactional(readOnly = true)
    public List<Aluno> findByStatus(StatusAluno status) {
        return alunoRepository.findByStatus(status);
    }
    
    @Transactional(readOnly = true)
    public List<Aluno> findByPersonalIdAndStatus(Long personalId, StatusAluno status) {
        return alunoRepository.findByPersonalIdAndStatus(personalId, status);
    }
    
    @Transactional(readOnly = true)
    public long countByPersonalIdAndStatus(Long personalId, StatusAluno status) {
        return alunoRepository.countByPersonalIdAndStatus(personalId, status);
    }
    
    @Transactional
    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}