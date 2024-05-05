package br.com.techchallenge.fiap.model;

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
 * Gets or Sets Combo
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-05T00:44:45.191036500-03:00[America/Sao_Paulo]")
public enum Combo {
  
  LANCHE("LANCHE"),
  
  ACOMPANHAMENTO("ACOMPANHAMENTO"),
  
  BEBIDA("BEBIDA"),
  
  SOBREMESA("SOBREMESA");

  private String value;

  Combo(String value) {
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
  public static Combo fromValue(String value) {
    for (Combo b : Combo.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

