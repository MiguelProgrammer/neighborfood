/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.usecase.service;

import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.jpa.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.jpa.NotificacaoRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.model.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.core.domain.Mimo;
import br.com.techchallenge.fiap.neighborfood.core.domain.MimoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.Random;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<Mimo> enviaMimos(MimoRequest mimo2) {
        Mimo beneficios = new Mimo();
        Optional<ClienteEntity> cliente = clienteRepository.findById(mimo2.getIdCliente());

        if (cliente.isPresent()) {
            Random gerador = new Random();
            beneficios.setCodigo(String.valueOf(gerador.nextInt(26)));
            beneficios.setDesconto(new BigDecimal(10.90).setScale(4, RoundingMode.HALF_UP));
            beneficios.setIdCliente(cliente.get().getId());

            System.out.println("Mimos enviados para sua próxima compra, obrigado e volte sempre!");
        }

        return ResponseEntity.ok(beneficios);
    }

}
