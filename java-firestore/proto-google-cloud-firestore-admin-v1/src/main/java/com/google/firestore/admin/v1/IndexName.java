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
public class IndexName implements ResourceName {
  private static final PathTemplate PROJECT_DATABASE_COLLECTION_INDEX =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/databases/{database}/collectionGroups/{collection}/indexes/{index}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String database;
  private final String collection;
  private final String index;

  @Deprecated
  protected IndexName() {
    project = null;
    database = null;
    collection = null;
    index = null;
  }

  private IndexName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    database = Preconditions.checkNotNull(builder.getDatabase());
    collection = Preconditions.checkNotNull(builder.getCollection());
    index = Preconditions.checkNotNull(builder.getIndex());
  }

  public String getProject() {
    return project;
  }

  public String getDatabase() {
    return database;
  }

  public String getCollection() {
    return collection;
  }

  public String getIndex() {
    return index;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static IndexName of(String project, String database, String collection, String index) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setCollection(collection)
        .setIndex(index)
        .build();
  }

  public static String format(String project, String database, String collection, String index) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setCollection(collection)
        .setIndex(index)
        .build()
        .toString();
  }

  public static IndexName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_DATABASE_COLLECTION_INDEX.validatedMatch(
            formattedString, "IndexName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("database"),
        matchMap.get("collection"),
        matchMap.get("index"));
  }

  public static List<IndexName> parseList(List<String> formattedStrings) {
    List<IndexName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<IndexName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (IndexName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_DATABASE_COLLECTION_INDEX.matches(formattedString);
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
          if (collection != null) {
            fieldMapBuilder.put("collection", collection);
          }
          if (index != null) {
            fieldMapBuilder.put("index", index);
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
    return PROJECT_DATABASE_COLLECTION_INDEX.instantiate(
        "project", project, "database", database, "collection", collection, "index", index);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      IndexName that = ((IndexName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.database, that.database)
          && Objects.equals(this.collection, that.collection)
          && Objects.equals(this.index, that.index);
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
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(index);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/databases/{database}/collectionGroups/{collection}/indexes/{index}.
   */
  public static class Builder {
    private String project;
    private String database;
    private String collection;
    private String index;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getDatabase() {
      return database;
    }

    public String getCollection() {
      return collection;
    }

    public String getIndex() {
      return index;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDatabase(String database) {
      this.database = database;
      return this;
    }

    public Builder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public Builder setIndex(String index) {
      this.index = index;
      return this;
    }

    private Builder(IndexName indexName) {
      this.project = indexName.project;
      this.database = indexName.database;
      this.collection = indexName.collection;
      this.index = indexName.index;
    }

    public IndexName build() {
      return new IndexName(this);
    }
  }
}
