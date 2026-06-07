package br.com.fiap.orbitops.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_ORBIT_SATELITE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_satelite", discriminatorType = DiscriminatorType.STRING)
public abstract class Satelite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    private String statusOperacional;
    private LocalDateTime ultimaSincronizacao; // Manipulação precisa de datas

    public Satelite() {}

    public Satelite(String nome) {
        this.nome = nome;
        this.statusOperacional = "OPERACIONAL";
        this.ultimaSincronizacao = LocalDateTime.now();
    }

    // Método abstrato para Polimorfismo operacional
    public abstract boolean analisarRiscoSinal(double leitura);

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getStatusOperacional() { return statusOperacional; }
    public void setStatusOperacional(String statusOperacional) { this.statusOperacional = statusOperacional; }
    public LocalDateTime getUltimaSincronizacao() { return ultimaSincronizacao; }
    public void setUltimaSincronizacao(LocalDateTime ultimaSincronizacao) { this.ultimaSincronizacao = ultimaSincronizacao; }
}