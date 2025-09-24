package com.trabalho.simulacao_credito.repository;

import com.trabalho.simulacao_credito.model.SimulacaoCredito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulacaoCreditoRepository extends JpaRepository<SimulacaoCredito, Long> {
}
