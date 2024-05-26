/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItemEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PagamentoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ProdutoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ItensRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PagamentoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ProdutoRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Item;
import br.com.techchallenge.fiap.neighborfood.domain.model.Pedido;
import br.com.techchallenge.fiap.neighborfood.domain.model.Produto;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Categoria;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class PedidoAdapter implements PedidoUseCaseAdapterPort {

    private PedidoRepository pedidoRepository;
    private PagamentoRepository pagamentoRepository;
    private ProdutoRepository produtoRepository;
    private ItensRepository itensRepository;

    public PedidoAdapter(PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository, ProdutoRepository produtoRepository, ItensRepository itensRepository) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.produtoRepository = produtoRepository;
        this.itensRepository = itensRepository;
    }

    @Override
    public Set<Produto> menuOpcionais(Categoria combo) {
        Set<ProdutoEntity> byCategoria = produtoRepository.findByCategoria(combo);
        return new Produto().setProdutosRequestFromSetEntity(byCategoria);
    }

    @Override
    public AcompanhamentoResponse pedido(Pedido pedido) {
        PedidoEntity entity = new PedidoEntity();

        entity.setDataPedido(pedido.getDataPedido());
        entity.setIdCliente(pedido.getIdCliente());
        entity.setDataPedido(pedido.getDataPedido());
        entity.setStatus(pedido.getStatus());
        entity.setTotal(pedido.getTotal());
        pedido.getItensProdutos().forEach(item -> {
            entity.getItensProdutos().add(item.itemDomainFromItemEntity());
        });
        PedidoEntity save = pedidoRepository.saveAndFlush(entity);
        save.getItensProdutos().forEach(item -> {
            item.setIdPedido(save.getId());
        });
        PedidoEntity updateResponse = pedidoRepository.saveAndFlush(save);
        AcompanhamentoResponse response = new AcompanhamentoResponse().pedidoEntityFromResponse(updateResponse);
        return response;
    }

    @Override
    public AcompanhamentoResponse atualizarPedido(Pedido pedido) {
        return null;
    }

    @Override
    public Pedido commitUpdates(PedidoEntity pedidoEntity) {
        PedidoEntity entity = pedidoRepository.findById(pedidoEntity.getId()).get();
        entity = pedidoEntity;
        pedidoRepository.save(entity);
        return new Pedido().entityFromDomain(entity);
    }

    @Override
    public void saveItens(Item item) {
        itensRepository.save(new Pedido().itemDomainFromItemEntity(item));
    }

    @Override
    public void removeItens(Set<Item> itens) {
    }

    @Override
    public Set<Item> findAllById(Long id) {
        return Set.of();
    }

    //    @Override
//    public void saveItens(Itens itens) {
//        ItensEntity item = new ItensEntity();
//        item.setIdPedido(itens.getIdPedido());
//        item.setNome(itens.getNome());
//        item.setDescricao(itens.getDescricao());
//        item.setPreco(itens.getPreco());
//        item.setCategoria(itens.getCategoria());
//        item.setImg(itens.getImg());
//        item.setPedido(itens.getPedido().fromEntity(itens.getPedido()));
//        itensRepository.save(item);
//    }

//    @Override
//    public void removeProdutos(Set<Produto> produtos) {
//        new Itens().fromListEntity(itens);
//        pedidoRepository.deleteAll();
//    }

//    @Override
//    public Set<Produto> findAllById(Long id) {
//        return new Itens().fromDomain(pr.findAllById(id));
//    }

    @Override
    public Set<Item> findAllByIdPedido(Long id) {
        Set<Item> produtos = new HashSet<>();
        Set<ItemEntity> byIdPedido = itensRepository.findByIdPedido(id);
        byIdPedido.forEach(item -> {
            Item produto = new Item();
            produto.setId(item.getId());
            produto.setIdPedido(item.getIdPedido());
            produto.setIdProduto(item.getIdProduto());
            produto.setNome(item.getNome());
            produto.setDescricao(item.getDescricao());
            produto.setCategoria(item.getCategoria());
            produto.setPreco(item.getPreco());
            produto.setImg(item.getImg());
            produtos.add(produto);
        });
        return produtos;
    }


    @Override
    public Pedido findByIdPedido(Long id) {
        Optional<PedidoEntity> pedidoRepositoryById = pedidoRepository.findById(id);
        return new Pedido().entityFromDomain(pedidoRepositoryById.get());
    }

    @Override
    public Pedido findById(Long id) {
        PedidoEntity entity = pedidoRepository.findById(id).get();
        entity.setItensProdutos(itensRepository.findByIdPedido(entity.getId()));
        return new Pedido().entityFromDomain(entity);
    }

    @Override
    @Transactional
    public void salvaPagamento(PagamentoEntity entity) {
        PagamentoEntity pagamento = new PagamentoEntity();
            pagamento.setPagou(entity.getPagou());
            pagamento.setIdPedido(entity.getIdPedido());
            pagamentoRepository.save(pagamento);
    }

    @Override
    public List<PedidoEntity> pedidosExecute() {
        return pedidoRepository.findAll();
    }
}
