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
public class ServingConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_SERVING_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/servingConfigs/{serving_config}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_SERVING_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/servingConfigs/{serving_config}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_ENGINE_SERVING_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/servingConfigs/{serving_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String servingConfig;
  private final String collection;
  private final String engine;

  @Deprecated
  protected ServingConfigName() {
    project = null;
    location = null;
    dataStore = null;
    servingConfig = null;
    collection = null;
    engine = null;
  }

  private ServingConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    servingConfig = Preconditions.checkNotNull(builder.getServingConfig());
    collection = null;
    engine = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_SERVING_CONFIG;
  }

  private ServingConfigName(ProjectLocationCollectionDataStoreServingConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    servingConfig = Preconditions.checkNotNull(builder.getServingConfig());
    engine = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_SERVING_CONFIG;
  }

  private ServingConfigName(ProjectLocationCollectionEngineServingConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    engine = Preconditions.checkNotNull(builder.getEngine());
    servingConfig = Preconditions.checkNotNull(builder.getServingConfig());
    dataStore = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_ENGINE_SERVING_CONFIG;
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

  public String getServingConfig() {
    return servingConfig;
  }

  public String getCollection() {
    return collection;
  }

  public String getEngine() {
    return engine;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationDataStoreServingConfigBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationCollectionDataStoreServingConfigBuilder
      newProjectLocationCollectionDataStoreServingConfigBuilder() {
    return new ProjectLocationCollectionDataStoreServingConfigBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationCollectionEngineServingConfigBuilder
      newProjectLocationCollectionEngineServingConfigBuilder() {
    return new ProjectLocationCollectionEngineServingConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ServingConfigName of(
      String project, String location, String dataStore, String servingConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setServingConfig(servingConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServingConfigName ofProjectLocationDataStoreServingConfigName(
      String project, String location, String dataStore, String servingConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setServingConfig(servingConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServingConfigName ofProjectLocationCollectionDataStoreServingConfigName(
      String project, String location, String collection, String dataStore, String servingConfig) {
    return newProjectLocationCollectionDataStoreServingConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setServingConfig(servingConfig)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ServingConfigName ofProjectLocationCollectionEngineServingConfigName(
      String project, String location, String collection, String engine, String servingConfig) {
    return newProjectLocationCollectionEngineServingConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setServingConfig(servingConfig)
        .build();
  }

  public static String format(
      String project, String location, String dataStore, String servingConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setServingConfig(servingConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationDataStoreServingConfigName(
      String project, String location, String dataStore, String servingConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setServingConfig(servingConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationCollectionDataStoreServingConfigName(
      String project, String location, String collection, String dataStore, String servingConfig) {
    return newProjectLocationCollectionDataStoreServingConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setServingConfig(servingConfig)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationCollectionEngineServingConfigName(
      String project, String location, String collection, String engine, String servingConfig) {
    return newProjectLocationCollectionEngineServingConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setServingConfig(servingConfig)
        .build()
        .toString();
  }

  public static ServingConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_SERVING_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_DATA_STORE_SERVING_CONFIG.match(formattedString);
      return ofProjectLocationDataStoreServingConfigName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("serving_config"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_SERVING_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_SERVING_CONFIG.match(formattedString);
      return ofProjectLocationCollectionDataStoreServingConfigName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("serving_config"));
    } else if (PROJECT_LOCATION_COLLECTION_ENGINE_SERVING_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_ENGINE_SERVING_CONFIG.match(formattedString);
      return ofProjectLocationCollectionEngineServingConfigName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("engine"),
          matchMap.get("serving_config"));
    }
    throw new ValidationException("ServingConfigName.parse: formattedString not in valid format");
  }

  public static List<ServingConfigName> parseList(List<String> formattedStrings) {
    List<ServingConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServingConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ServingConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_SERVING_CONFIG.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_SERVING_CONFIG.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_ENGINE_SERVING_CONFIG.matches(formattedString);
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
          if (servingConfig != null) {
            fieldMapBuilder.put("serving_config", servingConfig);
          }
          if (collection != null) {
            fieldMapBuilder.put("collection", collection);
          }
          if (engine != null) {
            fieldMapBuilder.put("engine", engine);
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
      ServingConfigName that = ((ServingConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.servingConfig, that.servingConfig)
          && Objects.equals(this.collection, that.collection)
          && Objects.equals(this.engine, that.engine);
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
    h ^= Objects.hashCode(servingConfig);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(engine);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataStores/{data_store}/servingConfigs/{serving_config}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String servingConfig;

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

    public String getServingConfig() {
      return servingConfig;
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

    public Builder setServingConfig(String servingConfig) {
      this.servingConfig = servingConfig;
      return this;
    }

    private Builder(ServingConfigName servingConfigName) {
      Preconditions.checkArgument(
          Objects.equals(
              servingConfigName.pathTemplate, PROJECT_LOCATION_DATA_STORE_SERVING_CONFIG),
          "toBuilder is only supported when ServingConfigName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/servingConfigs/{serving_config}");
      this.project = servingConfigName.project;
      this.location = servingConfigName.location;
      this.dataStore = servingConfigName.dataStore;
      this.servingConfig = servingConfigName.servingConfig;
    }

    public ServingConfigName build() {
      return new ServingConfigName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/servingConfigs/{serving_config}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationCollectionDataStoreServingConfigBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String servingConfig;

    protected ProjectLocationCollectionDataStoreServingConfigBuilder() {}

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

    public String getServingConfig() {
      return servingConfig;
    }

    public ProjectLocationCollectionDataStoreServingConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreServingConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreServingConfigBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreServingConfigBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreServingConfigBuilder setServingConfig(
        String servingConfig) {
      this.servingConfig = servingConfig;
      return this;
    }

    public ServingConfigName build() {
      return new ServingConfigName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/servingConfigs/{serving_config}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationCollectionEngineServingConfigBuilder {
    private String project;
    private String location;
    private String collection;
    private String engine;
    private String servingConfig;

    protected ProjectLocationCollectionEngineServingConfigBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCollection() {
      return collection;
    }

    public String getEngine() {
      return engine;
    }

    public String getServingConfig() {
      return servingConfig;
    }

    public ProjectLocationCollectionEngineServingConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionEngineServingConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionEngineServingConfigBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionEngineServingConfigBuilder setEngine(String engine) {
      this.engine = engine;
      return this;
    }

    public ProjectLocationCollectionEngineServingConfigBuilder setServingConfig(
        String servingConfig) {
      this.servingConfig = servingConfig;
      return this;
    }

    public ServingConfigName build() {
      return new ServingConfigName(this);
    }
  }
}
