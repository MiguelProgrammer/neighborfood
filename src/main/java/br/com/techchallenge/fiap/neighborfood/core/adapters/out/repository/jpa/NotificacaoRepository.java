
/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.jpa;

import br.com.techchallenge.fiap.neighborfood.core.adapters.out.repository.model.NotificacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<NotificacaoEntity, Long> {

}
