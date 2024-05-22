/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.Estoque;

public interface EstoqueUseCaseAdapterPort {

    Object gerenciaEstoque(Long idAmdin);

    Object repoemEstoque(Estoque estoque);

    Estoque findByNome(String nome);

    void deleteByNome(String nome);

    void deleteAll(Estoque lista);
}
