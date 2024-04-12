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
public class SessionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/sessions/{session}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/sessions/{session}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_ENGINE_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/sessions/{session}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String session;
  private final String collection;
  private final String engine;

  @Deprecated
  protected SessionName() {
    project = null;
    location = null;
    dataStore = null;
    session = null;
    collection = null;
    engine = null;
  }

  private SessionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    session = Preconditions.checkNotNull(builder.getSession());
    collection = null;
    engine = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_SESSION;
  }

  private SessionName(ProjectLocationCollectionDataStoreSessionBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    session = Preconditions.checkNotNull(builder.getSession());
    engine = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION;
  }

  private SessionName(ProjectLocationCollectionEngineSessionBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    engine = Preconditions.checkNotNull(builder.getEngine());
    session = Preconditions.checkNotNull(builder.getSession());
    dataStore = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_ENGINE_SESSION;
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

  public String getSession() {
    return session;
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

  public static Builder newProjectLocationDataStoreSessionBuilder() {
    return new Builder();
  }

  public static ProjectLocationCollectionDataStoreSessionBuilder
      newProjectLocationCollectionDataStoreSessionBuilder() {
    return new ProjectLocationCollectionDataStoreSessionBuilder();
  }

  public static ProjectLocationCollectionEngineSessionBuilder
      newProjectLocationCollectionEngineSessionBuilder() {
    return new ProjectLocationCollectionEngineSessionBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SessionName of(String project, String location, String dataStore, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSession(session)
        .build();
  }

  public static SessionName ofProjectLocationDataStoreSessionName(
      String project, String location, String dataStore, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSession(session)
        .build();
  }

  public static SessionName ofProjectLocationCollectionDataStoreSessionName(
      String project, String location, String collection, String dataStore, String session) {
    return newProjectLocationCollectionDataStoreSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setSession(session)
        .build();
  }

  public static SessionName ofProjectLocationCollectionEngineSessionName(
      String project, String location, String collection, String engine, String session) {
    return newProjectLocationCollectionEngineSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setSession(session)
        .build();
  }

  public static String format(String project, String location, String dataStore, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSession(session)
        .build()
        .toString();
  }

  public static String formatProjectLocationDataStoreSessionName(
      String project, String location, String dataStore, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSession(session)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionDataStoreSessionName(
      String project, String location, String collection, String dataStore, String session) {
    return newProjectLocationCollectionDataStoreSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setSession(session)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionEngineSessionName(
      String project, String location, String collection, String engine, String session) {
    return newProjectLocationCollectionEngineSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setSession(session)
        .build()
        .toString();
  }

  public static SessionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_SESSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_DATA_STORE_SESSION.match(formattedString);
      return ofProjectLocationDataStoreSessionName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("session"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION.match(formattedString);
      return ofProjectLocationCollectionDataStoreSessionName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("session"));
    } else if (PROJECT_LOCATION_COLLECTION_ENGINE_SESSION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_ENGINE_SESSION.match(formattedString);
      return ofProjectLocationCollectionEngineSessionName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("engine"),
          matchMap.get("session"));
    }
    throw new ValidationException("SessionName.parse: formattedString not in valid format");
  }

  public static List<SessionName> parseList(List<String> formattedStrings) {
    List<SessionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SessionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SessionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_SESSION.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_ENGINE_SESSION.matches(formattedString);
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
          if (session != null) {
            fieldMapBuilder.put("session", session);
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
      SessionName that = ((SessionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.session, that.session)
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
    h ^= Objects.hashCode(session);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(engine);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/dataStores/{data_store}/sessions/{session}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String session;

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

    public String getSession() {
      return session;
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

    public Builder setSession(String session) {
      this.session = session;
      return this;
    }

    private Builder(SessionName sessionName) {
      Preconditions.checkArgument(
          Objects.equals(sessionName.pathTemplate, PROJECT_LOCATION_DATA_STORE_SESSION),
          "toBuilder is only supported when SessionName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/sessions/{session}");
      this.project = sessionName.project;
      this.location = sessionName.location;
      this.dataStore = sessionName.dataStore;
      this.session = sessionName.session;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/sessions/{session}.
   */
  public static class ProjectLocationCollectionDataStoreSessionBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String session;

    protected ProjectLocationCollectionDataStoreSessionBuilder() {}

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

    public String getSession() {
      return session;
    }

    public ProjectLocationCollectionDataStoreSessionBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/sessions/{session}.
   */
  public static class ProjectLocationCollectionEngineSessionBuilder {
    private String project;
    private String location;
    private String collection;
    private String engine;
    private String session;

    protected ProjectLocationCollectionEngineSessionBuilder() {}

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

    public String getSession() {
      return session;
    }

    public ProjectLocationCollectionEngineSessionBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionEngineSessionBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionEngineSessionBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionEngineSessionBuilder setEngine(String engine) {
      this.engine = engine;
      return this;
    }

    public ProjectLocationCollectionEngineSessionBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }
}
