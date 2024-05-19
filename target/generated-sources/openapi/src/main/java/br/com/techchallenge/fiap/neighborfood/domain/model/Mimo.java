package br.com.techchallenge.fiap.neighborfood.domain.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Mimo
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-19T01:03:06.165477700-03:00[America/Sao_Paulo]")
public class Mimo {

  private String codigo;

  private BigDecimal desconto;

  private Long idCliente;

  public Mimo codigo(String codigo) {
    this.codigo = codigo;
    return this;
  }

  /**
   * Get codigo
   * @return codigo
  */
  
  @Schema(name = "codigo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("codigo")
  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public Mimo desconto(BigDecimal desconto) {
    this.desconto = desconto;
    return this;
  }

  /**
   * Get desconto
   * @return desconto
  */
  @Valid 
  @Schema(name = "desconto", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("desconto")
  public BigDecimal getDesconto() {
    return desconto;
  }

  public void setDesconto(BigDecimal desconto) {
    this.desconto = desconto;
  }

  public Mimo idCliente(Long idCliente) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mimo mimo = (Mimo) o;
    return Objects.equals(this.codigo, mimo.codigo) &&
        Objects.equals(this.desconto, mimo.desconto) &&
        Objects.equals(this.idCliente, mimo.idCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo, desconto, idCliente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mimo {\n");
    sb.append("    codigo: ").append(toIndentedString(codigo)).append("\n");
    sb.append("    desconto: ").append(toIndentedString(desconto)).append("\n");
    sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
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

