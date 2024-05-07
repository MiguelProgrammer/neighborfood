/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.*;
import br.com.techchallenge.fiap.neighborfood.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private ClienteRepository clienteRepository;

    private ModelMapper mapper = new ModelMapper();

    public List<String> menuOpcionais() {
        List<String> opcionais = new ArrayList<>();
        for (CategoriaCombo opt : CategoriaCombo.values()) {
            opcionais.add(opt.toString());
        }
        return opcionais;
    }

    public ResponseEntity<AcompanhamentoResponse> pedido(Pedido pedido) {

        Optional<ClienteEntity> cliente = clienteRepository.findById(pedido.getIdCliente());
        if (!cliente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pedido.setIdCliente(cliente.get().getId());

        List<Produto> produtos = new ArrayList<>();
        pedido.getItens().getProdutoList().forEach(pr -> {
            produtos.add(pr);
        });

        Itens itens = new Itens();
        itens.setProdutoList(produtos);

        AcompanhamentoResponse response = new AcompanhamentoResponse();
        response.setStatus(Acompanhamento.RECEBIDO);
        return ResponseEntity.ok(response);
    }
}
