package com.trabalho.simulacao_credito.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProdutoCreditoFiltroDTO {

    @Schema(description = "Nome do produto de crédito", example = "Crédito Pessoal Flex")
    private String nome;

    @Schema(description = "Taxa de juros do produto", example = "0.019")
    private BigDecimal taxaJuros;
}
