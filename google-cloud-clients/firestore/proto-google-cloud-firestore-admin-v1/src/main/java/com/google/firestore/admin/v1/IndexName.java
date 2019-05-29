/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.firestore.admin.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class IndexName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/databases/{database}/collectionGroups/{collection_id}/indexes/{index_id}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String database;
  private final String collectionId;
  private final String indexId;

  public String getProject() {
    return project;
  }

  public String getDatabase() {
    return database;
  }

  public String getCollectionId() {
    return collectionId;
  }

  public String getIndexId() {
    return indexId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private IndexName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    database = Preconditions.checkNotNull(builder.getDatabase());
    collectionId = Preconditions.checkNotNull(builder.getCollectionId());
    indexId = Preconditions.checkNotNull(builder.getIndexId());
  }

  public static IndexName of(String project, String database, String collectionId, String indexId) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setCollectionId(collectionId)
        .setIndexId(indexId)
        .build();
  }

  public static String format(
      String project, String database, String collectionId, String indexId) {
    return newBuilder()
        .setProject(project)
        .setDatabase(database)
        .setCollectionId(collectionId)
        .setIndexId(indexId)
        .build()
        .toString();
  }

  public static IndexName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "IndexName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("database"),
        matchMap.get("collection_id"),
        matchMap.get("index_id"));
  }

  public static List<IndexName> parseList(List<String> formattedStrings) {
    List<IndexName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<IndexName> values) {
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("database", database);
          fieldMapBuilder.put("collectionId", collectionId);
          fieldMapBuilder.put("indexId", indexId);
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
    return PATH_TEMPLATE.instantiate(
        "project",
        project,
        "database",
        database,
        "collection_id",
        collectionId,
        "index_id",
        indexId);
  }

  /** Builder for IndexName. */
  public static class Builder {

    private String project;
    private String database;
    private String collectionId;
    private String indexId;

    public String getProject() {
      return project;
    }

    public String getDatabase() {
      return database;
    }

    public String getCollectionId() {
      return collectionId;
    }

    public String getIndexId() {
      return indexId;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDatabase(String database) {
      this.database = database;
      return this;
    }

    public Builder setCollectionId(String collectionId) {
      this.collectionId = collectionId;
      return this;
    }

    public Builder setIndexId(String indexId) {
      this.indexId = indexId;
      return this;
    }

    private Builder() {}

    private Builder(IndexName indexName) {
      project = indexName.project;
      database = indexName.database;
      collectionId = indexName.collectionId;
      indexId = indexName.indexId;
    }

    public IndexName build() {
      return new IndexName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof IndexName) {
      IndexName that = (IndexName) o;
      return (this.project.equals(that.project))
          && (this.database.equals(that.database))
          && (this.collectionId.equals(that.collectionId))
          && (this.indexId.equals(that.indexId));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= database.hashCode();
    h *= 1000003;
    h ^= collectionId.hashCode();
    h *= 1000003;
    h ^= indexId.hashCode();
    return h;
  }
}
