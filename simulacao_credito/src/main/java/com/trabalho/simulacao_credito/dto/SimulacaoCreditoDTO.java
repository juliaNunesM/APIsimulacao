package com.trabalho.simulacao_credito.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class SimulacaoCreditoDTO {

    @Schema(description = "Nome do produto de crédito selecionado", example = "Crédito Pessoal Flex")
    private String nomeProduto;

    @Schema(description = "Valor solicitado pelo usuário", example = "2000.0")
    private Double valorSolicitado;

    @Schema(description = "Quantidade de meses do financiamento", example = "12")
    private Integer meses;

    @Schema(description = "Taxa de juros aplicada ao financiamento", example = "0.019")
    private BigDecimal taxaJuros;

    @Schema(description = "Valor total a ser pago (principal + juros)", example = "2038.0")
    private Double valorTotal;

    @Schema(description = "Valor da parcela mensal", example = "169.83")
    private Double valorParcela;
}
