/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.EstoqueEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.EstoqueRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Estoque;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.EstoqueUseCaseAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
        try {
            EstoqueEntity entity = estoque.fromEntity(estoque);
            return estoqueRepository.save(entity);
        } catch (RuntimeException ex){
            System.err.println(ex);
        }
        return null;
    }


    @Override
    public Estoque findByNome(String nome) {
        return null;// new Estoque().fromDomain(estoqueRepository.findByNome(nome));
    }

    @Override
    public void deleteByNome(String nome) {
        //estoqueRepository.deleteProduto(nome);
    }

    @Override
    public void deleteAll(Estoque lista) {
        estoqueRepository.delete(new Estoque().fromEntity(lista));
    }

}
