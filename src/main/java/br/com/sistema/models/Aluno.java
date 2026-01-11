package br.com.sistema.models;

import java.time.LocalDate;

import br.com.sistema.enums.Genero;
import br.com.sistema.enums.StatusAluno;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;
    
    @Column(length = 20)
    private String whatsapp;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Genero genero;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @ManyToOne
    @JoinColumn(name = "personal_id")
    private Personal personal;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusAluno status = StatusAluno.ATIVO;
}