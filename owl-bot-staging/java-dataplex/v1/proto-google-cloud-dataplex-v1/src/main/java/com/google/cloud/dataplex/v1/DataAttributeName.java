/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.dataplex.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class DataAttributeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATATAXONOMY_DATA_ATTRIBUTE_ID =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataTaxonomy;
  private final String dataAttributeId;

  @Deprecated
  protected DataAttributeName() {
    project = null;
    location = null;
    dataTaxonomy = null;
    dataAttributeId = null;
  }

  private DataAttributeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataTaxonomy = Preconditions.checkNotNull(builder.getDataTaxonomy());
    dataAttributeId = Preconditions.checkNotNull(builder.getDataAttributeId());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataTaxonomy() {
    return dataTaxonomy;
  }

  public String getDataAttributeId() {
    return dataAttributeId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataAttributeName of(
      String project, String location, String dataTaxonomy, String dataAttributeId) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataTaxonomy(dataTaxonomy)
        .setDataAttributeId(dataAttributeId)
        .build();
  }

  public static String format(
      String project, String location, String dataTaxonomy, String dataAttributeId) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataTaxonomy(dataTaxonomy)
        .setDataAttributeId(dataAttributeId)
        .build()
        .toString();
  }

  public static DataAttributeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATATAXONOMY_DATA_ATTRIBUTE_ID.validatedMatch(
            formattedString, "DataAttributeName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("dataTaxonomy"),
        matchMap.get("data_attribute_id"));
  }

  public static List<DataAttributeName> parseList(List<String> formattedStrings) {
    List<DataAttributeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataAttributeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataAttributeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATATAXONOMY_DATA_ATTRIBUTE_ID.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (dataTaxonomy != null) {
            fieldMapBuilder.put("dataTaxonomy", dataTaxonomy);
          }
          if (dataAttributeId != null) {
            fieldMapBuilder.put("data_attribute_id", dataAttributeId);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PROJECT_LOCATION_DATATAXONOMY_DATA_ATTRIBUTE_ID.instantiate(
        "project",
        project,
        "location",
        location,
        "dataTaxonomy",
        dataTaxonomy,
        "data_attribute_id",
        dataAttributeId);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DataAttributeName that = ((DataAttributeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataTaxonomy, that.dataTaxonomy)
          && Objects.equals(this.dataAttributeId, that.dataAttributeId);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(dataTaxonomy);
    h *= 1000003;
    h ^= Objects.hashCode(dataAttributeId);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataTaxonomies/{dataTaxonomy}/attributes/{data_attribute_id}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataTaxonomy;
    private String dataAttributeId;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataTaxonomy() {
      return dataTaxonomy;
    }

    public String getDataAttributeId() {
      return dataAttributeId;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataTaxonomy(String dataTaxonomy) {
      this.dataTaxonomy = dataTaxonomy;
      return this;
    }

    public Builder setDataAttributeId(String dataAttributeId) {
      this.dataAttributeId = dataAttributeId;
      return this;
    }

    private Builder(DataAttributeName dataAttributeName) {
      this.project = dataAttributeName.project;
      this.location = dataAttributeName.location;
      this.dataTaxonomy = dataAttributeName.dataTaxonomy;
      this.dataAttributeId = dataAttributeName.dataAttributeId;
    }

    public DataAttributeName build() {
      return new DataAttributeName(this);
    }
  }
}
