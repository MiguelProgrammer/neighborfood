/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.ports.inbound;

import br.com.techchallenge.fiap.neighborfood.domain.model.Admin;
import br.com.techchallenge.fiap.neighborfood.domain.model.Cliente;

public interface LoginUseCasePort {

    Cliente loginExecute(Cliente clienteRequest);

    Cliente cadastroExecute(Cliente clienteRequest);

    Admin loginAdmExecute(Admin adminRequest);

    Admin cadastroAdmExecute(Admin adminRequest);

}
