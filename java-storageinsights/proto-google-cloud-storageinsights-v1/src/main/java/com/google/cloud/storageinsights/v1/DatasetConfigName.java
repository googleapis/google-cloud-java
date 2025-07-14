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

package com.google.cloud.storageinsights.v1;

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
public class DatasetConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATASET_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/datasetConfigs/{dataset_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String datasetConfig;

  @Deprecated
  protected DatasetConfigName() {
    project = null;
    location = null;
    datasetConfig = null;
  }

  private DatasetConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    datasetConfig = Preconditions.checkNotNull(builder.getDatasetConfig());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDatasetConfig() {
    return datasetConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DatasetConfigName of(String project, String location, String datasetConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDatasetConfig(datasetConfig)
        .build();
  }

  public static String format(String project, String location, String datasetConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDatasetConfig(datasetConfig)
        .build()
        .toString();
  }

  public static DatasetConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATASET_CONFIG.validatedMatch(
            formattedString, "DatasetConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("dataset_config"));
  }

  public static List<DatasetConfigName> parseList(List<String> formattedStrings) {
    List<DatasetConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DatasetConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DatasetConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATASET_CONFIG.matches(formattedString);
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
          if (datasetConfig != null) {
            fieldMapBuilder.put("dataset_config", datasetConfig);
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
    return PROJECT_LOCATION_DATASET_CONFIG.instantiate(
        "project", project, "location", location, "dataset_config", datasetConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DatasetConfigName that = ((DatasetConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.datasetConfig, that.datasetConfig);
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
    h ^= Objects.hashCode(datasetConfig);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/datasetConfigs/{dataset_config}. */
  public static class Builder {
    private String project;
    private String location;
    private String datasetConfig;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDatasetConfig() {
      return datasetConfig;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDatasetConfig(String datasetConfig) {
      this.datasetConfig = datasetConfig;
      return this;
    }

    private Builder(DatasetConfigName datasetConfigName) {
      this.project = datasetConfigName.project;
      this.location = datasetConfigName.location;
      this.datasetConfig = datasetConfigName.datasetConfig;
    }

    public DatasetConfigName build() {
      return new DatasetConfigName(this);
    }
  }
}
