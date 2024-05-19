/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others.fazer;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa.NotificacaoRepository;
import br.com.techchallenge.fiap.neighborfood.domain.model.MimoDTO;
import br.com.techchallenge.fiap.neighborfood.domain.model.MimoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public ResponseEntity<MimoDTO> enviaMimos(MimoRequest mimo2) {
        MimoDTO beneficios = new MimoDTO();
        Optional<ClienteEntity> cliente = clienteRepository.findById(mimo2.getIdCliente());

        if (cliente.isPresent()) {
            Random gerador = new Random();
            beneficios.setCodigo(Long.parseLong(String.valueOf(gerador.nextInt(26))));
            beneficios.setAcao(cliente.get().getCpf());
            beneficios.setDescricao("desconto");

            System.out.println("Mimos enviados para sua próxima compra, obrigado e volte sempre!");
        }

        return ResponseEntity.ok(beneficios);
    }

}
