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
  private static final PathTemplate PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}/events/{event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String reasoningEngine;
  private final String session;
  private final String event;

  @Deprecated
  protected SessionEventName() {
    project = null;
    location = null;
    reasoningEngine = null;
    session = null;
    event = null;
  }

  private SessionEventName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    reasoningEngine = Preconditions.checkNotNull(builder.getReasoningEngine());
    session = Preconditions.checkNotNull(builder.getSession());
    event = Preconditions.checkNotNull(builder.getEvent());
  }

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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SessionEventName of(
      String project, String location, String reasoningEngine, String session, String event) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReasoningEngine(reasoningEngine)
        .setSession(session)
        .setEvent(event)
        .build();
  }

  public static String format(
      String project, String location, String reasoningEngine, String session, String event) {
    return newBuilder()
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
    Map<String, String> matchMap =
        PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT.validatedMatch(
            formattedString, "SessionEventName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("reasoning_engine"),
        matchMap.get("session"),
        matchMap.get("event"));
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
    return PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT.matches(formattedString);
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
          if (reasoningEngine != null) {
            fieldMapBuilder.put("reasoning_engine", reasoningEngine);
          }
          if (session != null) {
            fieldMapBuilder.put("session", session);
          }
          if (event != null) {
            fieldMapBuilder.put("event", event);
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
    return PROJECT_LOCATION_REASONING_ENGINE_SESSION_EVENT.instantiate(
        "project",
        project,
        "location",
        location,
        "reasoning_engine",
        reasoningEngine,
        "session",
        session,
        "event",
        event);
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
          && Objects.equals(this.reasoningEngine, that.reasoningEngine)
          && Objects.equals(this.session, that.session)
          && Objects.equals(this.event, that.event);
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
    h ^= Objects.hashCode(reasoningEngine);
    h *= 1000003;
    h ^= Objects.hashCode(session);
    h *= 1000003;
    h ^= Objects.hashCode(event);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/sessions/{session}/events/{event}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String reasoningEngine;
    private String session;
    private String event;

    protected Builder() {}

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

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setReasoningEngine(String reasoningEngine) {
      this.reasoningEngine = reasoningEngine;
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
      this.project = sessionEventName.project;
      this.location = sessionEventName.location;
      this.reasoningEngine = sessionEventName.reasoningEngine;
      this.session = sessionEventName.session;
      this.event = sessionEventName.event;
    }

    public SessionEventName build() {
      return new SessionEventName(this);
    }
  }
}
