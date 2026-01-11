package br.com.sistema.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.models.AgendaTreino;
import br.com.sistema.services.AgendaTreinoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/agenda-treinos")
@RequiredArgsConstructor
public class AgendaTreinoController {
    
    private final AgendaTreinoService agendaTreinoService;
    
    @PostMapping
    public ResponseEntity<AgendaTreino> create(@RequestBody AgendaTreino agendaTreino) {
        return ResponseEntity.ok(agendaTreinoService.save(agendaTreino));
    }
    
    @GetMapping
    public ResponseEntity<List<AgendaTreino>> findAll() {
        return ResponseEntity.ok(agendaTreinoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<AgendaTreino> findById(@PathVariable Long id) {
        return agendaTreinoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<AgendaTreino>> findByAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(agendaTreinoService.findByAlunoId(alunoId));
    }
    
    @GetMapping("/aluno/{alunoId}/periodo")
    public ResponseEntity<List<AgendaTreino>> findByAlunoIdAndPeriodo(
            @PathVariable Long alunoId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
        return ResponseEntity.ok(agendaTreinoService.findByAlunoIdAndPeriodo(alunoId, inicio, fim));
    }
    
    @GetMapping("/periodo")
    public ResponseEntity<List<AgendaTreino>> findByPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
        return ResponseEntity.ok(agendaTreinoService.findByPeriodo(inicio, fim));
    }
    
    @GetMapping("/personal/{personalId}/count")
    public ResponseEntity<Long> countByPersonalIdAndPeriodo(
            @PathVariable Long personalId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
        return ResponseEntity.ok(agendaTreinoService.countByPersonalIdAndPeriodo(personalId, inicio, fim));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AgendaTreino> update(@PathVariable Long id, @RequestBody AgendaTreino agendaTreino) {
        return agendaTreinoService.findById(id)
                .map(existing -> {
                    agendaTreino.setId(id);
                    return ResponseEntity.ok(agendaTreinoService.save(agendaTreino));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agendaTreinoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}