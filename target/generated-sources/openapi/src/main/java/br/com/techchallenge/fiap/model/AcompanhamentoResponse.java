package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.model.Pedido;
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
 * AcompanhamentoResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-07T23:47:14.174480-03:00[America/Sao_Paulo]")
public class AcompanhamentoResponse {

  private Pedido statusPedido;

  public AcompanhamentoResponse statusPedido(Pedido statusPedido) {
    this.statusPedido = statusPedido;
    return this;
  }

  /**
   * Get statusPedido
   * @return statusPedido
  */
  @Valid 
  @Schema(name = "statusPedido", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statusPedido")
  public Pedido getStatusPedido() {
    return statusPedido;
  }

  public void setStatusPedido(Pedido statusPedido) {
    this.statusPedido = statusPedido;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AcompanhamentoResponse acompanhamentoResponse = (AcompanhamentoResponse) o;
    return Objects.equals(this.statusPedido, acompanhamentoResponse.statusPedido);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusPedido);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcompanhamentoResponse {\n");
    sb.append("    statusPedido: ").append(toIndentedString(statusPedido)).append("\n");
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

