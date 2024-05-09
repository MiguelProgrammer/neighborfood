package br.com.techchallenge.fiap.neighborfood.repository;

import br.com.techchallenge.fiap.neighborfood.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {

}
