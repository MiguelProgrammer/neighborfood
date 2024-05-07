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
 * AcompanhamentoResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-07T07:28:27.371142200-03:00[America/Sao_Paulo]")
public class AcompanhamentoResponse {

  private Long idCliente;

  private Itens itens;

  private Acompanhamento status;

  private Double total;

  public AcompanhamentoResponse idCliente(Long idCliente) {
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

  public AcompanhamentoResponse itens(Itens itens) {
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

  public AcompanhamentoResponse total(Double total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  */
  
  @Schema(name = "total", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("total")
  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
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
    return Objects.equals(this.idCliente, acompanhamentoResponse.idCliente) &&
        Objects.equals(this.itens, acompanhamentoResponse.itens) &&
        Objects.equals(this.status, acompanhamentoResponse.status) &&
        Objects.equals(this.total, acompanhamentoResponse.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente, itens, status, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcompanhamentoResponse {\n");
    sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
    sb.append("    itens: ").append(toIndentedString(itens)).append("\n");
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

