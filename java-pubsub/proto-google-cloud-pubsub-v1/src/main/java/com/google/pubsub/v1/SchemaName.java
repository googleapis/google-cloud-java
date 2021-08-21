/*
 * Copyright 2021 Google LLC
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

package com.google.pubsub.v1;

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
public class SchemaName implements ResourceName {
  private static final PathTemplate PROJECT_SCHEMA =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/schemas/{schema}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String schema;

  @Deprecated
  protected SchemaName() {
    project = null;
    schema = null;
  }

  private SchemaName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    schema = Preconditions.checkNotNull(builder.getSchema());
  }

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
        PROJECT_SCHEMA.validatedMatch(
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
    List<String> list = new ArrayList<>(values.size());
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
    return PROJECT_SCHEMA.matches(formattedString);
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
          if (schema != null) {
            fieldMapBuilder.put("schema", schema);
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
    return PROJECT_SCHEMA.instantiate("project", project, "schema", schema);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SchemaName that = ((SchemaName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.schema, that.schema);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(schema);
    return h;
  }

  /** Builder for projects/{project}/schemas/{schema}. */
  public static class Builder {
    private String project;
    private String schema;

    protected Builder() {}

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

    private Builder(SchemaName schemaName) {
      this.project = schemaName.project;
      this.schema = schemaName.schema;
    }

    public SchemaName build() {
      return new SchemaName(this);
    }
  }
}
