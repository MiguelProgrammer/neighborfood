package br.com.techchallenge.fiap.neighborfood.domain.dto;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.neighborfood.domain.dto.CategoriaDTO;
import br.com.techchallenge.fiap.neighborfood.domain.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ItensPedido
 */

@JsonTypeName("itensPedido")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-24T00:34:49.182568600-03:00[America/Sao_Paulo]")
public class ItensPedido {

  private Long id;

  private Long idPedido;

  private ProdutoDTO itensPedido;

  private String nome;

  private java.math.BigDecimal preco;

  private CategoriaDTO categoria;

  private String descricao;

  private String img;

  public ItensPedido id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ItensPedido idPedido(Long idPedido) {
    this.idPedido = idPedido;
    return this;
  }

  /**
   * Get idPedido
   * @return idPedido
  */
  
  @Schema(name = "idPedido", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idPedido")
  public Long getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(Long idPedido) {
    this.idPedido = idPedido;
  }

  public ItensPedido itensPedido(ProdutoDTO itensPedido) {
    this.itensPedido = itensPedido;
    return this;
  }

  /**
   * Get itensPedido
   * @return itensPedido
  */
  @Valid 
  @Schema(name = "itensPedido", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itensPedido")
  public ProdutoDTO getItensPedido() {
    return itensPedido;
  }

  public void setItensPedido(ProdutoDTO itensPedido) {
    this.itensPedido = itensPedido;
  }

  public ItensPedido nome(String nome) {
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

  public ItensPedido preco(java.math.BigDecimal preco) {
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

  public ItensPedido categoria(CategoriaDTO categoria) {
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
  public CategoriaDTO getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaDTO categoria) {
    this.categoria = categoria;
  }

  public ItensPedido descricao(String descricao) {
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

  public ItensPedido img(String img) {
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
    ItensPedido itensPedido = (ItensPedido) o;
    return Objects.equals(this.id, itensPedido.id) &&
        Objects.equals(this.idPedido, itensPedido.idPedido) &&
        Objects.equals(this.itensPedido, itensPedido.itensPedido) &&
        Objects.equals(this.nome, itensPedido.nome) &&
        Objects.equals(this.preco, itensPedido.preco) &&
        Objects.equals(this.categoria, itensPedido.categoria) &&
        Objects.equals(this.descricao, itensPedido.descricao) &&
        Objects.equals(this.img, itensPedido.img);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idPedido, itensPedido, nome, preco, categoria, descricao, img);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItensPedido {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idPedido: ").append(toIndentedString(idPedido)).append("\n");
    sb.append("    itensPedido: ").append(toIndentedString(itensPedido)).append("\n");
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

