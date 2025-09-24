package com.trabalho.produto_credito.repository;

import com.trabalho.produto_credito.model.ProdutoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProdutoCreditoRepository extends JpaRepository<ProdutoCredito, Long> {

    @Query("SELECT p FROM ProdutoCredito p " +
            "WHERE :meses BETWEEN p.mesesMinimos AND p.mesesMaximos " +
            "AND :valor BETWEEN p.valorMinimo AND p.valorMaximo")
    Optional<ProdutoCredito> buscarPorMesesEValor(@Param("meses") int meses,
                                                  @Param("valor") double valor);
}