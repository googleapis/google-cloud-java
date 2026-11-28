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

package com.google.cloud.aiplatform.v1;

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
public class MonitoredAgentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MONITORED_AGENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String monitoredAgent;

  @Deprecated
  protected MonitoredAgentName() {
    project = null;
    location = null;
    monitoredAgent = null;
  }

  private MonitoredAgentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    monitoredAgent = Preconditions.checkNotNull(builder.getMonitoredAgent());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMonitoredAgent() {
    return monitoredAgent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MonitoredAgentName of(String project, String location, String monitoredAgent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMonitoredAgent(monitoredAgent)
        .build();
  }

  public static String format(String project, String location, String monitoredAgent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMonitoredAgent(monitoredAgent)
        .build()
        .toString();
  }

  public static @Nullable MonitoredAgentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MONITORED_AGENT.validatedMatch(
            formattedString, "MonitoredAgentName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("monitored_agent"));
  }

  public static List<MonitoredAgentName> parseList(List<String> formattedStrings) {
    List<MonitoredAgentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable MonitoredAgentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MonitoredAgentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MONITORED_AGENT.matches(formattedString);
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
          if (monitoredAgent != null) {
            fieldMapBuilder.put("monitored_agent", monitoredAgent);
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
    return PROJECT_LOCATION_MONITORED_AGENT.instantiate(
        "project", project, "location", location, "monitored_agent", monitoredAgent);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MonitoredAgentName that = ((MonitoredAgentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.monitoredAgent, that.monitoredAgent);
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
    h ^= Objects.hashCode(monitoredAgent);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}. */
  public static class Builder {
    private String project;
    private String location;
    private String monitoredAgent;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMonitoredAgent() {
      return monitoredAgent;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMonitoredAgent(String monitoredAgent) {
      this.monitoredAgent = monitoredAgent;
      return this;
    }

    private Builder(MonitoredAgentName monitoredAgentName) {
      this.project = monitoredAgentName.project;
      this.location = monitoredAgentName.location;
      this.monitoredAgent = monitoredAgentName.monitoredAgent;
    }

    public MonitoredAgentName build() {
      return new MonitoredAgentName(this);
    }
  }
}
