/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensRepository extends JpaRepository<ItemEntity, Long> {

    ItemEntity findAllById(Long id);

    ItemEntity findByIdPedido(Long id);
}
