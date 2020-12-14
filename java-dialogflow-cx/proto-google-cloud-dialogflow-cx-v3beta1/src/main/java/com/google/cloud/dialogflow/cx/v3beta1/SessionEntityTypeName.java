/*
 * Copyright 2020 Google LLC
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

import com.google.api.core.BetaApi;
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
public class SessionEntityTypeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_SESSION_ENTITY_TYPE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/sessions/{session}/entityTypes/{entity_type}");
  private static final PathTemplate PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION_ENTITY_TYPE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/environments/{environment}/sessions/{session}/entityTypes/{entity_type}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String agent;
  private final String session;
  private final String entityType;
  private final String environment;

  @Deprecated
  protected SessionEntityTypeName() {
    project = null;
    location = null;
    agent = null;
    session = null;
    entityType = null;
    environment = null;
  }

  private SessionEntityTypeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    session = Preconditions.checkNotNull(builder.getSession());
    entityType = Preconditions.checkNotNull(builder.getEntityType());
    environment = null;
    pathTemplate = PROJECT_LOCATION_AGENT_SESSION_ENTITY_TYPE;
  }

  private SessionEntityTypeName(ProjectLocationAgentEnvironmentSessionEntityTypeBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    session = Preconditions.checkNotNull(builder.getSession());
    entityType = Preconditions.checkNotNull(builder.getEntityType());
    pathTemplate = PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION_ENTITY_TYPE;
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

  public String getSession() {
    return session;
  }

  public String getEntityType() {
    return entityType;
  }

  public String getEnvironment() {
    return environment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationAgentSessionEntityTypeBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationAgentEnvironmentSessionEntityTypeBuilder
      newProjectLocationAgentEnvironmentSessionEntityTypeBuilder() {
    return new ProjectLocationAgentEnvironmentSessionEntityTypeBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SessionEntityTypeName of(
      String project, String location, String agent, String session, String entityType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setSession(session)
        .setEntityType(entityType)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SessionEntityTypeName ofProjectLocationAgentSessionEntityTypeName(
      String project, String location, String agent, String session, String entityType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setSession(session)
        .setEntityType(entityType)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SessionEntityTypeName ofProjectLocationAgentEnvironmentSessionEntityTypeName(
      String project,
      String location,
      String agent,
      String environment,
      String session,
      String entityType) {
    return newProjectLocationAgentEnvironmentSessionEntityTypeBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setEnvironment(environment)
        .setSession(session)
        .setEntityType(entityType)
        .build();
  }

  public static String format(
      String project, String location, String agent, String session, String entityType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setSession(session)
        .setEntityType(entityType)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationAgentSessionEntityTypeName(
      String project, String location, String agent, String session, String entityType) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setSession(session)
        .setEntityType(entityType)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationAgentEnvironmentSessionEntityTypeName(
      String project,
      String location,
      String agent,
      String environment,
      String session,
      String entityType) {
    return newProjectLocationAgentEnvironmentSessionEntityTypeBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setEnvironment(environment)
        .setSession(session)
        .setEntityType(entityType)
        .build()
        .toString();
  }

  public static SessionEntityTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_AGENT_SESSION_ENTITY_TYPE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_AGENT_SESSION_ENTITY_TYPE.match(formattedString);
      return ofProjectLocationAgentSessionEntityTypeName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("agent"),
          matchMap.get("session"),
          matchMap.get("entity_type"));
    } else if (PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION_ENTITY_TYPE.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION_ENTITY_TYPE.match(formattedString);
      return ofProjectLocationAgentEnvironmentSessionEntityTypeName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("agent"),
          matchMap.get("environment"),
          matchMap.get("session"),
          matchMap.get("entity_type"));
    }
    throw new ValidationException(
        "SessionEntityTypeName.parse: formattedString not in valid format");
  }

  public static List<SessionEntityTypeName> parseList(List<String> formattedStrings) {
    List<SessionEntityTypeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SessionEntityTypeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SessionEntityTypeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_SESSION_ENTITY_TYPE.matches(formattedString)
        || PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION_ENTITY_TYPE.matches(formattedString);
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
          if (session != null) {
            fieldMapBuilder.put("session", session);
          }
          if (entityType != null) {
            fieldMapBuilder.put("entity_type", entityType);
          }
          if (environment != null) {
            fieldMapBuilder.put("environment", environment);
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
    if (o != null || getClass() == o.getClass()) {
      SessionEntityTypeName that = ((SessionEntityTypeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.session, that.session)
          && Objects.equals(this.entityType, that.entityType)
          && Objects.equals(this.environment, that.environment);
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
    h ^= Objects.hashCode(session);
    h *= 1000003;
    h ^= Objects.hashCode(entityType);
    h *= 1000003;
    h ^= Objects.hashCode(environment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/sessions/{session}/entityTypes/{entity_type}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String agent;
    private String session;
    private String entityType;

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

    public String getSession() {
      return session;
    }

    public String getEntityType() {
      return entityType;
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

    public Builder setSession(String session) {
      this.session = session;
      return this;
    }

    public Builder setEntityType(String entityType) {
      this.entityType = entityType;
      return this;
    }

    private Builder(SessionEntityTypeName sessionEntityTypeName) {
      Preconditions.checkArgument(
          Objects.equals(
              sessionEntityTypeName.pathTemplate, PROJECT_LOCATION_AGENT_SESSION_ENTITY_TYPE),
          "toBuilder is only supported when SessionEntityTypeName has the pattern of projects/{project}/locations/{location}/agents/{agent}/sessions/{session}/entityTypes/{entity_type}");
      project = sessionEntityTypeName.project;
      location = sessionEntityTypeName.location;
      agent = sessionEntityTypeName.agent;
      session = sessionEntityTypeName.session;
      entityType = sessionEntityTypeName.entityType;
    }

    public SessionEntityTypeName build() {
      return new SessionEntityTypeName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/environments/{environment}/sessions/{session}/entityTypes/{entity_type}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationAgentEnvironmentSessionEntityTypeBuilder {
    private String project;
    private String location;
    private String agent;
    private String environment;
    private String session;
    private String entityType;

    protected ProjectLocationAgentEnvironmentSessionEntityTypeBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAgent() {
      return agent;
    }

    public String getEnvironment() {
      return environment;
    }

    public String getSession() {
      return session;
    }

    public String getEntityType() {
      return entityType;
    }

    public ProjectLocationAgentEnvironmentSessionEntityTypeBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionEntityTypeBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionEntityTypeBuilder setAgent(String agent) {
      this.agent = agent;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionEntityTypeBuilder setEnvironment(
        String environment) {
      this.environment = environment;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionEntityTypeBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionEntityTypeBuilder setEntityType(
        String entityType) {
      this.entityType = entityType;
      return this;
    }

    public SessionEntityTypeName build() {
      return new SessionEntityTypeName(this);
    }
  }
}
