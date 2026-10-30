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

package com.google.cloud.discoveryengine.v1;

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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class WidgetConfigName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_WIDGET_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/widgetConfigs/{widget_config}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_WIDGET_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/widgetConfigs/{widget_config}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_ENGINE_WIDGET_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/widgetConfigs/{widget_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String widgetConfig;
  private final String collection;
  private final String engine;

  @Deprecated
  protected WidgetConfigName() {
    project = null;
    location = null;
    dataStore = null;
    widgetConfig = null;
    collection = null;
    engine = null;
  }

  private WidgetConfigName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    widgetConfig = Preconditions.checkNotNull(builder.getWidgetConfig());
    collection = null;
    engine = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_WIDGET_CONFIG;
  }

  private WidgetConfigName(ProjectLocationCollectionDataStoreWidgetConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    widgetConfig = Preconditions.checkNotNull(builder.getWidgetConfig());
    engine = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_WIDGET_CONFIG;
  }

  private WidgetConfigName(ProjectLocationCollectionEngineWidgetConfigBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    engine = Preconditions.checkNotNull(builder.getEngine());
    widgetConfig = Preconditions.checkNotNull(builder.getWidgetConfig());
    dataStore = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_ENGINE_WIDGET_CONFIG;
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

  public String getWidgetConfig() {
    return widgetConfig;
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

  public static Builder newProjectLocationDataStoreWidgetConfigBuilder() {
    return new Builder();
  }

  public static ProjectLocationCollectionDataStoreWidgetConfigBuilder
      newProjectLocationCollectionDataStoreWidgetConfigBuilder() {
    return new ProjectLocationCollectionDataStoreWidgetConfigBuilder();
  }

  public static ProjectLocationCollectionEngineWidgetConfigBuilder
      newProjectLocationCollectionEngineWidgetConfigBuilder() {
    return new ProjectLocationCollectionEngineWidgetConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WidgetConfigName of(
      String project, String location, String dataStore, String widgetConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setWidgetConfig(widgetConfig)
        .build();
  }

  public static WidgetConfigName ofProjectLocationDataStoreWidgetConfigName(
      String project, String location, String dataStore, String widgetConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setWidgetConfig(widgetConfig)
        .build();
  }

  public static WidgetConfigName ofProjectLocationCollectionDataStoreWidgetConfigName(
      String project, String location, String collection, String dataStore, String widgetConfig) {
    return newProjectLocationCollectionDataStoreWidgetConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setWidgetConfig(widgetConfig)
        .build();
  }

  public static WidgetConfigName ofProjectLocationCollectionEngineWidgetConfigName(
      String project, String location, String collection, String engine, String widgetConfig) {
    return newProjectLocationCollectionEngineWidgetConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setWidgetConfig(widgetConfig)
        .build();
  }

  public static String format(
      String project, String location, String dataStore, String widgetConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setWidgetConfig(widgetConfig)
        .build()
        .toString();
  }

  public static String formatProjectLocationDataStoreWidgetConfigName(
      String project, String location, String dataStore, String widgetConfig) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setWidgetConfig(widgetConfig)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionDataStoreWidgetConfigName(
      String project, String location, String collection, String dataStore, String widgetConfig) {
    return newProjectLocationCollectionDataStoreWidgetConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setWidgetConfig(widgetConfig)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionEngineWidgetConfigName(
      String project, String location, String collection, String engine, String widgetConfig) {
    return newProjectLocationCollectionEngineWidgetConfigBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setWidgetConfig(widgetConfig)
        .build()
        .toString();
  }

  public static @Nullable WidgetConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_WIDGET_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_DATA_STORE_WIDGET_CONFIG.match(formattedString);
      return ofProjectLocationDataStoreWidgetConfigName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("widget_config"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_WIDGET_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_WIDGET_CONFIG.match(formattedString);
      return ofProjectLocationCollectionDataStoreWidgetConfigName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("widget_config"));
    } else if (PROJECT_LOCATION_COLLECTION_ENGINE_WIDGET_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_ENGINE_WIDGET_CONFIG.match(formattedString);
      return ofProjectLocationCollectionEngineWidgetConfigName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("engine"),
          matchMap.get("widget_config"));
    }
    throw new ValidationException("WidgetConfigName.parse: formattedString not in valid format");
  }

  public static List<WidgetConfigName> parseList(List<String> formattedStrings) {
    List<WidgetConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable WidgetConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WidgetConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_WIDGET_CONFIG.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_WIDGET_CONFIG.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_ENGINE_WIDGET_CONFIG.matches(formattedString);
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
          if (widgetConfig != null) {
            fieldMapBuilder.put("widget_config", widgetConfig);
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
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WidgetConfigName that = ((WidgetConfigName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.widgetConfig, that.widgetConfig)
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
    h ^= Objects.hashCode(widgetConfig);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(engine);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataStores/{data_store}/widgetConfigs/{widget_config}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String widgetConfig;

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

    public String getWidgetConfig() {
      return widgetConfig;
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

    public Builder setWidgetConfig(String widgetConfig) {
      this.widgetConfig = widgetConfig;
      return this;
    }

    private Builder(WidgetConfigName widgetConfigName) {
      Preconditions.checkArgument(
          Objects.equals(widgetConfigName.pathTemplate, PROJECT_LOCATION_DATA_STORE_WIDGET_CONFIG),
          "toBuilder is only supported when WidgetConfigName has the pattern of"
              + " projects/{project}/locations/{location}/dataStores/{data_store}/widgetConfigs/{widget_config}");
      this.project = widgetConfigName.project;
      this.location = widgetConfigName.location;
      this.dataStore = widgetConfigName.dataStore;
      this.widgetConfig = widgetConfigName.widgetConfig;
    }

    public WidgetConfigName build() {
      return new WidgetConfigName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/widgetConfigs/{widget_config}.
   */
  public static class ProjectLocationCollectionDataStoreWidgetConfigBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String widgetConfig;

    protected ProjectLocationCollectionDataStoreWidgetConfigBuilder() {}

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

    public String getWidgetConfig() {
      return widgetConfig;
    }

    public ProjectLocationCollectionDataStoreWidgetConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreWidgetConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreWidgetConfigBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreWidgetConfigBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreWidgetConfigBuilder setWidgetConfig(
        String widgetConfig) {
      this.widgetConfig = widgetConfig;
      return this;
    }

    public WidgetConfigName build() {
      return new WidgetConfigName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/widgetConfigs/{widget_config}.
   */
  public static class ProjectLocationCollectionEngineWidgetConfigBuilder {
    private String project;
    private String location;
    private String collection;
    private String engine;
    private String widgetConfig;

    protected ProjectLocationCollectionEngineWidgetConfigBuilder() {}

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

    public String getWidgetConfig() {
      return widgetConfig;
    }

    public ProjectLocationCollectionEngineWidgetConfigBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionEngineWidgetConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionEngineWidgetConfigBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionEngineWidgetConfigBuilder setEngine(String engine) {
      this.engine = engine;
      return this;
    }

    public ProjectLocationCollectionEngineWidgetConfigBuilder setWidgetConfig(String widgetConfig) {
      this.widgetConfig = widgetConfig;
      return this;
    }

    public WidgetConfigName build() {
      return new WidgetConfigName(this);
    }
  }
}
