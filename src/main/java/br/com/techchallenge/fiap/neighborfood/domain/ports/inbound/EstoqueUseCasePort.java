/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.Estoque;

import java.util.Set;

public interface EstoqueUseCasePort {

    Object gerenciaEstoqueExecute(Long idAmdin);
    Object repoemEstoqueExecute(Estoque estoque);
    Object findByNomeExecute(Estoque estoque);
    void deleteByNomeExecute(String nome);
    void deleteAllExecute(Set<Estoque> lista);
}
