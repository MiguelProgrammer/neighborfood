/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.Acompanhamento;
import br.com.techchallenge.fiap.model.AcompanhamentoResponse;
import br.com.techchallenge.fiap.model.CategoriaCombo;
import br.com.techchallenge.fiap.model.Pedido;
import br.com.techchallenge.fiap.neighborfood.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.entities.ProdutoEntity;
import br.com.techchallenge.fiap.neighborfood.repository.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.repository.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
@EnableScheduling
@Service
public class PedidoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    private ModelMapper mapper = new ModelMapper();

    public List<String> menuOpcionais() {
        List<String> opcionais = new ArrayList<>();
        for (CategoriaCombo opt : CategoriaCombo.values()) {
            opcionais.add(opt.toString());
        }
        return opcionais;
    }

    public ResponseEntity<AcompanhamentoResponse> pedido(Pedido pedido) {

        PedidoEntity entity = mapper.map(pedido, PedidoEntity.class);
        Set<ProdutoEntity> produtos = new HashSet<>();

        Optional<ClienteEntity> cliente = clienteRepository.findById(entity.getIdCliente());
        if (!cliente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pedido.getItens().forEach(pr -> {
            produtos.add(mapper.map(pr, ProdutoEntity.class));
            entity.setTotal(entity.getTotal().add(pr.getPreco()));
        });

        entity.setAcompanhamento(Acompanhamento.RECEBIDO);
        entity.setItens(produtos);
        PedidoEntity pedidoCriado = pedidoRepository.save(entity);
        pedidoCriado.getItens().forEach(pr -> {
            pr.setIdPedido(pedidoCriado.getId());
        });
        pedidoRepository.saveAndFlush(pedidoCriado);


        AcompanhamentoResponse response = new AcompanhamentoResponse();
        response.setTotal(pedidoCriado.getTotal());
        response.setPedido(mapper.map(pedidoCriado, Pedido.class));
        response.setStatus(pedidoCriado.getAcompanhamento());


        finalizaPedido(pedidoCriado);

        return ResponseEntity.ok(response);
    }

    @Scheduled(cron = "3000")
    private void finalizaPedido(PedidoEntity pedido) {

        AcompanhamentoResponse response = new AcompanhamentoResponse();
        response.setTotal(pedido.getTotal());
        response.setPedido(mapper.map(pedido, Pedido.class));
        response.setStatus(Acompanhamento.PRONTO);
        PedidoEntity entity = pedidoRepository.saveAndFlush(pedido);
        System.out.println(pedido);
    }

}
