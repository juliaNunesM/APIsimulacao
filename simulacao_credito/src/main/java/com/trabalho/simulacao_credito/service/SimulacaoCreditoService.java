package com.trabalho.simulacao_credito.service;

import com.trabalho.simulacao_credito.dto.ProdutoCreditoFiltroDTO;
import com.trabalho.simulacao_credito.dto.SimulacaoCreditoDTO;
import com.trabalho.simulacao_credito.dto.SimulacaoCreditoRequestDTO;
import com.trabalho.simulacao_credito.produto.ProdutoCreditoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class SimulacaoCreditoService {

    @Autowired
    private ProdutoCreditoClient produtoCreditoClient;


    public SimulacaoCreditoDTO simular(SimulacaoCreditoRequestDTO request) {

        ProdutoCreditoFiltroDTO produto = buscarProduto(request.getValorRequerido(), request.getMesesRequerido());

        if (produto == null) {

            return null;
        }

        BigDecimal valorRequerido = BigDecimal.valueOf(request.getValorRequerido());
        BigDecimal taxa = produto.getTaxaJuros();
        int meses = request.getMesesRequerido();

        BigDecimal valorJuros = calcularJuros(valorRequerido, taxa);
        BigDecimal valorTotal = valorRequerido.add(valorJuros);
        BigDecimal valorParcela = calcularParcela(valorTotal, meses);

        SimulacaoCreditoDTO response = new SimulacaoCreditoDTO();
        response.setNomeProduto(produto.getNome());
        response.setTaxaJuros(taxa);
        response.setValorTotal(valorTotal.doubleValue());
        response.setValorParcela(valorParcela.doubleValue());

        return response;
    }

    private BigDecimal calcularJuros(BigDecimal valor, BigDecimal taxa) {
        return valor.multiply(taxa);
    }

    private BigDecimal calcularParcela(BigDecimal valorTotal, int meses) {
        return valorTotal.divide(BigDecimal.valueOf(meses), 2, RoundingMode.HALF_UP);
    }

    private ProdutoCreditoFiltroDTO buscarProduto(double valor, int meses) {

        SimulacaoCreditoRequestDTO request = new SimulacaoCreditoRequestDTO();
        request.setValorRequerido(valor);
        request.setMesesRequerido(meses);
        return produtoCreditoClient.buscarPorFiltro(request);
    }

}

