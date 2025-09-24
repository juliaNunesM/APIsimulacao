package com.trabalho.produto_credito.controller;

import com.trabalho.produto_credito.dto.ProdutoCreditoDTO;
import com.trabalho.produto_credito.dto.ProdutoCreditoFiltroDTO;
import com.trabalho.produto_credito.dto.ProdutoCreditoRequestDTO;
import com.trabalho.produto_credito.service.ProdutoCreditoService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/produto-credito")
@Tag(name = "Produto Crédito", description = "API para cadastro e busca de opções de crédito")
public class ProdutoCreditoResource {

    @Autowired
    private ProdutoCreditoService service;

    @Operation(summary = "Cadastrar nova opção de crédito",
            description = "Cadastra um novo produto de crédito na base de dados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Erro ao criar produto", content = @Content)
            })
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@Valid @RequestBody ProdutoCreditoDTO produtoCreditoDTO) {

        boolean produtoCriado= service.cadastrar(produtoCreditoDTO);

        if (produtoCriado) {

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Produto criado com sucesso");
        } else {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Buscar opção de crédito por filtro",
            description = "Busca um produto de crédito baseado no valor e quantidade de meses",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Produto encontrado",
                            content = @Content(schema = @Schema(implementation = ProdutoCreditoFiltroDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Produto não encontrado", content = @Content)
            })
    @GetMapping("/buscarPorFiltro")
    public ResponseEntity<ProdutoCreditoFiltroDTO> buscarPorFiltro(
            @Parameter(description = "Valor requerido para o crédito", example = "5000.00")
            @RequestParam double valorRequerido,

            @Parameter(description = "Quantidade de meses para pagamento", example = "24")
            @RequestParam int mesesRequerido) {

        ProdutoCreditoRequestDTO requestDTO = new ProdutoCreditoRequestDTO();
        requestDTO.setValorRequerido(valorRequerido);
        requestDTO.setMesesRequerido(mesesRequerido);

        ProdutoCreditoFiltroDTO resultado = service.buscarPorFiltro(requestDTO);

        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
