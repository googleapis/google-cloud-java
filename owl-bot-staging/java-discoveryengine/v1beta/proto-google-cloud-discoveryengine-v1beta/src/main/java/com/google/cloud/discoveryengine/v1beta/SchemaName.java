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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_SCHEMA =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/schemas/{schema}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_SCHEMA =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String schema;
  private final String collection;

  @Deprecated
  protected SchemaName() {
    project = null;
    location = null;
    dataStore = null;
    schema = null;
    collection = null;
  }

  private SchemaName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    schema = Preconditions.checkNotNull(builder.getSchema());
    collection = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_SCHEMA;
  }

  private SchemaName(ProjectLocationCollectionDataStoreSchemaBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    schema = Preconditions.checkNotNull(builder.getSchema());
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_SCHEMA;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDataStore() {
    return dataStore;
  }

  public String getSchema() {
    return schema;
  }

  public String getCollection() {
    return collection;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationDataStoreSchemaBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationCollectionDataStoreSchemaBuilder
      newProjectLocationCollectionDataStoreSchemaBuilder() {
    return new ProjectLocationCollectionDataStoreSchemaBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SchemaName of(String project, String location, String dataStore, String schema) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSchema(schema)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SchemaName ofProjectLocationDataStoreSchemaName(
      String project, String location, String dataStore, String schema) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSchema(schema)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SchemaName ofProjectLocationCollectionDataStoreSchemaName(
      String project, String location, String collection, String dataStore, String schema) {
    return newProjectLocationCollectionDataStoreSchemaBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setSchema(schema)
        .build();
  }

  public static String format(String project, String location, String dataStore, String schema) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSchema(schema)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationDataStoreSchemaName(
      String project, String location, String dataStore, String schema) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSchema(schema)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationCollectionDataStoreSchemaName(
      String project, String location, String collection, String dataStore, String schema) {
    return newProjectLocationCollectionDataStoreSchemaBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setSchema(schema)
        .build()
        .toString();
  }

  public static SchemaName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_SCHEMA.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DATA_STORE_SCHEMA.match(formattedString);
      return ofProjectLocationDataStoreSchemaName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("schema"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_SCHEMA.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_SCHEMA.match(formattedString);
      return ofProjectLocationCollectionDataStoreSchemaName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("schema"));
    }
    throw new ValidationException("SchemaName.parse: formattedString not in valid format");
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
    return PROJECT_LOCATION_DATA_STORE_SCHEMA.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_SCHEMA.matches(formattedString);
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
          if (dataStore != null) {
            fieldMapBuilder.put("data_store", dataStore);
          }
          if (schema != null) {
            fieldMapBuilder.put("schema", schema);
          }
          if (collection != null) {
            fieldMapBuilder.put("collection", collection);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SchemaName that = ((SchemaName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.schema, that.schema)
          && Objects.equals(this.collection, that.collection);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(dataStore);
    h *= 1000003;
    h ^= Objects.hashCode(schema);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/dataStores/{data_store}/schemas/{schema}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String schema;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDataStore() {
      return dataStore;
    }

    public String getSchema() {
      return schema;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public Builder setSchema(String schema) {
      this.schema = schema;
      return this;
    }

    private Builder(SchemaName schemaName) {
      Preconditions.checkArgument(
          Objects.equals(schemaName.pathTemplate, PROJECT_LOCATION_DATA_STORE_SCHEMA),
          "toBuilder is only supported when SchemaName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/schemas/{schema}");
      this.project = schemaName.project;
      this.location = schemaName.location;
      this.dataStore = schemaName.dataStore;
      this.schema = schemaName.schema;
    }

    public SchemaName build() {
      return new SchemaName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/schemas/{schema}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationCollectionDataStoreSchemaBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String schema;

    protected ProjectLocationCollectionDataStoreSchemaBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCollection() {
      return collection;
    }

    public String getDataStore() {
      return dataStore;
    }

    public String getSchema() {
      return schema;
    }

    public ProjectLocationCollectionDataStoreSchemaBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreSchemaBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreSchemaBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreSchemaBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreSchemaBuilder setSchema(String schema) {
      this.schema = schema;
      return this;
    }

    public SchemaName build() {
      return new SchemaName(this);
    }
  }
}
