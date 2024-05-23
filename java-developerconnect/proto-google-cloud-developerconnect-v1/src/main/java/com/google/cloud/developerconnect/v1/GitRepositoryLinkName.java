/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.developerconnect.v1;

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
public class GitRepositoryLinkName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONNECTION_GIT_REPOSITORY_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/connections/{connection}/gitRepositoryLinks/{git_repository_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String connection;
  private final String gitRepositoryLink;

  @Deprecated
  protected GitRepositoryLinkName() {
    project = null;
    location = null;
    connection = null;
    gitRepositoryLink = null;
  }

  private GitRepositoryLinkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    connection = Preconditions.checkNotNull(builder.getConnection());
    gitRepositoryLink = Preconditions.checkNotNull(builder.getGitRepositoryLink());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getConnection() {
    return connection;
  }

  public String getGitRepositoryLink() {
    return gitRepositoryLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GitRepositoryLinkName of(
      String project, String location, String connection, String gitRepositoryLink) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConnection(connection)
        .setGitRepositoryLink(gitRepositoryLink)
        .build();
  }

  public static String format(
      String project, String location, String connection, String gitRepositoryLink) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConnection(connection)
        .setGitRepositoryLink(gitRepositoryLink)
        .build()
        .toString();
  }

  public static GitRepositoryLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CONNECTION_GIT_REPOSITORY_LINK.validatedMatch(
            formattedString, "GitRepositoryLinkName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("connection"),
        matchMap.get("git_repository_link"));
  }

  public static List<GitRepositoryLinkName> parseList(List<String> formattedStrings) {
    List<GitRepositoryLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GitRepositoryLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GitRepositoryLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CONNECTION_GIT_REPOSITORY_LINK.matches(formattedString);
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
          if (connection != null) {
            fieldMapBuilder.put("connection", connection);
          }
          if (gitRepositoryLink != null) {
            fieldMapBuilder.put("git_repository_link", gitRepositoryLink);
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
    return PROJECT_LOCATION_CONNECTION_GIT_REPOSITORY_LINK.instantiate(
        "project",
        project,
        "location",
        location,
        "connection",
        connection,
        "git_repository_link",
        gitRepositoryLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GitRepositoryLinkName that = ((GitRepositoryLinkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.connection, that.connection)
          && Objects.equals(this.gitRepositoryLink, that.gitRepositoryLink);
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
    h ^= Objects.hashCode(connection);
    h *= 1000003;
    h ^= Objects.hashCode(gitRepositoryLink);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/connections/{connection}/gitRepositoryLinks/{git_repository_link}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String connection;
    private String gitRepositoryLink;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConnection() {
      return connection;
    }

    public String getGitRepositoryLink() {
      return gitRepositoryLink;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setConnection(String connection) {
      this.connection = connection;
      return this;
    }

    public Builder setGitRepositoryLink(String gitRepositoryLink) {
      this.gitRepositoryLink = gitRepositoryLink;
      return this;
    }

    private Builder(GitRepositoryLinkName gitRepositoryLinkName) {
      this.project = gitRepositoryLinkName.project;
      this.location = gitRepositoryLinkName.location;
      this.connection = gitRepositoryLinkName.connection;
      this.gitRepositoryLink = gitRepositoryLinkName.gitRepositoryLink;
    }

    public GitRepositoryLinkName build() {
      return new GitRepositoryLinkName(this);
    }
  }
}
