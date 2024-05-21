/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.request.PedidoRequest;
import br.com.techchallenge.fiap.neighborfood.adapters.inbound.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.UserAdapter;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.NotificacaoEntity;
import br.com.techchallenge.fiap.neighborfood.config.exception.ClienteException;
import br.com.techchallenge.fiap.neighborfood.config.exception.PedidoException;
import br.com.techchallenge.fiap.neighborfood.domain.model.*;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.CategoriaCombo;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.StatusPedido;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.AcompanhamentoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.PedidoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.EstoqueUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.NotificationUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class PedidoUseCaseImpl implements PedidoUseCasePort {

    private PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort;
    private EstoqueUseCaseAdapterPort estoqueUseCaseAdapterPort;
    private NotificationUseCaseAdapterPort notificationUseCaseAdapterPort;
    private AcompanhamentoUseCasePort acompanhamentoUseCasePort;
    private UserAdapter userAdapter;

    public PedidoUseCaseImpl(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort, EstoqueUseCaseAdapterPort estoqueUseCaseAdapterPort, NotificationUseCaseAdapterPort notificationUseCaseAdapterPort, AcompanhamentoUseCasePort acompanhamentoUseCasePort, UserAdapter userAdapter) {
        this.pedidoUseCaseAdapterPort = pedidoUseCaseAdapterPort;
        this.estoqueUseCaseAdapterPort = estoqueUseCaseAdapterPort;
        this.notificationUseCaseAdapterPort = notificationUseCaseAdapterPort;
        this.acompanhamentoUseCasePort = acompanhamentoUseCasePort;
        this.userAdapter = userAdapter;
    }

    @Override
    public Object menuOpcionaisExecute() {
        HashMap<CategoriaCombo, Set> menuItens = new HashMap<>();

        for (CategoriaCombo opt : CategoriaCombo.values()) {
            menuItens.put(opt, pedidoUseCaseAdapterPort.menuOpcionais(opt));
        }

        return menuItens;
    }

    @Override
    public AcompanhamentoResponse pedidoExecute(PedidoRequest pedidoRequest) {

        Pedido pedido = new Pedido();
        AcompanhamentoResponse response = new AcompanhamentoResponse();
        Cliente cliente = userAdapter.clienteById(pedidoRequest.getIdCliente());

        if (cliente == null) {
            throw new ClienteException("CLIENTE NÃO ENCONTRADO");
        }

        pedidoRequest.setIdCliente(cliente.getId());
        pedidoRequest.getItens().getProdutos().forEach(produto -> {

            Set<Estoque> estoque = estoqueUseCaseAdapterPort.findByNome(produto.getNome());

            if (estoque != null) {
                pedido.getItens().getProdutos().add(produto);
                pedido.setTotal(pedido.getTotal().add(produto.getPreco()));
                estoqueUseCaseAdapterPort.deleteAll(estoque);
            } else {
                Produto emFalta = new Produto();
                emFalta.setDescricao("produto em falta!");
                pedido.setTotal(BigDecimal.ZERO);
                pedido.getItens().getProdutos().add(emFalta);
            }
        });

        pedido.setStatus(StatusPedido.RECEBIDO);
        pedido.setDataPedido(new Date());

        if (!pedido.getTotal().equals(BigDecimal.ZERO)) {

            log.info(acompanhamentoUseCasePort.smsExecute(pedido.getStatus()));

            Pedido pedidoDTO = pedidoUseCaseAdapterPort.commitUpdates(pedido.fromEntity(pedido));
            pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.fromEntity(pedidoDTO));
            response.setPedido(pedidoDTO);
        } else {
            NotificacaoEntity notificacao = new NotificacaoEntity();
            notificacao.setDescricao("Caro adm, por favor, veja a quantia de itens cadastrado no estoque!");
            notificationUseCaseAdapterPort.notifica(new Notificacao().fromDomain(notificacao));
            log.info("\n\nItens selecionados em falta!\n\n");
        }

        return response;
    }


    @Override
    public AcompanhamentoResponse atualizarPedidoExecute(PedidoRequest pedido) {
        Cliente cliente = userAdapter.clienteById(pedido.getIdCliente());
        Set<Itens> itensById = pedidoUseCaseAdapterPort.findByIdPedidoItens(pedido.getId());

        if (cliente == null && ObjectUtils.isEmpty(itensById)) {
            throw new PedidoException("\n\nCliente ou Pedido não encontrado!\n\n");
        }

        itensById.forEach(item -> {
            Estoque estoque = new Estoque();
            estoque.setId(item.getId());
            estoque.setNome(item.getNome());
            estoque.setDescricao(item.getDescricao());
            estoque.setCategoria(item.getCategoria());
            estoque.setImg(item.getImg());
            estoque.setPreco(item.getPreco());
            estoqueUseCaseAdapterPort.repoemEstoque(estoque);
        });

        Pedido byIdPedidoPedido = pedidoUseCaseAdapterPort.findByIdPedido(pedido.getId());
        pedidoUseCaseAdapterPort.pedido(pedido);
        byIdPedidoPedido.setTotal(BigDecimal.ZERO);
        pedidoUseCaseAdapterPort.commitUpdates(byIdPedidoPedido.fromEntity(byIdPedidoPedido));

        pedidoUseCaseAdapterPort.removeItens(itensById);
        pedido.getItens().forEach(ped -> {

            itensById.forEach(item -> {
                ped.setIdPedido(item.getIdPedido());

                Pedido pedidoDTO = pedidoUseCaseAdapterPort.findByIdPedido(pedido.getId());
                pedidoDTO.setTotal(pedidoDTO.getTotal().add(ped.getPreco()));
                pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.fromEntity(pedidoDTO));

                pedidoUseCaseAdapterPort.saveItens(ped);
                estoqueUseCaseAdapterPort.deleteByNome(ped.getNome());
            });
        });
        log.info("Pedido atualizado!");

        return pedidoUseCaseAdapterPort.atualizarPedido(pedido);

    }

    @Override
    public void removeItensExecute(Set<Itens> itens) {
        pedidoUseCaseAdapterPort.removeItens(itens);
    }
}
