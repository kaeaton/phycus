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
import io.swagger.client.model.PopulationSubmissionData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * PopulationSubmissionResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-18T09:39:57.795-07:00")
public class PopulationSubmissionResponse {
  @SerializedName("PopulationSubmissionList")
  private List<PopulationSubmissionData> populationSubmissionList = null;

  public PopulationSubmissionResponse populationSubmissionList(List<PopulationSubmissionData> populationSubmissionList) {
    this.populationSubmissionList = populationSubmissionList;
    return this;
  }

  public PopulationSubmissionResponse addPopulationSubmissionListItem(PopulationSubmissionData populationSubmissionListItem) {
    if (this.populationSubmissionList == null) {
      this.populationSubmissionList = new ArrayList<PopulationSubmissionData>();
    }
    this.populationSubmissionList.add(populationSubmissionListItem);
    return this;
  }

   /**
   * List of populations together with all attached submissions
   * @return populationSubmissionList
  **/
  @ApiModelProperty(value = "List of populations together with all attached submissions")
  public List<PopulationSubmissionData> getPopulationSubmissionList() {
    return populationSubmissionList;
  }

  public void setPopulationSubmissionList(List<PopulationSubmissionData> populationSubmissionList) {
    this.populationSubmissionList = populationSubmissionList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PopulationSubmissionResponse populationSubmissionResponse = (PopulationSubmissionResponse) o;
    return Objects.equals(this.populationSubmissionList, populationSubmissionResponse.populationSubmissionList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(populationSubmissionList);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PopulationSubmissionResponse {\n");
    
    sb.append("    populationSubmissionList: ").append(toIndentedString(populationSubmissionList)).append("\n");
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

