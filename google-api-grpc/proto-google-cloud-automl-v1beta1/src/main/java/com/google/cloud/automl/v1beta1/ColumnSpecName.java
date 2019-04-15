/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.automl.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ColumnSpecName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/datasets/{dataset}/tableSpecs/{table_spec}/columnSpecs/{column_spec}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String dataset;
  private final String tableSpec;
  private final String columnSpec;

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

  private ColumnSpecName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    tableSpec = Preconditions.checkNotNull(builder.getTableSpec());
    columnSpec = Preconditions.checkNotNull(builder.getColumnSpec());
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
        PATH_TEMPLATE.validatedMatch(
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("dataset", dataset);
          fieldMapBuilder.put("tableSpec", tableSpec);
          fieldMapBuilder.put("columnSpec", columnSpec);
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
    return PATH_TEMPLATE.instantiate(
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

  /** Builder for ColumnSpecName. */
  public static class Builder {

    private String project;
    private String location;
    private String dataset;
    private String tableSpec;
    private String columnSpec;

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

    private Builder() {}

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

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ColumnSpecName) {
      ColumnSpecName that = (ColumnSpecName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.dataset.equals(that.dataset))
          && (this.tableSpec.equals(that.tableSpec))
          && (this.columnSpec.equals(that.columnSpec));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= dataset.hashCode();
    h *= 1000003;
    h ^= tableSpec.hashCode();
    h *= 1000003;
    h ^= columnSpec.hashCode();
    return h;
  }
}
