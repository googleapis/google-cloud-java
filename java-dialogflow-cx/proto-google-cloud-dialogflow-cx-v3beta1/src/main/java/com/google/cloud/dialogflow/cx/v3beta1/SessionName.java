/*
 * Copyright 2022 Google LLC
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
public class SessionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/sessions/{session}");
  private static final PathTemplate PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/environments/{environment}/sessions/{session}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String agent;
  private final String session;
  private final String environment;

  @Deprecated
  protected SessionName() {
    project = null;
    location = null;
    agent = null;
    session = null;
    environment = null;
  }

  private SessionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    session = Preconditions.checkNotNull(builder.getSession());
    environment = null;
    pathTemplate = PROJECT_LOCATION_AGENT_SESSION;
  }

  private SessionName(ProjectLocationAgentEnvironmentSessionBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    session = Preconditions.checkNotNull(builder.getSession());
    pathTemplate = PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION;
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

  public String getEnvironment() {
    return environment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationAgentSessionBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationAgentEnvironmentSessionBuilder
      newProjectLocationAgentEnvironmentSessionBuilder() {
    return new ProjectLocationAgentEnvironmentSessionBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SessionName of(String project, String location, String agent, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setSession(session)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SessionName ofProjectLocationAgentSessionName(
      String project, String location, String agent, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setSession(session)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SessionName ofProjectLocationAgentEnvironmentSessionName(
      String project, String location, String agent, String environment, String session) {
    return newProjectLocationAgentEnvironmentSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setEnvironment(environment)
        .setSession(session)
        .build();
  }

  public static String format(String project, String location, String agent, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setSession(session)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationAgentSessionName(
      String project, String location, String agent, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setSession(session)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationAgentEnvironmentSessionName(
      String project, String location, String agent, String environment, String session) {
    return newProjectLocationAgentEnvironmentSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setEnvironment(environment)
        .setSession(session)
        .build()
        .toString();
  }

  public static SessionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_AGENT_SESSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_AGENT_SESSION.match(formattedString);
      return ofProjectLocationAgentSessionName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("agent"),
          matchMap.get("session"));
    } else if (PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION.match(formattedString);
      return ofProjectLocationAgentEnvironmentSessionName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("agent"),
          matchMap.get("environment"),
          matchMap.get("session"));
    }
    throw new ValidationException("SessionName.parse: formattedString not in valid format");
  }

  public static List<SessionName> parseList(List<String> formattedStrings) {
    List<SessionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SessionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SessionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_SESSION.matches(formattedString)
        || PROJECT_LOCATION_AGENT_ENVIRONMENT_SESSION.matches(formattedString);
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
      SessionName that = ((SessionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.session, that.session)
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
    h ^= Objects.hashCode(environment);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/agents/{agent}/sessions/{session}. */
  public static class Builder {
    private String project;
    private String location;
    private String agent;
    private String session;

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

    private Builder(SessionName sessionName) {
      Preconditions.checkArgument(
          Objects.equals(sessionName.pathTemplate, PROJECT_LOCATION_AGENT_SESSION),
          "toBuilder is only supported when SessionName has the pattern of projects/{project}/locations/{location}/agents/{agent}/sessions/{session}");
      this.project = sessionName.project;
      this.location = sessionName.location;
      this.agent = sessionName.agent;
      this.session = sessionName.session;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/environments/{environment}/sessions/{session}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationAgentEnvironmentSessionBuilder {
    private String project;
    private String location;
    private String agent;
    private String environment;
    private String session;

    protected ProjectLocationAgentEnvironmentSessionBuilder() {}

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

    public ProjectLocationAgentEnvironmentSessionBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionBuilder setAgent(String agent) {
      this.agent = agent;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionBuilder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    public ProjectLocationAgentEnvironmentSessionBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }
}
