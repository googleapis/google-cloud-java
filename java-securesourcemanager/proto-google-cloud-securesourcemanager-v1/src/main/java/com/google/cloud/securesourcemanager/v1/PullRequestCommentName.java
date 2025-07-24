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
public class PullRequestCommentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REPOSITORY_PULL_REQUEST_COMMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/repositories/{repository}/pullRequests/{pull_request}/pullRequestComments/{comment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String repository;
  private final String pullRequest;
  private final String comment;

  @Deprecated
  protected PullRequestCommentName() {
    project = null;
    location = null;
    repository = null;
    pullRequest = null;
    comment = null;
  }

  private PullRequestCommentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    repository = Preconditions.checkNotNull(builder.getRepository());
    pullRequest = Preconditions.checkNotNull(builder.getPullRequest());
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

  public String getPullRequest() {
    return pullRequest;
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

  public static PullRequestCommentName of(
      String project, String location, String repository, String pullRequest, String comment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRepository(repository)
        .setPullRequest(pullRequest)
        .setComment(comment)
        .build();
  }

  public static String format(
      String project, String location, String repository, String pullRequest, String comment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRepository(repository)
        .setPullRequest(pullRequest)
        .setComment(comment)
        .build()
        .toString();
  }

  public static PullRequestCommentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REPOSITORY_PULL_REQUEST_COMMENT.validatedMatch(
            formattedString, "PullRequestCommentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("repository"),
        matchMap.get("pull_request"),
        matchMap.get("comment"));
  }

  public static List<PullRequestCommentName> parseList(List<String> formattedStrings) {
    List<PullRequestCommentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PullRequestCommentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PullRequestCommentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REPOSITORY_PULL_REQUEST_COMMENT.matches(formattedString);
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
          if (pullRequest != null) {
            fieldMapBuilder.put("pull_request", pullRequest);
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
    return PROJECT_LOCATION_REPOSITORY_PULL_REQUEST_COMMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "repository",
        repository,
        "pull_request",
        pullRequest,
        "comment",
        comment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PullRequestCommentName that = ((PullRequestCommentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.repository, that.repository)
          && Objects.equals(this.pullRequest, that.pullRequest)
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
    h ^= Objects.hashCode(pullRequest);
    h *= 1000003;
    h ^= Objects.hashCode(comment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/repositories/{repository}/pullRequests/{pull_request}/pullRequestComments/{comment}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String repository;
    private String pullRequest;
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

    public String getPullRequest() {
      return pullRequest;
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

    public Builder setPullRequest(String pullRequest) {
      this.pullRequest = pullRequest;
      return this;
    }

    public Builder setComment(String comment) {
      this.comment = comment;
      return this;
    }

    private Builder(PullRequestCommentName pullRequestCommentName) {
      this.project = pullRequestCommentName.project;
      this.location = pullRequestCommentName.location;
      this.repository = pullRequestCommentName.repository;
      this.pullRequest = pullRequestCommentName.pullRequest;
      this.comment = pullRequestCommentName.comment;
    }

    public PullRequestCommentName build() {
      return new PullRequestCommentName(this);
    }
  }
}
