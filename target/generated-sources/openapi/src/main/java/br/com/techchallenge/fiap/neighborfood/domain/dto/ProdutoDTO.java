package br.com.techchallenge.fiap.neighborfood.domain.dto;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.neighborfood.domain.dto.CategoriaComboDTO;
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
 * ProdutoDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-20T23:19:13.374846-03:00[America/Sao_Paulo]")
public class ProdutoDTO {

  private String nome;

  private java.math.BigDecimal preco;

  private CategoriaComboDTO categoria;

  private String descricao;

  private String img;

  public ProdutoDTO nome(String nome) {
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

  public ProdutoDTO preco(java.math.BigDecimal preco) {
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

  public ProdutoDTO categoria(CategoriaComboDTO categoria) {
    this.categoria = categoria;
    return this;
  }

  /**
   * Get categoria
   * @return categoria
  */
  @Valid 
  @Schema(name = "categoria", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("categoria")
  public CategoriaComboDTO getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaComboDTO categoria) {
    this.categoria = categoria;
  }

  public ProdutoDTO descricao(String descricao) {
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

  public ProdutoDTO img(String img) {
    this.img = img;
    return this;
  }

  /**
   * Get img
   * @return img
  */
  
  @Schema(name = "img", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("img")
  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProdutoDTO produtoDTO = (ProdutoDTO) o;
    return Objects.equals(this.nome, produtoDTO.nome) &&
        Objects.equals(this.preco, produtoDTO.preco) &&
        Objects.equals(this.categoria, produtoDTO.categoria) &&
        Objects.equals(this.descricao, produtoDTO.descricao) &&
        Objects.equals(this.img, produtoDTO.img);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, preco, categoria, descricao, img);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProdutoDTO {\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    preco: ").append(toIndentedString(preco)).append("\n");
    sb.append("    categoria: ").append(toIndentedString(categoria)).append("\n");
    sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
    sb.append("    img: ").append(toIndentedString(img)).append("\n");
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

