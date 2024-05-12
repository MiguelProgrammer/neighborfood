/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.Acompanhamento;
import br.com.techchallenge.fiap.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.repository.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.service.acompanhachain.AcompanhamentoChain;
import br.com.techchallenge.fiap.neighborfood.service.acompanhachain.impl.AcompanhamentoChainRecebidoImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class AcompanhamentoService extends AcompanhamentoChain {

    @Autowired
    private PedidoRepository pedidoRepository;

    private ModelMapper mapper = new ModelMapper();

    private AcompanhamentoChain acompanhamentoChain;

    public ResponseEntity<AcompanhamentoResponse> getOrderStatus(Long idPedido) {
        try {
            AcompanhamentoResponse map = mapper.map(
                    pedidoRepository.findById(idPedido).get(),
                    AcompanhamentoResponse.class);

            if (map.getStatus().equals(Acompanhamento.EM_PREPARACAO)) {
                this.pedidoStatus(idPedido, Acompanhamento.PRONTO);
                map.setStatus(Acompanhamento.PRONTO);
            } else if (map.getStatus().equals(Acompanhamento.PRONTO)) {
                this.fluxoAcompanhamento(idPedido, Acompanhamento.FINALIZADO);
                map.setStatus(Acompanhamento.FINALIZADO);
            }

            return ResponseEntity.ok(map);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new AcompanhamentoResponse());
        }
    }


    @Override
    public String sms(Acompanhamento acompanhamento) {
        return new AcompanhamentoChainRecebidoImpl(acompanhamentoChain).sms(acompanhamento);
    }

    @Transactional
    public void fluxoAcompanhamento(Long idPedido, Acompanhamento acompanhamento) {
        PedidoEntity entity = pedidoRepository.findById(idPedido).get();
        entity.setStatus(acompanhamento);
        if (entity.getStatus().equals(Acompanhamento.FINALIZADO)) {
            entity.setDataPedidoFim(new Date());
        }
        pedidoRepository.saveAndFlush(entity);

        System.out.println(this.sms(entity.getStatus()));
    }

    @Transactional
    public void pedidoStatus(Long idPedido, Acompanhamento acompanhamento) {

        PedidoEntity pedido = pedidoRepository.findById(idPedido).orElseThrow();
        pedido.setStatus(acompanhamento);
        PedidoEntity entity = pedidoRepository.saveAndFlush(pedido);
        System.out.println(this.sms(entity.getStatus()));
    }

}
