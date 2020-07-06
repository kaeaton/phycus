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
 * Method Record
 */
@ApiModel(description = "Method Record")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-06T12:21:43.393-07:00")
public class Method {
  /**
   * Type of method label
   */
  @JsonAdapter(TypeOfMethodEnum.Adapter.class)
  public enum TypeOfMethodEnum {
    EM_ALGORITHM("EM_ALGORITHM"),
    
    EM_VERSION("EM_VERSION"),
    
    EM_ALG_REF("EM_ALG_REF"),
    
    MAC_SERVICE("MAC_SERVICE"),
    
    MAC_SER_REF("MAC_SER_REF"),
    
    MAC_VERSION("MAC_VERSION"),
    
    ARS_SERVICE("ARS_SERVICE"),
    
    ARS_SERV_REF("ARS_SERV_REF"),
    
    ARS_VERSION("ARS_VERSION"),
    
    HWE_METHOD("HWE_METHOD"),
    
    HWE_REF("HWE_REF"),
    
    LD_METHOD("LD_METHOD"),
    
    LD_METHOD_REF("LD_METHOD_REF");

    private String value;

    TypeOfMethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeOfMethodEnum fromValue(String text) {
      for (TypeOfMethodEnum b : TypeOfMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeOfMethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeOfMethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeOfMethodEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeOfMethodEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("typeOfMethod")
  private TypeOfMethodEnum typeOfMethod = null;

  @SerializedName("methodValue")
  private String methodValue = null;

  @SerializedName("methodComment")
  private String methodComment = null;

  @SerializedName("methodReference")
  private String methodReference = null;

  public Method typeOfMethod(TypeOfMethodEnum typeOfMethod) {
    this.typeOfMethod = typeOfMethod;
    return this;
  }

   /**
   * Type of method label
   * @return typeOfMethod
  **/
  @ApiModelProperty(value = "Type of method label")
  public TypeOfMethodEnum getTypeOfMethod() {
    return typeOfMethod;
  }

  public void setTypeOfMethod(TypeOfMethodEnum typeOfMethod) {
    this.typeOfMethod = typeOfMethod;
  }

  public Method methodValue(String methodValue) {
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

  public Method methodComment(String methodComment) {
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

  public Method methodReference(String methodReference) {
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
    Method method = (Method) o;
    return Objects.equals(this.typeOfMethod, method.typeOfMethod) &&
        Objects.equals(this.methodValue, method.methodValue) &&
        Objects.equals(this.methodComment, method.methodComment) &&
        Objects.equals(this.methodReference, method.methodReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeOfMethod, methodValue, methodComment, methodReference);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Method {\n");
    
    sb.append("    typeOfMethod: ").append(toIndentedString(typeOfMethod)).append("\n");
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

