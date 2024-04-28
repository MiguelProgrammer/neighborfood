package br.com.techchallenge.fiap.neighborfood;

import br.com.techchallenge.fiap.neighborfood.repository.PedidoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Getter
@SpringBootApplication
public class NeighborfoodApplication {

    @Autowired
    public PedidoRepository pedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(NeighborfoodApplication.class, args);

//        PedidoEntity pedidoEntity = new PedidoEntity();
//        pedidoEntity.setName("Miguel Pereira da Silva");
//
//        pedidoRepository.save(pedidoEntity);
    }

}
