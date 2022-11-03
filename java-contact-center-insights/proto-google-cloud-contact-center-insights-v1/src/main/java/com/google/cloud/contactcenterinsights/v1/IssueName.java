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

package com.google.cloud.contactcenterinsights.v1;

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
public class IssueName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ISSUE_MODEL_ISSUE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/issueModels/{issue_model}/issues/{issue}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String issueModel;
  private final String issue;

  @Deprecated
  protected IssueName() {
    project = null;
    location = null;
    issueModel = null;
    issue = null;
  }

  private IssueName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    issueModel = Preconditions.checkNotNull(builder.getIssueModel());
    issue = Preconditions.checkNotNull(builder.getIssue());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getIssueModel() {
    return issueModel;
  }

  public String getIssue() {
    return issue;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static IssueName of(String project, String location, String issueModel, String issue) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setIssueModel(issueModel)
        .setIssue(issue)
        .build();
  }

  public static String format(String project, String location, String issueModel, String issue) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setIssueModel(issueModel)
        .setIssue(issue)
        .build()
        .toString();
  }

  public static IssueName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ISSUE_MODEL_ISSUE.validatedMatch(
            formattedString, "IssueName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("issue_model"),
        matchMap.get("issue"));
  }

  public static List<IssueName> parseList(List<String> formattedStrings) {
    List<IssueName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<IssueName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (IssueName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ISSUE_MODEL_ISSUE.matches(formattedString);
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
          if (issueModel != null) {
            fieldMapBuilder.put("issue_model", issueModel);
          }
          if (issue != null) {
            fieldMapBuilder.put("issue", issue);
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
    return PROJECT_LOCATION_ISSUE_MODEL_ISSUE.instantiate(
        "project", project, "location", location, "issue_model", issueModel, "issue", issue);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      IssueName that = ((IssueName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.issueModel, that.issueModel)
          && Objects.equals(this.issue, that.issue);
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
    h ^= Objects.hashCode(issueModel);
    h *= 1000003;
    h ^= Objects.hashCode(issue);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/issueModels/{issue_model}/issues/{issue}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String issueModel;
    private String issue;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getIssueModel() {
      return issueModel;
    }

    public String getIssue() {
      return issue;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setIssueModel(String issueModel) {
      this.issueModel = issueModel;
      return this;
    }

    public Builder setIssue(String issue) {
      this.issue = issue;
      return this;
    }

    private Builder(IssueName issueName) {
      this.project = issueName.project;
      this.location = issueName.location;
      this.issueModel = issueName.issueModel;
      this.issue = issueName.issue;
    }

    public IssueName build() {
      return new IssueName(this);
    }
  }
}
