/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.resources.api;


import _generated_sources_swagger.NeighborfoodApi;
import br.com.techchallenge.fiap.model.*;
import br.com.techchallenge.fiap.neighborfood.service.LoginService;
import br.com.techchallenge.fiap.neighborfood.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanchoneteControllerImpl implements NeighborfoodApi {

    @Autowired
    private LoginService acesso;

    @Autowired
    private PedidoService pedidoService;

    @Override
    public ResponseEntity<Object> login(ClienteRequest clienteRequest) {
        return acesso.login(clienteRequest);
    }

    @Override
    public ResponseEntity<Object> register(ClienteRequest clienteRequest) {
        return acesso.cadastro(clienteRequest);
    }

    @Override
    public ResponseEntity<List<String>> menu() {
        return ResponseEntity.ok(pedidoService.menuOpcionais());
    }

    @Override
    public ResponseEntity<AcompanhamentoResponse> order(Pedido pedido) {
        return NeighborfoodApi.super.order(pedido);
    }

    @Override
    public ResponseEntity<AcompanhamentoResponse> payment(Pagamento pagamento) {
        return NeighborfoodApi.super.payment(pagamento);
    }

    @Override
    public ResponseEntity<Combo> listCategory() {
        return NeighborfoodApi.super.listCategory();
    }

    @Override
    public ResponseEntity<AcompanhamentoResponse> findOrderByIdOrder(Long idpedido) {
        return NeighborfoodApi.super.findOrderByIdOrder(idpedido);
    }

    @Override
    public ResponseEntity<Void> registerProduct(Produto produto) {
        return NeighborfoodApi.super.registerProduct(produto);
    }

    @Override
    public ResponseEntity<Void> sendBonus(Mimo mimo) {
        return NeighborfoodApi.super.sendBonus(mimo);
    }
}
