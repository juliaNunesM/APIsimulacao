package com.trabalho.simulacao_credito.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SimulacaoCreditoRequestDTO {

    @NotNull
    @Schema(description = "Valor requerido pelo usuário", example = "2000.0")
    private Double valorRequerido;

    @NotNull
    @Schema(description = "Quantidade de meses requerida pelo usuário", example = "12")
    private Integer mesesRequerido;
}
