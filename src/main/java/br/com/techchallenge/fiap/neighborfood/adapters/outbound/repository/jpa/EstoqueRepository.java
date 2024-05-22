/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.jpa;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities.EstoqueEntity;
import br.com.techchallenge.fiap.neighborfood.domain.model.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntity, Long> {

//    @Query(name = "select E.nome, E.preco, E.categoria, E.descricao, E.img from EstoqueEntity E " +
//            " where E.categoria =:categoria ", nativeQuery = true)
//    Set<EstoqueEntity> findByCategoria(@Param("categoria") Categoria categoria);

//    EstoqueEntity findByNome(String nome);
//
//    @Query(name = "select E.nome, E.preco, E.categoria, E.descricao, E.img from EstoqueEntity E " +
//            " where E.categoria =:categoria ", nativeQuery = true)
//    void deleteProduto(String nome);
//}
}
