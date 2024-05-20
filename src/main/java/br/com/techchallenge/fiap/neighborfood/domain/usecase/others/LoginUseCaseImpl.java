/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others;

import br.com.techchallenge.fiap.neighborfood.config.exception.AdminException;
import br.com.techchallenge.fiap.neighborfood.config.exception.ClienteException;
import br.com.techchallenge.fiap.neighborfood.domain.model.Admin;
import br.com.techchallenge.fiap.neighborfood.domain.model.Cliente;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.LoginUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.LoginUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.NotificationUseCaseAdapterPort;
import org.apache.commons.lang3.ObjectUtils;

public class LoginUseCaseImpl implements LoginUseCasePort {

    private LoginUseCaseAdapterPort loginAdapterPort;
    private NotificationUseCaseAdapterPort notificacaoAdapter;
    private final String MESSAGE = "Usuário não encontrado ou não cadastrado!\n\n" +
            "Por favor, verifique as informações inseridas.";


    @Override
    public Cliente loginExecute(Cliente clienteRequest) {

        Cliente cliente = new Cliente();
        try {
            cliente = loginAdapterPort.login(clienteRequest);

            if (ObjectUtils.isEmpty(cliente)) {
                throw new ClienteException(MESSAGE);
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }

        return cliente;
    }


    @Override
    public Cliente cadastroExecute(Cliente clienteRequest) {

        Cliente clienteCadastrado = new Cliente();

        try {

            Cliente cadastro = this.loginExecute(clienteRequest);
            if (ObjectUtils.isEmpty(cadastro)) {
                clienteCadastrado = loginAdapterPort.cadastro(clienteRequest);
            }
        } catch (RuntimeException ex) {
            System.err.println(ex.getMessage());
        }
        return clienteCadastrado;
    }


    @Override
    public Admin loginAdmExecute(Admin adminRequest) {

        Admin admin = new Admin();

        try {

            admin = loginAdapterPort.loginAdm(adminRequest);

            if (ObjectUtils.isEmpty(admin)) {
                throw new AdminException(MESSAGE);
            }

//            else {
//
//                //List<NotificacaoEntity> all = notificacaoRepository.findAll();
//                List<String> notificacoes = new ArrayList<>();
//
//                if (!ObjectUtils.isEmpty(all)) {
//
//                    all.forEach(sms -> {
//                        notificacoes.add(mapper.map(sms.getDescricao(), String.class));
//                    });
//
//                    map.setNotificacao(notificacoes);
//
//                }
//
//                return ResponseEntity.ok(map);
//            }

        } catch (RuntimeException ex) {

            System.err.println(ex.getMessage());

        }
        return admin;
    }


    @Override
    public Admin cadastroAdmExecute(Admin adminRequest) {

//        try {
//
//            AdminEntity adm = admRepository.findByCpf(adminRequest.getCpf());
//            if (ObjectUtils.isEmpty(adm)) {
//                if (ObjectUtils.isEmpty(adminRequest)) {
//                    log.info("ADM NÃO SE IDENTIFICADO.");
//                    return ResponseEntity.ok(admRepository.save(new AdminEntity()));
//                }
//                log.info("ADM CADASTRADO.");
//                return ResponseEntity.ok(admRepository.save(mapper.map(adminRequest, AdminEntity.class)));
//            } else {
//                return ResponseEntity.ok(mapper.map(adm, AdmDTO.class));
//            }
//        } catch (RuntimeException ex) {
//            System.err.println(ex.getMessage());
//        }

        return loginAdapterPort.cadastroAdm(adminRequest);
    }
}
