/*
 * Copyright 2026 Google LLC
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

package com.google.firestore.admin.v1;

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
public class DatabaseName implements ResourceName {
  private static final PathTemplate PROJECT_DATABASE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/databases/{database}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String database;

  @Deprecated
  protected DatabaseName() {
    project = null;
    database = null;
  }

  private DatabaseName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    database = Preconditions.checkNotNull(builder.getDatabase());
  }

  public String getProject() {
    return project;
  }

  public String getDatabase() {
    return database;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DatabaseName of(String project, String database) {
    return newBuilder().setProject(project).setDatabase(database).build();
  }

  public static String format(String project, String database) {
    return newBuilder().setProject(project).setDatabase(database).build().toString();
  }

  public static DatabaseName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_DATABASE.validatedMatch(
            formattedString, "DatabaseName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("database"));
  }

  public static List<DatabaseName> parseList(List<String> formattedStrings) {
    List<DatabaseName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DatabaseName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DatabaseName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_DATABASE.matches(formattedString);
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
          if (database != null) {
            fieldMapBuilder.put("database", database);
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
    return PROJECT_DATABASE.instantiate("project", project, "database", database);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DatabaseName that = ((DatabaseName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.database, that.database);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(database);
    return h;
  }

  /** Builder for projects/{project}/databases/{database}. */
  public static class Builder {
    private String project;
    private String database;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getDatabase() {
      return database;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDatabase(String database) {
      this.database = database;
      return this;
    }

    private Builder(DatabaseName databaseName) {
      this.project = databaseName.project;
      this.database = databaseName.database;
    }

    public DatabaseName build() {
      return new DatabaseName(this);
    }
  }
}
