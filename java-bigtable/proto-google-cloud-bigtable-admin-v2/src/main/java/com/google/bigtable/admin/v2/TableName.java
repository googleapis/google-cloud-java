/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.bigtable.admin.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class TableName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/instances/{instance}/tables/{table}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String instance;
  private final String table;

  public String getProject() {
    return project;
  }

  public String getInstance() {
    return instance;
  }

  public String getTable() {
    return table;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private TableName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instance = Preconditions.checkNotNull(builder.getInstance());
    table = Preconditions.checkNotNull(builder.getTable());
  }

  public static TableName of(String project, String instance, String table) {
    return newBuilder().setProject(project).setInstance(instance).setTable(table).build();
  }

  public static String format(String project, String instance, String table) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setTable(table)
        .build()
        .toString();
  }

  public static TableName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "TableName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("instance"), matchMap.get("table"));
  }

  public static List<TableName> parseList(List<String> formattedStrings) {
    List<TableName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TableName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (TableName value : values) {
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
          fieldMapBuilder.put("instance", instance);
          fieldMapBuilder.put("table", table);
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
    return PATH_TEMPLATE.instantiate("project", project, "instance", instance, "table", table);
  }

  /** Builder for TableName. */
  public static class Builder {

    private String project;
    private String instance;
    private String table;

    public String getProject() {
      return project;
    }

    public String getInstance() {
      return instance;
    }

    public String getTable() {
      return table;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setTable(String table) {
      this.table = table;
      return this;
    }

    private Builder() {}

    private Builder(TableName tableName) {
      project = tableName.project;
      instance = tableName.instance;
      table = tableName.table;
    }

    public TableName build() {
      return new TableName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TableName) {
      TableName that = (TableName) o;
      return (this.project.equals(that.project))
          && (this.instance.equals(that.instance))
          && (this.table.equals(that.table));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= instance.hashCode();
    h *= 1000003;
    h ^= table.hashCode();
    return h;
  }
}
