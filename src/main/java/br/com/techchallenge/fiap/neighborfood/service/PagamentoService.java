/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.Acompanhamento;
import br.com.techchallenge.fiap.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.model.Pagamento;
import br.com.techchallenge.fiap.model.Pedido;
import br.com.techchallenge.fiap.neighborfood.entities.PagamentoEntity;
import br.com.techchallenge.fiap.neighborfood.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.repository.PagamentoRepository;
import br.com.techchallenge.fiap.neighborfood.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    private ModelMapper mapper = new ModelMapper();

    public AcompanhamentoResponse pagamento(Pagamento pagamento) {

        Optional<PedidoEntity> pedid = pedidoRepository.findById(pagamento.getIdPedido());
        AcompanhamentoResponse response = new AcompanhamentoResponse();

        if (pedid.isPresent()) {

            PagamentoEntity entity = mapper.map(pagamento, PagamentoEntity.class);
            pagamentoRepository.save(entity);

            try {

                response.setStatus(Acompanhamento.EM_PREPARACAO);
                pedid.get().setAcompanhamento(Acompanhamento.EM_PREPARACAO);
                pedidoRepository.save(pedid.get());

                response.setPedido(mapper.map(pedid, Pedido.class));
                response.setTotal(pedid.get().getTotal());

            } catch (RuntimeException ex) {
                System.err.println("Erro ao realizar pagamento => Pedido não encontrado!!!");
            }
        }
        return response;
    }
}
