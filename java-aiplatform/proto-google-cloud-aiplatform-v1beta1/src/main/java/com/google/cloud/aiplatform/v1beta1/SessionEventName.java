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
public class SessionEventName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SESSION_EVENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sessions/{session}/events/{event}");
  private static final PathTemplate PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}/events/{event}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String session;
  private final String event;
  private final String reasoningEngine;

  @Deprecated
  protected SessionEventName() {
    project = null;
    location = null;
    session = null;
    event = null;
    reasoningEngine = null;
  }

  private SessionEventName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    session = Preconditions.checkNotNull(builder.getSession());
    event = Preconditions.checkNotNull(builder.getEvent());
    reasoningEngine = null;
    pathTemplate = PROJECT_LOCATION_SESSION_EVENT;
  }

  private SessionEventName(ProjectLocationReasoningEngineSessionEventBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reasoningEngine = Preconditions.checkNotNull(builder.getReasoningEngine());
    session = Preconditions.checkNotNull(builder.getSession());
    event = Preconditions.checkNotNull(builder.getEvent());
    pathTemplate = PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT;
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

  public String getEvent() {
    return event;
  }

  public String getReasoningEngine() {
    return reasoningEngine;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationSessionEventBuilder() {
    return new Builder();
  }

  public static ProjectLocationReasoningEngineSessionEventBuilder
      newProjectLocationReasoningEngineSessionEventBuilder() {
    return new ProjectLocationReasoningEngineSessionEventBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SessionEventName of(String project, String location, String session, String event) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .setEvent(event)
        .build();
  }

  public static SessionEventName ofProjectLocationSessionEventName(
      String project, String location, String session, String event) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .setEvent(event)
        .build();
  }

  public static SessionEventName ofProjectLocationReasoningEngineSessionEventName(
      String project, String location, String reasoningEngine, String session, String event) {
    return newProjectLocationReasoningEngineSessionEventBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .setSession(session)
        .setEvent(event)
        .build();
  }

  public static String format(String project, String location, String session, String event) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .setEvent(event)
        .build()
        .toString();
  }

  public static String formatProjectLocationSessionEventName(
      String project, String location, String session, String event) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSession(session)
        .setEvent(event)
        .build()
        .toString();
  }

  public static String formatProjectLocationReasoningEngineSessionEventName(
      String project, String location, String reasoningEngine, String session, String event) {
    return newProjectLocationReasoningEngineSessionEventBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .setSession(session)
        .setEvent(event)
        .build()
        .toString();
  }

  public static SessionEventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_SESSION_EVENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SESSION_EVENT.match(formattedString);
      return ofProjectLocationSessionEventName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("session"),
          matchMap.get("event"));
    } else if (PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT.match(formattedString);
      return ofProjectLocationReasoningEngineSessionEventName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("reasoning_engine"),
          matchMap.get("session"),
          matchMap.get("event"));
    }
    throw new ValidationException("SessionEventName.parse: formattedString not in valid format");
  }

  public static List<SessionEventName> parseList(List<String> formattedStrings) {
    List<SessionEventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SessionEventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SessionEventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SESSION_EVENT.matches(formattedString)
        || PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT.matches(formattedString);
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
          if (event != null) {
            fieldMapBuilder.put("event", event);
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
      SessionEventName that = ((SessionEventName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.session, that.session)
          && Objects.equals(this.event, that.event)
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
    h ^= Objects.hashCode(event);
    h *= 1000003;
    h ^= Objects.hashCode(reasoningEngine);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/sessions/{session}/events/{event}. */
  public static class Builder {
    private String project;
    private String location;
    private String session;
    private String event;

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

    public String getEvent() {
      return event;
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

    public Builder setEvent(String event) {
      this.event = event;
      return this;
    }

    private Builder(SessionEventName sessionEventName) {
      Preconditions.checkArgument(
          Objects.equals(sessionEventName.pathTemplate, PROJECT_LOCATION_SESSION_EVENT),
          "toBuilder is only supported when SessionEventName has the pattern of"
              + " projects/{project}/locations/{location}/sessions/{session}/events/{event}");
      this.project = sessionEventName.project;
      this.location = sessionEventName.location;
      this.session = sessionEventName.session;
      this.event = sessionEventName.event;
    }

    public SessionEventName build() {
      return new SessionEventName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}/events/{event}.
   */
  public static class ProjectLocationReasoningEngineSessionEventBuilder {
    private String project;
    private String location;
    private String reasoningEngine;
    private String session;
    private String event;

    protected ProjectLocationReasoningEngineSessionEventBuilder() {}

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

    public String getEvent() {
      return event;
    }

    public ProjectLocationReasoningEngineSessionEventBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationReasoningEngineSessionEventBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationReasoningEngineSessionEventBuilder setReasoningEngine(
        String reasoningEngine) {
      this.reasoningEngine = reasoningEngine;
      return this;
    }

    public ProjectLocationReasoningEngineSessionEventBuilder setSession(String session) {
      this.session = session;
      return this;
    }

    public ProjectLocationReasoningEngineSessionEventBuilder setEvent(String event) {
      this.event = event;
      return this;
    }

    public SessionEventName build() {
      return new SessionEventName(this);
    }
  }
}
