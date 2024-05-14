/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.resources.api;


import _generated_sources_swagger.NeighborfoodApi;
import br.com.techchallenge.fiap.model.*;
import br.com.techchallenge.fiap.neighborfood.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanchoneteControllerImpl implements NeighborfoodApi {

    @Autowired
    private AdmService admService;

    @Autowired
    private NotificacaoService notificacaoService;

    @Autowired
    private LoginService acesso;

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private AcompanhamentoService acompanhamentoService;

    @Override
    public ResponseEntity<Object> login(ClienteRequest clienteRequest) {
        return acesso.login(clienteRequest);
    }

    @Override
    public ResponseEntity<Object> register(ClienteRequest clienteRequest) {
        return acesso.cadastro(clienteRequest);
    }

    @Override
    public ResponseEntity<String> menu() {
        return pedidoService.menuOpcionais();
    }

    @Override
    public ResponseEntity<AcompanhamentoResponse> payment(Pagamento pagamento) {
        return ResponseEntity.ok(pagamentoService.pagamento(pagamento));
    }

    @Override
    public ResponseEntity<AcompanhamentoResponse> order(Pedido pedido) {
        return pedidoService.pedido(pedido);
    }


    /**
     * ÁREA ADMINISTRATIVA
     */


    @Override
    public ResponseEntity<AcompanhamentoResponse> findOrderByIdOrder(Long idpedido) {
        return acompanhamentoService.getOrderStatus(idpedido);
    }



    @Override
    public ResponseEntity<Object> loginAdm(AdminRequest adminRequest) {
        return acesso.loginAdm(adminRequest);
    }

    @Override
    public ResponseEntity<Object> registerAdm(AdminRequest adminRequest) {
        return acesso.cadastroAdm(adminRequest);
    }


    @Override
    public ResponseEntity<Object> registerProduct(Long idAdmin) {
        return estoqueService.gerenciaEstoque(idAdmin);
    }

    @Override
    public ResponseEntity<Mimo> sendBonus(MimoRequest mimo) {
        return notificacaoService.enviaMimos(mimo);
    }

    /**
     * GET /neighborfood/painel/pedido/lista/{idAdmin} : Lista de pedidos efetuados contendo seus clientes, itens, status, valores e data de pedido e data de entrega.
     * Lista os pedidos recebidos
     *
     * @param idAdmin id identificador do administrador (required)
     * @return Lista de pedidos (status code 200)
     * or Id inválido (status code 400)
     * or Mimo não disponível (status code 404)
     */
    @Override
    public ResponseEntity<List<AcompanhamentoResponse>> listOrders(Long idAdmin) {
        return admService.listaPedidos(idAdmin);
    }

    /**
     * PUT /neighborfood/pedido/update : Atualizar um pedido
     * Atualizar itens de um pedido já realizado
     *
     * @param pedido atualiar um  pedido (optional)
     * @return Pedido atualizado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<AcompanhamentoResponse> updateOrder(Pedido pedido) {
        return NeighborfoodApi.super.updateOrder(pedido);
    }
}
