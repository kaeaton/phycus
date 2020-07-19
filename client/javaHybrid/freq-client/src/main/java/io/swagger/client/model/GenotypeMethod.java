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
 * GenotypeMethod Record
 */
@ApiModel(description = "GenotypeMethod Record")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-19T16:22:07.220-07:00")
public class GenotypeMethod {
  /**
   * Type of method label
   */
  @JsonAdapter(MethodLabelEnum.Adapter.class)
  public enum MethodLabelEnum {
    TYPING_METHOD("TYPING_METHOD"),
    
    TYPING_REF("TYPING_REF"),
    
    TYPING_DATE("TYPING_DATE"),
    
    TYPING_IMGT_VER("TYPING_IMGT_VER"),
    
    MIRING_REF("MIRING_REF");

    private String value;

    MethodLabelEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MethodLabelEnum fromValue(String text) {
      for (MethodLabelEnum b : MethodLabelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<MethodLabelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MethodLabelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MethodLabelEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return MethodLabelEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("methodLabel")
  private MethodLabelEnum methodLabel = null;

  @SerializedName("methodValue")
  private String methodValue = null;

  @SerializedName("methodComment")
  private String methodComment = null;

  @SerializedName("methodReference")
  private String methodReference = null;

  public GenotypeMethod methodLabel(MethodLabelEnum methodLabel) {
    this.methodLabel = methodLabel;
    return this;
  }

   /**
   * Type of method label
   * @return methodLabel
  **/
  @ApiModelProperty(value = "Type of method label")
  public MethodLabelEnum getMethodLabel() {
    return methodLabel;
  }

  public void setMethodLabel(MethodLabelEnum methodLabel) {
    this.methodLabel = methodLabel;
  }

  public GenotypeMethod methodValue(String methodValue) {
    this.methodValue = methodValue;
    return this;
  }

   /**
   * Value of method
   * @return methodValue
  **/
  @ApiModelProperty(value = "Value of method")
  public String getMethodValue() {
    return methodValue;
  }

  public void setMethodValue(String methodValue) {
    this.methodValue = methodValue;
  }

  public GenotypeMethod methodComment(String methodComment) {
    this.methodComment = methodComment;
    return this;
  }

   /**
   * Comment on method
   * @return methodComment
  **/
  @ApiModelProperty(value = "Comment on method")
  public String getMethodComment() {
    return methodComment;
  }

  public void setMethodComment(String methodComment) {
    this.methodComment = methodComment;
  }

  public GenotypeMethod methodReference(String methodReference) {
    this.methodReference = methodReference;
    return this;
  }

   /**
   * To be used to refer to an external source
   * @return methodReference
  **/
  @ApiModelProperty(value = "To be used to refer to an external source")
  public String getMethodReference() {
    return methodReference;
  }

  public void setMethodReference(String methodReference) {
    this.methodReference = methodReference;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenotypeMethod genotypeMethod = (GenotypeMethod) o;
    return Objects.equals(this.methodLabel, genotypeMethod.methodLabel) &&
        Objects.equals(this.methodValue, genotypeMethod.methodValue) &&
        Objects.equals(this.methodComment, genotypeMethod.methodComment) &&
        Objects.equals(this.methodReference, genotypeMethod.methodReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(methodLabel, methodValue, methodComment, methodReference);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenotypeMethod {\n");
    
    sb.append("    methodLabel: ").append(toIndentedString(methodLabel)).append("\n");
    sb.append("    methodValue: ").append(toIndentedString(methodValue)).append("\n");
    sb.append("    methodComment: ").append(toIndentedString(methodComment)).append("\n");
    sb.append("    methodReference: ").append(toIndentedString(methodReference)).append("\n");
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

