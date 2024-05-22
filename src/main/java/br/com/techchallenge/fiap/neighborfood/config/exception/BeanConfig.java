/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.config.exception;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.UserAdapter;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.*;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.ProdutoUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.LoginUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.NotificationUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.PedidoUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.*;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.AcompanhamentoChain;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl.AcompanhamentoChainFinalizadoImpl;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl.AcompanhamentoChainPreparacaoImpl;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl.AcompanhamentoChainProntoImpl;
import br.com.techchallenge.fiap.neighborfood.domain.usecase.others.acompanhachain.impl.AcompanhamentoChainRecebidoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    public AcompanhamentoUseCasePort acompanhamentoUseCaseImpl() {
        return new AcompanhamentoUseCaseImpl();
    }

    @Bean
    public AcompanhamentoChain acompanhamentoChainPronto() {
        return new AcompanhamentoChainProntoImpl();
    }

    @Bean
    public AcompanhamentoChain acompanhamentoChainRecebido() {
        return new AcompanhamentoChainRecebidoImpl();
    }

    @Bean
    public AcompanhamentoChain acompanhamentoChainPreparacao() {
        return new AcompanhamentoChainPreparacaoImpl();
    }

    @Bean
    public AcompanhamentoChain acompanhamentoChainFinalizado() {
        return new AcompanhamentoChainFinalizadoImpl();
    }

    @Bean
    public AdminUseCasePort adminUseCasePort() {
        return new AdmUseCaseImpl();
    }

    @Bean
    public ProdutoUseCasePort estoqueUseCasePort(ProdutoUseCaseAdapterPort estoqueUseCaseAdapterPort,
                                                 LoginUseCaseAdapterPort loginAdapter, UserAdapter userdapter) {
        return new ProdutoUseCaseImpl(estoqueUseCaseAdapterPort, loginAdapter, userdapter);
    }

    @Bean
    public LoginUseCasePort loginUseCasePort(LoginUseCaseAdapterPort loginAdapterPort,
                                             NotificationUseCaseAdapterPort notificacaoAdapter,
                                             UserAdapter userAdapter) {
        return new LoginUseCaseImpl(loginAdapterPort, notificacaoAdapter, userAdapter);
    }

    @Bean
    public NotificationUseCasePort notificationUseCasePort() {
        return new NotificacaoUseCaseImpl();
    }

    @Bean
    public PagamentoUseCasePort pagamentoUseCasePort() {
        return new PagamentoUseCaseImpl();
    }

    @Bean
    public PedidoUseCasePort pedidoUseCasePort(PedidoUseCaseAdapterPort pedidoUseCaseAdapterPort,
                                               ProdutoUseCaseAdapterPort estoqueUseCaseAdapterPort,
                                               NotificationUseCaseAdapterPort notificationUseCaseAdapterPort,
                                               AcompanhamentoUseCasePort acompanhamentoUseCasePort,
                                               UserAdapter userAdapter) {
        return new PedidoUseCaseImpl(pedidoUseCaseAdapterPort, estoqueUseCaseAdapterPort,
                notificationUseCaseAdapterPort, acompanhamentoUseCasePort, userAdapter);
    }
}
