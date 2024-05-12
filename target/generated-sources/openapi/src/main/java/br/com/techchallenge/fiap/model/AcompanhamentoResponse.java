package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.model.Acompanhamento;
import br.com.techchallenge.fiap.model.Pedido;
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
 * AcompanhamentoResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-12T00:39:16.545662600-03:00[America/Sao_Paulo]")
public class AcompanhamentoResponse {

  private Pedido pedido;

  private Acompanhamento status;

  private java.math.BigDecimal total;

  public AcompanhamentoResponse pedido(Pedido pedido) {
    this.pedido = pedido;
    return this;
  }

  /**
   * Get pedido
   * @return pedido
  */
  @Valid 
  @Schema(name = "pedido", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pedido")
  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public AcompanhamentoResponse status(Acompanhamento status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public Acompanhamento getStatus() {
    return status;
  }

  public void setStatus(Acompanhamento status) {
    this.status = status;
  }

  public AcompanhamentoResponse total(java.math.BigDecimal total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  */
  
  @Schema(name = "total", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total")
  public java.math.BigDecimal getTotal() {
    return total;
  }

  public void setTotal(java.math.BigDecimal total) {
    this.total = total;
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
    return Objects.equals(this.pedido, acompanhamentoResponse.pedido) &&
        Objects.equals(this.status, acompanhamentoResponse.status) &&
        Objects.equals(this.total, acompanhamentoResponse.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pedido, status, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcompanhamentoResponse {\n");
    sb.append("    pedido: ").append(toIndentedString(pedido)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

