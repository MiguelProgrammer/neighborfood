package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
import br.com.techchallenge.fiap.model.Combo;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T00:44:45.191036500-03:00[America/Sao_Paulo]")
public class Itens {

  @Valid
  private List<Combo> comboList;

  @Valid
  private List<@Valid Produto> produtoList;

  public Itens comboList(List<Combo> comboList) {
    this.comboList = comboList;
    return this;
  }

  public Itens addComboListItem(Combo comboListItem) {
    if (this.comboList == null) {
      this.comboList = new ArrayList<>();
    }
    this.comboList.add(comboListItem);
    return this;
  }

  /**
   * Get comboList
   * @return comboList
  */
  @Valid 
  @Schema(name = "comboList", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("comboList")
  public List<Combo> getComboList() {
    return comboList;
  }

  public void setComboList(List<Combo> comboList) {
    this.comboList = comboList;
  }

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
    return Objects.equals(this.comboList, itens.comboList) &&
        Objects.equals(this.produtoList, itens.produtoList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(comboList, produtoList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Itens {\n");
    sb.append("    comboList: ").append(toIndentedString(comboList)).append("\n");
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

