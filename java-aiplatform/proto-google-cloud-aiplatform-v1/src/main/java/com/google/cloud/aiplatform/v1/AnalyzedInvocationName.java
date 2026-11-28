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
public class AnalyzedInvocationName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_MONITORED_AGENT_ANALYZED_SESSION_ANALYZED_INVOCATION =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}/analyzedInvocations/{analyzed_invocation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String monitoredAgent;
  private final String analyzedSession;
  private final String analyzedInvocation;

  @Deprecated
  protected AnalyzedInvocationName() {
    project = null;
    location = null;
    monitoredAgent = null;
    analyzedSession = null;
    analyzedInvocation = null;
  }

  private AnalyzedInvocationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    monitoredAgent = Preconditions.checkNotNull(builder.getMonitoredAgent());
    analyzedSession = Preconditions.checkNotNull(builder.getAnalyzedSession());
    analyzedInvocation = Preconditions.checkNotNull(builder.getAnalyzedInvocation());
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

  public String getAnalyzedInvocation() {
    return analyzedInvocation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AnalyzedInvocationName of(
      String project,
      String location,
      String monitoredAgent,
      String analyzedSession,
      String analyzedInvocation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMonitoredAgent(monitoredAgent)
        .setAnalyzedSession(analyzedSession)
        .setAnalyzedInvocation(analyzedInvocation)
        .build();
  }

  public static String format(
      String project,
      String location,
      String monitoredAgent,
      String analyzedSession,
      String analyzedInvocation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMonitoredAgent(monitoredAgent)
        .setAnalyzedSession(analyzedSession)
        .setAnalyzedInvocation(analyzedInvocation)
        .build()
        .toString();
  }

  public static @Nullable AnalyzedInvocationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MONITORED_AGENT_ANALYZED_SESSION_ANALYZED_INVOCATION.validatedMatch(
            formattedString, "AnalyzedInvocationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("monitored_agent"),
        matchMap.get("analyzed_session"),
        matchMap.get("analyzed_invocation"));
  }

  public static List<AnalyzedInvocationName> parseList(List<String> formattedStrings) {
    List<AnalyzedInvocationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AnalyzedInvocationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AnalyzedInvocationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MONITORED_AGENT_ANALYZED_SESSION_ANALYZED_INVOCATION.matches(
        formattedString);
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
          if (analyzedInvocation != null) {
            fieldMapBuilder.put("analyzed_invocation", analyzedInvocation);
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
    return PROJECT_LOCATION_MONITORED_AGENT_ANALYZED_SESSION_ANALYZED_INVOCATION.instantiate(
        "project",
        project,
        "location",
        location,
        "monitored_agent",
        monitoredAgent,
        "analyzed_session",
        analyzedSession,
        "analyzed_invocation",
        analyzedInvocation);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AnalyzedInvocationName that = ((AnalyzedInvocationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.monitoredAgent, that.monitoredAgent)
          && Objects.equals(this.analyzedSession, that.analyzedSession)
          && Objects.equals(this.analyzedInvocation, that.analyzedInvocation);
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
    h *= 1000003;
    h ^= Objects.hashCode(analyzedInvocation);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}/analyzedInvocations/{analyzed_invocation}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String monitoredAgent;
    private String analyzedSession;
    private String analyzedInvocation;

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

    public String getAnalyzedInvocation() {
      return analyzedInvocation;
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

    public Builder setAnalyzedInvocation(String analyzedInvocation) {
      this.analyzedInvocation = analyzedInvocation;
      return this;
    }

    private Builder(AnalyzedInvocationName analyzedInvocationName) {
      this.project = analyzedInvocationName.project;
      this.location = analyzedInvocationName.location;
      this.monitoredAgent = analyzedInvocationName.monitoredAgent;
      this.analyzedSession = analyzedInvocationName.analyzedSession;
      this.analyzedInvocation = analyzedInvocationName.analyzedInvocation;
    }

    public AnalyzedInvocationName build() {
      return new AnalyzedInvocationName(this);
    }
  }
}
