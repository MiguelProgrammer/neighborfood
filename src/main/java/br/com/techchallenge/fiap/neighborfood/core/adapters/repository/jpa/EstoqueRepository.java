/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.core.adapters.repository.jpa;

import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.model.EstoqueEntity;
import br.com.techchallenge.fiap.neighborfood.core.domain.CategoriaCombo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {

    @Query(name = "select E.nome, E.preco, E.categoria, E.descricao, E.img from EstoqueEntity E " +
            " where E.categoria =:categoria ", nativeQuery = true)
    List<EstoqueEntity> findByCategoria(@Param("categoria") CategoriaCombo categoria);

    List<EstoqueEntity> findByNome(String nome);
}
