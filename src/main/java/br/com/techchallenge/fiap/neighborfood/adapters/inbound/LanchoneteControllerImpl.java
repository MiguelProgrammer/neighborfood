/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound;


import br.com.techchallenge.fiap.neighborfood.domain.model.*;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.EstoqueUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.LoginUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.PedidoUseCaseImpl;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.fazer.AcompanhamentoService;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.fazer.AdmService;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.fazer.NotificacaoService;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.fazer.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanchoneteControllerImpl /*implements NeighborfoodApi*/ {

    @Autowired
    private AdmService admService;

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private LoginUseCaseImpl acesso;

    @Autowired
    private EstoqueUseCaseImpl estoqueService;

    @Autowired
    private PedidoUseCaseImpl pedidoService;

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private AcompanhamentoService acompanhamentoService;

    //@Override
    public ResponseEntity<Object> login(Cliente clienteRequest) {
        return ResponseEntity.ok(acesso.loginExecute(clienteRequest));
    }

    //@Override
    public ResponseEntity<Object> register(Cliente clienteRequest) {
        return ResponseEntity.ok(acesso.cadastroExecute(clienteRequest));
    }

    //@Override
    public ResponseEntity<String> menu() {
        return ResponseEntity.ok(pedidoService.menuOpcionaisExecute());
    }

    //@Override
    public ResponseEntity<AcompanhamentoResponse> payment(PagamentoDTO pagamento) {
        return ResponseEntity.ok(pagamentoService.pagamento(pagamento));
    }

    //@Override
    public ResponseEntity<AcompanhamentoResponse> order(PedidoDTO pedido) {
        return null;//pedidoService.pedido(pedido);
    }


    /**
     * ÁREA ADMINISTRATIVA
     */


    //@Override
    public ResponseEntity<AcompanhamentoResponse> findOrderByIdOrder(Long idpedido) {
        return acompanhamentoService.getOrderStatus(idpedido);
    }


    //@Override
    public ResponseEntity<Object> loginAdm(Admin adminRequest) {
        return ResponseEntity.ok(acesso.loginAdmExecute(adminRequest));
    }

    //@Override
    public ResponseEntity<Object> registerAdm(Admin adminRequest) {
        return null;//acesso.cadastroAdmExecute(adminRequest);
    }


    //@Override
    public ResponseEntity<Object> registerProduct(Long idAdmin) {
        return ResponseEntity.ok(estoqueService.gerenciaEstoqueExecute(idAdmin));
    }

    //@Override
    public ResponseEntity<MimoDTO> sendBonus(MimoDTO mimo) {
        return null; //notificacaoService.enviaMimos(mimo);
    }

    //@Override
    public ResponseEntity<List<AcompanhamentoResponse>> listOrders(Long idAdmin) {
        return admService.listaPedidos(idAdmin);
    }

    //@Override
    public ResponseEntity<AcompanhamentoResponse> updateOrder(PedidoDTO pedido) {
        return null;//pedidoService.atualizarPedido(pedido);
    }
}
