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
import io.swagger.client.model.GenotypeList;
import java.io.IOException;

/**
 * CohortData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-12T14:15:34.209-07:00")
public class CohortData {
  @SerializedName("GenotypeList")
  private GenotypeList genotypeList = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("id")
  private Long id = null;

  public CohortData genotypeList(GenotypeList genotypeList) {
    this.genotypeList = genotypeList;
    return this;
  }

   /**
   * Get genotypeList
   * @return genotypeList
  **/
  @ApiModelProperty(required = true, value = "")
  public GenotypeList getGenotypeList() {
    return genotypeList;
  }

  public void setGenotypeList(GenotypeList genotypeList) {
    this.genotypeList = genotypeList;
  }

  public CohortData name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the cohort
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the cohort")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CohortData id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * id of the cohort
   * @return id
  **/
  @ApiModelProperty(value = "id of the cohort")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CohortData cohortData = (CohortData) o;
    return Objects.equals(this.genotypeList, cohortData.genotypeList) &&
        Objects.equals(this.name, cohortData.name) &&
        Objects.equals(this.id, cohortData.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genotypeList, name, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CohortData {\n");
    
    sb.append("    genotypeList: ").append(toIndentedString(genotypeList)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

