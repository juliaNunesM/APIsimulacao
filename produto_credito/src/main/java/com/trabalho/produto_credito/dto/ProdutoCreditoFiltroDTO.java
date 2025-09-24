package com.trabalho.produto_credito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProdutoCreditoFiltroDTO {

    private String nome;
    private BigDecimal taxaJuros;
}
