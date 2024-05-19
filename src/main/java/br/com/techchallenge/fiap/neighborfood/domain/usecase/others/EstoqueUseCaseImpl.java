/*
 * Copyright (c) 2024. MiguelProgrammer
 */

package br.com.techchallenge.fiap.neighborfood.domain.usecase.others;

import br.com.techchallenge.fiap.neighborfood.adapters.outbound.repository.UserAdapter;
import br.com.techchallenge.fiap.neighborfood.domain.model.Admin;
import br.com.techchallenge.fiap.neighborfood.domain.model.CategoriaCombo;
import br.com.techchallenge.fiap.neighborfood.domain.model.Estoque;
import br.com.techchallenge.fiap.neighborfood.domain.ports.inbound.EstoqueUseCasePort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.EstoqueUseCaseAdapterPort;
import br.com.techchallenge.fiap.neighborfood.domain.ports.outbound.LoginUseCaseAdapterPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class EstoqueUseCaseImpl implements EstoqueUseCasePort {


    private EstoqueUseCaseAdapterPort estoqueUseCaseAdapterPort;
    private LoginUseCaseAdapterPort loginAdapter;
    private UserAdapter userdapter;

    @Override
    public Object gerenciaEstoqueExecute(Long idAmdin) {
        List<Estoque> listaProdutos = new ArrayList<>();
        Admin admin = loginAdapter.loginAdm(userdapter.adminById(idAmdin));

        if (admin != null) {

            /**
             * Cadastro auto de produtos
             */
            Estoque produtoLanche = new Estoque();
            produtoLanche.setNome("Hambuguer N*1");
            produtoLanche.setDescricao("Hambuguer com duas carnes e molho");
            produtoLanche.setCategoria(CategoriaCombo.LANCHE);
            produtoLanche.setPreco(new BigDecimal(14.89));
            produtoLanche.setImg("https://www.designi.com.br/images/preview/11052407.jpg");
            listaProdutos.add(produtoLanche);

            Estoque produtoBebida = new Estoque();
            produtoBebida.setNome("Coca Cola 600ml");
            produtoBebida.setDescricao("Refrigerante cola 600ml garrafa");
            produtoBebida.setCategoria(CategoriaCombo.BEBIDA);
            produtoBebida.setPreco(new BigDecimal(9.90));
            produtoBebida.setImg("https://w7.pngwing.com/pngs/574/913/png-transparent-caffeine-free-coca-cola-soft-drink-coca-cola-coca-cola-bottle-glass-beer-bottle-cola-thumbnail.png");
            listaProdutos.add(produtoBebida);

            Estoque produtoAcompanha = new Estoque();
            produtoAcompanha.setNome("Batata Frita");
            produtoAcompanha.setDescricao("Batata fritas média");
            produtoAcompanha.setCategoria(CategoriaCombo.ACOMPANHAMENTO);
            produtoAcompanha.setPreco(new BigDecimal(7.00));
            produtoAcompanha.setImg("https://www.designi.com.br/images/preview/10001736.jpg");
            listaProdutos.add(produtoAcompanha);

            Estoque produtoSobremesa = new Estoque();
            produtoSobremesa.setNome("Sorvete de casquinha");
            produtoSobremesa.setDescricao("Sorvete de casquinha meio a meio");
            produtoSobremesa.setCategoria(CategoriaCombo.SOBREMESA);
            produtoSobremesa.setPreco(new BigDecimal(4.90));
            produtoSobremesa.setImg("https://i.pinimg.com/originals/9a/25/9e/9a259efb922ed0e05b46b73373777adc.png");
            listaProdutos.add(produtoSobremesa);

            listaProdutos.forEach(pr -> {
                this.repoemEstoqueExecute(pr);
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

    @Override
    public Object repoemEstoqueExecute(Estoque estoque) {
        return estoqueUseCaseAdapterPort.repoemEstoque(estoque);
    }

    @Override
    public Object findByNomeExecute(Estoque estoque) {
        return estoqueUseCaseAdapterPort.findByNome(estoque.getNome());
    }

    @Override
    public void deleteByNomeExecute(String nome) {
        estoqueUseCaseAdapterPort.deleteByNome(nome);
    }

    @Override
    public void deleteAllExecute(Set<Estoque> lista) {
        estoqueUseCaseAdapterPort.deleteAll(lista);
    }
}
