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
 * Gets or Sets Acompanhamento
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-08T07:51:34.385242400-03:00[America/Sao_Paulo]")
public enum Acompanhamento {
  
  RECEBIDO("RECEBIDO"),
  
  EM_PREPARACAO("EM_PREPARACAO"),
  
  PRONTO("PRONTO"),
  
  FINALIZADO("FINALIZADO");

  private String value;

  Acompanhamento(String value) {
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
  public static Acompanhamento fromValue(String value) {
    for (Acompanhamento b : Acompanhamento.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

