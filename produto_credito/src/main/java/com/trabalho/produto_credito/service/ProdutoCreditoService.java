package com.trabalho.produto_credito.service;

import com.trabalho.produto_credito.dto.ProdutoCreditoDTO;
import com.trabalho.produto_credito.dto.ProdutoCreditoFiltroDTO;
import com.trabalho.produto_credito.dto.ProdutoCreditoRequestDTO;
import com.trabalho.produto_credito.model.ProdutoCredito;
import com.trabalho.produto_credito.repository.ProdutoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoCreditoService {

    @Autowired
    private ProdutoCreditoRepository repository;

    public boolean cadastrar(ProdutoCreditoDTO produto) {

        boolean salvo = false;

        ProdutoCredito produtoSalvo = ProdutoCredito.toEntity(produto);
        produtoSalvo = repository.save(produtoSalvo);

        if (produtoSalvo.getId() != null){

            salvo = true;
        }

        return salvo;
    }

    public ProdutoCreditoFiltroDTO buscarPorFiltro(ProdutoCreditoRequestDTO produtoRequerido) {

        return repository.buscarPorMesesEValor(
                        produtoRequerido.getMesesRequerido(),
                        produtoRequerido.getValorRequerido()
                )
                .map(produto -> new ProdutoCreditoFiltroDTO(produto.getNome(), produto.getTaxaJuros()))
                .orElse(null);
    }
}
