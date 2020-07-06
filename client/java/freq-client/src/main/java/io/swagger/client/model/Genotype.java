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
import io.swagger.client.model.GenotypeMethod;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Genotype
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-05-15T14:15:40.152-07:00")
public class Genotype {
  @SerializedName("genotypeString")
  private String genotypeString = null;

  @SerializedName("genotypingMethods")
  private List<GenotypeMethod> genotypingMethods = null;

  public Genotype genotypeString(String genotypeString) {
    this.genotypeString = genotypeString;
    return this;
  }

   /**
   * GL string of the genotype
   * @return genotypeString
  **/
  @ApiModelProperty(required = true, value = "GL string of the genotype")
  public String getGenotypeString() {
    return genotypeString;
  }

  public void setGenotypeString(String genotypeString) {
    this.genotypeString = genotypeString;
  }

  public Genotype genotypingMethods(List<GenotypeMethod> genotypingMethods) {
    this.genotypingMethods = genotypingMethods;
    return this;
  }

  public Genotype addGenotypingMethodsItem(GenotypeMethod genotypingMethodsItem) {
    if (this.genotypingMethods == null) {
      this.genotypingMethods = new ArrayList<GenotypeMethod>();
    }
    this.genotypingMethods.add(genotypingMethodsItem);
    return this;
  }

   /**
   * Additional Information on genotype
   * @return genotypingMethods
  **/
  @ApiModelProperty(value = "Additional Information on genotype")
  public List<GenotypeMethod> getGenotypingMethods() {
    return genotypingMethods;
  }

  public void setGenotypingMethods(List<GenotypeMethod> genotypingMethods) {
    this.genotypingMethods = genotypingMethods;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Genotype genotype = (Genotype) o;
    return Objects.equals(this.genotypeString, genotype.genotypeString) &&
        Objects.equals(this.genotypingMethods, genotype.genotypingMethods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(genotypeString, genotypingMethods);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Genotype {\n");
    
    sb.append("    genotypeString: ").append(toIndentedString(genotypeString)).append("\n");
    sb.append("    genotypingMethods: ").append(toIndentedString(genotypingMethods)).append("\n");
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

