package br.com.techchallenge.fiap.neighborfood.repository;

import br.com.techchallenge.fiap.neighborfood.entities.ItensEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensRepository extends JpaRepository<ItensEntity, Long> {

}
