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

package com.google.cloud.biglake.hive.v1beta;

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
public class NamespaceName implements ResourceName {
  private static final PathTemplate PROJECT_CATALOG_DATABASE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/catalogs/{catalog}/databases/{database}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String catalog;
  private final String database;

  @Deprecated
  protected NamespaceName() {
    project = null;
    catalog = null;
    database = null;
  }

  private NamespaceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
    database = Preconditions.checkNotNull(builder.getDatabase());
  }

  public String getProject() {
    return project;
  }

  public String getCatalog() {
    return catalog;
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

  public static NamespaceName of(String project, String catalog, String database) {
    return newBuilder().setProject(project).setCatalog(catalog).setDatabase(database).build();
  }

  public static String format(String project, String catalog, String database) {
    return newBuilder()
        .setProject(project)
        .setCatalog(catalog)
        .setDatabase(database)
        .build()
        .toString();
  }

  public static NamespaceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_CATALOG_DATABASE.validatedMatch(
            formattedString, "NamespaceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("catalog"), matchMap.get("database"));
  }

  public static List<NamespaceName> parseList(List<String> formattedStrings) {
    List<NamespaceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NamespaceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NamespaceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CATALOG_DATABASE.matches(formattedString);
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
          if (catalog != null) {
            fieldMapBuilder.put("catalog", catalog);
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
    return PROJECT_CATALOG_DATABASE.instantiate(
        "project", project, "catalog", catalog, "database", database);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NamespaceName that = ((NamespaceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.catalog, that.catalog)
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
    h ^= Objects.hashCode(catalog);
    h *= 1000003;
    h ^= Objects.hashCode(database);
    return h;
  }

  /** Builder for projects/{project}/catalogs/{catalog}/databases/{database}. */
  public static class Builder {
    private String project;
    private String catalog;
    private String database;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getCatalog() {
      return catalog;
    }

    public String getDatabase() {
      return database;
    }

    public Builder setProject(String project) {
      this.project = project;
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

    private Builder(NamespaceName namespaceName) {
      this.project = namespaceName.project;
      this.catalog = namespaceName.catalog;
      this.database = namespaceName.database;
    }

    public NamespaceName build() {
      return new NamespaceName(this);
    }
  }
}
