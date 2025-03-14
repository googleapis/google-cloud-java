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

package com.google.cloud.dialogflow.cx.v3beta1;

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
public class ToolVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_TOOL_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/tools/{tool}/versions/{version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String agent;
  private final String tool;
  private final String version;

  @Deprecated
  protected ToolVersionName() {
    project = null;
    location = null;
    agent = null;
    tool = null;
    version = null;
  }

  private ToolVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    tool = Preconditions.checkNotNull(builder.getTool());
    version = Preconditions.checkNotNull(builder.getVersion());
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

  public String getTool() {
    return tool;
  }

  public String getVersion() {
    return version;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ToolVersionName of(
      String project, String location, String agent, String tool, String version) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setTool(tool)
        .setVersion(version)
        .build();
  }

  public static String format(
      String project, String location, String agent, String tool, String version) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setTool(tool)
        .setVersion(version)
        .build()
        .toString();
  }

  public static ToolVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AGENT_TOOL_VERSION.validatedMatch(
            formattedString, "ToolVersionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("agent"),
        matchMap.get("tool"),
        matchMap.get("version"));
  }

  public static List<ToolVersionName> parseList(List<String> formattedStrings) {
    List<ToolVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ToolVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ToolVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_TOOL_VERSION.matches(formattedString);
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
          if (tool != null) {
            fieldMapBuilder.put("tool", tool);
          }
          if (version != null) {
            fieldMapBuilder.put("version", version);
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
    return PROJECT_LOCATION_AGENT_TOOL_VERSION.instantiate(
        "project", project, "location", location, "agent", agent, "tool", tool, "version", version);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ToolVersionName that = ((ToolVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.tool, that.tool)
          && Objects.equals(this.version, that.version);
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
    h ^= Objects.hashCode(agent);
    h *= 1000003;
    h ^= Objects.hashCode(tool);
    h *= 1000003;
    h ^= Objects.hashCode(version);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/tools/{tool}/versions/{version}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String agent;
    private String tool;
    private String version;

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

    public String getTool() {
      return tool;
    }

    public String getVersion() {
      return version;
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

    public Builder setTool(String tool) {
      this.tool = tool;
      return this;
    }

    public Builder setVersion(String version) {
      this.version = version;
      return this;
    }

    private Builder(ToolVersionName toolVersionName) {
      this.project = toolVersionName.project;
      this.location = toolVersionName.location;
      this.agent = toolVersionName.agent;
      this.tool = toolVersionName.tool;
      this.version = toolVersionName.version;
    }

    public ToolVersionName build() {
      return new ToolVersionName(this);
    }
  }
}
