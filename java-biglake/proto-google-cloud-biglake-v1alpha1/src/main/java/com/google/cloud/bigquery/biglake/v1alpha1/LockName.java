/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigquery.biglake.v1alpha1;

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
public class LockName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CATALOG_DATABASE_LOCK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/databases/{database}/locks/{lock}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String catalog;
  private final String database;
  private final String lock;

  @Deprecated
  protected LockName() {
    project = null;
    location = null;
    catalog = null;
    database = null;
    lock = null;
  }

  private LockName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
    database = Preconditions.checkNotNull(builder.getDatabase());
    lock = Preconditions.checkNotNull(builder.getLock());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCatalog() {
    return catalog;
  }

  public String getDatabase() {
    return database;
  }

  public String getLock() {
    return lock;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LockName of(
      String project, String location, String catalog, String database, String lock) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setDatabase(database)
        .setLock(lock)
        .build();
  }

  public static String format(
      String project, String location, String catalog, String database, String lock) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCatalog(catalog)
        .setDatabase(database)
        .setLock(lock)
        .build()
        .toString();
  }

  public static LockName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CATALOG_DATABASE_LOCK.validatedMatch(
            formattedString, "LockName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("catalog"),
        matchMap.get("database"),
        matchMap.get("lock"));
  }

  public static List<LockName> parseList(List<String> formattedStrings) {
    List<LockName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LockName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LockName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CATALOG_DATABASE_LOCK.matches(formattedString);
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
          if (catalog != null) {
            fieldMapBuilder.put("catalog", catalog);
          }
          if (database != null) {
            fieldMapBuilder.put("database", database);
          }
          if (lock != null) {
            fieldMapBuilder.put("lock", lock);
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
    return PROJECT_LOCATION_CATALOG_DATABASE_LOCK.instantiate(
        "project",
        project,
        "location",
        location,
        "catalog",
        catalog,
        "database",
        database,
        "lock",
        lock);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LockName that = ((LockName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.catalog, that.catalog)
          && Objects.equals(this.database, that.database)
          && Objects.equals(this.lock, that.lock);
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
    h ^= Objects.hashCode(catalog);
    h *= 1000003;
    h ^= Objects.hashCode(database);
    h *= 1000003;
    h ^= Objects.hashCode(lock);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/catalogs/{catalog}/databases/{database}/locks/{lock}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String catalog;
    private String database;
    private String lock;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCatalog() {
      return catalog;
    }

    public String getDatabase() {
      return database;
    }

    public String getLock() {
      return lock;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCatalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    public Builder setDatabase(String database) {
      this.database = database;
      return this;
    }

    public Builder setLock(String lock) {
      this.lock = lock;
      return this;
    }

    private Builder(LockName lockName) {
      this.project = lockName.project;
      this.location = lockName.location;
      this.catalog = lockName.catalog;
      this.database = lockName.database;
      this.lock = lockName.lock;
    }

    public LockName build() {
      return new LockName(this);
    }
  }
}
