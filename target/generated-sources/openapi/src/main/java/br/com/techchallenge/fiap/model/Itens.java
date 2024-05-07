package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.model.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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
 * Itens
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-07T07:28:27.371142200-03:00[America/Sao_Paulo]")
public class Itens {

  @Valid
  private List<@Valid Produto> produtoList;

  public Itens produtoList(List<@Valid Produto> produtoList) {
    this.produtoList = produtoList;
    return this;
  }

  public Itens addProdutoListItem(Produto produtoListItem) {
    if (this.produtoList == null) {
      this.produtoList = new ArrayList<>();
    }
    this.produtoList.add(produtoListItem);
    return this;
  }

  /**
   * Get produtoList
   * @return produtoList
  */
  @Valid 
  @Schema(name = "produtoList", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("produtoList")
  public List<@Valid Produto> getProdutoList() {
    return produtoList;
  }

  public void setProdutoList(List<@Valid Produto> produtoList) {
    this.produtoList = produtoList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Itens itens = (Itens) o;
    return Objects.equals(this.produtoList, itens.produtoList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(produtoList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Itens {\n");
    sb.append("    produtoList: ").append(toIndentedString(produtoList)).append("\n");
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

