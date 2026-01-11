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

import br.com.sistema.models.Personal;
import br.com.sistema.services.PersonalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/personals")
@RequiredArgsConstructor
public class PersonalController {
    
    private final PersonalService personalService;
    
    @PostMapping
    public ResponseEntity<Personal> create(@RequestBody Personal personal) {
        return ResponseEntity.ok(personalService.save(personal));
    }
    
    @GetMapping
    public ResponseEntity<List<Personal>> findAll() {
        return ResponseEntity.ok(personalService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Personal> findById(@PathVariable Long id) {
        return personalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Personal> findByUsuarioId(@PathVariable Long usuarioId) {
        return personalService.findByUsuarioId(usuarioId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Personal> update(@PathVariable Long id, @RequestBody Personal personal) {
        return personalService.findById(id)
                .map(existing -> {
                    personal.setId(id);
                    return ResponseEntity.ok(personalService.save(personal));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
