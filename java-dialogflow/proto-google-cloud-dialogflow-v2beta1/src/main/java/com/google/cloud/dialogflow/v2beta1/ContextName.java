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
public class ContextName implements ResourceName {
  private static final PathTemplate PROJECT_SESSION_CONTEXT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/agent/sessions/{session}/contexts/{context}");
  private static final PathTemplate PROJECT_ENVIRONMENT_USER_SESSION_CONTEXT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/agent/environments/{environment}/users/{user}/sessions/{session}/contexts/{context}");
  private static final PathTemplate PROJECT_LOCATION_SESSION_CONTEXT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agent/sessions/{session}/contexts/{context}");
  private static final PathTemplate PROJECT_LOCATION_ENVIRONMENT_USER_SESSION_CONTEXT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agent/environments/{environment}/users/{user}/sessions/{session}/contexts/{context}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String session;
  private final String context;
  private final String environment;
  private final String user;
  private final String location;

  @Deprecated
  protected ContextName() {
    project = null;
    session = null;
    context = null;
    environment = null;
    user = null;
    location = null;
  }

  private ContextName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    session = Preconditions.checkNotNull(builder.getSession());
    context = Preconditions.checkNotNull(builder.getContext());
    environment = null;
    user = null;
    location = null;
    pathTemplate = PROJECT_SESSION_CONTEXT;
  }

  private ContextName(ProjectEnvironmentUserSessionContextBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    user = Preconditions.checkNotNull(builder.getUser());
    session = Preconditions.checkNotNull(builder.getSession());
    context = Preconditions.checkNotNull(builder.getContext());
    location = null;
    pathTemplate = PROJECT_ENVIRONMENT_USER_SESSION_CONTEXT;
  }

  private ContextName(ProjectLocationSessionContextBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    session = Preconditions.checkNotNull(builder.getSession());
    context = Preconditions.checkNotNull(builder.getContext());
    environment = null;
    user = null;
    pathTemplate = PROJECT_LOCATION_SESSION_CONTEXT;
  }

  private ContextName(ProjectLocationEnvironmentUserSessionContextBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    user = Preconditions.checkNotNull(builder.getUser());
    session = Preconditions.checkNotNull(builder.getSession());
    context = Preconditions.checkNotNull(builder.getContext());
    pathTemplate = PROJECT_LOCATION_ENVIRONMENT_USER_SESSION_CONTEXT;
  }

  public String getProject() {
    return project;
  }

  public String getSession() {
    return session;
  }

  public String getContext() {
    return context;
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

  public static Builder newProjectSessionContextBuilder() {
    return new Builder();
  }

  public static ProjectEnvironmentUserSessionContextBuilder
      newProjectEnvironmentUserSessionContextBuilder() {
    return new ProjectEnvironmentUserSessionContextBuilder();
  }

  public static ProjectLocationSessionContextBuilder newProjectLocationSessionContextBuilder() {
    return new ProjectLocationSessionContextBuilder();
  }

  public static ProjectLocationEnvironmentUserSessionContextBuilder
      newProjectLocationEnvironmentUserSessionContextBuilder() {
    return new ProjectLocationEnvironmentUserSessionContextBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ContextName of(String project, String session, String context) {
    return newBuilder().setProject(project).setSession(session).setContext(context).build();
  }

  public static ContextName ofProjectSessionContextName(
      String project, String session, String context) {
    return newBuilder().setProject(project).setSession(session).setContext(context).build();
  }

  public static ContextName ofProjectEnvironmentUserSessionContextName(
      String project, String environment, String user, String session, String context) {
    return newProjectEnvironmentUserSessionContextBuilder()
        .setProject(project)
        .setEnvironment(environment)
        .setUser(user)
        .setSession(session)
        .setContext(context)
        .build();
  }

  public static ContextName ofProjectLocationSessionContextName(
      String project, String location, String session, String context) {
    return newProjectLocationSessionContextBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .setContext(context)
        .build();
  }

  public static ContextName ofProjectLocationEnvironmentUserSessionContextName(
      String project,
      String location,
      String environment,
      String user,
      String session,
      String context) {
    return newProjectLocationEnvironmentUserSessionContextBuilder()
        .setProject(project)
        .setLocation(location)
        .setEnvironment(environment)
        .setUser(user)
        .setSession(session)
        .setContext(context)
        .build();
  }

  public static String format(String project, String session, String context) {
    return newBuilder()
        .setProject(project)
        .setSession(session)
        .setContext(context)
        .build()
        .toString();
  }

  public static String formatProjectSessionContextName(
      String project, String session, String context) {
    return newBuilder()
        .setProject(project)
        .setSession(session)
        .setContext(context)
        .build()
        .toString();
  }

  public static String formatProjectEnvironmentUserSessionContextName(
      String project, String environment, String user, String session, String context) {
    return newProjectEnvironmentUserSessionContextBuilder()
        .setProject(project)
        .setEnvironment(environment)
        .setUser(user)
        .setSession(session)
        .setContext(context)
        .build()
        .toString();
  }

  public static String formatProjectLocationSessionContextName(
      String project, String location, String session, String context) {
    return newProjectLocationSessionContextBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .setContext(context)
        .build()
        .toString();
  }

  public static String formatProjectLocationEnvironmentUserSessionContextName(
      String project,
      String location,
      String environment,
      String user,
      String session,
      String context) {
    return newProjectLocationEnvironmentUserSessionContextBuilder()
        .setProject(project)
        .setLocation(location)
        .setEnvironment(environment)
        .setUser(user)
        .setSession(session)
        .setContext(context)
        .build()
        .toString();
  }

  public static ContextName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_SESSION_CONTEXT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SESSION_CONTEXT.match(formattedString);
      return ofProjectSessionContextName(
          matchMap.get("project"), matchMap.get("session"), matchMap.get("context"));
    } else if (PROJECT_ENVIRONMENT_USER_SESSION_CONTEXT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_ENVIRONMENT_USER_SESSION_CONTEXT.match(formattedString);
      return ofProjectEnvironmentUserSessionContextName(
          matchMap.get("project"),
          matchMap.get("environment"),
          matchMap.get("user"),
          matchMap.get("session"),
          matchMap.get("context"));
    } else if (PROJECT_LOCATION_SESSION_CONTEXT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SESSION_CONTEXT.match(formattedString);
      return ofProjectLocationSessionContextName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("session"),
          matchMap.get("context"));
    } else if (PROJECT_LOCATION_ENVIRONMENT_USER_SESSION_CONTEXT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_ENVIRONMENT_USER_SESSION_CONTEXT.match(formattedString);
      return ofProjectLocationEnvironmentUserSessionContextName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("environment"),
          matchMap.get("user"),
          matchMap.get("session"),
          matchMap.get("context"));
    }
    throw new ValidationException("ContextName.parse: formattedString not in valid format");
  }

  public static List<ContextName> parseList(List<String> formattedStrings) {
    List<ContextName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ContextName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ContextName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SESSION_CONTEXT.matches(formattedString)
        || PROJECT_ENVIRONMENT_USER_SESSION_CONTEXT.matches(formattedString)
        || PROJECT_LOCATION_SESSION_CONTEXT.matches(formattedString)
        || PROJECT_LOCATION_ENVIRONMENT_USER_SESSION_CONTEXT.matches(formattedString);
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
          if (context != null) {
            fieldMapBuilder.put("context", context);
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
    if (o != null && getClass() == o.getClass()) {
      ContextName that = ((ContextName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.session, that.session)
          && Objects.equals(this.context, that.context)
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
    h ^= Objects.hashCode(context);
    h *= 1000003;
    h ^= Objects.hashCode(environment);
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/agent/sessions/{session}/contexts/{context}. */
  public static class Builder {
    private String project;
    private String session;
    private String context;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getSession() {
      return session;
    }

    public String getContext() {
      return context;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSession(String session) {
      this.session = session;
      return this;
    }

    public Builder setContext(String context) {
      this.context = context;
      return this;
    }

    private Builder(ContextName contextName) {
      Preconditions.checkArgument(
          Objects.equals(contextName.pathTemplate, PROJECT_SESSION_CONTEXT),
          "toBuilder is only supported when ContextName has the pattern of projects/{project}/agent/sessions/{session}/contexts/{context}");
      this.project = contextName.project;
      this.session = contextName.session;
      this.context = contextName.context;
    }

    public ContextName build() {
      return new ContextName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/agent/environments/{environment}/users/{user}/sessions/{session}/contexts/{context}.
   */
  public static class ProjectEnvironmentUserSessionContextBuilder {
    private String project;
    private String environment;
    private String user;
    private String session;
    private String context;

    protected ProjectEnvironmentUserSessionContextBuilder() {}

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

    public String getContext() {
      return context;
    }

    public ProjectEnvironmentUserSessionContextBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectEnvironmentUserSessionContextBuilder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    public ProjectEnvironmentUserSessionContextBuilder setUser(String user) {
      this.user = user;
      return this;
    }

    public ProjectEnvironmentUserSessionContextBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public ProjectEnvironmentUserSessionContextBuilder setContext(String context) {
      this.context = context;
      return this;
    }

    public ContextName build() {
      return new ContextName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agent/sessions/{session}/contexts/{context}.
   */
  public static class ProjectLocationSessionContextBuilder {
    private String project;
    private String location;
    private String session;
    private String context;

    protected ProjectLocationSessionContextBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSession() {
      return session;
    }

    public String getContext() {
      return context;
    }

    public ProjectLocationSessionContextBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationSessionContextBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationSessionContextBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public ProjectLocationSessionContextBuilder setContext(String context) {
      this.context = context;
      return this;
    }

    public ContextName build() {
      return new ContextName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agent/environments/{environment}/users/{user}/sessions/{session}/contexts/{context}.
   */
  public static class ProjectLocationEnvironmentUserSessionContextBuilder {
    private String project;
    private String location;
    private String environment;
    private String user;
    private String session;
    private String context;

    protected ProjectLocationEnvironmentUserSessionContextBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
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

    public String getContext() {
      return context;
    }

    public ProjectLocationEnvironmentUserSessionContextBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationEnvironmentUserSessionContextBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationEnvironmentUserSessionContextBuilder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    public ProjectLocationEnvironmentUserSessionContextBuilder setUser(String user) {
      this.user = user;
      return this;
    }

    public ProjectLocationEnvironmentUserSessionContextBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public ProjectLocationEnvironmentUserSessionContextBuilder setContext(String context) {
      this.context = context;
      return this;
    }

    public ContextName build() {
      return new ContextName(this);
    }
  }
}
