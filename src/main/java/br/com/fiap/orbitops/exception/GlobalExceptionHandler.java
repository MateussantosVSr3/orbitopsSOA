package br.com.fiap.orbitops.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice // Garante que a aplicação capture erros e responda sem quebrar abruptamente
public class GlobalExceptionHandler {

    @ExceptionHandler(SateliteDesconectadoException.class)
    public ResponseEntity<Object> handleSateliteDesconectado(SateliteDesconectadoException ex) {
        Map<String, Object> body = new LinkedHashMap<>();

        // CORREÇÃO AQUI: Trocado .add() por .put()
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
        body.put("error", "Falha Crítica de Link");
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
    }
}