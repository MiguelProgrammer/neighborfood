package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.model.CategoriaCombo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Produto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-10T00:51:13.584459400-03:00[America/Sao_Paulo]")
public class Produto {

  private String nome;

  private java.math.BigDecimal preco;

  private CategoriaCombo categoria;

  private String descricao;

  public Produto nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  
  @Schema(name = "nome", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Produto preco(java.math.BigDecimal preco) {
    this.preco = preco;
    return this;
  }

  /**
   * Get preco
   * @return preco
  */
  
  @Schema(name = "preco", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("preco")
  public java.math.BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(java.math.BigDecimal preco) {
    this.preco = preco;
  }

  public Produto categoria(CategoriaCombo categoria) {
    this.categoria = categoria;
    return this;
  }

  /**
   * Get categoria
   * @return categoria
  */
  @Valid 
  @Schema(name = "Categoria", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Categoria")
  public CategoriaCombo getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaCombo categoria) {
    this.categoria = categoria;
  }

  public Produto descricao(String descricao) {
    this.descricao = descricao;
    return this;
  }

  /**
   * Get descricao
   * @return descricao
  */
  
  @Schema(name = "descricao", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("descricao")
  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Produto produto = (Produto) o;
    return Objects.equals(this.nome, produto.nome) &&
        Objects.equals(this.preco, produto.preco) &&
        Objects.equals(this.categoria, produto.categoria) &&
        Objects.equals(this.descricao, produto.descricao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, preco, categoria, descricao);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Produto {\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
    sb.append("    categoria: ").append(toIndentedString(categoria)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

