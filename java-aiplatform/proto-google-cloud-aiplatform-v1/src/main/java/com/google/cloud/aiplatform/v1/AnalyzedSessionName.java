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

package com.google.cloud.aiplatform.v1;

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
public class AnalyzedSessionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MONITORED_AGENT_ANALYZED_SESSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String monitoredAgent;
  private final String analyzedSession;

  @Deprecated
  protected AnalyzedSessionName() {
    project = null;
    location = null;
    monitoredAgent = null;
    analyzedSession = null;
  }

  private AnalyzedSessionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    monitoredAgent = Preconditions.checkNotNull(builder.getMonitoredAgent());
    analyzedSession = Preconditions.checkNotNull(builder.getAnalyzedSession());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMonitoredAgent() {
    return monitoredAgent;
  }

  public String getAnalyzedSession() {
    return analyzedSession;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AnalyzedSessionName of(
      String project, String location, String monitoredAgent, String analyzedSession) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMonitoredAgent(monitoredAgent)
        .setAnalyzedSession(analyzedSession)
        .build();
  }

  public static String format(
      String project, String location, String monitoredAgent, String analyzedSession) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMonitoredAgent(monitoredAgent)
        .setAnalyzedSession(analyzedSession)
        .build()
        .toString();
  }

  public static @Nullable AnalyzedSessionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MONITORED_AGENT_ANALYZED_SESSION.validatedMatch(
            formattedString, "AnalyzedSessionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("monitored_agent"),
        matchMap.get("analyzed_session"));
  }

  public static List<AnalyzedSessionName> parseList(List<String> formattedStrings) {
    List<AnalyzedSessionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AnalyzedSessionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AnalyzedSessionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MONITORED_AGENT_ANALYZED_SESSION.matches(formattedString);
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
          if (monitoredAgent != null) {
            fieldMapBuilder.put("monitored_agent", monitoredAgent);
          }
          if (analyzedSession != null) {
            fieldMapBuilder.put("analyzed_session", analyzedSession);
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
    return PROJECT_LOCATION_MONITORED_AGENT_ANALYZED_SESSION.instantiate(
        "project",
        project,
        "location",
        location,
        "monitored_agent",
        monitoredAgent,
        "analyzed_session",
        analyzedSession);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AnalyzedSessionName that = ((AnalyzedSessionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.monitoredAgent, that.monitoredAgent)
          && Objects.equals(this.analyzedSession, that.analyzedSession);
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
    h ^= Objects.hashCode(monitoredAgent);
    h *= 1000003;
    h ^= Objects.hashCode(analyzedSession);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String monitoredAgent;
    private String analyzedSession;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMonitoredAgent() {
      return monitoredAgent;
    }

    public String getAnalyzedSession() {
      return analyzedSession;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMonitoredAgent(String monitoredAgent) {
      this.monitoredAgent = monitoredAgent;
      return this;
    }

    public Builder setAnalyzedSession(String analyzedSession) {
      this.analyzedSession = analyzedSession;
      return this;
    }

    private Builder(AnalyzedSessionName analyzedSessionName) {
      this.project = analyzedSessionName.project;
      this.location = analyzedSessionName.location;
      this.monitoredAgent = analyzedSessionName.monitoredAgent;
      this.analyzedSession = analyzedSessionName.analyzedSession;
    }

    public AnalyzedSessionName build() {
      return new AnalyzedSessionName(this);
    }
  }
}
