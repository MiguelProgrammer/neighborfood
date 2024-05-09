package br.com.techchallenge.fiap.neighborfood.repository;

import br.com.techchallenge.fiap.neighborfood.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
