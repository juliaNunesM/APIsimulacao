package com.trabalho.produto_credito.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoCreditoDTO {

    @NotBlank
    @Schema(description = "Nome do produto de crédito", example = "Crédito Pessoal Flex")
    private String nome;

    @NotNull
    @Min(1)
    @Schema(description = "Quantidade mínima de meses", example = "6")
    private Integer mesesMinimos;

    @NotNull
    @Min(1)
    @Schema(description = "Quantidade máxima de meses", example = "24")
    private Integer mesesMaximos;

    @NotNull
    @Positive
    @Schema(description = "Valor mínimo financiável", example = "1000.0")
    private Double valorMinimo;

    @NotNull
    @Positive
    @Schema(description = "Valor máximo financiável", example = "5000.0")
    private Double valorMaximo;

    @NotNull
    @DecimalMin(value = "0.0")
    @Schema(description = "Taxa de juros ao mês", example = "0.019")
    private BigDecimal taxaJuros;
}
