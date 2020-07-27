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
 * License models, there will be a default license if one is not provided
 */
@ApiModel(description = "License models, there will be a default license if one is not provided")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-15T14:15:40.152-07:00")
public class License {
  /**
   * Type of creative commons license
   */
  @JsonAdapter(TypeOfLicenseEnum.Adapter.class)
  public enum TypeOfLicenseEnum {
    CC0("CC0"),
    
    BY("by"),
    
    BY_SA("by-sa"),
    
    BY_ND("by-nd"),
    
    BY_NC("by-nc"),
    
    BY_NC_SA("by-nc-sa"),
    
    BY_NC_ND("by-nc-nd");

    private String value;

    TypeOfLicenseEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeOfLicenseEnum fromValue(String text) {
      for (TypeOfLicenseEnum b : TypeOfLicenseEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeOfLicenseEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeOfLicenseEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeOfLicenseEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeOfLicenseEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("typeOfLicense")
  private TypeOfLicenseEnum typeOfLicense = null;

  public License typeOfLicense(TypeOfLicenseEnum typeOfLicense) {
    this.typeOfLicense = typeOfLicense;
    return this;
  }

   /**
   * Type of creative commons license
   * @return typeOfLicense
  **/
  @ApiModelProperty(required = true, value = "Type of creative commons license")
  public TypeOfLicenseEnum getTypeOfLicense() {
    return typeOfLicense;
  }

  public void setTypeOfLicense(TypeOfLicenseEnum typeOfLicense) {
    this.typeOfLicense = typeOfLicense;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    License license = (License) o;
    return Objects.equals(this.typeOfLicense, license.typeOfLicense);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeOfLicense);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class License {\n");
    
    sb.append("    typeOfLicense: ").append(toIndentedString(typeOfLicense)).append("\n");
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
