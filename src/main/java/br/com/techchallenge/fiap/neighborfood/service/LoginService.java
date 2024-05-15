/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.AdminRequest;
import br.com.techchallenge.fiap.model.ClienteRequest;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.model.AdminEntity;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.model.ClienteEntity;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.model.NotificacaoEntity;
import br.com.techchallenge.fiap.neighborfood.core.domain.models.AdmDTO;
import br.com.techchallenge.fiap.neighborfood.core.domain.models.ClienteDTO;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.jpa.AdmRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.jpa.ClienteRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.jpa.NotificacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AdmRepository admRepository;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    private ModelMapper mapper = new ModelMapper();

    final String MESSAGE = "Usuário não encontrado ou não cadastrado!\n\n" +
            "Por favor, verifique as informações inseridas.";

    public ResponseEntity<Object> login(ClienteRequest clienteRequest) {


        try {
            ClienteEntity cliente = clienteRepository.findByCpf(clienteRequest.getCpf());
            if (ObjectUtils.isEmpty(cliente)) {
                return ResponseEntity.ok(MESSAGE);
            } else {
                return ResponseEntity.ok(mapper.map(cliente, ClienteDTO.class));
            }

        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public ResponseEntity<Object> cadastro(ClienteRequest clienteRequest) {
        try {

            ClienteEntity cliente = clienteRepository.findByCpf(clienteRequest.getCpf());
            if (ObjectUtils.isEmpty(cliente)) {
                if (ObjectUtils.isEmpty(clienteRequest)) {
                    log.info("CLIENTE NÃO SE IDENTIFICADO.");
                    return ResponseEntity.ok(clienteRepository.save(new ClienteEntity()));
                }
                log.info("CLIENTE CADASTRADO.");
                return ResponseEntity.ok(clienteRepository.save(mapper.map(clienteRequest, ClienteEntity.class)));
            } else {
                return ResponseEntity.ok(mapper.map(cliente, ClienteDTO.class));
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

    public ResponseEntity<Object> loginAdm(AdminRequest adminRequest) {

        try {

            AdminEntity adm = admRepository.findByCpf(adminRequest.getCpf());

            if (ObjectUtils.isEmpty(adm)) {

                return ResponseEntity.ok(MESSAGE);

            } else {

                AdmDTO map = mapper.map(adm, AdmDTO.class);
                List<NotificacaoEntity> all = notificacaoRepository.findAll();
                List<String> notificacoes = new ArrayList<>();

                if (!ObjectUtils.isEmpty(all)) {

                    all.forEach(sms -> {
                        notificacoes.add(mapper.map(sms.getDescricao(), String.class));
                    });

                    map.setNotificacao(notificacoes);

                }

                return ResponseEntity.ok(map);
            }

        } catch (RuntimeException ex) {

            System.err.println(ex.getMessage());

        }
        return null;
    }

    public ResponseEntity<Object> cadastroAdm(AdminRequest adminRequest) {
        try {

            AdminEntity adm = admRepository.findByCpf(adminRequest.getCpf());
            if (ObjectUtils.isEmpty(adm)) {
                if (ObjectUtils.isEmpty(adminRequest)) {
                    log.info("ADM NÃO SE IDENTIFICADO.");
                    return ResponseEntity.ok(admRepository.save(new AdminEntity()));
                }
                log.info("ADM CADASTRADO.");
                return ResponseEntity.ok(admRepository.save(mapper.map(adminRequest, AdminEntity.class)));
            } else {
                return ResponseEntity.ok(mapper.map(adm, AdmDTO.class));
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
