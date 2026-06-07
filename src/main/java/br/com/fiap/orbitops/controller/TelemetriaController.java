package br.com.fiap.orbitops.controller;

import br.com.fiap.orbitops.dto.TelemetriaDTO;
import br.com.fiap.orbitops.model.Satelite;
import br.com.fiap.orbitops.service.TelemetriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orbitops") // Atende o requisito de produção de WebService
public class TelemetriaController {

    private final TelemetriaService service;

    public TelemetriaController(TelemetriaService service) {
        this.service = service;
    }

    @PostMapping("/telemetria")
    public ResponseEntity<Satelite> receberDadosTelemetria(@RequestBody TelemetriaDTO payload) {
        Satelite resultado = service.processarLeituraOrbital(payload);
        return ResponseEntity.ok(resultado); // Retorna HTTP 200 com os dados sincronizados
    }
}