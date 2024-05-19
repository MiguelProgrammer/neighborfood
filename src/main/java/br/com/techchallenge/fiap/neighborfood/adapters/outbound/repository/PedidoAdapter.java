/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.EstoqueEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItensEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PagamentoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.EstoqueRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ItensRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PagamentoRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.*;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class PedidoAdapter implements PedidoUseCaseAdapterPort {

    private EstoqueRepository estoqueRepository;
    private PedidoRepository pedidoRepository;
    private ItensRepository itensRepository;
    private PagamentoRepository pagamentoRepository;

    public PedidoAdapter(EstoqueRepository estoqueRepository, PedidoRepository pedidoRepository, ItensRepository itensRepository, PagamentoRepository pagamentoRepository) {
        this.estoqueRepository = estoqueRepository;
        this.pedidoRepository = pedidoRepository;
        this.itensRepository = itensRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Set<Estoque> menuOpcionais(CategoriaCombo combo) {
        Set<EstoqueEntity> byCategoria = estoqueRepository.findByCategoria(combo);
        return new Estoque().fromDomain(byCategoria);
    }

    @Override
    public AcompanhamentoResponse pedido(PedidoDTO pedido) {
        AcompanhamentoResponse response = new AcompanhamentoResponse();
        PedidoDTO pedidoDTO = new PedidoDTO();
        PedidoEntity pedidoEntity = pedidoRepository.findById(pedido.getId()).get();
        response.setPedido(pedidoDTO.fromDomain(pedidoEntity));
        response.setTotal(pedidoEntity.getTotal());
        return response;
    }

    @Override
    public AcompanhamentoResponse atualizarPedido(PedidoDTO pedido) {
        return null;
    }

    @Override
    public PedidoDTO commitUpdates(PedidoEntity pedidoEntity) {
        return new PedidoDTO().fromDomain(pedidoRepository.saveAndFlush(pedidoEntity));
    }

    @Override
    public void saveItens(Itens itens) {
        ItensEntity item = new ItensEntity();
        item.setIdPedido(itens.getIdPedido());
        item.setNome(itens.getNome());
        item.setDescricao(itens.getDescricao());
        item.setPreco(itens.getPreco());
        item.setCategoria(itens.getCategoria());
        item.setImg(itens.getImg());
        item.setPedido(itens.getPedido().fromEntity(itens.getPedido()));
        itensRepository.save(item);
    }

    @Override
    public void removeItens(Set<Itens> itens) {
        new Itens().fromListEntity(itens);
        pedidoRepository.deleteAll();
    }

    @Override
    public Set<Itens> findAllById(Long id) {
        return new Itens().fromDomain(itensRepository.findAllById(id));
    }

    @Override
    public Set<Itens> findByIdPedidoItens(Long id) {
        return new Itens().fromDomain(itensRepository.findByIdPedido(id));
    }


    @Override
    public PedidoDTO findByIdPedido(Long id) {
        Optional<PedidoEntity> pedidoRepositoryById = pedidoRepository.findById(id);
        return new PedidoDTO().fromDomain(pedidoRepositoryById.get());
    }

    @Override
    public PedidoDTO findById(Long id) {
        return new PedidoDTO().fromDomain(pedidoRepository.findById(id).get());
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
