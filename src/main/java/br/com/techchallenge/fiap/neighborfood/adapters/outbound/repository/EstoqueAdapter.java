/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.EstoqueRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Estoque;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.EstoqueUseCaseAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EstoqueAdapter implements EstoqueUseCaseAdapterPort {

    private EstoqueRepository estoqueRepository;

    public EstoqueAdapter(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public Object gerenciaEstoque(Long idAmdin) {
        return null;
    }

    @Override
    public Object repoemEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque.fromEntity(estoque));
    }


    @Override
    public Set<Estoque> findByNome(String nome) {
        return new Estoque().fromDomain(estoqueRepository.findByNome(nome));
    }

    @Override
    public void deleteByNome(String nome) {
        estoqueRepository.deleteByNome(nome);
    }

    @Override
    public void deleteAll(Set<Estoque> lista) {
        estoqueRepository.deleteAll(new Estoque().fromListEntity(lista));
    }

}
