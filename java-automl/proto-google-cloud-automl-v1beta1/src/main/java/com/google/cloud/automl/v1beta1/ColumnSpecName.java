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

package com.google.cloud.automl.v1beta1;

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
public class ColumnSpecName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATASET_TABLE_SPEC_COLUMN_SPEC =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/datasets/{dataset}/tableSpecs/{table_spec}/columnSpecs/{column_spec}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dataset;
  private final String tableSpec;
  private final String columnSpec;

  @Deprecated
  protected ColumnSpecName() {
    project = null;
    location = null;
    dataset = null;
    tableSpec = null;
    columnSpec = null;
  }

  private ColumnSpecName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    tableSpec = Preconditions.checkNotNull(builder.getTableSpec());
    columnSpec = Preconditions.checkNotNull(builder.getColumnSpec());
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

  public String getTableSpec() {
    return tableSpec;
  }

  public String getColumnSpec() {
    return columnSpec;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ColumnSpecName of(
      String project, String location, String dataset, String tableSpec, String columnSpec) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setTableSpec(tableSpec)
        .setColumnSpec(columnSpec)
        .build();
  }

  public static String format(
      String project, String location, String dataset, String tableSpec, String columnSpec) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataset(dataset)
        .setTableSpec(tableSpec)
        .setColumnSpec(columnSpec)
        .build()
        .toString();
  }

  public static ColumnSpecName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DATASET_TABLE_SPEC_COLUMN_SPEC.validatedMatch(
            formattedString, "ColumnSpecName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("dataset"),
        matchMap.get("table_spec"),
        matchMap.get("column_spec"));
  }

  public static List<ColumnSpecName> parseList(List<String> formattedStrings) {
    List<ColumnSpecName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ColumnSpecName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ColumnSpecName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATASET_TABLE_SPEC_COLUMN_SPEC.matches(formattedString);
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
          if (tableSpec != null) {
            fieldMapBuilder.put("table_spec", tableSpec);
          }
          if (columnSpec != null) {
            fieldMapBuilder.put("column_spec", columnSpec);
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
    return PROJECT_LOCATION_DATASET_TABLE_SPEC_COLUMN_SPEC.instantiate(
        "project",
        project,
        "location",
        location,
        "dataset",
        dataset,
        "table_spec",
        tableSpec,
        "column_spec",
        columnSpec);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ColumnSpecName that = ((ColumnSpecName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataset, that.dataset)
          && Objects.equals(this.tableSpec, that.tableSpec)
          && Objects.equals(this.columnSpec, that.columnSpec);
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
    h ^= Objects.hashCode(tableSpec);
    h *= 1000003;
    h ^= Objects.hashCode(columnSpec);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/datasets/{dataset}/tableSpecs/{table_spec}/columnSpecs/{column_spec}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataset;
    private String tableSpec;
    private String columnSpec;

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

    public String getTableSpec() {
      return tableSpec;
    }

    public String getColumnSpec() {
      return columnSpec;
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

    public Builder setTableSpec(String tableSpec) {
      this.tableSpec = tableSpec;
      return this;
    }

    public Builder setColumnSpec(String columnSpec) {
      this.columnSpec = columnSpec;
      return this;
    }

    private Builder(ColumnSpecName columnSpecName) {
      project = columnSpecName.project;
      location = columnSpecName.location;
      dataset = columnSpecName.dataset;
      tableSpec = columnSpecName.tableSpec;
      columnSpec = columnSpecName.columnSpec;
    }

    public ColumnSpecName build() {
      return new ColumnSpecName(this);
    }
  }
}
