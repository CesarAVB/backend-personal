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

import br.com.sistema.models.ExercicioTreino;
import br.com.sistema.services.ExercicioTreinoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exercicios-treino")
@RequiredArgsConstructor
public class ExercicioTreinoController {
    
    private final ExercicioTreinoService exercicioTreinoService;
    
    @PostMapping
    public ResponseEntity<ExercicioTreino> create(@RequestBody ExercicioTreino exercicioTreino) {
        return ResponseEntity.ok(exercicioTreinoService.save(exercicioTreino));
    }
    
    @GetMapping
    public ResponseEntity<List<ExercicioTreino>> findAll() {
        return ResponseEntity.ok(exercicioTreinoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ExercicioTreino> findById(@PathVariable Long id) {
        return exercicioTreinoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/treino/{treinoId}")
    public ResponseEntity<List<ExercicioTreino>> findByTreinoId(@PathVariable Long treinoId) {
        return ResponseEntity.ok(exercicioTreinoService.findByTreinoId(treinoId));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ExercicioTreino> update(@PathVariable Long id, @RequestBody ExercicioTreino exercicioTreino) {
        return exercicioTreinoService.findById(id)
                .map(existing -> {
                    exercicioTreino.setId(id);
                    return ResponseEntity.ok(exercicioTreinoService.save(exercicioTreino));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        exercicioTreinoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/treino/{treinoId}")
    public ResponseEntity<Void> deleteByTreinoId(@PathVariable Long treinoId) {
        exercicioTreinoService.deleteByTreinoId(treinoId);
        return ResponseEntity.noContent().build();
    }
}