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

package com.google.cloud.oracledatabase.v1;

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
public class DbSystemName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DB_SYSTEM =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dbSystems/{db_system}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dbSystem;

  @Deprecated
  protected DbSystemName() {
    project = null;
    location = null;
    dbSystem = null;
  }

  private DbSystemName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dbSystem = Preconditions.checkNotNull(builder.getDbSystem());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDbSystem() {
    return dbSystem;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DbSystemName of(String project, String location, String dbSystem) {
    return newBuilder().setProject(project).setLocation(location).setDbSystem(dbSystem).build();
  }

  public static String format(String project, String location, String dbSystem) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDbSystem(dbSystem)
        .build()
        .toString();
  }

  public static DbSystemName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DB_SYSTEM.validatedMatch(
            formattedString, "DbSystemName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("db_system"));
  }

  public static List<DbSystemName> parseList(List<String> formattedStrings) {
    List<DbSystemName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DbSystemName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DbSystemName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DB_SYSTEM.matches(formattedString);
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
          if (dbSystem != null) {
            fieldMapBuilder.put("db_system", dbSystem);
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
    return PROJECT_LOCATION_DB_SYSTEM.instantiate(
        "project", project, "location", location, "db_system", dbSystem);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DbSystemName that = ((DbSystemName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dbSystem, that.dbSystem);
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
    h ^= Objects.hashCode(dbSystem);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/dbSystems/{db_system}. */
  public static class Builder {
    private String project;
    private String location;
    private String dbSystem;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDbSystem() {
      return dbSystem;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDbSystem(String dbSystem) {
      this.dbSystem = dbSystem;
      return this;
    }

    private Builder(DbSystemName dbSystemName) {
      this.project = dbSystemName.project;
      this.location = dbSystemName.location;
      this.dbSystem = dbSystemName.dbSystem;
    }

    public DbSystemName build() {
      return new DbSystemName(this);
    }
  }
}
