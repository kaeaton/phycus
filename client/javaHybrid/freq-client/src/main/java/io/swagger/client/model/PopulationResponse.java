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
import io.swagger.client.model.PopulationData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * PopulationResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-13T11:57:47.476-07:00")
public class PopulationResponse {
  @SerializedName("PopulationList")
  private List<PopulationData> populationList = null;

  public PopulationResponse populationList(List<PopulationData> populationList) {
    this.populationList = populationList;
    return this;
  }

  public PopulationResponse addPopulationListItem(PopulationData populationListItem) {
    if (this.populationList == null) {
      this.populationList = new ArrayList<PopulationData>();
    }
    this.populationList.add(populationListItem);
    return this;
  }

   /**
   * List of populations
   * @return populationList
  **/
  @ApiModelProperty(value = "List of populations")
  public List<PopulationData> getPopulationList() {
    return populationList;
  }

  public void setPopulationList(List<PopulationData> populationList) {
    this.populationList = populationList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PopulationResponse populationResponse = (PopulationResponse) o;
    return Objects.equals(this.populationList, populationResponse.populationList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(populationList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PopulationResponse {\n");
    
    sb.append("    populationList: ").append(toIndentedString(populationList)).append("\n");
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

