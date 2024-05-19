/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.config;

import br.com.techchallenge.fiap.neighborfood.domain.model.AcompanhamentoResponse;

public class PedidoException extends RuntimeException {
    public PedidoException(String s) {
        super(s);
    }
}
