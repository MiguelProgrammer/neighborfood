/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.resources.api;



import _generated_sources_swagger.NeighborfoodApi;
import br.com.techchallenge.fiap.model.*;
import br.com.techchallenge.fiap.neighborfood.model.Cliente;
import br.com.techchallenge.fiap.neighborfood.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LojaControllerImpl implements NeighborfoodApi {

    @Autowired
    private Login acesso;

    /**
     * @param clienteRequest
     * @return
     */
    @Override
    public Cliente login(ClienteRequest clienteRequest) {
        ClienteRequest login = acesso.login(clienteRequest);
        return NeighborfoodApi.super.login(login);
    }

    /**
     * @return
     */
    @Override
    public ResponseEntity<Combo> menu() {
        return NeighborfoodApi.super.menu();
    }

    /**
     * @param pedido
     * @return
     */
    @Override
    public ResponseEntity<AcompanhamentoResponse> order(Pedido pedido) {
        return NeighborfoodApi.super.order(pedido);
    }

    /**
     * @param pagamento
     * @return
     */
    @Override
    public ResponseEntity<AcompanhamentoResponse> payment(Pagamento pagamento) {
        return NeighborfoodApi.super.payment(pagamento);
    }

    /**
     * @param body
     * @return
     */
    @Override
    public ResponseEntity<Object> register(Object body) {
        return NeighborfoodApi.super.register(body);
    }

    /**
     * @param idpedido
     * @return
     */
    @Override
    public ResponseEntity<AcompanhamentoResponse> findOrderByIdOrder(Long idpedido) {
        return NeighborfoodApi.super.findOrderByIdOrder(idpedido);
    }

    /**
     * @return
     */
    @Override
    public ResponseEntity<Combo> listCategory() {
        return NeighborfoodApi.super.listCategory();
    }

    /**
     * @param produto
     * @return
     */
    @Override
    public ResponseEntity<Void> registerProduct(Produto produto) {
        return NeighborfoodApi.super.registerProduct(produto);
    }

    /**
     * @param mimo
     * @return
     */
    @Override
    public ResponseEntity<Void> sendBonus(Mimo mimo) {
        return NeighborfoodApi.super.sendBonus(mimo);
    }
}
