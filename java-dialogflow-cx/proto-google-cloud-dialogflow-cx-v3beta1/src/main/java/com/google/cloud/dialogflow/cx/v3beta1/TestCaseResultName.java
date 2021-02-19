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
public class TestCaseResultName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_TEST_CASE_RESULT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/testCases/{test_case}/results/{result}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String agent;
  private final String testCase;
  private final String result;

  @Deprecated
  protected TestCaseResultName() {
    project = null;
    location = null;
    agent = null;
    testCase = null;
    result = null;
  }

  private TestCaseResultName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    testCase = Preconditions.checkNotNull(builder.getTestCase());
    result = Preconditions.checkNotNull(builder.getResult());
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

  public String getTestCase() {
    return testCase;
  }

  public String getResult() {
    return result;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TestCaseResultName of(
      String project, String location, String agent, String testCase, String result) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setTestCase(testCase)
        .setResult(result)
        .build();
  }

  public static String format(
      String project, String location, String agent, String testCase, String result) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setTestCase(testCase)
        .setResult(result)
        .build()
        .toString();
  }

  public static TestCaseResultName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AGENT_TEST_CASE_RESULT.validatedMatch(
            formattedString, "TestCaseResultName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("agent"),
        matchMap.get("test_case"),
        matchMap.get("result"));
  }

  public static List<TestCaseResultName> parseList(List<String> formattedStrings) {
    List<TestCaseResultName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TestCaseResultName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TestCaseResultName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_TEST_CASE_RESULT.matches(formattedString);
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
          if (testCase != null) {
            fieldMapBuilder.put("test_case", testCase);
          }
          if (result != null) {
            fieldMapBuilder.put("result", result);
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
    return PROJECT_LOCATION_AGENT_TEST_CASE_RESULT.instantiate(
        "project",
        project,
        "location",
        location,
        "agent",
        agent,
        "test_case",
        testCase,
        "result",
        result);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TestCaseResultName that = ((TestCaseResultName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.testCase, that.testCase)
          && Objects.equals(this.result, that.result);
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
    h ^= Objects.hashCode(testCase);
    h *= 1000003;
    h ^= Objects.hashCode(result);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/agents/{agent}/testCases/{test_case}/results/{result}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String agent;
    private String testCase;
    private String result;

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

    public String getTestCase() {
      return testCase;
    }

    public String getResult() {
      return result;
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

    public Builder setTestCase(String testCase) {
      this.testCase = testCase;
      return this;
    }

    public Builder setResult(String result) {
      this.result = result;
      return this;
    }

    private Builder(TestCaseResultName testCaseResultName) {
      project = testCaseResultName.project;
      location = testCaseResultName.location;
      agent = testCaseResultName.agent;
      testCase = testCaseResultName.testCase;
      result = testCaseResultName.result;
    }

    public TestCaseResultName build() {
      return new TestCaseResultName(this);
    }
  }
}
