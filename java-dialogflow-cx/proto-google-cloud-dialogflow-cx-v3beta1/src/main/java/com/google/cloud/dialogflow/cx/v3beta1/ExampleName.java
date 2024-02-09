/*
 * Copyright 2023 Google LLC
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
public class ExampleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_PLAYBOOK_EXAMPLE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/playbooks/{playbook}/examples/{example}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String agent;
  private final String playbook;
  private final String example;

  @Deprecated
  protected ExampleName() {
    project = null;
    location = null;
    agent = null;
    playbook = null;
    example = null;
  }

  private ExampleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    playbook = Preconditions.checkNotNull(builder.getPlaybook());
    example = Preconditions.checkNotNull(builder.getExample());
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

  public String getPlaybook() {
    return playbook;
  }

  public String getExample() {
    return example;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ExampleName of(
      String project, String location, String agent, String playbook, String example) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setPlaybook(playbook)
        .setExample(example)
        .build();
  }

  public static String format(
      String project, String location, String agent, String playbook, String example) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setPlaybook(playbook)
        .setExample(example)
        .build()
        .toString();
  }

  public static ExampleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AGENT_PLAYBOOK_EXAMPLE.validatedMatch(
            formattedString, "ExampleName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("agent"),
        matchMap.get("playbook"),
        matchMap.get("example"));
  }

  public static List<ExampleName> parseList(List<String> formattedStrings) {
    List<ExampleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ExampleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ExampleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_PLAYBOOK_EXAMPLE.matches(formattedString);
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
          if (playbook != null) {
            fieldMapBuilder.put("playbook", playbook);
          }
          if (example != null) {
            fieldMapBuilder.put("example", example);
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
    return PROJECT_LOCATION_AGENT_PLAYBOOK_EXAMPLE.instantiate(
        "project",
        project,
        "location",
        location,
        "agent",
        agent,
        "playbook",
        playbook,
        "example",
        example);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ExampleName that = ((ExampleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.playbook, that.playbook)
          && Objects.equals(this.example, that.example);
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
    h ^= Objects.hashCode(playbook);
    h *= 1000003;
    h ^= Objects.hashCode(example);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/playbooks/{playbook}/examples/{example}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String agent;
    private String playbook;
    private String example;

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

    public String getPlaybook() {
      return playbook;
    }

    public String getExample() {
      return example;
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

    public Builder setPlaybook(String playbook) {
      this.playbook = playbook;
      return this;
    }

    public Builder setExample(String example) {
      this.example = example;
      return this;
    }

    private Builder(ExampleName exampleName) {
      this.project = exampleName.project;
      this.location = exampleName.location;
      this.agent = exampleName.agent;
      this.playbook = exampleName.playbook;
      this.example = exampleName.example;
    }

    public ExampleName build() {
      return new ExampleName(this);
    }
  }
}
