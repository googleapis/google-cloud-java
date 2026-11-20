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

package com.google.cloud.agentregistry.v1;

import com.google.api.pathtemplate.PathTemplate;
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
public class AiApplicationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AI_APPLICATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/aiApplications/{ai_application}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String aiApplication;

  @Deprecated
  protected AiApplicationName() {
    project = null;
    location = null;
    aiApplication = null;
  }

  private AiApplicationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    aiApplication = Preconditions.checkNotNull(builder.getAiApplication());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAiApplication() {
    return aiApplication;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AiApplicationName of(String project, String location, String aiApplication) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAiApplication(aiApplication)
        .build();
  }

  public static String format(String project, String location, String aiApplication) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAiApplication(aiApplication)
        .build()
        .toString();
  }

  public static @Nullable AiApplicationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AI_APPLICATION.validatedMatch(
            formattedString, "AiApplicationName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("ai_application"));
  }

  public static List<AiApplicationName> parseList(List<String> formattedStrings) {
    List<AiApplicationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AiApplicationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AiApplicationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AI_APPLICATION.matches(formattedString);
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
          if (aiApplication != null) {
            fieldMapBuilder.put("ai_application", aiApplication);
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
    return PROJECT_LOCATION_AI_APPLICATION.instantiate(
        "project", project, "location", location, "ai_application", aiApplication);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AiApplicationName that = ((AiApplicationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.aiApplication, that.aiApplication);
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
    h ^= Objects.hashCode(aiApplication);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/aiApplications/{ai_application}. */
  public static class Builder {
    private String project;
    private String location;
    private String aiApplication;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAiApplication() {
      return aiApplication;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAiApplication(String aiApplication) {
      this.aiApplication = aiApplication;
      return this;
    }

    private Builder(AiApplicationName aiApplicationName) {
      this.project = aiApplicationName.project;
      this.location = aiApplicationName.location;
      this.aiApplication = aiApplicationName.aiApplication;
    }

    public AiApplicationName build() {
      return new AiApplicationName(this);
    }
  }
}
