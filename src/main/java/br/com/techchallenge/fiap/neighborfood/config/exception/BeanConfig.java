/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.config.exception;

import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AcompanhamentoResponse getOrderStatusExecute(Long idPedido) {
        return new AcompanhamentoResponse();
    }
}
