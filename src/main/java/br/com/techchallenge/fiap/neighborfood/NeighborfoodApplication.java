package br.com.techchallenge.fiap.neighborfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@SpringBootApplication(scanBasePackages={"br.com.techchallenge.fiap.neighborfood.adpters.outbound.respository"})
@EntityScan(basePackages = "br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.entities")

public class NeighborfoodApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SpringApplication.run(NeighborfoodApplication.class, args);
        System.out.println("_______________ Lanchonete NeighborFood _______________");
    }
}
