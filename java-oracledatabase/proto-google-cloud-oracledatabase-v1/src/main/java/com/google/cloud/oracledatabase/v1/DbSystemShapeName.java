/*
 * Copyright 2024 Google LLC
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
public class DbSystemShapeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DB_SYSTEM_SHAPE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dbSystemShapes/{db_system_shape}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String dbSystemShape;

  @Deprecated
  protected DbSystemShapeName() {
    project = null;
    location = null;
    dbSystemShape = null;
  }

  private DbSystemShapeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dbSystemShape = Preconditions.checkNotNull(builder.getDbSystemShape());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDbSystemShape() {
    return dbSystemShape;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DbSystemShapeName of(String project, String location, String dbSystemShape) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDbSystemShape(dbSystemShape)
        .build();
  }

  public static String format(String project, String location, String dbSystemShape) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDbSystemShape(dbSystemShape)
        .build()
        .toString();
  }

  public static DbSystemShapeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DB_SYSTEM_SHAPE.validatedMatch(
            formattedString, "DbSystemShapeName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("db_system_shape"));
  }

  public static List<DbSystemShapeName> parseList(List<String> formattedStrings) {
    List<DbSystemShapeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DbSystemShapeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DbSystemShapeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DB_SYSTEM_SHAPE.matches(formattedString);
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
          if (dbSystemShape != null) {
            fieldMapBuilder.put("db_system_shape", dbSystemShape);
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
    return PROJECT_LOCATION_DB_SYSTEM_SHAPE.instantiate(
        "project", project, "location", location, "db_system_shape", dbSystemShape);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DbSystemShapeName that = ((DbSystemShapeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dbSystemShape, that.dbSystemShape);
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
    h ^= Objects.hashCode(dbSystemShape);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/dbSystemShapes/{db_system_shape}. */
  public static class Builder {
    private String project;
    private String location;
    private String dbSystemShape;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDbSystemShape() {
      return dbSystemShape;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDbSystemShape(String dbSystemShape) {
      this.dbSystemShape = dbSystemShape;
      return this;
    }

    private Builder(DbSystemShapeName dbSystemShapeName) {
      this.project = dbSystemShapeName.project;
      this.location = dbSystemShapeName.location;
      this.dbSystemShape = dbSystemShapeName.dbSystemShape;
    }

    public DbSystemShapeName build() {
      return new DbSystemShapeName(this);
    }
  }
}
