package br.com.fiap.orbitops.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_ORBIT_ALERTA")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String nivelCriticidade;
    private LocalDateTime dataEmissao; // Histórico temporal obrigatório

    @ManyToOne
    @JoinColumn(name = "satelite_id")
    private Satelite satelite;

    public Alerta() {}

    public Alerta(String descricao, String nivelCriticidade, Satelite satelite) {
        this.descricao = descricao;
        this.nivelCriticidade = nivelCriticidade;
        this.satelite = satelite;
        this.dataEmissao = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getNivelCriticidade() { return nivelCriticidade; }
    public LocalDateTime getDataEmissao() { return dataEmissao; }
    public Satelite getSatelite() { return satelite; }
}