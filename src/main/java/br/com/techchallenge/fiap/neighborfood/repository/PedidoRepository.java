package br.com.techchallenge.fiap.neighborfood.repository;

import br.com.techchallenge.fiap.neighborfood.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
