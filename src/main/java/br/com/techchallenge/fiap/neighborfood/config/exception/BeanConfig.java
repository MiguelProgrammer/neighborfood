/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.config.exception;

import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.*;
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
    public EstoqueUseCasePort estoqueUseCasePort() {
        return new EstoqueUseCaseImpl();
    }

    @Bean
    public LoginUseCasePort loginUseCasePort() {
        return new LoginUseCaseImpl();
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
    public PedidoUseCasePort pedidoUseCasePort() {
        return new PedidoUseCaseImpl();
    }
}
