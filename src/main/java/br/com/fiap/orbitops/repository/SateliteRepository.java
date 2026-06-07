package br.com.fiap.orbitops.repository;

import br.com.fiap.orbitops.model.Satelite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Interface herdando JpaRepository para persistência automatizada no banco relacional
public interface SateliteRepository extends JpaRepository<Satelite, Long> {
}