package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.model.Itens;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-07T07:28:27.371142200-03:00[America/Sao_Paulo]")
public class Pedido {

  private Long idCliente;

  private Itens itens;

  public Pedido idCliente(Long idCliente) {
    this.idCliente = idCliente;
    return this;
  }

  /**
   * Get idCliente
   * @return idCliente
  */
  
  @Schema(name = "idCliente", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idCliente")
  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pedido pedido = (Pedido) o;
    return Objects.equals(this.idCliente, pedido.idCliente) &&
        Objects.equals(this.itens, pedido.itens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente, itens);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pedido {\n");
    sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
    sb.append("    itens: ").append(toIndentedString(itens)).append("\n");
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

