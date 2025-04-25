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

package com.google.cloud.discoveryengine.v1alpha;

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
public class DataStoreName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String collection;

  @Deprecated
  protected DataStoreName() {
    project = null;
    location = null;
    dataStore = null;
    collection = null;
  }

  private DataStoreName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    collection = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE;
  }

  private DataStoreName(ProjectLocationCollectionDataStoreBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE;
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

  public String getCollection() {
    return collection;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationDataStoreBuilder() {
    return new Builder();
  }

  public static ProjectLocationCollectionDataStoreBuilder
      newProjectLocationCollectionDataStoreBuilder() {
    return new ProjectLocationCollectionDataStoreBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataStoreName of(String project, String location, String dataStore) {
    return newBuilder().setProject(project).setLocation(location).setDataStore(dataStore).build();
  }

  public static DataStoreName ofProjectLocationDataStoreName(
      String project, String location, String dataStore) {
    return newBuilder().setProject(project).setLocation(location).setDataStore(dataStore).build();
  }

  public static DataStoreName ofProjectLocationCollectionDataStoreName(
      String project, String location, String collection, String dataStore) {
    return newProjectLocationCollectionDataStoreBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .build();
  }

  public static String format(String project, String location, String dataStore) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .build()
        .toString();
  }

  public static String formatProjectLocationDataStoreName(
      String project, String location, String dataStore) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionDataStoreName(
      String project, String location, String collection, String dataStore) {
    return newProjectLocationCollectionDataStoreBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .build()
        .toString();
  }

  public static DataStoreName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DATA_STORE.match(formattedString);
      return ofProjectLocationDataStoreName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("data_store"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_COLLECTION_DATA_STORE.match(formattedString);
      return ofProjectLocationCollectionDataStoreName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"));
    }
    throw new ValidationException("DataStoreName.parse: formattedString not in valid format");
  }

  public static List<DataStoreName> parseList(List<String> formattedStrings) {
    List<DataStoreName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataStoreName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataStoreName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE.matches(formattedString);
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
      DataStoreName that = ((DataStoreName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
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
    h ^= Objects.hashCode(collection);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/dataStores/{data_store}. */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;

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

    private Builder(DataStoreName dataStoreName) {
      Preconditions.checkArgument(
          Objects.equals(dataStoreName.pathTemplate, PROJECT_LOCATION_DATA_STORE),
          "toBuilder is only supported when DataStoreName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}");
      this.project = dataStoreName.project;
      this.location = dataStoreName.location;
      this.dataStore = dataStoreName.dataStore;
    }

    public DataStoreName build() {
      return new DataStoreName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}.
   */
  public static class ProjectLocationCollectionDataStoreBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;

    protected ProjectLocationCollectionDataStoreBuilder() {}

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

    public ProjectLocationCollectionDataStoreBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public DataStoreName build() {
      return new DataStoreName(this);
    }
  }
}
