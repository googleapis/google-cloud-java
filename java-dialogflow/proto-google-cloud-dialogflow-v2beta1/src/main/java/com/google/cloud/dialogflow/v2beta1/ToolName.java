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

package com.google.cloud.dialogflow.v2beta1;

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
public class ToolName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_TOOL =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/tools/{tool}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String tool;

  @Deprecated
  protected ToolName() {
    project = null;
    location = null;
    tool = null;
  }

  private ToolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    tool = Preconditions.checkNotNull(builder.getTool());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getTool() {
    return tool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ToolName of(String project, String location, String tool) {
    return newBuilder().setProject(project).setLocation(location).setTool(tool).build();
  }

  public static String format(String project, String location, String tool) {
    return newBuilder().setProject(project).setLocation(location).setTool(tool).build().toString();
  }

  public static ToolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_TOOL.validatedMatch(
            formattedString, "ToolName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("tool"));
  }

  public static List<ToolName> parseList(List<String> formattedStrings) {
    List<ToolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ToolName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ToolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_TOOL.matches(formattedString);
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
          if (tool != null) {
            fieldMapBuilder.put("tool", tool);
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
    return PROJECT_LOCATION_TOOL.instantiate(
        "project", project, "location", location, "tool", tool);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ToolName that = ((ToolName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.tool, that.tool);
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
    h ^= Objects.hashCode(tool);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/tools/{tool}. */
  public static class Builder {
    private String project;
    private String location;
    private String tool;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTool() {
      return tool;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTool(String tool) {
      this.tool = tool;
      return this;
    }

    private Builder(ToolName toolName) {
      this.project = toolName.project;
      this.location = toolName.location;
      this.tool = toolName.tool;
    }

    public ToolName build() {
      return new ToolName(this);
    }
  }
}
