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
public class ContinuousTestResultName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_ENVIRONMENT_CONTINUOUS_TEST_RESULT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/environments/{environment}/continuousTestResults/{continuous_test_result}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String agent;
  private final String environment;
  private final String continuousTestResult;

  @Deprecated
  protected ContinuousTestResultName() {
    project = null;
    location = null;
    agent = null;
    environment = null;
    continuousTestResult = null;
  }

  private ContinuousTestResultName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
    continuousTestResult = Preconditions.checkNotNull(builder.getContinuousTestResult());
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

  public String getEnvironment() {
    return environment;
  }

  public String getContinuousTestResult() {
    return continuousTestResult;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ContinuousTestResultName of(
      String project,
      String location,
      String agent,
      String environment,
      String continuousTestResult) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setEnvironment(environment)
        .setContinuousTestResult(continuousTestResult)
        .build();
  }

  public static String format(
      String project,
      String location,
      String agent,
      String environment,
      String continuousTestResult) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setEnvironment(environment)
        .setContinuousTestResult(continuousTestResult)
        .build()
        .toString();
  }

  public static ContinuousTestResultName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AGENT_ENVIRONMENT_CONTINUOUS_TEST_RESULT.validatedMatch(
            formattedString, "ContinuousTestResultName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("agent"),
        matchMap.get("environment"),
        matchMap.get("continuous_test_result"));
  }

  public static List<ContinuousTestResultName> parseList(List<String> formattedStrings) {
    List<ContinuousTestResultName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ContinuousTestResultName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ContinuousTestResultName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_ENVIRONMENT_CONTINUOUS_TEST_RESULT.matches(formattedString);
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
          if (environment != null) {
            fieldMapBuilder.put("environment", environment);
          }
          if (continuousTestResult != null) {
            fieldMapBuilder.put("continuous_test_result", continuousTestResult);
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
    return PROJECT_LOCATION_AGENT_ENVIRONMENT_CONTINUOUS_TEST_RESULT.instantiate(
        "project",
        project,
        "location",
        location,
        "agent",
        agent,
        "environment",
        environment,
        "continuous_test_result",
        continuousTestResult);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ContinuousTestResultName that = ((ContinuousTestResultName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.environment, that.environment)
          && Objects.equals(this.continuousTestResult, that.continuousTestResult);
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
    h ^= Objects.hashCode(agent);
    h *= 1000003;
    h ^= Objects.hashCode(environment);
    h *= 1000003;
    h ^= Objects.hashCode(continuousTestResult);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/environments/{environment}/continuousTestResults/{continuous_test_result}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String agent;
    private String environment;
    private String continuousTestResult;

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

    public String getEnvironment() {
      return environment;
    }

    public String getContinuousTestResult() {
      return continuousTestResult;
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

    public Builder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    public Builder setContinuousTestResult(String continuousTestResult) {
      this.continuousTestResult = continuousTestResult;
      return this;
    }

    private Builder(ContinuousTestResultName continuousTestResultName) {
      this.project = continuousTestResultName.project;
      this.location = continuousTestResultName.location;
      this.agent = continuousTestResultName.agent;
      this.environment = continuousTestResultName.environment;
      this.continuousTestResult = continuousTestResultName.continuousTestResult;
    }

    public ContinuousTestResultName build() {
      return new ContinuousTestResultName(this);
    }
  }
}
