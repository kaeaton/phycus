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
 * AccessData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-13T05:00:01.021-07:00")
public class AccessData {
  @SerializedName("typeOfAccess")
  private String typeOfAccess = null;

  public AccessData typeOfAccess(String typeOfAccess) {
    this.typeOfAccess = typeOfAccess;
    return this;
  }

   /**
   * There will be a default license if one is not provided
   * @return typeOfAccess
  **/
  @ApiModelProperty(required = true, value = "There will be a default license if one is not provided")
  public String getTypeOfAccess() {
    return typeOfAccess;
  }

  public void setTypeOfAccess(String typeOfAccess) {
    this.typeOfAccess = typeOfAccess;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccessData accessData = (AccessData) o;
    return Objects.equals(this.typeOfAccess, accessData.typeOfAccess);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeOfAccess);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccessData {\n");
    
    sb.append("    typeOfAccess: ").append(toIndentedString(typeOfAccess)).append("\n");
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

