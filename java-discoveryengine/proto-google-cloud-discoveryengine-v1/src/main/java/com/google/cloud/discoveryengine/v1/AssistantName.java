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

package com.google.cloud.discoveryengine.v1;

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
public class AssistantName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_COLLECTION_ENGINE_ASSISTANT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/assistants/{assistant}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String collection;
  private final String engine;
  private final String assistant;

  @Deprecated
  protected AssistantName() {
    project = null;
    location = null;
    collection = null;
    engine = null;
    assistant = null;
  }

  private AssistantName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    collection = Preconditions.checkNotNull(builder.getCollection());
    engine = Preconditions.checkNotNull(builder.getEngine());
    assistant = Preconditions.checkNotNull(builder.getAssistant());
  }

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

  public String getAssistant() {
    return assistant;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AssistantName of(
      String project, String location, String collection, String engine, String assistant) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setAssistant(assistant)
        .build();
  }

  public static String format(
      String project, String location, String collection, String engine, String assistant) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCollection(collection)
        .setEngine(engine)
        .setAssistant(assistant)
        .build()
        .toString();
  }

  public static AssistantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_COLLECTION_ENGINE_ASSISTANT.validatedMatch(
            formattedString, "AssistantName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("collection"),
        matchMap.get("engine"),
        matchMap.get("assistant"));
  }

  public static List<AssistantName> parseList(List<String> formattedStrings) {
    List<AssistantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AssistantName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AssistantName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_COLLECTION_ENGINE_ASSISTANT.matches(formattedString);
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
          if (collection != null) {
            fieldMapBuilder.put("collection", collection);
          }
          if (engine != null) {
            fieldMapBuilder.put("engine", engine);
          }
          if (assistant != null) {
            fieldMapBuilder.put("assistant", assistant);
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
    return PROJECT_LOCATION_COLLECTION_ENGINE_ASSISTANT.instantiate(
        "project",
        project,
        "location",
        location,
        "collection",
        collection,
        "engine",
        engine,
        "assistant",
        assistant);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AssistantName that = ((AssistantName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.collection, that.collection)
          && Objects.equals(this.engine, that.engine)
          && Objects.equals(this.assistant, that.assistant);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(collection);
    h *= 1000003;
    h ^= Objects.hashCode(engine);
    h *= 1000003;
    h ^= Objects.hashCode(assistant);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/collections/{collection}/engines/{engine}/assistants/{assistant}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String collection;
    private String engine;
    private String assistant;

    protected Builder() {}

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

    public String getAssistant() {
      return assistant;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCollection(String collection) {
      this.collection = collection;
      return this;
    }

    public Builder setEngine(String engine) {
      this.engine = engine;
      return this;
    }

    public Builder setAssistant(String assistant) {
      this.assistant = assistant;
      return this;
    }

    private Builder(AssistantName assistantName) {
      this.project = assistantName.project;
      this.location = assistantName.location;
      this.collection = assistantName.collection;
      this.engine = assistantName.engine;
      this.assistant = assistantName.assistant;
    }

    public AssistantName build() {
      return new AssistantName(this);
    }
  }
}
