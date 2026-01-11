package br.com.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.models.Personal;
import br.com.sistema.repositories.PersonalRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonalService {
    
    private final PersonalRepository personalRepository;
    
    @Transactional
    public Personal save(Personal personal) {
        return personalRepository.save(personal);
    }
    
    @Transactional(readOnly = true)
    public List<Personal> findAll() {
        return personalRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public Optional<Personal> findById(Long id) {
        return personalRepository.findById(id);
    }
    
    @Transactional(readOnly = true)
    public Optional<Personal> findByUsuarioId(Long usuarioId) {
        return personalRepository.findByUsuarioId(usuarioId);
    }
    
    @Transactional
    public void deleteById(Long id) {
        personalRepository.deleteById(id);
    }
}