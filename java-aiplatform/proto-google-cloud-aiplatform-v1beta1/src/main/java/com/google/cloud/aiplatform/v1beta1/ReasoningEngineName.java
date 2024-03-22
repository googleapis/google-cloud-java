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

package com.google.cloud.aiplatform.v1beta1;

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
public class ReasoningEngineName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REASONING_ENGINE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String reasoningEngine;

  @Deprecated
  protected ReasoningEngineName() {
    project = null;
    location = null;
    reasoningEngine = null;
  }

  private ReasoningEngineName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reasoningEngine = Preconditions.checkNotNull(builder.getReasoningEngine());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getReasoningEngine() {
    return reasoningEngine;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReasoningEngineName of(String project, String location, String reasoningEngine) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .build();
  }

  public static String format(String project, String location, String reasoningEngine) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .build()
        .toString();
  }

  public static ReasoningEngineName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REASONING_ENGINE.validatedMatch(
            formattedString, "ReasoningEngineName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("reasoning_engine"));
  }

  public static List<ReasoningEngineName> parseList(List<String> formattedStrings) {
    List<ReasoningEngineName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReasoningEngineName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReasoningEngineName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REASONING_ENGINE.matches(formattedString);
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
          if (reasoningEngine != null) {
            fieldMapBuilder.put("reasoning_engine", reasoningEngine);
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
    return PROJECT_LOCATION_REASONING_ENGINE.instantiate(
        "project", project, "location", location, "reasoning_engine", reasoningEngine);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ReasoningEngineName that = ((ReasoningEngineName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.reasoningEngine, that.reasoningEngine);
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
    h ^= Objects.hashCode(reasoningEngine);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}. */
  public static class Builder {
    private String project;
    private String location;
    private String reasoningEngine;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getReasoningEngine() {
      return reasoningEngine;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setReasoningEngine(String reasoningEngine) {
      this.reasoningEngine = reasoningEngine;
      return this;
    }

    private Builder(ReasoningEngineName reasoningEngineName) {
      this.project = reasoningEngineName.project;
      this.location = reasoningEngineName.location;
      this.reasoningEngine = reasoningEngineName.reasoningEngine;
    }

    public ReasoningEngineName build() {
      return new ReasoningEngineName(this);
    }
  }
}
