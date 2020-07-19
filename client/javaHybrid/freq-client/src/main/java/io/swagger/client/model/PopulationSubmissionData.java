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
 * Contains all submissions for a population
 */
@ApiModel(description = "Contains all submissions for a population")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-07-19T16:22:07.220-07:00")
public class PopulationSubmissionData {
  @SerializedName("population")
  private PopulationData population = null;

  @SerializedName("submissions")
  private List<Long> submissions = null;

  public PopulationSubmissionData population(PopulationData population) {
    this.population = population;
    return this;
  }

   /**
   * Get population
   * @return population
  **/
  @ApiModelProperty(required = true, value = "")
  public PopulationData getPopulation() {
    return population;
  }

  public void setPopulation(PopulationData population) {
    this.population = population;
  }

  public PopulationSubmissionData submissions(List<Long> submissions) {
    this.submissions = submissions;
    return this;
  }

  public PopulationSubmissionData addSubmissionsItem(Long submissionsItem) {
    if (this.submissions == null) {
      this.submissions = new ArrayList<Long>();
    }
    this.submissions.add(submissionsItem);
    return this;
  }

   /**
   * submissions that describe the population
   * @return submissions
  **/
  @ApiModelProperty(value = "submissions that describe the population")
  public List<Long> getSubmissions() {
    return submissions;
  }

  public void setSubmissions(List<Long> submissions) {
    this.submissions = submissions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PopulationSubmissionData populationSubmissionData = (PopulationSubmissionData) o;
    return Objects.equals(this.population, populationSubmissionData.population) &&
        Objects.equals(this.submissions, populationSubmissionData.submissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(population, submissions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PopulationSubmissionData {\n");
    
    sb.append("    population: ").append(toIndentedString(population)).append("\n");
    sb.append("    submissions: ").append(toIndentedString(submissions)).append("\n");
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

