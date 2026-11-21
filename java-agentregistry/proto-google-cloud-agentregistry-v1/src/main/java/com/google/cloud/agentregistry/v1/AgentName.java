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
public class AgentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}");
  private static final PathTemplate PROJECT_LOCATION_AI_APPLICATION_AGENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/aiApplications/{ai_application}/agents/{agent}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String agent;
  private final String aiApplication;

  @Deprecated
  protected AgentName() {
    project = null;
    location = null;
    agent = null;
    aiApplication = null;
  }

  private AgentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    aiApplication = null;
    pathTemplate = PROJECT_LOCATION_AGENT;
  }

  private AgentName(ProjectLocationAiApplicationAgentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    aiApplication = Preconditions.checkNotNull(builder.getAiApplication());
    agent = Preconditions.checkNotNull(builder.getAgent());
    pathTemplate = PROJECT_LOCATION_AI_APPLICATION_AGENT;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAgent() {
    return agent;
  }

  public String getAiApplication() {
    return aiApplication;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationAgentBuilder() {
    return new Builder();
  }

  public static ProjectLocationAiApplicationAgentBuilder
      newProjectLocationAiApplicationAgentBuilder() {
    return new ProjectLocationAiApplicationAgentBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AgentName of(String project, String location, String agent) {
    return newBuilder().setProject(project).setLocation(location).setAgent(agent).build();
  }

  public static AgentName ofProjectLocationAgentName(
      String project, String location, String agent) {
    return newBuilder().setProject(project).setLocation(location).setAgent(agent).build();
  }

  public static AgentName ofProjectLocationAiApplicationAgentName(
      String project, String location, String aiApplication, String agent) {
    return newProjectLocationAiApplicationAgentBuilder()
        .setProject(project)
        .setLocation(location)
        .setAiApplication(aiApplication)
        .setAgent(agent)
        .build();
  }

  public static String format(String project, String location, String agent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .build()
        .toString();
  }

  public static String formatProjectLocationAgentName(
      String project, String location, String agent) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .build()
        .toString();
  }

  public static String formatProjectLocationAiApplicationAgentName(
      String project, String location, String aiApplication, String agent) {
    return newProjectLocationAiApplicationAgentBuilder()
        .setProject(project)
        .setLocation(location)
        .setAiApplication(aiApplication)
        .setAgent(agent)
        .build()
        .toString();
  }

  public static @Nullable AgentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_AGENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_AGENT.match(formattedString);
      return ofProjectLocationAgentName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("agent"));
    } else if (PROJECT_LOCATION_AI_APPLICATION_AGENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_AI_APPLICATION_AGENT.match(formattedString);
      return ofProjectLocationAiApplicationAgentName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("ai_application"),
          matchMap.get("agent"));
    }
    throw new ValidationException("AgentName.parse: formattedString not in valid format");
  }

  public static List<AgentName> parseList(List<String> formattedStrings) {
    List<AgentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AgentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AgentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT.matches(formattedString)
        || PROJECT_LOCATION_AI_APPLICATION_AGENT.matches(formattedString);
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
          if (agent != null) {
            fieldMapBuilder.put("agent", agent);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AgentName that = ((AgentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.aiApplication, that.aiApplication);
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
    h ^= Objects.hashCode(agent);
    h *= 1000003;
    h ^= Objects.hashCode(aiApplication);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/agents/{agent}. */
  public static class Builder {
    private String project;
    private String location;
    private String agent;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAgent() {
      return agent;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAgent(String agent) {
      this.agent = agent;
      return this;
    }

    private Builder(AgentName agentName) {
      Preconditions.checkArgument(
          Objects.equals(agentName.pathTemplate, PROJECT_LOCATION_AGENT),
          "toBuilder is only supported when AgentName has the pattern of"
              + " projects/{project}/locations/{location}/agents/{agent}");
      this.project = agentName.project;
      this.location = agentName.location;
      this.agent = agentName.agent;
    }

    public AgentName build() {
      return new AgentName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/aiApplications/{ai_application}/agents/{agent}.
   */
  public static class ProjectLocationAiApplicationAgentBuilder {
    private String project;
    private String location;
    private String aiApplication;
    private String agent;

    protected ProjectLocationAiApplicationAgentBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAiApplication() {
      return aiApplication;
    }

    public String getAgent() {
      return agent;
    }

    public ProjectLocationAiApplicationAgentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAiApplicationAgentBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAiApplicationAgentBuilder setAiApplication(String aiApplication) {
      this.aiApplication = aiApplication;
      return this;
    }

    public ProjectLocationAiApplicationAgentBuilder setAgent(String agent) {
      this.agent = agent;
      return this;
    }

    public AgentName build() {
      return new AgentName(this);
    }
  }
}
