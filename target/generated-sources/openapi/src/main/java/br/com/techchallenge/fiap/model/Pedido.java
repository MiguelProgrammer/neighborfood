package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.model.Acompanhamento;
import br.com.techchallenge.fiap.model.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-07T23:47:14.174480-03:00[America/Sao_Paulo]")
public class Pedido {

  private Long idCliente;

  @Valid
  private List<@Valid Produto> itens;

  private Double total;

  private Acompanhamento status;

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

  public Pedido itens(List<@Valid Produto> itens) {
    this.itens = itens;
    return this;
  }

  public Pedido addItensItem(Produto itensItem) {
    if (this.itens == null) {
      this.itens = new ArrayList<>();
    }
    this.itens.add(itensItem);
    return this;
  }

  /**
   * Get itens
   * @return itens
  */
  @Valid 
  @Schema(name = "Itens", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Itens")
  public List<@Valid Produto> getItens() {
    return itens;
  }

  public void setItens(List<@Valid Produto> itens) {
    this.itens = itens;
  }

  public Pedido total(Double total) {
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

  public Pedido status(Acompanhamento status) {
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
        Objects.equals(this.itens, pedido.itens) &&
        Objects.equals(this.total, pedido.total) &&
        Objects.equals(this.status, pedido.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente, itens, total, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pedido {\n");
    sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
    sb.append("    itens: ").append(toIndentedString(itens)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

