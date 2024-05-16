/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.usecase.service;

import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.jpa.*;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.model.*;
import br.com.techchallenge.fiap.neighborfood.core.domain.*;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Service
public class PedidoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private AcompanhamentoService acompanhamentoService;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItensRepository itensRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    private ModelMapper mapper = new ModelMapper();

    public ResponseEntity<String> menuOpcionais() {

        Gson gson = new Gson();
        HashMap<CategoriaCombo, List> menuItens = new HashMap<>();

        for (CategoriaCombo opt : CategoriaCombo.values()) {
            menuItens.put(opt, estoqueRepository.findByCategoria(opt));
        }
        return ResponseEntity.ok(gson.toJson(menuItens));
    }

    public ResponseEntity<AcompanhamentoResponse> pedido(Pedido pedido) {

        Set<ItensEntity> itens = new HashSet<>();
        AcompanhamentoResponse response = new AcompanhamentoResponse();
        PedidoEntity entity = mapper.map(pedido, PedidoEntity.class);

        Optional<ClienteEntity> cliente = clienteRepository.findById(entity.getIdCliente());
        if (!cliente.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        pedido.getItens().forEach(pr -> {

            List<EstoqueEntity> produto = estoqueRepository.findByNome(pr.getNome());
            if (!ObjectUtils.isEmpty(produto)) {
                itens.add(mapper.map(pr, ItensEntity.class));
                entity.setTotal(entity.getTotal().add(pr.getPreco()));
                estoqueRepository.deleteAll(produto);
            } else {
                ItensEntity entity1 = new ItensEntity();
                entity1.setDescricao("produto em falta! ");
                itens.add(entity1);
                entity.setTotal(BigDecimal.ZERO);
            }
        });

        entity.setStatus(Acompanhamento.RECEBIDO);
        entity.setItens(itens);
        entity.setDataPedido(new Date());

        if (!entity.getTotal().equals(BigDecimal.ZERO)) {

            System.out.println(acompanhamentoService.sms(entity.getStatus()));

            PedidoEntity pedidoCriado = pedidoRepository.save(entity);
            pedidoCriado.getItens().forEach(pr -> {
                pr.setIdPedido(pedidoCriado.getId());
            });

            pedidoRepository.saveAndFlush(pedidoCriado);
            response.setTotal(pedidoCriado.getTotal());
            response.setPedido(mapper.map(pedidoCriado, Pedido.class));
            response.setStatus(pedidoCriado.getStatus());
            return ResponseEntity.ok(response);
        } else {
            NotificacaoEntity notificacao = new NotificacaoEntity();
            notificacao.setDescricao("Caro adm, por favor, veja a quantia de itens cadastrado no estoque!");
            notificacaoRepository.save(notificacao);
            log.info("\n\nItens selecionados em falta!\n\n");
            return ResponseEntity.ok(response);
        }

    }

    @Transactional
    public ResponseEntity<AcompanhamentoResponse> atualizarPedido(Pedido pedido) {

        PedidoEntity entity = mapper.map(pedido, PedidoEntity.class);
        Optional<ClienteEntity> cliente = clienteRepository.findById(entity.getIdCliente());
        Set<ItensEntity> itensById = itensRepository.findByIdPedido(pedido.getId());
        if (!cliente.isPresent() && ObjectUtils.isEmpty(itensById)) {
            log.info("\n\nCliente ou Pedido não encontrado!\n\n");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        itensById.forEach(item -> {
            estoqueRepository.save(mapper.map(item, EstoqueEntity.class));
        });

        Optional<PedidoEntity> byId = pedidoRepository.findById(pedido.getId());
        byId.get().setTotal(BigDecimal.ZERO);
        pedidoRepository.saveAndFlush(byId.get());

        itensRepository.deleteAll(itensById);
        pedido.getItens().forEach(ped -> {

            itensById.forEach(item -> {
                ItensEntity map = mapper.map(ped, ItensEntity.class);
                map.setIdPedido(item.getIdPedido());

                Optional<PedidoEntity> pedid = pedidoRepository.findById(pedido.getId());
                byId.get().setTotal(byId.get().getTotal().add(map.getPreco()));
                pedidoRepository.saveAndFlush(pedid.get());

                itensRepository.save(map);
                estoqueRepository.deleteByNome(ped.getNome());
            });
        });
        log.info("Pedido atualizado!");
        return null;

    }


}
