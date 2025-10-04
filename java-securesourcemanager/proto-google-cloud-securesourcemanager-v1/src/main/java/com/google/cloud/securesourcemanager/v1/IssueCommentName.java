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

package com.google.cloud.securesourcemanager.v1;

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
public class IssueCommentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REPOSITORY_ISSUE_COMMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/repositories/{repository}/issues/{issue}/issueComments/{comment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String repository;
  private final String issue;
  private final String comment;

  @Deprecated
  protected IssueCommentName() {
    project = null;
    location = null;
    repository = null;
    issue = null;
    comment = null;
  }

  private IssueCommentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    repository = Preconditions.checkNotNull(builder.getRepository());
    issue = Preconditions.checkNotNull(builder.getIssue());
    comment = Preconditions.checkNotNull(builder.getComment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRepository() {
    return repository;
  }

  public String getIssue() {
    return issue;
  }

  public String getComment() {
    return comment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static IssueCommentName of(
      String project, String location, String repository, String issue, String comment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRepository(repository)
        .setIssue(issue)
        .setComment(comment)
        .build();
  }

  public static String format(
      String project, String location, String repository, String issue, String comment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRepository(repository)
        .setIssue(issue)
        .setComment(comment)
        .build()
        .toString();
  }

  public static IssueCommentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REPOSITORY_ISSUE_COMMENT.validatedMatch(
            formattedString, "IssueCommentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("repository"),
        matchMap.get("issue"),
        matchMap.get("comment"));
  }

  public static List<IssueCommentName> parseList(List<String> formattedStrings) {
    List<IssueCommentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<IssueCommentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (IssueCommentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REPOSITORY_ISSUE_COMMENT.matches(formattedString);
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
          if (repository != null) {
            fieldMapBuilder.put("repository", repository);
          }
          if (issue != null) {
            fieldMapBuilder.put("issue", issue);
          }
          if (comment != null) {
            fieldMapBuilder.put("comment", comment);
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
    return PROJECT_LOCATION_REPOSITORY_ISSUE_COMMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "repository",
        repository,
        "issue",
        issue,
        "comment",
        comment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      IssueCommentName that = ((IssueCommentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.repository, that.repository)
          && Objects.equals(this.issue, that.issue)
          && Objects.equals(this.comment, that.comment);
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
    h ^= Objects.hashCode(repository);
    h *= 1000003;
    h ^= Objects.hashCode(issue);
    h *= 1000003;
    h ^= Objects.hashCode(comment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/repositories/{repository}/issues/{issue}/issueComments/{comment}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String repository;
    private String issue;
    private String comment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRepository() {
      return repository;
    }

    public String getIssue() {
      return issue;
    }

    public String getComment() {
      return comment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRepository(String repository) {
      this.repository = repository;
      return this;
    }

    public Builder setIssue(String issue) {
      this.issue = issue;
      return this;
    }

    public Builder setComment(String comment) {
      this.comment = comment;
      return this;
    }

    private Builder(IssueCommentName issueCommentName) {
      this.project = issueCommentName.project;
      this.location = issueCommentName.location;
      this.repository = issueCommentName.repository;
      this.issue = issueCommentName.issue;
      this.comment = issueCommentName.comment;
    }

    public IssueCommentName build() {
      return new IssueCommentName(this);
    }
  }
}
