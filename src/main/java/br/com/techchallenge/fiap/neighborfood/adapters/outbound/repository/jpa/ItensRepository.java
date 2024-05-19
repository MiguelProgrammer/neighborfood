/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.ItensEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ItensRepository extends JpaRepository<ItensEntity, Long> {

    Set<ItensEntity> findAllById(Long id);

    Set<ItensEntity> findByIdPedido(Long id);
}
