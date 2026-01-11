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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.enums.GrupoMuscular;
import br.com.sistema.models.Exercicio;
import br.com.sistema.services.ExercicioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exercicios")
@RequiredArgsConstructor
public class ExercicioController {
    
    private final ExercicioService exercicioService;
    
    @PostMapping
    public ResponseEntity<Exercicio> create(@RequestBody Exercicio exercicio) {
        return ResponseEntity.ok(exercicioService.save(exercicio));
    }
    
    @GetMapping
    public ResponseEntity<List<Exercicio>> findAll() {
        return ResponseEntity.ok(exercicioService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> findById(@PathVariable Long id) {
        return exercicioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/grupo/{grupoMuscular}")
    public ResponseEntity<List<Exercicio>> findByGrupoMuscular(@PathVariable GrupoMuscular grupoMuscular) {
        return ResponseEntity.ok(exercicioService.findByGrupoMuscular(grupoMuscular));
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Exercicio>> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(exercicioService.findByNome(nome));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> update(@PathVariable Long id, @RequestBody Exercicio exercicio) {
        return exercicioService.findById(id)
                .map(existing -> {
                    exercicio.setId(id);
                    return ResponseEntity.ok(exercicioService.save(exercicio));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        exercicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}