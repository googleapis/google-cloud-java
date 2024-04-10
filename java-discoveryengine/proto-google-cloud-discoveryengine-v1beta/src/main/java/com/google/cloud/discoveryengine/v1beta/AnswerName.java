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
public class AnswerName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_SESSION_ANSWER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/sessions/{session}/answers/{answer}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION_ANSWER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/sessions/{session}/answers/{answer}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_ENGINE_SESSION_ANSWER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/sessions/{session}/answers/{answer}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String session;
  private final String answer;
  private final String collection;
  private final String engine;

  @Deprecated
  protected AnswerName() {
    project = null;
    location = null;
    dataStore = null;
    session = null;
    answer = null;
    collection = null;
    engine = null;
  }

  private AnswerName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    session = Preconditions.checkNotNull(builder.getSession());
    answer = Preconditions.checkNotNull(builder.getAnswer());
    collection = null;
    engine = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_SESSION_ANSWER;
  }

  private AnswerName(ProjectLocationCollectionDataStoreSessionAnswerBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    session = Preconditions.checkNotNull(builder.getSession());
    answer = Preconditions.checkNotNull(builder.getAnswer());
    engine = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION_ANSWER;
  }

  private AnswerName(ProjectLocationCollectionEngineSessionAnswerBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    engine = Preconditions.checkNotNull(builder.getEngine());
    session = Preconditions.checkNotNull(builder.getSession());
    answer = Preconditions.checkNotNull(builder.getAnswer());
    dataStore = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_ENGINE_SESSION_ANSWER;
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

  public String getAnswer() {
    return answer;
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

  public static Builder newProjectLocationDataStoreSessionAnswerBuilder() {
    return new Builder();
  }

  public static ProjectLocationCollectionDataStoreSessionAnswerBuilder
      newProjectLocationCollectionDataStoreSessionAnswerBuilder() {
    return new ProjectLocationCollectionDataStoreSessionAnswerBuilder();
  }

  public static ProjectLocationCollectionEngineSessionAnswerBuilder
      newProjectLocationCollectionEngineSessionAnswerBuilder() {
    return new ProjectLocationCollectionEngineSessionAnswerBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AnswerName of(
      String project, String location, String dataStore, String session, String answer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSession(session)
        .setAnswer(answer)
        .build();
  }

  public static AnswerName ofProjectLocationDataStoreSessionAnswerName(
      String project, String location, String dataStore, String session, String answer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSession(session)
        .setAnswer(answer)
        .build();
  }

  public static AnswerName ofProjectLocationCollectionDataStoreSessionAnswerName(
      String project,
      String location,
      String collection,
      String dataStore,
      String session,
      String answer) {
    return newProjectLocationCollectionDataStoreSessionAnswerBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setSession(session)
        .setAnswer(answer)
        .build();
  }

  public static AnswerName ofProjectLocationCollectionEngineSessionAnswerName(
      String project,
      String location,
      String collection,
      String engine,
      String session,
      String answer) {
    return newProjectLocationCollectionEngineSessionAnswerBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setSession(session)
        .setAnswer(answer)
        .build();
  }

  public static String format(
      String project, String location, String dataStore, String session, String answer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSession(session)
        .setAnswer(answer)
        .build()
        .toString();
  }

  public static String formatProjectLocationDataStoreSessionAnswerName(
      String project, String location, String dataStore, String session, String answer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setSession(session)
        .setAnswer(answer)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionDataStoreSessionAnswerName(
      String project,
      String location,
      String collection,
      String dataStore,
      String session,
      String answer) {
    return newProjectLocationCollectionDataStoreSessionAnswerBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setSession(session)
        .setAnswer(answer)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionEngineSessionAnswerName(
      String project,
      String location,
      String collection,
      String engine,
      String session,
      String answer) {
    return newProjectLocationCollectionEngineSessionAnswerBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setSession(session)
        .setAnswer(answer)
        .build()
        .toString();
  }

  public static AnswerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_SESSION_ANSWER.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_DATA_STORE_SESSION_ANSWER.match(formattedString);
      return ofProjectLocationDataStoreSessionAnswerName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("session"),
          matchMap.get("answer"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION_ANSWER.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION_ANSWER.match(formattedString);
      return ofProjectLocationCollectionDataStoreSessionAnswerName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("session"),
          matchMap.get("answer"));
    } else if (PROJECT_LOCATION_COLLECTION_ENGINE_SESSION_ANSWER.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_ENGINE_SESSION_ANSWER.match(formattedString);
      return ofProjectLocationCollectionEngineSessionAnswerName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("engine"),
          matchMap.get("session"),
          matchMap.get("answer"));
    }
    throw new ValidationException("AnswerName.parse: formattedString not in valid format");
  }

  public static List<AnswerName> parseList(List<String> formattedStrings) {
    List<AnswerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnswerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AnswerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_SESSION_ANSWER.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_SESSION_ANSWER.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_ENGINE_SESSION_ANSWER.matches(formattedString);
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
          if (answer != null) {
            fieldMapBuilder.put("answer", answer);
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
      AnswerName that = ((AnswerName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.session, that.session)
          && Objects.equals(this.answer, that.answer)
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
    h ^= Objects.hashCode(answer);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(engine);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataStores/{data_store}/sessions/{session}/answers/{answer}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String session;
    private String answer;

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

    public String getAnswer() {
      return answer;
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

    public Builder setAnswer(String answer) {
      this.answer = answer;
      return this;
    }

    private Builder(AnswerName answerName) {
      Preconditions.checkArgument(
          Objects.equals(answerName.pathTemplate, PROJECT_LOCATION_DATA_STORE_SESSION_ANSWER),
          "toBuilder is only supported when AnswerName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/sessions/{session}/answers/{answer}");
      this.project = answerName.project;
      this.location = answerName.location;
      this.dataStore = answerName.dataStore;
      this.session = answerName.session;
      this.answer = answerName.answer;
    }

    public AnswerName build() {
      return new AnswerName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/sessions/{session}/answers/{answer}.
   */
  public static class ProjectLocationCollectionDataStoreSessionAnswerBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String session;
    private String answer;

    protected ProjectLocationCollectionDataStoreSessionAnswerBuilder() {}

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

    public String getAnswer() {
      return answer;
    }

    public ProjectLocationCollectionDataStoreSessionAnswerBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionAnswerBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionAnswerBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionAnswerBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionAnswerBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public ProjectLocationCollectionDataStoreSessionAnswerBuilder setAnswer(String answer) {
      this.answer = answer;
      return this;
    }

    public AnswerName build() {
      return new AnswerName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/sessions/{session}/answers/{answer}.
   */
  public static class ProjectLocationCollectionEngineSessionAnswerBuilder {
    private String project;
    private String location;
    private String collection;
    private String engine;
    private String session;
    private String answer;

    protected ProjectLocationCollectionEngineSessionAnswerBuilder() {}

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

    public String getAnswer() {
      return answer;
    }

    public ProjectLocationCollectionEngineSessionAnswerBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionEngineSessionAnswerBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionEngineSessionAnswerBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionEngineSessionAnswerBuilder setEngine(String engine) {
      this.engine = engine;
      return this;
    }

    public ProjectLocationCollectionEngineSessionAnswerBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public ProjectLocationCollectionEngineSessionAnswerBuilder setAnswer(String answer) {
      this.answer = answer;
      return this;
    }

    public AnswerName build() {
      return new AnswerName(this);
    }
  }
}
