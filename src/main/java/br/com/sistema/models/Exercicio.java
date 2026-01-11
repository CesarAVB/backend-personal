package br.com.sistema.models;

import br.com.sistema.enums.GrupoMuscular;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nome;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "grupo_muscular", length = 20)
    private GrupoMuscular grupoMuscular;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @Column(name = "video_url")
    private String videoUrl;
}