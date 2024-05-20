/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.inbound;


import _generated_sources_swagger.NeighborfoodApi;
import br.com.techchallenge.fiap.neighborfood.domain.dto.*;
import br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponse;
import br.com.techchallenge.fiap.neighborfood.domain.model.*;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanchoneteControllerImpl implements NeighborfoodApi {

    private AcompanhamentoUseCasePort acompanhamentoUseCasePort;
    private AdminUseCasePort adminUseCasePort;
    private EstoqueUseCasePort estoqueUseCasePort;
    private LoginUseCasePort loginUseCasePort;
    private NotificationUseCasePort notificationUseCasePort;
    private PagamentoUseCasePort pagamentoUseCasePort;
    private PedidoUseCasePort pedidoUseCasePort;

    public LanchoneteControllerImpl(AcompanhamentoUseCasePort acompanhamentoUseCasePort, AdminUseCasePort adminUseCasePort, EstoqueUseCasePort estoqueUseCasePort, LoginUseCasePort loginUseCasePort, NotificationUseCasePort notificationUseCasePort, PagamentoUseCasePort pagamentoUseCasePort, PedidoUseCasePort pedidoUseCasePort) {
        this.acompanhamentoUseCasePort = acompanhamentoUseCasePort;
        this.adminUseCasePort = adminUseCasePort;
        this.estoqueUseCasePort = estoqueUseCasePort;
        this.loginUseCasePort = loginUseCasePort;
        this.notificationUseCasePort = notificationUseCasePort;
        this.pagamentoUseCasePort = pagamentoUseCasePort;
        this.pedidoUseCasePort = pedidoUseCasePort;
    }

    /**
     * GET /neighborfood/acompanhamento/{idPedido} : Procura o status de um pedido
     * Retorna o status de um pedido
     *
     * @param idPedido id do pedido (required)
     * @return successful operation (status code 200)
     * or Id inválido (status code 400)
     * or Pedido não encontrado (status code 404)
     */
    @Override
    public ResponseEntity<AcompanhamentoResponse> findOrderByIdOrder(Long idPedido) {
        return NeighborfoodApi.super.findOrderByIdOrder(idPedido);
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
    public ResponseEntity<List<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponse>> listOrders(Long idAdmin) {
        return NeighborfoodApi.super.listOrders(idAdmin);
    }

    /**
     * POST /neighborfood/login : Se cadastrar, logar
     * Identificação do cliente
     *
     * @param clienteRequest Identifica um cliente logado (optional)
     * @return Usuário logado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> login(ClienteRequest clienteRequest) {
        return NeighborfoodApi.super.login(clienteRequest);
    }

    /**
     * POST /neighborfood/painel/login : Cadastrar adm, logar adm
     * Identificação do adm
     *
     * @param adminRequest Identifica um adminsitrador logado (optional)
     * @return Usuário logado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> loginAdm(AdminRequest adminRequest) {
        return NeighborfoodApi.super.loginAdm(adminRequest);
    }

    /**
     * GET /neighborfood/menu : Apresenta o menu com itens opcionais
     * menu de opções
     *
     * @return Apresenta os itens de menu (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<String> menu() {
        return NeighborfoodApi.super.menu();
    }

    /**
     * POST /neighborfood/pedido : Realizar um pedido
     * Fazer um  pedido
     *
     * @param pedido Cria um novo pedido (optional)
     * @return Pedido criado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponse> order(Pedido pedido) {
        return NeighborfoodApi.super.order(pedido);
    }

    /**
     * POST /neighborfood/pagamento : Realiza o pagamento do pedido
     * Realiza pagamento
     *
     * @param pagamento (required)
     * @return pagamento realizado com sucesso. (status code 200)
     * or Id inválido (status code 400)
     * or Pedido não encontrado (status code 404)
     */
    @Override
    public ResponseEntity<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponse> payment(Pagamento pagamento) {
        return NeighborfoodApi.super.payment(pagamento);
    }

    /**
     * POST /neighborfood/cadastro : Se cadastrar, logar
     * Cria cliente
     *
     * @param clienteRequest Cria um novo cliente (optional)
     * @return Usuário logado (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> register(ClienteRequest clienteRequest) {

        Cliente cliente = new Cliente();
        cliente.setNome(clienteRequest.getNome());
        cliente.setEmail(clienteRequest.getEmail());
        cliente.setCpf(clienteRequest.getCpf());

        return ResponseEntity.ok(loginUseCasePort.cadastroExecute(cliente));
    }

    /**
     * POST /neighborfood/painel/cadastro : Se cadastrar, logar
     * Cria cliente
     *
     * @param adminRequest Cria um novo administrador (optional)
     * @return Usuário cadastrao (status code 200)
     * or request inválida (status code 400)
     */
    @Override
    public ResponseEntity<Object> registerAdm(AdminRequest adminRequest) {
        return NeighborfoodApi.super.registerAdm(adminRequest);
    }

    /**
     * GET /neighborfood/painel/produto/cadastro/{idAdmin} : Cadastra produtos
     * Cadastra produtos em lote
     *
     * @param idAdmin id identificador do administrador (required)
     * @return Produtos cadastrados (status code 200)
     * or Id inválido (status code 400)
     * or Produto inválido (status code 404)
     */
    @Override
    public ResponseEntity<Object> registerProduct(Long idAdmin) {
        return NeighborfoodApi.super.registerProduct(idAdmin);
    }

    /**
     * POST /neighborfood/painel/cliente : Envia mimo ao último cliente que realizou um pedido
     * Envia mimo ao cliente
     *
     * @param mimoRequest (required)
     * @return Mimo enviado (status code 200)
     * or Id inválido (status code 400)
     * or Mimo não disponível (status code 404)
     */
    @Override
    public ResponseEntity<Mimo> sendBonus(MimoRequest mimoRequest) {
        return NeighborfoodApi.super.sendBonus(mimoRequest);
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
    public ResponseEntity<br.com.techchallenge.fiap.neighborfood.domain.dto.AcompanhamentoResponse> updateOrder(Pedido pedido) {
        return NeighborfoodApi.super.updateOrder(pedido);
    }
}
