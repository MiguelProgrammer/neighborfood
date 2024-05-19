/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.outbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.Admin;
import br.com.techchallenge.fiap.neighborfood.domain.model.Cliente;

public interface LoginUseCaseAdapterPort {

    Cliente login(Cliente clienteRequest);

    Cliente cadastro(Cliente clienteRequest);

    Admin loginAdm(Admin adminRequest);

    Admin cadastroAdm(Admin adminRequest);

}
