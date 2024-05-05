package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.model.Acompanhamento;
import br.com.techchallenge.fiap.model.Itens;
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
 * Pedido
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T00:44:45.191036500-03:00[America/Sao_Paulo]")
public class Pedido {

  private Long id;

  private Object cliente;

  private Itens itens;

  private Acompanhamento acompanhamento;

  public Pedido id(Long id) {
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

  public Pedido cliente(Object cliente) {
    this.cliente = cliente;
    return this;
  }

  /**
   * Get cliente
   * @return cliente
  */
  
  @Schema(name = "Cliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Cliente")
  public Object getCliente() {
    return cliente;
  }

  public void setCliente(Object cliente) {
    this.cliente = cliente;
  }

  public Pedido itens(Itens itens) {
    this.itens = itens;
    return this;
  }

  /**
   * Get itens
   * @return itens
  */
  @Valid 
  @Schema(name = "Itens", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Itens")
  public Itens getItens() {
    return itens;
  }

  public void setItens(Itens itens) {
    this.itens = itens;
  }

  public Pedido acompanhamento(Acompanhamento acompanhamento) {
    this.acompanhamento = acompanhamento;
    return this;
  }

  /**
   * Get acompanhamento
   * @return acompanhamento
  */
  @Valid 
  @Schema(name = "Acompanhamento", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Acompanhamento")
  public Acompanhamento getAcompanhamento() {
    return acompanhamento;
  }

  public void setAcompanhamento(Acompanhamento acompanhamento) {
    this.acompanhamento = acompanhamento;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pedido pedido = (Pedido) o;
    return Objects.equals(this.id, pedido.id) &&
        Objects.equals(this.cliente, pedido.cliente) &&
        Objects.equals(this.itens, pedido.itens) &&
        Objects.equals(this.acompanhamento, pedido.acompanhamento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cliente, itens, acompanhamento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pedido {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    cliente: ").append(toIndentedString(cliente)).append("\n");
    sb.append("    itens: ").append(toIndentedString(itens)).append("\n");
    sb.append("    acompanhamento: ").append(toIndentedString(acompanhamento)).append("\n");
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

