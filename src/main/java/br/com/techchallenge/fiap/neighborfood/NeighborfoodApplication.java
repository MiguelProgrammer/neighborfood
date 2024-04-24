package br.com.techchallenge.fiap.neighborfood;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@SpringBootApplication
public class NeighborfoodApplication {

    @Autowired
    private static PedidoRepository pedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(NeighborfoodApplication.class, args);

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setName("Miguel Pereira da Silva");

        pedidoRepository.save(pedidoEntity);
    }

	@Repository
	public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

	}

    @Getter
    @Setter
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "pedido")
    public static class PedidoEntity implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        private String name;
    }
}
