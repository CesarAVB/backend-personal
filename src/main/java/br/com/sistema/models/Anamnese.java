package br.com.sistema.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anamneses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anamnese {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    
    @Column(name = "data_avaliacao", nullable = false)
    private LocalDateTime dataAvaliacao;
    
    private Double peso;
    
    private Double altura;
    
    private Double imc;
    
    @Column(columnDefinition = "TEXT")
    private String objetivos;
    
    @Column(name = "restricoes_medicas", columnDefinition = "TEXT")
    private String restricoesMedicas;
    
    @Column(columnDefinition = "TEXT")
    private String observacoes;
    
    @Column(columnDefinition = "TEXT")
    private String medidas;
    
    @PrePersist
    protected void onCreate() {
        dataAvaliacao = LocalDateTime.now();
        if (peso != null && altura != null && altura > 0) {
            imc = peso / (altura * altura);
        }
    }
}