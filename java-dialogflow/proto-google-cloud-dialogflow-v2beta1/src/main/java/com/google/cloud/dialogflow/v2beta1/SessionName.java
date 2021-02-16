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

package com.google.cloud.dialogflow.v2beta1;

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
  private static final PathTemplate PROJECT_SESSION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/agent/sessions/{session}");
  private static final PathTemplate PROJECT_ENVIRONMENT_USER_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/agent/environments/{environment}/users/{user}/sessions/{session}");
  private static final PathTemplate PROJECT_LOCATION_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agent/sessions/{session}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String session;
  private final String environment;
  private final String user;
  private final String location;

  @Deprecated
  protected SessionName() {
    project = null;
    session = null;
    environment = null;
    user = null;
    location = null;
  }

  private SessionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    session = Preconditions.checkNotNull(builder.getSession());
    environment = null;
    user = null;
    location = null;
    pathTemplate = PROJECT_SESSION;
  }

  private SessionName(ProjectEnvironmentUserSessionBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    user = Preconditions.checkNotNull(builder.getUser());
    session = Preconditions.checkNotNull(builder.getSession());
    location = null;
    pathTemplate = PROJECT_ENVIRONMENT_USER_SESSION;
  }

  private SessionName(ProjectLocationSessionBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    session = Preconditions.checkNotNull(builder.getSession());
    environment = null;
    user = null;
    pathTemplate = PROJECT_LOCATION_SESSION;
  }

  public String getProject() {
    return project;
  }

  public String getSession() {
    return session;
  }

  public String getEnvironment() {
    return environment;
  }

  public String getUser() {
    return user;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectSessionBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectEnvironmentUserSessionBuilder newProjectEnvironmentUserSessionBuilder() {
    return new ProjectEnvironmentUserSessionBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationSessionBuilder newProjectLocationSessionBuilder() {
    return new ProjectLocationSessionBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SessionName of(String project, String session) {
    return newBuilder().setProject(project).setSession(session).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SessionName ofProjectSessionName(String project, String session) {
    return newBuilder().setProject(project).setSession(session).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SessionName ofProjectEnvironmentUserSessionName(
      String project, String environment, String user, String session) {
    return newProjectEnvironmentUserSessionBuilder()
        .setProject(project)
        .setEnvironment(environment)
        .setUser(user)
        .setSession(session)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SessionName ofProjectLocationSessionName(
      String project, String location, String session) {
    return newProjectLocationSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .build();
  }

  public static String format(String project, String session) {
    return newBuilder().setProject(project).setSession(session).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectSessionName(String project, String session) {
    return newBuilder().setProject(project).setSession(session).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectEnvironmentUserSessionName(
      String project, String environment, String user, String session) {
    return newProjectEnvironmentUserSessionBuilder()
        .setProject(project)
        .setEnvironment(environment)
        .setUser(user)
        .setSession(session)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationSessionName(
      String project, String location, String session) {
    return newProjectLocationSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .build()
        .toString();
  }

  public static SessionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_SESSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SESSION.match(formattedString);
      return ofProjectSessionName(matchMap.get("project"), matchMap.get("session"));
    } else if (PROJECT_ENVIRONMENT_USER_SESSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ENVIRONMENT_USER_SESSION.match(formattedString);
      return ofProjectEnvironmentUserSessionName(
          matchMap.get("project"),
          matchMap.get("environment"),
          matchMap.get("user"),
          matchMap.get("session"));
    } else if (PROJECT_LOCATION_SESSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SESSION.match(formattedString);
      return ofProjectLocationSessionName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("session"));
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
    return PROJECT_SESSION.matches(formattedString)
        || PROJECT_ENVIRONMENT_USER_SESSION.matches(formattedString)
        || PROJECT_LOCATION_SESSION.matches(formattedString);
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
          if (session != null) {
            fieldMapBuilder.put("session", session);
          }
          if (environment != null) {
            fieldMapBuilder.put("environment", environment);
          }
          if (user != null) {
            fieldMapBuilder.put("user", user);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
          && Objects.equals(this.session, that.session)
          && Objects.equals(this.environment, that.environment)
          && Objects.equals(this.user, that.user)
          && Objects.equals(this.location, that.location);
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
    h ^= Objects.hashCode(session);
    h *= 1000003;
    h ^= Objects.hashCode(environment);
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/agent/sessions/{session}. */
  public static class Builder {
    private String project;
    private String session;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getSession() {
      return session;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSession(String session) {
      this.session = session;
      return this;
    }

    private Builder(SessionName sessionName) {
      Preconditions.checkArgument(
          Objects.equals(sessionName.pathTemplate, PROJECT_SESSION),
          "toBuilder is only supported when SessionName has the pattern of projects/{project}/agent/sessions/{session}");
      project = sessionName.project;
      session = sessionName.session;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/agent/environments/{environment}/users/{user}/sessions/{session}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectEnvironmentUserSessionBuilder {
    private String project;
    private String environment;
    private String user;
    private String session;

    protected ProjectEnvironmentUserSessionBuilder() {}

    public String getProject() {
      return project;
    }

    public String getEnvironment() {
      return environment;
    }

    public String getUser() {
      return user;
    }

    public String getSession() {
      return session;
    }

    public ProjectEnvironmentUserSessionBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectEnvironmentUserSessionBuilder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    public ProjectEnvironmentUserSessionBuilder setUser(String user) {
      this.user = user;
      return this;
    }

    public ProjectEnvironmentUserSessionBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/agent/sessions/{session}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationSessionBuilder {
    private String project;
    private String location;
    private String session;

    protected ProjectLocationSessionBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSession() {
      return session;
    }

    public ProjectLocationSessionBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationSessionBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationSessionBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }
}
