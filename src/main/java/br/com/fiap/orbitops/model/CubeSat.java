package br.com.fiap.orbitops.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;


@Entity
@DiscriminatorValue("CUBESAT")
public class CubeSat extends Satelite {

    private double tamanhoU; // Ex: 3.0 para CubeSats 3U

    public CubeSat() {}

    public CubeSat(String nome, double tamanhoU) {
        super(nome);
        this.tamanhoU = tamanhoU;
    }

    @Override
    public boolean analisarRiscoSinal(double temperaturaBateria) {
        // Polimorfismo: CubeSats entram em modo de risco com temperaturas de bateria superiores a 50°C
        return temperaturaBateria > 50.0;
    }

    public double getTamanhoU() { return tamanhoU; }
    public void setTamanhoU(double tamanhoU) { this.tamanhoU = tamanhoU; }
}