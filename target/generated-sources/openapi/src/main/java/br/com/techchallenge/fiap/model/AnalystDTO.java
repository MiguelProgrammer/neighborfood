package br.com.techchallenge.fiap.model;

import java.net.URI;
import java.util.Objects;
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
 * AnalystDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-01T12:13:14.856070800-03:00[GMT-03:00]")
public class AnalystDTO {

  private Long pId;

  /**
   * Gets or Sets actuation
   */
  public enum ActuationEnum {
    BACK("BACK"),
    
    FRONT("FRONT"),
    
    BLANK("BLANK");

    private String value;

    ActuationEnum(String value) {
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
    public static ActuationEnum fromValue(String value) {
      for (ActuationEnum b : ActuationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ActuationEnum actuation;

  /**
   * Gets or Sets stack
   */
  public enum StackEnum {
    JAVA("JAVA"),
    
    ANGULAR("ANGULAR"),
    
    DEVOPS("DEVOPS"),
    
    SECURITY_INFORMATION("SECURITY_INFORMATION");

    private String value;

    StackEnum(String value) {
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
    public static StackEnum fromValue(String value) {
      for (StackEnum b : StackEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StackEnum stack;

  /**
   * Default constructor
   * @deprecated Use {@link AnalystDTO#AnalystDTO(Long, ActuationEnum, StackEnum)}
   */
  @Deprecated
  public AnalystDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AnalystDTO(Long pId, ActuationEnum actuation, StackEnum stack) {
    this.pId = pId;
    this.actuation = actuation;
    this.stack = stack;
  }

  public AnalystDTO pId(Long pId) {
    this.pId = pId;
    return this;
  }

  /**
   * Get pId
   * @return pId
  */
  @NotNull 
  @Schema(name = "pId", example = "8", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pId")
  public Long getpId() {
    return pId;
  }

  public void setpId(Long pId) {
    this.pId = pId;
  }

  public AnalystDTO actuation(ActuationEnum actuation) {
    this.actuation = actuation;
    return this;
  }

  /**
   * Get actuation
   * @return actuation
  */
  @NotNull 
  @Schema(name = "actuation", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("actuation")
  public ActuationEnum getActuation() {
    return actuation;
  }

  public void setActuation(ActuationEnum actuation) {
    this.actuation = actuation;
  }

  public AnalystDTO stack(StackEnum stack) {
    this.stack = stack;
    return this;
  }

  /**
   * Get stack
   * @return stack
  */
  @NotNull 
  @Schema(name = "stack", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("stack")
  public StackEnum getStack() {
    return stack;
  }

  public void setStack(StackEnum stack) {
    this.stack = stack;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalystDTO analystDTO = (AnalystDTO) o;
    return Objects.equals(this.pId, analystDTO.pId) &&
        Objects.equals(this.actuation, analystDTO.actuation) &&
        Objects.equals(this.stack, analystDTO.stack);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pId, actuation, stack);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalystDTO {\n");
    sb.append("    pId: ").append(toIndentedString(pId)).append("\n");
    sb.append("    actuation: ").append(toIndentedString(actuation)).append("\n");
    sb.append("    stack: ").append(toIndentedString(stack)).append("\n");
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

