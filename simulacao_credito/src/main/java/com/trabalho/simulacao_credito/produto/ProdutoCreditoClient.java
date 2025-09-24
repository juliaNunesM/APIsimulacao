package com.trabalho.simulacao_credito.produto;

import com.trabalho.simulacao_credito.dto.ProdutoCreditoFiltroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "produto-credito", url = "http://localhost:8080")
public interface ProdutoCreditoClient {

    @GetMapping("/produto-credito/buscarPorFiltro")
    ProdutoCreditoFiltroDTO buscarProduto(
            @RequestParam("valorRequerido") double valorRequerido,
            @RequestParam("mesesRequerido") int mesesRequerido);
}

