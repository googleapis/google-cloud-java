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
public class ConversationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DATA_STORE_CONVERSATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/dataStores/{data_store}/conversations/{conversation}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_DATA_STORE_CONVERSATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/conversations/{conversation}");
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_ENGINE_CONVERSATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/conversations/{conversation}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String dataStore;
  private final String conversation;
  private final String collection;
  private final String engine;

  @Deprecated
  protected ConversationName() {
    project = null;
    location = null;
    dataStore = null;
    conversation = null;
    collection = null;
    engine = null;
  }

  private ConversationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    collection = null;
    engine = null;
    pathTemplate = PROJECT_LOCATION_DATA_STORE_CONVERSATION;
  }

  private ConversationName(ProjectLocationCollectionDataStoreConversationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    dataStore = Preconditions.checkNotNull(builder.getDataStore());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    engine = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_DATA_STORE_CONVERSATION;
  }

  private ConversationName(ProjectLocationCollectionEngineConversationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    engine = Preconditions.checkNotNull(builder.getEngine());
    conversation = Preconditions.checkNotNull(builder.getConversation());
    dataStore = null;
    pathTemplate = PROJECT_LOCATION_COLLECTION_ENGINE_CONVERSATION;
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

  public String getConversation() {
    return conversation;
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

  public static Builder newProjectLocationDataStoreConversationBuilder() {
    return new Builder();
  }

  public static ProjectLocationCollectionDataStoreConversationBuilder
      newProjectLocationCollectionDataStoreConversationBuilder() {
    return new ProjectLocationCollectionDataStoreConversationBuilder();
  }

  public static ProjectLocationCollectionEngineConversationBuilder
      newProjectLocationCollectionEngineConversationBuilder() {
    return new ProjectLocationCollectionEngineConversationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConversationName of(
      String project, String location, String dataStore, String conversation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setConversation(conversation)
        .build();
  }

  public static ConversationName ofProjectLocationDataStoreConversationName(
      String project, String location, String dataStore, String conversation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setConversation(conversation)
        .build();
  }

  public static ConversationName ofProjectLocationCollectionDataStoreConversationName(
      String project, String location, String collection, String dataStore, String conversation) {
    return newProjectLocationCollectionDataStoreConversationBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setConversation(conversation)
        .build();
  }

  public static ConversationName ofProjectLocationCollectionEngineConversationName(
      String project, String location, String collection, String engine, String conversation) {
    return newProjectLocationCollectionEngineConversationBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setConversation(conversation)
        .build();
  }

  public static String format(
      String project, String location, String dataStore, String conversation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setConversation(conversation)
        .build()
        .toString();
  }

  public static String formatProjectLocationDataStoreConversationName(
      String project, String location, String dataStore, String conversation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDataStore(dataStore)
        .setConversation(conversation)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionDataStoreConversationName(
      String project, String location, String collection, String dataStore, String conversation) {
    return newProjectLocationCollectionDataStoreConversationBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setDataStore(dataStore)
        .setConversation(conversation)
        .build()
        .toString();
  }

  public static String formatProjectLocationCollectionEngineConversationName(
      String project, String location, String collection, String engine, String conversation) {
    return newProjectLocationCollectionEngineConversationBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setConversation(conversation)
        .build()
        .toString();
  }

  public static ConversationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_DATA_STORE_CONVERSATION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_DATA_STORE_CONVERSATION.match(formattedString);
      return ofProjectLocationDataStoreConversationName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("data_store"),
          matchMap.get("conversation"));
    } else if (PROJECT_LOCATION_COLLECTION_DATA_STORE_CONVERSATION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_DATA_STORE_CONVERSATION.match(formattedString);
      return ofProjectLocationCollectionDataStoreConversationName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("data_store"),
          matchMap.get("conversation"));
    } else if (PROJECT_LOCATION_COLLECTION_ENGINE_CONVERSATION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_COLLECTION_ENGINE_CONVERSATION.match(formattedString);
      return ofProjectLocationCollectionEngineConversationName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("collection"),
          matchMap.get("engine"),
          matchMap.get("conversation"));
    }
    throw new ValidationException("ConversationName.parse: formattedString not in valid format");
  }

  public static List<ConversationName> parseList(List<String> formattedStrings) {
    List<ConversationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConversationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConversationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DATA_STORE_CONVERSATION.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_DATA_STORE_CONVERSATION.matches(formattedString)
        || PROJECT_LOCATION_COLLECTION_ENGINE_CONVERSATION.matches(formattedString);
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
          if (conversation != null) {
            fieldMapBuilder.put("conversation", conversation);
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
      ConversationName that = ((ConversationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.dataStore, that.dataStore)
          && Objects.equals(this.conversation, that.conversation)
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
    h ^= Objects.hashCode(conversation);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(engine);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/dataStores/{data_store}/conversations/{conversation}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String dataStore;
    private String conversation;

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

    public String getConversation() {
      return conversation;
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

    public Builder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    private Builder(ConversationName conversationName) {
      Preconditions.checkArgument(
          Objects.equals(conversationName.pathTemplate, PROJECT_LOCATION_DATA_STORE_CONVERSATION),
          "toBuilder is only supported when ConversationName has the pattern of projects/{project}/locations/{location}/dataStores/{data_store}/conversations/{conversation}");
      this.project = conversationName.project;
      this.location = conversationName.location;
      this.dataStore = conversationName.dataStore;
      this.conversation = conversationName.conversation;
    }

    public ConversationName build() {
      return new ConversationName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/conversations/{conversation}.
   */
  public static class ProjectLocationCollectionDataStoreConversationBuilder {
    private String project;
    private String location;
    private String collection;
    private String dataStore;
    private String conversation;

    protected ProjectLocationCollectionDataStoreConversationBuilder() {}

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

    public String getConversation() {
      return conversation;
    }

    public ProjectLocationCollectionDataStoreConversationBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionDataStoreConversationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionDataStoreConversationBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionDataStoreConversationBuilder setDataStore(String dataStore) {
      this.dataStore = dataStore;
      return this;
    }

    public ProjectLocationCollectionDataStoreConversationBuilder setConversation(
        String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ConversationName build() {
      return new ConversationName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/conversations/{conversation}.
   */
  public static class ProjectLocationCollectionEngineConversationBuilder {
    private String project;
    private String location;
    private String collection;
    private String engine;
    private String conversation;

    protected ProjectLocationCollectionEngineConversationBuilder() {}

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

    public String getConversation() {
      return conversation;
    }

    public ProjectLocationCollectionEngineConversationBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationCollectionEngineConversationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationCollectionEngineConversationBuilder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public ProjectLocationCollectionEngineConversationBuilder setEngine(String engine) {
      this.engine = engine;
      return this;
    }

    public ProjectLocationCollectionEngineConversationBuilder setConversation(String conversation) {
      this.conversation = conversation;
      return this;
    }

    public ConversationName build() {
      return new ConversationName(this);
    }
  }
}
