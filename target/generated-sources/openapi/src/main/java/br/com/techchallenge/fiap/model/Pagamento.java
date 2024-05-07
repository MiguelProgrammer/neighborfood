package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
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
 * Pagamento
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-07T07:28:27.371142200-03:00[America/Sao_Paulo]")
public class Pagamento {

  private Long idPedido;

  private Boolean pagou;

  public Pagamento idPedido(Long idPedido) {
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

  public Pagamento pagou(Boolean pagou) {
    this.pagou = pagou;
    return this;
  }

  /**
   * Get pagou
   * @return pagou
  */
  
  @Schema(name = "pagou", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pagou")
  public Boolean getPagou() {
    return pagou;
  }

  public void setPagou(Boolean pagou) {
    this.pagou = pagou;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pagamento pagamento = (Pagamento) o;
    return Objects.equals(this.idPedido, pagamento.idPedido) &&
        Objects.equals(this.pagou, pagamento.pagou);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPedido, pagou);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pagamento {\n");
    sb.append("    idPedido: ").append(toIndentedString(idPedido)).append("\n");
    sb.append("    pagou: ").append(toIndentedString(pagou)).append("\n");
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

