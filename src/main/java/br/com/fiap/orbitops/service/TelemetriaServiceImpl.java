package br.com.fiap.orbitops.service;

import br.com.fiap.orbitops.dto.TelemetriaDTO;
import br.com.fiap.orbitops.model.Satelite;
import br.com.fiap.orbitops.model.Alerta;
import br.com.fiap.orbitops.repository.SateliteRepository;
import br.com.fiap.orbitops.repository.AlertaRepository;
import br.com.fiap.orbitops.exception.SateliteDesconectadoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class TelemetriaServiceImpl implements TelemetriaService {

    private final SateliteRepository sateliteRepository;
    private final AlertaRepository alertaRepository;

    // Injeção de Dependência pelo construtor (Desacoplamento exigido por SOA)
    public TelemetriaServiceImpl(SateliteRepository sateliteRepository, AlertaRepository alertaRepository) {
        this.sateliteRepository = sateliteRepository;
        this.alertaRepository = alertaRepository;
    }

    @Override
    @Transactional
    public Satelite processarLeituraOrbital(TelemetriaDTO dto) {
        // Lógica de Fluxo e barreira de segurança crítica
        if (!dto.isSinalAtivo()) {
            throw new SateliteDesconectadoException("Sinal ausente para o Satélite ID: " + dto.getSateliteId() + ". Telemetria interrompida.");
        }

        // Busca o ativo no banco de dados relacional
        Satelite satelite = sateliteRepository.findById(dto.getSateliteId())
                .orElseGet(() -> sateliteRepository.save(new br.com.fiap.orbitops.model.CubeSat("Satélite Temporário " + dto.getSateliteId(), 3.0)));

        // Execução do polimorfismo dinâmico da entidade de domínio
        boolean possuiRisco = satelite.analisarRiscoSinal(dto.getValorLeitura());

        if (possuiRisco) {
            satelite.setStatusOperacional("SAFE_MODE");
            alertaRepository.save(new Alerta("Anomalia térmica detectada no componente: " + dto.getNomeSensor(), "CRITICO", satelite));
        } else {
            satelite.setStatusOperacional("NOMINAL");
        }

        satelite.setUltimaSincronizacao(LocalDateTime.now());
        return sateliteRepository.save(satelite); // Persistência real no banco de dados
    }
}