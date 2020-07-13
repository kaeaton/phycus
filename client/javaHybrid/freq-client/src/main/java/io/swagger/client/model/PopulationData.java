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
 * PopulationData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-13T05:00:01.021-07:00")
public class PopulationData {
  @SerializedName("id")
  private Long id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  public PopulationData id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * id of the population
   * @return id
  **/
  @ApiModelProperty(value = "id of the population")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PopulationData name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the population
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the population")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PopulationData description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the population
   * @return description
  **/
  @ApiModelProperty(value = "Description of the population")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PopulationData populationData = (PopulationData) o;
    return Objects.equals(this.id, populationData.id) &&
        Objects.equals(this.name, populationData.name) &&
        Objects.equals(this.description, populationData.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PopulationData {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

