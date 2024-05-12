package br.com.techchallenge.fiap.neighborfood.repository;

import br.com.techchallenge.fiap.neighborfood.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepository extends JpaRepository<AdminEntity, Long> {

    AdminEntity findByCpf(String cpf);
}
