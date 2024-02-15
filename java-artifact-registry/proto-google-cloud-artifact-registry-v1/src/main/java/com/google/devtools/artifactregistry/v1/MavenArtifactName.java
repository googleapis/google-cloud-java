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

package com.google.devtools.artifactregistry.v1;

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
public class MavenArtifactName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REPOSITORY_MAVEN_ARTIFACT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/repositories/{repository}/mavenArtifacts/{maven_artifact}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String repository;
  private final String mavenArtifact;

  @Deprecated
  protected MavenArtifactName() {
    project = null;
    location = null;
    repository = null;
    mavenArtifact = null;
  }

  private MavenArtifactName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    repository = Preconditions.checkNotNull(builder.getRepository());
    mavenArtifact = Preconditions.checkNotNull(builder.getMavenArtifact());
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

  public String getMavenArtifact() {
    return mavenArtifact;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MavenArtifactName of(
      String project, String location, String repository, String mavenArtifact) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRepository(repository)
        .setMavenArtifact(mavenArtifact)
        .build();
  }

  public static String format(
      String project, String location, String repository, String mavenArtifact) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRepository(repository)
        .setMavenArtifact(mavenArtifact)
        .build()
        .toString();
  }

  public static MavenArtifactName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REPOSITORY_MAVEN_ARTIFACT.validatedMatch(
            formattedString, "MavenArtifactName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("repository"),
        matchMap.get("maven_artifact"));
  }

  public static List<MavenArtifactName> parseList(List<String> formattedStrings) {
    List<MavenArtifactName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MavenArtifactName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MavenArtifactName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REPOSITORY_MAVEN_ARTIFACT.matches(formattedString);
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
          if (mavenArtifact != null) {
            fieldMapBuilder.put("maven_artifact", mavenArtifact);
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
    return PROJECT_LOCATION_REPOSITORY_MAVEN_ARTIFACT.instantiate(
        "project",
        project,
        "location",
        location,
        "repository",
        repository,
        "maven_artifact",
        mavenArtifact);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MavenArtifactName that = ((MavenArtifactName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.repository, that.repository)
          && Objects.equals(this.mavenArtifact, that.mavenArtifact);
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
    h ^= Objects.hashCode(mavenArtifact);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/repositories/{repository}/mavenArtifacts/{maven_artifact}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String repository;
    private String mavenArtifact;

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

    public String getMavenArtifact() {
      return mavenArtifact;
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

    public Builder setMavenArtifact(String mavenArtifact) {
      this.mavenArtifact = mavenArtifact;
      return this;
    }

    private Builder(MavenArtifactName mavenArtifactName) {
      this.project = mavenArtifactName.project;
      this.location = mavenArtifactName.location;
      this.repository = mavenArtifactName.repository;
      this.mavenArtifact = mavenArtifactName.mavenArtifact;
    }

    public MavenArtifactName build() {
      return new MavenArtifactName(this);
    }
  }
}
