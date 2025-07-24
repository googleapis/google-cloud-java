/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.backupdr.v1;

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
public class DataSourceReferenceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_SOURCE_REFERENCE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataSourceReferences/{data_source_reference}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataSourceReference;

  @Deprecated
  protected DataSourceReferenceName() {
    project = null;
    location = null;
    dataSourceReference = null;
  }

  private DataSourceReferenceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataSourceReference = Preconditions.checkNotNull(builder.getDataSourceReference());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataSourceReference() {
    return dataSourceReference;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataSourceReferenceName of(
      String project, String location, String dataSourceReference) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataSourceReference(dataSourceReference)
        .build();
  }

  public static String format(String project, String location, String dataSourceReference) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataSourceReference(dataSourceReference)
        .build()
        .toString();
  }

  public static DataSourceReferenceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATA_SOURCE_REFERENCE.validatedMatch(
            formattedString, "DataSourceReferenceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("data_source_reference"));
  }

  public static List<DataSourceReferenceName> parseList(List<String> formattedStrings) {
    List<DataSourceReferenceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataSourceReferenceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataSourceReferenceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_SOURCE_REFERENCE.matches(formattedString);
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
          if (dataSourceReference != null) {
            fieldMapBuilder.put("data_source_reference", dataSourceReference);
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
    return PROJECT_LOCATION_DATA_SOURCE_REFERENCE.instantiate(
        "project", project, "location", location, "data_source_reference", dataSourceReference);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DataSourceReferenceName that = ((DataSourceReferenceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataSourceReference, that.dataSourceReference);
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
    h ^= Objects.hashCode(dataSourceReference);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataSourceReferences/{data_source_reference}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataSourceReference;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataSourceReference() {
      return dataSourceReference;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataSourceReference(String dataSourceReference) {
      this.dataSourceReference = dataSourceReference;
      return this;
    }

    private Builder(DataSourceReferenceName dataSourceReferenceName) {
      this.project = dataSourceReferenceName.project;
      this.location = dataSourceReferenceName.location;
      this.dataSourceReference = dataSourceReferenceName.dataSourceReference;
    }

    public DataSourceReferenceName build() {
      return new DataSourceReferenceName(this);
    }
  }
}
