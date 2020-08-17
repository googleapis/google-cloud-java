/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class TransitionRouteGroupName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/flows/{flow}/transitionRouteGroups/{transition_route_group}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String agent;
  private final String flow;
  private final String transitionRouteGroup;

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

  public Builder toBuilder() {
    return new Builder(this);
  }

  private TransitionRouteGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    flow = Preconditions.checkNotNull(builder.getFlow());
    transitionRouteGroup = Preconditions.checkNotNull(builder.getTransitionRouteGroup());
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

  public static TransitionRouteGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "TransitionRouteGroupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("agent"),
        matchMap.get("flow"),
        matchMap.get("transition_route_group"));
  }

  public static List<TransitionRouteGroupName> parseList(List<String> formattedStrings) {
    List<TransitionRouteGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TransitionRouteGroupName> values) {
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("agent", agent);
          fieldMapBuilder.put("flow", flow);
          fieldMapBuilder.put("transitionRouteGroup", transitionRouteGroup);
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
    return PATH_TEMPLATE.instantiate(
        "project",
        project,
        "location",
        location,
        "agent",
        agent,
        "flow",
        flow,
        "transition_route_group",
        transitionRouteGroup);
  }

  /** Builder for TransitionRouteGroupName. */
  public static class Builder {

    private String project;
    private String location;
    private String agent;
    private String flow;
    private String transitionRouteGroup;

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

    private Builder() {}

    private Builder(TransitionRouteGroupName transitionRouteGroupName) {
      project = transitionRouteGroupName.project;
      location = transitionRouteGroupName.location;
      agent = transitionRouteGroupName.agent;
      flow = transitionRouteGroupName.flow;
      transitionRouteGroup = transitionRouteGroupName.transitionRouteGroup;
    }

    public TransitionRouteGroupName build() {
      return new TransitionRouteGroupName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TransitionRouteGroupName) {
      TransitionRouteGroupName that = (TransitionRouteGroupName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.agent.equals(that.agent))
          && (this.flow.equals(that.flow))
          && (this.transitionRouteGroup.equals(that.transitionRouteGroup));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= agent.hashCode();
    h *= 1000003;
    h ^= flow.hashCode();
    h *= 1000003;
    h ^= transitionRouteGroup.hashCode();
    return h;
  }
}
