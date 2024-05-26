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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class ControlName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_CONTROL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/controls/{control}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_CONTROL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/controls/{control}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_ENGINE_CONTROL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/controls/{control}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String control;
  private final String collection;
  private final String engine;

  @Deprecated
  protected ControlName() {
    project = null;
    location = null;
    dataStore = null;
    control = null;
    collection = null;
    engine = null;
  }

  private ControlName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    control = Preconditions.checkNotNull(builder.getControl());
    collection = null;
    engine = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_CONTROL;
  }

  private ControlName(ProjectLocationCollectionDataStoreControlBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    control = Preconditions.checkNotNull(builder.getControl());
    engine = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_CONTROL;
  }

  private ControlName(ProjectLocationCollectionEngineControlBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    engine = Preconditions.checkNotNull(builder.getEngine());
    control = Preconditions.checkNotNull(builder.getControl());
    dataStore = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_ENGINE_CONTROL;
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

  public String getControl() {
    return control;
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

  public static Builder newProjectLocationDataStoreControlBuilder() {
    return new Builder();
  }

  public static ProjectLocationCollectionDataStoreControlBuilder
      newProjectLocationCollectionDataStoreControlBuilder() {
    return new ProjectLocationCollectionDataStoreControlBuilder();
  }

  public static ProjectLocationCollectionEngineControlBuilder
      newProjectLocationCollectionEngineControlBuilder() {
    return new ProjectLocationCollectionEngineControlBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ControlName of(String project, String location, String dataStore, String control) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setControl(control)
        .build();
  }

  public static ControlName ofProjectLocationDataStoreControlName(
      String project, String location, String dataStore, String control) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setControl(control)
        .build();
  }

  public static ControlName ofProjectLocationCollectionDataStoreControlName(
      String project, String location, String collection, String dataStore, String control) {
    return newProjectLocationCollectionDataStoreControlBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setControl(control)
        .build();
  }

  public static ControlName ofProjectLocationCollectionEngineControlName(
      String project, String location, String collection, String engine, String control) {
    return newProjectLocationCollectionEngineControlBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setControl(control)
        .build();
  }

  public static String format(String project, String location, String dataStore, String control) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setControl(control)
        .build()
        .toString();
  }

  public static String formatProjectLocationDataStoreControlName(
      String project, String location, String dataStore, String control) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setControl(control)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionDataStoreControlName(
      String project, String location, String collection, String dataStore, String control) {
    return newProjectLocationCollectionDataStoreControlBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setControl(control)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionEngineControlName(
      String project, String location, String collection, String engine, String control) {
    return newProjectLocationCollectionEngineControlBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setControl(control)
        .build()
        .toString();
  }

  public static ControlName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_CONTROL.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DATA_STORE_CONTROL.match(formattedString);
      return ofProjectLocationDataStoreControlName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("control"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_CONTROL.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_CONTROL.match(formattedString);
      return ofProjectLocationCollectionDataStoreControlName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("control"));
    } else if (PROJECT_LOCATION_COLLECTION_ENGINE_CONTROL.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_ENGINE_CONTROL.match(formattedString);
      return ofProjectLocationCollectionEngineControlName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("engine"),
          matchMap.get("control"));
    }
    throw new ValidationException("ControlName.parse: formattedString not in valid format");
  }

  public static List<ControlName> parseList(List<String> formattedStrings) {
    List<ControlName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ControlName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ControlName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_CONTROL.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_CONTROL.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_ENGINE_CONTROL.matches(formattedString);
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
          if (control != null) {
            fieldMapBuilder.put("control", control);
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
      ControlName that = ((ControlName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.control, that.control)
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
    h ^= Objects.hashCode(control);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(engine);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/dataStores/{data_store}/controls/{control}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String control;

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

    public String getControl() {
      return control;
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

    public Builder setControl(String control) {
      this.control = control;
      return this;
    }

    private Builder(ControlName controlName) {
      Preconditions.checkArgument(
          Objects.equals(controlName.pathTemplate, PROJECT_LOCATION_DATA_STORE_CONTROL),
          "toBuilder is only supported when ControlName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/controls/{control}");
      this.project = controlName.project;
      this.location = controlName.location;
      this.dataStore = controlName.dataStore;
      this.control = controlName.control;
    }

    public ControlName build() {
      return new ControlName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/controls/{control}.
   */
  public static class ProjectLocationCollectionDataStoreControlBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String control;

    protected ProjectLocationCollectionDataStoreControlBuilder() {}

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

    public String getControl() {
      return control;
    }

    public ProjectLocationCollectionDataStoreControlBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreControlBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreControlBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreControlBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreControlBuilder setControl(String control) {
      this.control = control;
      return this;
    }

    public ControlName build() {
      return new ControlName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/controls/{control}.
   */
  public static class ProjectLocationCollectionEngineControlBuilder {
    private String project;
    private String location;
    private String collection;
    private String engine;
    private String control;

    protected ProjectLocationCollectionEngineControlBuilder() {}

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

    public String getControl() {
      return control;
    }

    public ProjectLocationCollectionEngineControlBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionEngineControlBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionEngineControlBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionEngineControlBuilder setEngine(String engine) {
      this.engine = engine;
      return this;
    }

    public ProjectLocationCollectionEngineControlBuilder setControl(String control) {
      this.control = control;
      return this;
    }

    public ControlName build() {
      return new ControlName(this);
    }
  }
}
