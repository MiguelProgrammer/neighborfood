package br.com.techchallenge.fiap.neighborfood.domain.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CategoriaComboDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-20T23:19:13.374846-03:00[America/Sao_Paulo]")
public enum CategoriaComboDTO {
  
  LANCHE("LANCHE"),
  
  ACOMPANHAMENTO("ACOMPANHAMENTO"),
  
  BEBIDA("BEBIDA"),
  
  SOBREMESA("SOBREMESA");

  private String value;

  CategoriaComboDTO(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static CategoriaComboDTO fromValue(String value) {
    for (CategoriaComboDTO b : CategoriaComboDTO.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

