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

package com.google.cloud.bigquery.storage.v1beta2;

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
public class WriteStreamName implements ResourceName {
  private static final PathTemplate PROJECT_DATASET_TABLE_STREAM =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/datasets/{dataset}/tables/{table}/streams/{stream}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String dataset;
  private final String table;
  private final String stream;

  @Deprecated
  protected WriteStreamName() {
    project = null;
    dataset = null;
    table = null;
    stream = null;
  }

  private WriteStreamName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    table = Preconditions.checkNotNull(builder.getTable());
    stream = Preconditions.checkNotNull(builder.getStream());
  }

  public String getProject() {
    return project;
  }

  public String getDataset() {
    return dataset;
  }

  public String getTable() {
    return table;
  }

  public String getStream() {
    return stream;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WriteStreamName of(String project, String dataset, String table, String stream) {
    return newBuilder()
        .setProject(project)
        .setDataset(dataset)
        .setTable(table)
        .setStream(stream)
        .build();
  }

  public static String format(String project, String dataset, String table, String stream) {
    return newBuilder()
        .setProject(project)
        .setDataset(dataset)
        .setTable(table)
        .setStream(stream)
        .build()
        .toString();
  }

  public static WriteStreamName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_DATASET_TABLE_STREAM.validatedMatch(
            formattedString, "WriteStreamName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("dataset"),
        matchMap.get("table"),
        matchMap.get("stream"));
  }

  public static List<WriteStreamName> parseList(List<String> formattedStrings) {
    List<WriteStreamName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WriteStreamName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WriteStreamName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_DATASET_TABLE_STREAM.matches(formattedString);
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
          if (dataset != null) {
            fieldMapBuilder.put("dataset", dataset);
          }
          if (table != null) {
            fieldMapBuilder.put("table", table);
          }
          if (stream != null) {
            fieldMapBuilder.put("stream", stream);
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
    return PROJECT_DATASET_TABLE_STREAM.instantiate(
        "project", project, "dataset", dataset, "table", table, "stream", stream);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      WriteStreamName that = ((WriteStreamName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.dataset, that.dataset)
          && Objects.equals(this.table, that.table)
          && Objects.equals(this.stream, that.stream);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(dataset);
    h *= 1000003;
    h ^= Objects.hashCode(table);
    h *= 1000003;
    h ^= Objects.hashCode(stream);
    return h;
  }

  /** Builder for projects/{project}/datasets/{dataset}/tables/{table}/streams/{stream}. */
  public static class Builder {
    private String project;
    private String dataset;
    private String table;
    private String stream;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getDataset() {
      return dataset;
    }

    public String getTable() {
      return table;
    }

    public String getStream() {
      return stream;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    public Builder setTable(String table) {
      this.table = table;
      return this;
    }

    public Builder setStream(String stream) {
      this.stream = stream;
      return this;
    }

    private Builder(WriteStreamName writeStreamName) {
      project = writeStreamName.project;
      dataset = writeStreamName.dataset;
      table = writeStreamName.table;
      stream = writeStreamName.stream;
    }

    public WriteStreamName build() {
      return new WriteStreamName(this);
    }
  }
}
