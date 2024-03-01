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

package com.google.cloud.dialogflow.cx.v3;

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
public class TransitionRouteGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_FLOW_TRANSITION_ROUTE_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/flows/{flow}/transitionRouteGroups/{transition_route_group}");
  private static final PathTemplate PROJECT_LOCATION_AGENT_TRANSITION_ROUTE_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/transitionRouteGroups/{transition_route_group}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String agent;
  private final String flow;
  private final String transitionRouteGroup;

  @Deprecated
  protected TransitionRouteGroupName() {
    project = null;
    location = null;
    agent = null;
    flow = null;
    transitionRouteGroup = null;
  }

  private TransitionRouteGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    flow = Preconditions.checkNotNull(builder.getFlow());
    transitionRouteGroup = Preconditions.checkNotNull(builder.getTransitionRouteGroup());
    pathTemplate = PROJECT_LOCATION_AGENT_FLOW_TRANSITION_ROUTE_GROUP;
  }

  private TransitionRouteGroupName(ProjectLocationAgentTransitionRouteGroupBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    transitionRouteGroup = Preconditions.checkNotNull(builder.getTransitionRouteGroup());
    flow = null;
    pathTemplate = PROJECT_LOCATION_AGENT_TRANSITION_ROUTE_GROUP;
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

  public String getFlow() {
    return flow;
  }

  public String getTransitionRouteGroup() {
    return transitionRouteGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationAgentFlowTransitionRouteGroupBuilder() {
    return new Builder();
  }

  public static ProjectLocationAgentTransitionRouteGroupBuilder
      newProjectLocationAgentTransitionRouteGroupBuilder() {
    return new ProjectLocationAgentTransitionRouteGroupBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TransitionRouteGroupName of(
      String project, String location, String agent, String flow, String transitionRouteGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setFlow(flow)
        .setTransitionRouteGroup(transitionRouteGroup)
        .build();
  }

  public static TransitionRouteGroupName ofProjectLocationAgentFlowTransitionRouteGroupName(
      String project, String location, String agent, String flow, String transitionRouteGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setFlow(flow)
        .setTransitionRouteGroup(transitionRouteGroup)
        .build();
  }

  public static TransitionRouteGroupName ofProjectLocationAgentTransitionRouteGroupName(
      String project, String location, String agent, String transitionRouteGroup) {
    return newProjectLocationAgentTransitionRouteGroupBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setTransitionRouteGroup(transitionRouteGroup)
        .build();
  }

  public static String format(
      String project, String location, String agent, String flow, String transitionRouteGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setFlow(flow)
        .setTransitionRouteGroup(transitionRouteGroup)
        .build()
        .toString();
  }

  public static String formatProjectLocationAgentFlowTransitionRouteGroupName(
      String project, String location, String agent, String flow, String transitionRouteGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setFlow(flow)
        .setTransitionRouteGroup(transitionRouteGroup)
        .build()
        .toString();
  }

  public static String formatProjectLocationAgentTransitionRouteGroupName(
      String project, String location, String agent, String transitionRouteGroup) {
    return newProjectLocationAgentTransitionRouteGroupBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setTransitionRouteGroup(transitionRouteGroup)
        .build()
        .toString();
  }

  public static TransitionRouteGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_AGENT_FLOW_TRANSITION_ROUTE_GROUP.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_AGENT_FLOW_TRANSITION_ROUTE_GROUP.match(formattedString);
      return ofProjectLocationAgentFlowTransitionRouteGroupName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("agent"),
          matchMap.get("flow"),
          matchMap.get("transition_route_group"));
    } else if (PROJECT_LOCATION_AGENT_TRANSITION_ROUTE_GROUP.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_AGENT_TRANSITION_ROUTE_GROUP.match(formattedString);
      return ofProjectLocationAgentTransitionRouteGroupName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("agent"),
          matchMap.get("transition_route_group"));
    }
    throw new ValidationException(
        "TransitionRouteGroupName.parse: formattedString not in valid format");
  }

  public static List<TransitionRouteGroupName> parseList(List<String> formattedStrings) {
    List<TransitionRouteGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TransitionRouteGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TransitionRouteGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_FLOW_TRANSITION_ROUTE_GROUP.matches(formattedString)
        || PROJECT_LOCATION_AGENT_TRANSITION_ROUTE_GROUP.matches(formattedString);
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
          if (flow != null) {
            fieldMapBuilder.put("flow", flow);
          }
          if (transitionRouteGroup != null) {
            fieldMapBuilder.put("transition_route_group", transitionRouteGroup);
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
      TransitionRouteGroupName that = ((TransitionRouteGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.flow, that.flow)
          && Objects.equals(this.transitionRouteGroup, that.transitionRouteGroup);
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
    h ^= Objects.hashCode(flow);
    h *= 1000003;
    h ^= Objects.hashCode(transitionRouteGroup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/flows/{flow}/transitionRouteGroups/{transition_route_group}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String agent;
    private String flow;
    private String transitionRouteGroup;

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

    public String getFlow() {
      return flow;
    }

    public String getTransitionRouteGroup() {
      return transitionRouteGroup;
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

    public Builder setFlow(String flow) {
      this.flow = flow;
      return this;
    }

    public Builder setTransitionRouteGroup(String transitionRouteGroup) {
      this.transitionRouteGroup = transitionRouteGroup;
      return this;
    }

    private Builder(TransitionRouteGroupName transitionRouteGroupName) {
      Preconditions.checkArgument(
          Objects.equals(
              transitionRouteGroupName.pathTemplate,
              PROJECT_LOCATION_AGENT_FLOW_TRANSITION_ROUTE_GROUP),
          "toBuilder is only supported when TransitionRouteGroupName has the pattern of projects/{project}/locations/{location}/agents/{agent}/flows/{flow}/transitionRouteGroups/{transition_route_group}");
      this.project = transitionRouteGroupName.project;
      this.location = transitionRouteGroupName.location;
      this.agent = transitionRouteGroupName.agent;
      this.flow = transitionRouteGroupName.flow;
      this.transitionRouteGroup = transitionRouteGroupName.transitionRouteGroup;
    }

    public TransitionRouteGroupName build() {
      return new TransitionRouteGroupName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/transitionRouteGroups/{transition_route_group}.
   */
  public static class ProjectLocationAgentTransitionRouteGroupBuilder {
    private String project;
    private String location;
    private String agent;
    private String transitionRouteGroup;

    protected ProjectLocationAgentTransitionRouteGroupBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAgent() {
      return agent;
    }

    public String getTransitionRouteGroup() {
      return transitionRouteGroup;
    }

    public ProjectLocationAgentTransitionRouteGroupBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAgentTransitionRouteGroupBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAgentTransitionRouteGroupBuilder setAgent(String agent) {
      this.agent = agent;
      return this;
    }

    public ProjectLocationAgentTransitionRouteGroupBuilder setTransitionRouteGroup(
        String transitionRouteGroup) {
      this.transitionRouteGroup = transitionRouteGroup;
      return this;
    }

    public TransitionRouteGroupName build() {
      return new TransitionRouteGroupName(this);
    }
  }
}
