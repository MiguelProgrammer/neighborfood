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
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Categoria;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Status;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.AcompanhamentoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.PedidoUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.EstoqueUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.NotificationUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

@Slf4j
public class PedidoUseCaseImpl implements PedidoUseCasePort {

    private static final String MESSAGE_ADM_ESTOQUE =
            "Caro adm, por favor, veja a quantia de itens cadastrado no estoque!";
    private static final String CLIENTE_NOT_FOUND = "\n\nCliente ou Pedido não encontrado!\n\n";
    private static final String ITENS_EM_FALLTA = "\n\nItens selecionados em falta!\n\n";

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
        HashMap<Categoria, Set> menuItens = new HashMap<>();

        for (Categoria opt : Categoria.values()) {
            menuItens.put(opt, pedidoUseCaseAdapterPort.menuOpcionais(opt));
        }
        return menuItens;
    }

    @Override
    public AcompanhamentoResponse pedidoExecute(PedidoRequest request) {

        Pedido pedidoDomain = new Pedido();
        AcompanhamentoResponse pedidoResponse = new AcompanhamentoResponse();
        Cliente cliente = userAdapter.clienteById(request.getIdCliente());

        if (cliente == null) {
            throw new ClienteException("CLIENTE NÃO ENCONTRADO");
        }

        request.setIdCliente(cliente.getId());
        request.getProdutos().forEach(produto -> {

            Estoque estoque = estoqueUseCaseAdapterPort.findByNome(produto.getNome());

            if (estoque != null) {
                pedidoDomain.getProdutos().add(produto);
                pedidoDomain.setTotal(pedidoDomain.getTotal().add(produto.getPreco()));
                estoqueUseCaseAdapterPort.deleteAll(estoque);
            } else {
                Produto emFalta = new Produto();
                emFalta.setDescricao("produto em falta!");
                pedidoDomain.setTotal(BigDecimal.ZERO);
                pedidoDomain.getProdutos().add(emFalta);
            }

        });

        pedidoDomain.setStatus(Status.RECEBIDO);
        pedidoDomain.setDataPedido(new Date());

        if (!pedidoDomain.getTotal().equals(BigDecimal.ZERO)) {

            log.info(acompanhamentoUseCasePort.smsExecute(pedidoDomain.getStatus()));
            Pedido pedidoEnviado = pedidoUseCaseAdapterPort.commitUpdates(pedidoDomain.domainFromEntity());
            pedidoResponse.setTotal(pedidoEnviado.getTotal());
            pedidoResponse.setStatus(pedidoEnviado.getStatus());
            pedidoResponse.setPedidoRequest(request);
        } else {
            NotificacaoEntity notificacao = new NotificacaoEntity();
            notificacao.setDescricao(MESSAGE_ADM_ESTOQUE);
            notificationUseCaseAdapterPort.notifica(new Notificacao().entityfromDomain(notificacao));
            log.info(ITENS_EM_FALLTA);
        }

        return pedidoResponse;
    }


    @Override
    public AcompanhamentoResponse atualizarPedidoExecute(PedidoRequest pedido) {
        Cliente cliente = userAdapter.clienteById(pedido.getIdCliente());
        Set<Produto> produtos = pedidoUseCaseAdapterPort.findAllByIdPedido(pedido.getId());

        if (cliente == null && produtos == null) {
            throw new PedidoException(CLIENTE_NOT_FOUND);
        }

        produtos.forEach(produto -> {
            Estoque estoque = new Estoque();
            estoque.setProdutos(produtos);
            estoqueUseCaseAdapterPort.repoemEstoque(estoque);
        });

        Pedido pedidoRealizado = pedidoUseCaseAdapterPort.findByIdPedido(pedido.getId());
        pedidoUseCaseAdapterPort.pedido(pedidoRealizado);
        pedidoRealizado.setTotal(BigDecimal.ZERO);
        pedidoUseCaseAdapterPort.commitUpdates(pedidoRealizado.domainFromEntity());

        //pedidoUseCaseAdapterPort.removeItens(itensById);

        pedido.getProdutos().forEach(pro -> {
            Pedido pedidoDTO = pedidoUseCaseAdapterPort.findByIdPedido(pedido.getId());
            pedidoDTO.setTotal(pedidoDTO.getTotal().add(pro.getPreco()));
            pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.domainFromEntity());

            //pedidoUseCaseAdapterPort.saveItens();
            estoqueUseCaseAdapterPort.deleteByNome(pro.getNome());
        });

        log.info("Pedido atualizado!");

        return pedidoUseCaseAdapterPort.atualizarPedido(pedidoRealizado);

    }

    @Override
    public void removeItensExecute(Set<Itens> itens) {
        pedidoUseCaseAdapterPort.removeItens(itens);
    }
}
