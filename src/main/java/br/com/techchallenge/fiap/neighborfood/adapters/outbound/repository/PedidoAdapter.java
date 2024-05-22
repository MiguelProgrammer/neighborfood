/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.inbound.response.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.EstoqueEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PagamentoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ProdutoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.EstoqueRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PagamentoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ProdutoRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.Estoque;
import br.com.techchallenge.fiap.neighborfood.domain.model.Itens;
import br.com.techchallenge.fiap.neighborfood.domain.model.Pedido;
import br.com.techchallenge.fiap.neighborfood.domain.model.Produto;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Categoria;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class PedidoAdapter implements PedidoUseCaseAdapterPort {

    private EstoqueRepository estoqueRepository;
    private PedidoRepository pedidoRepository;
    private PagamentoRepository pagamentoRepository;
    private ProdutoRepository produtoRepository;

    public PedidoAdapter(EstoqueRepository estoqueRepository, PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository, ProdutoRepository produtoRepository) {
        this.estoqueRepository = estoqueRepository;
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Set<Produto> menuOpcionais(Categoria combo) {
        Set<ProdutoEntity> byCategoria = produtoRepository.findByCategoria(combo);
        return new Produto().setProdutosRequestFromSetEntity(byCategoria);
    }

    @Override
    public AcompanhamentoResponse pedido(Pedido pedido) {
        return new AcompanhamentoResponse()
                .pedidoEntityFromResponse(pedidoRepository.findById(pedido.getId()).get());
    }

    @Override
    public AcompanhamentoResponse atualizarPedido(Pedido pedido) {
        return null;
    }

    @Override
    public Pedido commitUpdates(PedidoEntity pedidoEntity) {
        return new Pedido().entityFromDomain(pedidoRepository.saveAndFlush(pedidoEntity));
    }

    /**
     * @param itens
     */
    @Override
    public void saveItens(Itens itens) {

    }

    /**
     * @param itens
     */
    @Override
    public void removeItens(Set<Itens> itens) {

    }

    /**
     * @param id
     * @return
     */
    @Override
    public Set<Itens> findAllById(Long id) {
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
    public Set<Produto> findAllByIdPedido(Long id) {
        return null;//new Produto().setProdutosRequestFromSetEntity(itensRepository.findByIdPedido(id));
    }


    @Override
    public Pedido findByIdPedido(Long id) {
        Optional<PedidoEntity> pedidoRepositoryById = pedidoRepository.findById(id);
        return new Pedido().entityFromDomain(pedidoRepositoryById.get());
    }

    @Override
    public Pedido findById(Long id) {
        return new Pedido().entityFromDomain(pedidoRepository.findById(id).get());
    }

    @Override
    public void salvaPagamento(PagamentoEntity entity) {
        pagamentoRepository.save(entity);
    }

    @Override
    public List<PedidoEntity> pedidosExecute() {
        return pedidoRepository.findAll();
    }
}
