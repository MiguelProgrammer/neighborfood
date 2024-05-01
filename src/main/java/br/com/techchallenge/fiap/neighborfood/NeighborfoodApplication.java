package br.com.techchallenge.fiap.neighborfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EntityScan(basePackages = "br.com.techchallenge.fiap.neighborfood.entities")
public class NeighborfoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeighborfoodApplication.class, args);
    }

}
