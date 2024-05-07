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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-06T23:24:06.360344700-03:00[America/Sao_Paulo]")
public class AcompanhamentoResponse {

  private Long idCliente;

  private Itens status;

  private Acompanhamento acompanhamento;

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

  public AcompanhamentoResponse status(Itens status) {
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
  public Itens getStatus() {
    return status;
  }

  public void setStatus(Itens status) {
    this.status = status;
  }

  public AcompanhamentoResponse acompanhamento(Acompanhamento acompanhamento) {
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
        Objects.equals(this.status, acompanhamentoResponse.status) &&
        Objects.equals(this.acompanhamento, acompanhamentoResponse.acompanhamento) &&
        Objects.equals(this.total, acompanhamentoResponse.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente, status, acompanhamento, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcompanhamentoResponse {\n");
    sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    acompanhamento: ").append(toIndentedString(acompanhamento)).append("\n");
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

