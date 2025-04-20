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

package com.google.cloud.aiplatform.v1beta1;

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
  private static final PathTemplate PROJECT_LOCATION_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sessions/{session}");
  private static final PathTemplate PROJECT_LOCATION_REASONING_ENGINE_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String session;
  private final String reasoningEngine;

  @Deprecated
  protected SessionName() {
    project = null;
    location = null;
    session = null;
    reasoningEngine = null;
  }

  private SessionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    session = Preconditions.checkNotNull(builder.getSession());
    reasoningEngine = null;
    pathTemplate = PROJECT_LOCATION_SESSION;
  }

  private SessionName(ProjectLocationReasoningEngineSessionBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reasoningEngine = Preconditions.checkNotNull(builder.getReasoningEngine());
    session = Preconditions.checkNotNull(builder.getSession());
    pathTemplate = PROJECT_LOCATION_REASONING_ENGINE_SESSION;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSession() {
    return session;
  }

  public String getReasoningEngine() {
    return reasoningEngine;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationSessionBuilder() {
    return new Builder();
  }

  public static ProjectLocationReasoningEngineSessionBuilder
      newProjectLocationReasoningEngineSessionBuilder() {
    return new ProjectLocationReasoningEngineSessionBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SessionName of(String project, String location, String session) {
    return newBuilder().setProject(project).setLocation(location).setSession(session).build();
  }

  public static SessionName ofProjectLocationSessionName(
      String project, String location, String session) {
    return newBuilder().setProject(project).setLocation(location).setSession(session).build();
  }

  public static SessionName ofProjectLocationReasoningEngineSessionName(
      String project, String location, String reasoningEngine, String session) {
    return newProjectLocationReasoningEngineSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .setSession(session)
        .build();
  }

  public static String format(String project, String location, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .build()
        .toString();
  }

  public static String formatProjectLocationSessionName(
      String project, String location, String session) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .build()
        .toString();
  }

  public static String formatProjectLocationReasoningEngineSessionName(
      String project, String location, String reasoningEngine, String session) {
    return newProjectLocationReasoningEngineSessionBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .setSession(session)
        .build()
        .toString();
  }

  public static SessionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_SESSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SESSION.match(formattedString);
      return ofProjectLocationSessionName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("session"));
    } else if (PROJECT_LOCATION_REASONING_ENGINE_SESSION.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_REASONING_ENGINE_SESSION.match(formattedString);
      return ofProjectLocationReasoningEngineSessionName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("reasoning_engine"),
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
    return PROJECT_LOCATION_SESSION.matches(formattedString)
        || PROJECT_LOCATION_REASONING_ENGINE_SESSION.matches(formattedString);
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
          if (session != null) {
            fieldMapBuilder.put("session", session);
          }
          if (reasoningEngine != null) {
            fieldMapBuilder.put("reasoning_engine", reasoningEngine);
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
      SessionName that = ((SessionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.session, that.session)
          && Objects.equals(this.reasoningEngine, that.reasoningEngine);
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
    h ^= Objects.hashCode(session);
    h *= 1000003;
    h ^= Objects.hashCode(reasoningEngine);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/sessions/{session}. */
  public static class Builder {
    private String project;
    private String location;
    private String session;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
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

    public Builder setSession(String session) {
      this.session = session;
      return this;
    }

    private Builder(SessionName sessionName) {
      Preconditions.checkArgument(
          Objects.equals(sessionName.pathTemplate, PROJECT_LOCATION_SESSION),
          "toBuilder is only supported when SessionName has the pattern of"
              + " projects/{project}/locations/{location}/sessions/{session}");
      this.project = sessionName.project;
      this.location = sessionName.location;
      this.session = sessionName.session;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}.
   */
  public static class ProjectLocationReasoningEngineSessionBuilder {
    private String project;
    private String location;
    private String reasoningEngine;
    private String session;

    protected ProjectLocationReasoningEngineSessionBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getReasoningEngine() {
      return reasoningEngine;
    }

    public String getSession() {
      return session;
    }

    public ProjectLocationReasoningEngineSessionBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationReasoningEngineSessionBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationReasoningEngineSessionBuilder setReasoningEngine(String reasoningEngine) {
      this.reasoningEngine = reasoningEngine;
      return this;
    }

    public ProjectLocationReasoningEngineSessionBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public SessionName build() {
      return new SessionName(this);
    }
  }
}
