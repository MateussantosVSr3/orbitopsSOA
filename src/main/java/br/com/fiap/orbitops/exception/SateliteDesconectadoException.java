package br.com.fiap.orbitops.exception;

// Exceção customizada específica para cenários de falhas de sistemas espaciais críticos
public class SateliteDesconectadoException extends RuntimeException {
    public SateliteDesconectadoException(String msg) {
        super(msg);
    }
}