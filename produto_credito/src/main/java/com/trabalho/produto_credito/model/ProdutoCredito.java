package com.trabalho.produto_credito.model;

import com.trabalho.produto_credito.dto.ProdutoCreditoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Entity
@Table(name = "produto_credito")
public class ProdutoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotNull(message = "O mínimo de meses é obrigatório")
    @Min(value = 1, message = "O mínimo de meses deve ser maior ou igual a 1")
    private Integer mesesMinimos;

    @NotNull(message = "O máximo de meses é obrigatório")
    @Min(value = 1, message = "O máximo de meses deve ser maior ou igual a 1")
    private Integer mesesMaximos;

    @NotNull(message = "O valor mínimo é obrigatório")
    @Positive(message = "O valor mínimo deve ser maior que zero")
    private Double valorMinimo;

    @NotNull(message = "O valor máximo é obrigatório")
    @Positive(message = "O valor máximo deve ser maior que zero")
    private Double valorMaximo;

    @NotNull(message = "A taxa de juros é obrigatória")
    @DecimalMin(value = "0.0", message = "A taxa de juros não pode ser negativa")
    private BigDecimal taxaJuros;

    public static ProdutoCredito toEntity(ProdutoCreditoDTO produto) {

        return new ProdutoCredito(
                null,
                produto.getNome(),
                produto.getMesesMinimos(),
                produto.getMesesMaximos(),
                produto.getValorMinimo(),
                produto.getValorMaximo(),
                produto.getTaxaJuros()
        );
    }
}
