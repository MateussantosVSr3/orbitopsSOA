package br.com.fiap.orbitops.service;

import br.com.fiap.orbitops.dto.TelemetriaDTO;
import br.com.fiap.orbitops.model.Satelite;

public interface TelemetriaService { // Interface de Abstração
    Satelite processarLeituraOrbital(TelemetriaDTO dto);
}