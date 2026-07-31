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

package com.google.cloud.networkservices.v1;

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
public class AgentGatewayName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_GATEWAY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agentGateways/{agent_gateway}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String agentGateway;

  @Deprecated
  protected AgentGatewayName() {
    project = null;
    location = null;
    agentGateway = null;
  }

  private AgentGatewayName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agentGateway = Preconditions.checkNotNull(builder.getAgentGateway());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAgentGateway() {
    return agentGateway;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AgentGatewayName of(String project, String location, String agentGateway) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgentGateway(agentGateway)
        .build();
  }

  public static String format(String project, String location, String agentGateway) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgentGateway(agentGateway)
        .build()
        .toString();
  }

  public static @Nullable AgentGatewayName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AGENT_GATEWAY.validatedMatch(
            formattedString, "AgentGatewayName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("agent_gateway"));
  }

  public static List<AgentGatewayName> parseList(List<String> formattedStrings) {
    List<AgentGatewayName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AgentGatewayName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AgentGatewayName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_GATEWAY.matches(formattedString);
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
          if (agentGateway != null) {
            fieldMapBuilder.put("agent_gateway", agentGateway);
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
    return PROJECT_LOCATION_AGENT_GATEWAY.instantiate(
        "project", project, "location", location, "agent_gateway", agentGateway);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AgentGatewayName that = ((AgentGatewayName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agentGateway, that.agentGateway);
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
    h ^= Objects.hashCode(agentGateway);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/agentGateways/{agent_gateway}. */
  public static class Builder {
    private String project;
    private String location;
    private String agentGateway;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAgentGateway() {
      return agentGateway;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAgentGateway(String agentGateway) {
      this.agentGateway = agentGateway;
      return this;
    }

    private Builder(AgentGatewayName agentGatewayName) {
      this.project = agentGatewayName.project;
      this.location = agentGatewayName.location;
      this.agentGateway = agentGatewayName.agentGateway;
    }

    public AgentGatewayName build() {
      return new AgentGatewayName(this);
    }
  }
}
