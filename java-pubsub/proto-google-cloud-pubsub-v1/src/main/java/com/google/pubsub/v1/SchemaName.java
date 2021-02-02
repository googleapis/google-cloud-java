/*
 * Copyright 2020 Google LLC
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

package com.google.pubsub.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class SchemaName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/schemas/{schema}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String schema;

  public String getProject() {
    return project;
  }

  public String getSchema() {
    return schema;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private SchemaName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    schema = Preconditions.checkNotNull(builder.getSchema());
  }

  public static SchemaName of(String project, String schema) {
    return newBuilder().setProject(project).setSchema(schema).build();
  }

  public static String format(String project, String schema) {
    return newBuilder().setProject(project).setSchema(schema).build().toString();
  }

  public static SchemaName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "SchemaName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("schema"));
  }

  public static List<SchemaName> parseList(List<String> formattedStrings) {
    List<SchemaName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SchemaName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (SchemaName value : values) {
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
          fieldMapBuilder.put("schema", schema);
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
    return PATH_TEMPLATE.instantiate("project", project, "schema", schema);
  }

  /** Builder for SchemaName. */
  public static class Builder {

    private String project;
    private String schema;

    public String getProject() {
      return project;
    }

    public String getSchema() {
      return schema;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSchema(String schema) {
      this.schema = schema;
      return this;
    }

    private Builder() {}

    private Builder(SchemaName schemaName) {
      project = schemaName.project;
      schema = schemaName.schema;
    }

    public SchemaName build() {
      return new SchemaName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SchemaName) {
      SchemaName that = (SchemaName) o;
      return (this.project.equals(that.project)) && (this.schema.equals(that.schema));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= schema.hashCode();
    return h;
  }
}
