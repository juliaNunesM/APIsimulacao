package com.trabalho.simulacao_credito.produto;

import com.trabalho.simulacao_credito.dto.ProdutoCreditoFiltroDTO;
import com.trabalho.simulacao_credito.dto.SimulacaoCreditoRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "produto-credito", url = "http://localhost:8080")
public interface ProdutoCreditoClient {

    @PostMapping("/produto-credito/buscarPorFiltro")
    ProdutoCreditoFiltroDTO buscarPorFiltro(@RequestBody SimulacaoCreditoRequestDTO requestDTO);
}

