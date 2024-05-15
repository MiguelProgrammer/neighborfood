/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.service;

import br.com.techchallenge.fiap.model.CategoriaCombo;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.model.AdminEntity;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.model.EstoqueEntity;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.jpa.AdmRepository;
import br.com.techchallenge.fiap.neighborfood.core.adapters.repository.jpa.EstoqueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private AdmRepository admRepository;

    public ResponseEntity<Object> gerenciaEstoque(Long idAmdin) {

        List<EstoqueEntity> listaProdutos = new ArrayList<>();
        Optional<AdminEntity> adm = admRepository.findById(idAmdin);

        if (adm.isPresent()) {

            /**
             * Cadastro auto de produtos
             */
            EstoqueEntity produtoLanche = new EstoqueEntity();
            produtoLanche.setNome("Hambuguer N*1");
            produtoLanche.setDescricao("Hambuguer com duas carnes e molho");
            produtoLanche.setCategoria(CategoriaCombo.LANCHE);
            produtoLanche.setPreco(new BigDecimal(14.89));
            produtoLanche.setImg("https://www.designi.com.br/images/preview/11052407.jpg");
            listaProdutos.add(produtoLanche);

            EstoqueEntity produtoBebida = new EstoqueEntity();
            produtoBebida.setNome("Coca Cola 600ml");
            produtoBebida.setDescricao("Refrigerante cola 600ml garrafa");
            produtoBebida.setCategoria(CategoriaCombo.BEBIDA);
            produtoBebida.setPreco(new BigDecimal(9.90));
            produtoBebida.setImg("https://w7.pngwing.com/pngs/574/913/png-transparent-caffeine-free-coca-cola-soft-drink-coca-cola-coca-cola-bottle-glass-beer-bottle-cola-thumbnail.png");
            listaProdutos.add(produtoBebida);

            EstoqueEntity produtoAcompanha = new EstoqueEntity();
            produtoAcompanha.setNome("Batata Frita");
            produtoAcompanha.setDescricao("Batata fritas média");
            produtoAcompanha.setCategoria(CategoriaCombo.ACOMPANHAMENTO);
            produtoAcompanha.setPreco(new BigDecimal(7.00));
            produtoAcompanha.setImg("https://www.designi.com.br/images/preview/10001736.jpg");
            listaProdutos.add(produtoAcompanha);

            EstoqueEntity produtoSobremesa = new EstoqueEntity();
            produtoSobremesa.setNome("Sorvete de casquinha");
            produtoSobremesa.setDescricao("Sorvete de casquinha meio a meio");
            produtoSobremesa.setCategoria(CategoriaCombo.SOBREMESA);
            produtoSobremesa.setPreco(new BigDecimal(4.90));
            produtoSobremesa.setImg("https://i.pinimg.com/originals/9a/25/9e/9a259efb922ed0e05b46b73373777adc.png");
            listaProdutos.add(produtoSobremesa);

            listaProdutos.forEach(pr -> {
                estoqueRepository.save(pr);
            });

            final String CADASTRO_PRODUTOS =
                    "_____________________________________________\n "
                            + listaProdutos.size() +
                    " novos produtos foram cadastrados no estoque \n" +
                    "_____________________________________________";

            log.info(CADASTRO_PRODUTOS);
            return ResponseEntity.ok(CADASTRO_PRODUTOS);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado ou não possui permissão!");
        }
    }

}
