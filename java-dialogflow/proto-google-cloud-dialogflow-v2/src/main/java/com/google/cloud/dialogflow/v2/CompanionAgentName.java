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

package com.google.cloud.dialogflow.v2;

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
public class CompanionAgentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_COMPANION_AGENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/companionAgents/{companion_agent}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String companionAgent;

  @Deprecated
  protected CompanionAgentName() {
    project = null;
    location = null;
    companionAgent = null;
  }

  private CompanionAgentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    companionAgent = Preconditions.checkNotNull(builder.getCompanionAgent());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCompanionAgent() {
    return companionAgent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CompanionAgentName of(String project, String location, String companionAgent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCompanionAgent(companionAgent)
        .build();
  }

  public static String format(String project, String location, String companionAgent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCompanionAgent(companionAgent)
        .build()
        .toString();
  }

  public static @Nullable CompanionAgentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_COMPANION_AGENT.validatedMatch(
            formattedString, "CompanionAgentName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("companion_agent"));
  }

  public static List<CompanionAgentName> parseList(List<String> formattedStrings) {
    List<CompanionAgentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable CompanionAgentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CompanionAgentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_COMPANION_AGENT.matches(formattedString);
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
          if (companionAgent != null) {
            fieldMapBuilder.put("companion_agent", companionAgent);
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
    return PROJECT_LOCATION_COMPANION_AGENT.instantiate(
        "project", project, "location", location, "companion_agent", companionAgent);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CompanionAgentName that = ((CompanionAgentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.companionAgent, that.companionAgent);
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
    h ^= Objects.hashCode(companionAgent);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/companionAgents/{companion_agent}. */
  public static class Builder {
    private String project;
    private String location;
    private String companionAgent;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCompanionAgent() {
      return companionAgent;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCompanionAgent(String companionAgent) {
      this.companionAgent = companionAgent;
      return this;
    }

    private Builder(CompanionAgentName companionAgentName) {
      this.project = companionAgentName.project;
      this.location = companionAgentName.location;
      this.companionAgent = companionAgentName.companionAgent;
    }

    public CompanionAgentName build() {
      return new CompanionAgentName(this);
    }
  }
}
