
/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.MimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MimoRepository extends JpaRepository<MimoEntity, Long> {

}
