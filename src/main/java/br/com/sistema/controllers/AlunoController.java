package br.com.sistema.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.enums.StatusAluno;
import br.com.sistema.models.Aluno;
import br.com.sistema.services.AlunoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {
    
    private final AlunoService alunoService;
    
    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.save(aluno));
    }
    
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        return alunoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Aluno> findByUsuarioId(@PathVariable Long usuarioId) {
        return alunoService.findByUsuarioId(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/personal/{personalId}")
    public ResponseEntity<List<Aluno>> findByPersonalId(@PathVariable Long personalId) {
        return ResponseEntity.ok(alunoService.findByPersonalId(personalId));
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Aluno>> findByStatus(@PathVariable StatusAluno status) {
        return ResponseEntity.ok(alunoService.findByStatus(status));
    }
    
    @GetMapping("/personal/{personalId}/status/{status}")
    public ResponseEntity<List<Aluno>> findByPersonalIdAndStatus(
            @PathVariable Long personalId, 
            @PathVariable StatusAluno status) {
        return ResponseEntity.ok(alunoService.findByPersonalIdAndStatus(personalId, status));
    }
    
    @GetMapping("/personal/{personalId}/count")
    public ResponseEntity<Long> countByPersonalId(@PathVariable Long personalId) {
        return ResponseEntity.ok(alunoService.countByPersonalIdAndStatus(personalId, StatusAluno.ATIVO));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.findById(id)
                .map(existing -> {
                    aluno.setId(id);
                    return ResponseEntity.ok(alunoService.save(aluno));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}