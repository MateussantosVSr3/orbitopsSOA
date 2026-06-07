package br.com.fiap.orbitops.dto;


public class TelemetriaDTO {
    private Long sateliteId;
    private String nomeSensor;
    private double valorLeitura;
    private boolean sinalAtivo;

    // Getters e Setters
    public Long getSateliteId() { return sateliteId; }
    public void setSateliteId(Long sateliteId) { this.sateliteId = sateliteId; }
    public String getNomeSensor() { return nomeSensor; }
    public void setNomeSensor(String nomeSensor) { this.nomeSensor = nomeSensor; }
    public double getValorLeitura() { return valorLeitura; }
    public void setValorLeitura(double valorLeitura) { this.valorLeitura = valorLeitura; }
    public boolean isSinalAtivo() { return sinalAtivo; }
    public void setSinalAtivo(boolean sinalAtivo) { this.sinalAtivo = sinalAtivo; }
}