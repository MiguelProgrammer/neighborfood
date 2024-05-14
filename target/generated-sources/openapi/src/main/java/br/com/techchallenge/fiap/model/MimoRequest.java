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
 * MimoRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-14T07:58:43.923520700-03:00[America/Sao_Paulo]")
public class MimoRequest {

  private Long idCliente;

  public MimoRequest idCliente(Long idCliente) {
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
    MimoRequest mimoRequest = (MimoRequest) o;
    return Objects.equals(this.idCliente, mimoRequest.idCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MimoRequest {\n");
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

