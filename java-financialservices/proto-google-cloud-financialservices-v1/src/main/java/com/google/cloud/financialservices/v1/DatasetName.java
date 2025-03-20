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

package com.google.cloud.financialservices.v1;

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
public class DatasetName implements ResourceName {
  private static final PathTemplate PROJECT_NUM_LOCATION_INSTANCE_DATASET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project_num}/locations/{location}/instances/{instance}/datasets/{dataset}");
  private volatile Map<String, String> fieldValuesMap;
  private final String projectNum;
  private final String location;
  private final String instance;
  private final String dataset;

  @Deprecated
  protected DatasetName() {
    projectNum = null;
    location = null;
    instance = null;
    dataset = null;
  }

  private DatasetName(Builder builder) {
    projectNum = Preconditions.checkNotNull(builder.getProjectNum());
    location = Preconditions.checkNotNull(builder.getLocation());
    instance = Preconditions.checkNotNull(builder.getInstance());
    dataset = Preconditions.checkNotNull(builder.getDataset());
  }

  public String getProjectNum() {
    return projectNum;
  }

  public String getLocation() {
    return location;
  }

  public String getInstance() {
    return instance;
  }

  public String getDataset() {
    return dataset;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DatasetName of(
      String projectNum, String location, String instance, String dataset) {
    return newBuilder()
        .setProjectNum(projectNum)
        .setLocation(location)
        .setInstance(instance)
        .setDataset(dataset)
        .build();
  }

  public static String format(String projectNum, String location, String instance, String dataset) {
    return newBuilder()
        .setProjectNum(projectNum)
        .setLocation(location)
        .setInstance(instance)
        .setDataset(dataset)
        .build()
        .toString();
  }

  public static DatasetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_NUM_LOCATION_INSTANCE_DATASET.validatedMatch(
            formattedString, "DatasetName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project_num"),
        matchMap.get("location"),
        matchMap.get("instance"),
        matchMap.get("dataset"));
  }

  public static List<DatasetName> parseList(List<String> formattedStrings) {
    List<DatasetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DatasetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DatasetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_NUM_LOCATION_INSTANCE_DATASET.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (projectNum != null) {
            fieldMapBuilder.put("project_num", projectNum);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
          }
          if (dataset != null) {
            fieldMapBuilder.put("dataset", dataset);
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
    return PROJECT_NUM_LOCATION_INSTANCE_DATASET.instantiate(
        "project_num", projectNum, "location", location, "instance", instance, "dataset", dataset);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DatasetName that = ((DatasetName) o);
      return Objects.equals(this.projectNum, that.projectNum)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.dataset, that.dataset);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(projectNum);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(dataset);
    return h;
  }

  /**
   * Builder for
   * projects/{project_num}/locations/{location}/instances/{instance}/datasets/{dataset}.
   */
  public static class Builder {
    private String projectNum;
    private String location;
    private String instance;
    private String dataset;

    protected Builder() {}

    public String getProjectNum() {
      return projectNum;
    }

    public String getLocation() {
      return location;
    }

    public String getInstance() {
      return instance;
    }

    public String getDataset() {
      return dataset;
    }

    public Builder setProjectNum(String projectNum) {
      this.projectNum = projectNum;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    private Builder(DatasetName datasetName) {
      this.projectNum = datasetName.projectNum;
      this.location = datasetName.location;
      this.instance = datasetName.instance;
      this.dataset = datasetName.dataset;
    }

    public DatasetName build() {
      return new DatasetName(this);
    }
  }
}
