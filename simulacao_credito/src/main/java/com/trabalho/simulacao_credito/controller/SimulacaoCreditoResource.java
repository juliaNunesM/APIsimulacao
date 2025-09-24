package com.trabalho.simulacao_credito.controller;

import com.trabalho.simulacao_credito.dto.SimulacaoCreditoDTO;
import com.trabalho.simulacao_credito.dto.SimulacaoCreditoRequestDTO;
import com.trabalho.simulacao_credito.service.SimulacaoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/simulacao-credito")
@Tag(name = "Simulação de Crédito", description = "API para simular crédito usando produtos cadastrados")
public class SimulacaoCreditoResource {

    @Autowired
    private SimulacaoCreditoService service;


    @PostMapping("/simular")
    @Operation(summary = "Buscar produto para simulação", description = "Retorna o produto que atende ao valor e meses desejados")
    public ResponseEntity<?> simular(SimulacaoCreditoRequestDTO requestDTO) {

        SimulacaoCreditoDTO resultado = service.simular(requestDTO);

        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Não existe um produto para os valores informados");
        }
    }
}

