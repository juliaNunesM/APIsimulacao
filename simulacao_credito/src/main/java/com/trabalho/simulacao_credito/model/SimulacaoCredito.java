package com.trabalho.simulacao_credito.model;

import com.trabalho.simulacao_credito.dto.SimulacaoCreditoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "simulacao_credito")
public class SimulacaoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;

    @NotNull
    @Positive
    @Column(name = "valor_solicitado", nullable = false)
    private BigDecimal valorSolicitado;

    @NotNull
    @Positive
    @Column(name = "meses", nullable = false)
    private Integer meses;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    @Column(name = "taxa_juros", nullable = false)
    private BigDecimal taxaJuros;

    @NotNull
    @Positive
    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @NotNull
    @Positive
    @Column(name = "valor_parcela", nullable = false)
    private BigDecimal valorParcela;

    @NotNull
    @Column(name = "data_simulacao", nullable = false)
    private LocalDateTime dataSimulacao;

    public static SimulacaoCredito toEntity(SimulacaoCreditoDTO dto) {

        return new SimulacaoCredito(
                null,
                dto.getNomeProduto(),
                BigDecimal.valueOf(dto.getValorSolicitado()),
                dto.getMeses(),
                dto.getTaxaJuros(),
                BigDecimal.valueOf(dto.getValorTotal()),
                BigDecimal.valueOf(dto.getValorParcela()),
                LocalDateTime.now()
        );
    }
}
