/*
 * Haplotype Frequency Curation Service
 * Allows to store and return haplotype frequency data
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ScopeElement
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-15T14:15:40.152-07:00")
public class ScopeElement {
  @SerializedName("name")
  private String name = null;

  @SerializedName("freeName")
  private String freeName = null;

  /**
   * type of label
   */
  @JsonAdapter(TypeOfScopeEnum.Adapter.class)
  public enum TypeOfScopeEnum {
    GENE("gene"),
    
    FEATURE("feature");

    private String value;

    TypeOfScopeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeOfScopeEnum fromValue(String text) {
      for (TypeOfScopeEnum b : TypeOfScopeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeOfScopeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeOfScopeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeOfScopeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeOfScopeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("typeOfScope")
  private TypeOfScopeEnum typeOfScope = null;

  public ScopeElement name(String name) {
    this.name = name;
    return this;
  }

   /**
   * label name
   * @return name
  **/
  @ApiModelProperty(value = "label name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ScopeElement freeName(String freeName) {
    this.freeName = freeName;
    return this;
  }

   /**
   * label name
   * @return freeName
  **/
  @ApiModelProperty(value = "label name")
  public String getFreeName() {
    return freeName;
  }

  public void setFreeName(String freeName) {
    this.freeName = freeName;
  }

  public ScopeElement typeOfScope(TypeOfScopeEnum typeOfScope) {
    this.typeOfScope = typeOfScope;
    return this;
  }

   /**
   * type of label
   * @return typeOfScope
  **/
  @ApiModelProperty(value = "type of label")
  public TypeOfScopeEnum getTypeOfScope() {
    return typeOfScope;
  }

  public void setTypeOfScope(TypeOfScopeEnum typeOfScope) {
    this.typeOfScope = typeOfScope;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScopeElement scopeElement = (ScopeElement) o;
    return Objects.equals(this.name, scopeElement.name) &&
        Objects.equals(this.freeName, scopeElement.freeName) &&
        Objects.equals(this.typeOfScope, scopeElement.typeOfScope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, freeName, typeOfScope);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScopeElement {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    freeName: ").append(toIndentedString(freeName)).append("\n");
    sb.append("    typeOfScope: ").append(toIndentedString(typeOfScope)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
