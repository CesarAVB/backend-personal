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

import br.com.sistema.models.Treino;
import br.com.sistema.services.TreinoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/treinos")
@RequiredArgsConstructor
public class TreinoController {
    
    private final TreinoService treinoService;
    
    @PostMapping
    public ResponseEntity<Treino> create(@RequestBody Treino treino) {
        return ResponseEntity.ok(treinoService.save(treino));
    }
    
    @GetMapping
    public ResponseEntity<List<Treino>> findAll() {
        return ResponseEntity.ok(treinoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Treino> findById(@PathVariable Long id) {
        return treinoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<Treino>> findByAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok(treinoService.findByAlunoId(alunoId));
    }
    
    @GetMapping("/aluno/{alunoId}/ativos")
    public ResponseEntity<List<Treino>> findByAlunoIdAndAtivo(@PathVariable Long alunoId) {
        return ResponseEntity.ok(treinoService.findByAlunoIdAndAtivo(alunoId, true));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Treino> update(@PathVariable Long id, @RequestBody Treino treino) {
        return treinoService.findById(id)
                .map(existing -> {
                    treino.setId(id);
                    return ResponseEntity.ok(treinoService.save(treino));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        treinoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}