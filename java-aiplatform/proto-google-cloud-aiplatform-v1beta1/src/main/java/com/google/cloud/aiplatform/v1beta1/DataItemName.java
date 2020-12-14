/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

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
public class DataItemName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATASET_DATA_ITEM =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/datasets/{dataset}/dataItems/{data_item}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataset;
  private final String dataItem;

  @Deprecated
  protected DataItemName() {
    project = null;
    location = null;
    dataset = null;
    dataItem = null;
  }

  private DataItemName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    dataItem = Preconditions.checkNotNull(builder.getDataItem());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataset() {
    return dataset;
  }

  public String getDataItem() {
    return dataItem;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataItemName of(String project, String location, String dataset, String dataItem) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setDataItem(dataItem)
        .build();
  }

  public static String format(String project, String location, String dataset, String dataItem) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setDataItem(dataItem)
        .build()
        .toString();
  }

  public static DataItemName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATASET_DATA_ITEM.validatedMatch(
            formattedString, "DataItemName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("dataset"),
        matchMap.get("data_item"));
  }

  public static List<DataItemName> parseList(List<String> formattedStrings) {
    List<DataItemName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataItemName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataItemName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATASET_DATA_ITEM.matches(formattedString);
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
          if (dataset != null) {
            fieldMapBuilder.put("dataset", dataset);
          }
          if (dataItem != null) {
            fieldMapBuilder.put("data_item", dataItem);
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
    return PROJECT_LOCATION_DATASET_DATA_ITEM.instantiate(
        "project", project, "location", location, "dataset", dataset, "data_item", dataItem);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DataItemName that = ((DataItemName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataset, that.dataset)
          && Objects.equals(this.dataItem, that.dataItem);
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
    h ^= Objects.hashCode(dataset);
    h *= 1000003;
    h ^= Objects.hashCode(dataItem);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/datasets/{dataset}/dataItems/{data_item}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataset;
    private String dataItem;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataset() {
      return dataset;
    }

    public String getDataItem() {
      return dataItem;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    public Builder setDataItem(String dataItem) {
      this.dataItem = dataItem;
      return this;
    }

    private Builder(DataItemName dataItemName) {
      project = dataItemName.project;
      location = dataItemName.location;
      dataset = dataItemName.dataset;
      dataItem = dataItemName.dataItem;
    }

    public DataItemName build() {
      return new DataItemName(this);
    }
  }
}
