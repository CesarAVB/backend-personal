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

import br.com.sistema.models.Anamnese;
import br.com.sistema.services.AnamneseService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/anamneses")
@RequiredArgsConstructor
public class AnamneseController {
    
    private final AnamneseService anamneseService;
    
    @PostMapping
    public ResponseEntity<Anamnese> create(@RequestBody Anamnese anamnese) {
        return ResponseEntity.ok(anamneseService.save(anamnese));
    }
    
    @GetMapping
    public ResponseEntity<List<Anamnese>> findAll() {
        return ResponseEntity.ok(anamneseService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Anamnese> findById(@PathVariable Long id) {
        return anamneseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Anamnese>> findByAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(anamneseService.findByAlunoId(alunoId));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Anamnese> update(@PathVariable Long id, @RequestBody Anamnese anamnese) {
        return anamneseService.findById(id)
                .map(existing -> {
                    anamnese.setId(id);
                    return ResponseEntity.ok(anamneseService.save(anamnese));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        anamneseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}