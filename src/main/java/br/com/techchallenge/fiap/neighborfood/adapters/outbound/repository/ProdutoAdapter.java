/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ProdutoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ProdutoRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Produto;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.ProdutoUseCaseAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class ProdutoAdapter implements ProdutoUseCaseAdapterPort {

    private ProdutoRepository produtoRepository;

    public ProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Object gerenciaEstoque(Long idAmdin) {
        return null;
    }

    @Override
    public Object repoemEstoque(Set<Produto> produtos) {
        try {
            produtos.forEach(produto -> {
                produtoRepository.save(produto.dtoFromEntity());
            });
            return produtos;
        } catch (RuntimeException ex) {
            System.err.println(ex);
        }
        return null;
    }


    @Override
    public Produto findById(Long idProduto) {
        Optional<ProdutoEntity> produtoById = produtoRepository.findById(idProduto);
        if (produtoById.isPresent()) {
            return new Produto()
                    .entityFromDto(produtoById.get());
        }
        return new Produto();
    }

    @Override
    public void deleteById(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }

    @Override
    public void deleteAll(Set<Produto> produtos) {
        produtos.forEach(produto -> {
            produtoRepository.delete(produto.dtoFromEntity());
        });
    }

}
