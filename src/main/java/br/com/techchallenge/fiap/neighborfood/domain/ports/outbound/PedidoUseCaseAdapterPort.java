/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PagamentoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.domain.model.*;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.CategoriaCombo;

import java.util.List;
import java.util.Set;

public interface PedidoUseCaseAdapterPort {

    Set<Estoque> menuOpcionais(CategoriaCombo combo);

    AcompanhamentoResponse pedido(Pedido pedido);

    AcompanhamentoResponse atualizarPedido(Pedido pedido);

    Pedido commitUpdates(PedidoEntity pedidoEntity);
    void saveItens(Itens itens);

    void removeItens(Set<Itens> itens);

    Set<Itens> findAllById(Long id);

    Set<Itens> findByIdPedidoItens(Long id);
    Pedido findByIdPedido(Long id);

    Pedido findById(Long id);

    void salvaPagamento(PagamentoEntity entity);

    List<PedidoEntity> pedidosExecute();
}
