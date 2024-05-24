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
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.NotificationUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.ProdutoUseCaseAdapterPort;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class PedidoUseCaseImpl implements PedidoUseCasePort {

    private static final String MESSAGE_ADM_ESTOQUE =
            "Caro adm, por favor, veja a quantia de itens cadastrado no estoque!";
    private static final String CLIENTE_NOT_FOUND = "\n\nCliente ou Pedido não encontrado!\n\n";
    private static final String ITENS_EM_FALLTA = "\n\nItens selecionados em falta!\n\n";

    private PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort;
    private ProdutoUseCaseAdapterPort produtoUseCaseAdapterPort;
    private NotificationUseCaseAdapterPort notificationUseCaseAdapterPort;
    private AcompanhamentoUseCasePort acompanhamentoUseCasePort;
    private UserAdapter userAdapter;

    public PedidoUseCaseImpl(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort, ProdutoUseCaseAdapterPort estoqueUseCaseAdapterPort, NotificationUseCaseAdapterPort notificationUseCaseAdapterPort, AcompanhamentoUseCasePort acompanhamentoUseCasePort, UserAdapter userAdapter) {
        this.pedidoUseCaseAdapterPort = pedidoUseCaseAdapterPort;
        this.produtoUseCaseAdapterPort = estoqueUseCaseAdapterPort;
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
        Pedido pedido = new Pedido();
        Set<Item> itensPedido = new HashSet<>();
        Item itemPedido = new Item();
        Set<Produto> deleteProdutos = new HashSet<>();
        AcompanhamentoResponse pedidoResponse = new AcompanhamentoResponse();
        Cliente cliente = userAdapter.clienteById(request.getIdCliente());

        if (cliente == null) {
            throw new ClienteException("CLIENTE NÃO ENCONTRADO");
        }

        pedido.setIdCliente(cliente.getId());
        request.getItemPedido().forEach(item -> {

            Produto prod = produtoUseCaseAdapterPort.findById(item.getId());

            if (prod != null) {
                itemPedido.setId(prod.getId());
                itemPedido.setNome(prod.getNome());
                itemPedido.setCategoria(Categoria.valueOf(prod.getCategoria().toString()));
                itemPedido.setDescricao(prod.getDescricao());
                itemPedido.setPreco(prod.getPreco());
                itemPedido.setImg(prod.getImg());
                deleteProdutos.add(prod);
            } else {
                Item emFalta = new Item();
                emFalta.setPreco(BigDecimal.ZERO);
                emFalta.setImg("https://st4.depositphotos.com/14953852/24787/v/450/depositphotos_247872612-stock-illustration-no-image-available-icon-vector.jpg");
                emFalta.setDescricao("produto em falta!");
                itensPedido.add(emFalta);
            }

        });

        itensPedido.add(itemPedido);
        pedido.setIdCliente(request.getIdCliente());
        pedido.setItemProdutos(itensPedido);
        pedido.setStatus(Status.RECEBIDO);
        itensPedido.forEach(valor -> {
            pedido.setTotal(pedido.getTotal().add(valor.getPreco()));
        });
        pedido.setDataPedido(new Date());

        if (!pedido.getTotal().equals(BigDecimal.ZERO)) {

            log.info(acompanhamentoUseCasePort.smsExecute(pedido.getStatus()));
            AcompanhamentoResponse ped = pedidoUseCaseAdapterPort.pedido(pedido);
            pedidoResponse.setTotal(ped.getTotal());
            pedidoResponse.setStatus(ped.getStatus());
            pedidoResponse.setPedidoRequest(request);
            produtoUseCaseAdapterPort.deleteAll(deleteProdutos);
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

        produtoUseCaseAdapterPort.repoemEstoque(produtos);

        Pedido pedidoRealizado = pedidoUseCaseAdapterPort.findByIdPedido(pedido.getId());
        pedidoUseCaseAdapterPort.pedido(pedidoRealizado);
        pedidoRealizado.setTotal(BigDecimal.ZERO);
        pedidoUseCaseAdapterPort.commitUpdates(pedidoRealizado.domainFromEntity());

        //pedidoUseCaseAdapterPort.removeItens(itensById);

        pedido.getItemPedido().forEach(pro -> {
            Pedido pedidoDTO = pedidoUseCaseAdapterPort.findByIdPedido(pedido.getId());
            pedidoDTO.setTotal(pedidoDTO.getTotal().add(pro.getPreco()));
            pedidoUseCaseAdapterPort.commitUpdates(pedidoDTO.domainFromEntity());

            //pedidoUseCaseAdapterPort.saveItens();
            produtoUseCaseAdapterPort.deleteById(pro.getId());
        });

        log.info("Pedido atualizado!");

        return pedidoUseCaseAdapterPort.atualizarPedido(pedidoRealizado);

    }

    @Override
    public void removeItensExecute(Set<Item> itens) {
        pedidoUseCaseAdapterPort.removeItens(itens);
    }
}
