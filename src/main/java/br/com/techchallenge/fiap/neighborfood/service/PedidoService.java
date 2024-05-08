/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.*;
import br.com.techchallenge.fiap.neighborfood.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.entities.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.entities.ProdutoEntity;
import br.com.techchallenge.fiap.neighborfood.repository.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    private ModelMapper mapper = new ModelMapper();

    public List<String> menuOpcionais() {
        List<String> opcionais = new ArrayList<>();
        for (CategoriaCombo opt : CategoriaCombo.values()) {
            opcionais.add(opt.toString());
        }
        return opcionais;
    }

    public ResponseEntity<AcompanhamentoResponse> pedido(Pedido pedido) {

        PedidoEntity entity = new PedidoEntity();
        List<ProdutoEntity> produtos = new ArrayList<>();
        Optional<ClienteEntity> cliente = clienteRepository.findById(pedido.getIdCliente());
        if (!cliente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        entity.setIdCliente(cliente.get().getId());

        pedido.getItens().forEach(pr -> {
            produtos.add(mapper.map(pr, ProdutoEntity.class));
        });
        entity.setItens(produtos);
        entity.setAcompanhamento(Acompanhamento.RECEBIDO);
        pedido.getItens().forEach(pr -> {
            entity.setTotal(entity.getTotal().add(BigDecimal.valueOf(pr.getPreco())));
        });

        AcompanhamentoResponse response = new AcompanhamentoResponse();
        response.setStatusPedido(mapper.map(pedidoRepository.save(entity), Pedido.class));
        return ResponseEntity.ok(response);
    }
}
