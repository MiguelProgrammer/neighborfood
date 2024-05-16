/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.usecase.service;

import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.jpa.AdmRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.jpa.PedidoRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.model.AdminEntity;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.model.PedidoEntity;
import br.com.techchallenge.fiap.neighborfood.core.domain.AcompanhamentoResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AdmService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private AdmRepository admRepository;

    private ModelMapper mapper = new ModelMapper();

    final String MESSAGE = "\n\nAdmin não encontrado ou não localizado!";
    final String MESSAGE_LIST = "\n\nNão há pedidos para listar";

    public ResponseEntity<List<AcompanhamentoResponse>> listaPedidos(Long idAdmin) {

        List<AcompanhamentoResponse> listaAcomp = new ArrayList<>();
        Optional<AdminEntity> admin = admRepository.findById(idAdmin);

        if (ObjectUtils.isEmpty(admin)) {
            log.info(MESSAGE);
            return ResponseEntity.ok(listaAcomp);
        }

        log.info("Listando pedidos ...\n");
        List<PedidoEntity> listaPedidos = pedidoRepository.findAll();

        if (!ObjectUtils.isEmpty(listaPedidos)) {

            listaPedidos.forEach(pr -> {
                log.info("\nPedido: ", pr.getId());
                listaAcomp.add(mapper.map(pr, AcompanhamentoResponse.class));
            });
            log.info("\nListagem finalizada.");

        } else {
            log.info(MESSAGE_LIST);
            return ResponseEntity.ok(listaAcomp);
        }

        return ResponseEntity.ok(listaAcomp);
    }
}
