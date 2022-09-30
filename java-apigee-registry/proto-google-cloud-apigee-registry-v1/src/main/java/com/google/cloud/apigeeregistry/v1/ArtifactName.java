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

package com.google.cloud.apigeeregistry.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class ArtifactName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ARTIFACT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/artifacts/{artifact}");
  private static final PathTemplate PROJECT_LOCATION_API_ARTIFACT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apis/{api}/artifacts/{artifact}");
  private static final PathTemplate PROJECT_LOCATION_API_VERSION_ARTIFACT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apis/{api}/versions/{version}/artifacts/{artifact}");
  private static final PathTemplate PROJECT_LOCATION_API_VERSION_SPEC_ARTIFACT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}/artifacts/{artifact}");
  private static final PathTemplate PROJECT_LOCATION_API_DEPLOYMENT_ARTIFACT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apis/{api}/deployments/{deployment}/artifacts/{artifact}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String artifact;
  private final String api;
  private final String version;
  private final String spec;
  private final String deployment;

  @Deprecated
  protected ArtifactName() {
    project = null;
    location = null;
    artifact = null;
    api = null;
    version = null;
    spec = null;
    deployment = null;
  }

  private ArtifactName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    artifact = Preconditions.checkNotNull(builder.getArtifact());
    api = null;
    version = null;
    spec = null;
    deployment = null;
    pathTemplate = PROJECT_LOCATION_ARTIFACT;
  }

  private ArtifactName(ProjectLocationApiArtifactBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    api = Preconditions.checkNotNull(builder.getApi());
    artifact = Preconditions.checkNotNull(builder.getArtifact());
    version = null;
    spec = null;
    deployment = null;
    pathTemplate = PROJECT_LOCATION_API_ARTIFACT;
  }

  private ArtifactName(ProjectLocationApiVersionArtifactBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    api = Preconditions.checkNotNull(builder.getApi());
    version = Preconditions.checkNotNull(builder.getVersion());
    artifact = Preconditions.checkNotNull(builder.getArtifact());
    spec = null;
    deployment = null;
    pathTemplate = PROJECT_LOCATION_API_VERSION_ARTIFACT;
  }

  private ArtifactName(ProjectLocationApiVersionSpecArtifactBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    api = Preconditions.checkNotNull(builder.getApi());
    version = Preconditions.checkNotNull(builder.getVersion());
    spec = Preconditions.checkNotNull(builder.getSpec());
    artifact = Preconditions.checkNotNull(builder.getArtifact());
    deployment = null;
    pathTemplate = PROJECT_LOCATION_API_VERSION_SPEC_ARTIFACT;
  }

  private ArtifactName(ProjectLocationApiDeploymentArtifactBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    api = Preconditions.checkNotNull(builder.getApi());
    deployment = Preconditions.checkNotNull(builder.getDeployment());
    artifact = Preconditions.checkNotNull(builder.getArtifact());
    version = null;
    spec = null;
    pathTemplate = PROJECT_LOCATION_API_DEPLOYMENT_ARTIFACT;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getArtifact() {
    return artifact;
  }

  public String getApi() {
    return api;
  }

  public String getVersion() {
    return version;
  }

  public String getSpec() {
    return spec;
  }

  public String getDeployment() {
    return deployment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectLocationArtifactBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationApiArtifactBuilder newProjectLocationApiArtifactBuilder() {
    return new ProjectLocationApiArtifactBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationApiVersionArtifactBuilder
      newProjectLocationApiVersionArtifactBuilder() {
    return new ProjectLocationApiVersionArtifactBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationApiVersionSpecArtifactBuilder
      newProjectLocationApiVersionSpecArtifactBuilder() {
    return new ProjectLocationApiVersionSpecArtifactBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationApiDeploymentArtifactBuilder
      newProjectLocationApiDeploymentArtifactBuilder() {
    return new ProjectLocationApiDeploymentArtifactBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ArtifactName of(String project, String location, String artifact) {
    return newBuilder().setProject(project).setLocation(location).setArtifact(artifact).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ArtifactName ofProjectLocationArtifactName(
      String project, String location, String artifact) {
    return newBuilder().setProject(project).setLocation(location).setArtifact(artifact).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ArtifactName ofProjectLocationApiArtifactName(
      String project, String location, String api, String artifact) {
    return newProjectLocationApiArtifactBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setArtifact(artifact)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ArtifactName ofProjectLocationApiVersionArtifactName(
      String project, String location, String api, String version, String artifact) {
    return newProjectLocationApiVersionArtifactBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setVersion(version)
        .setArtifact(artifact)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ArtifactName ofProjectLocationApiVersionSpecArtifactName(
      String project, String location, String api, String version, String spec, String artifact) {
    return newProjectLocationApiVersionSpecArtifactBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setVersion(version)
        .setSpec(spec)
        .setArtifact(artifact)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ArtifactName ofProjectLocationApiDeploymentArtifactName(
      String project, String location, String api, String deployment, String artifact) {
    return newProjectLocationApiDeploymentArtifactBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setDeployment(deployment)
        .setArtifact(artifact)
        .build();
  }

  public static String format(String project, String location, String artifact) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setArtifact(artifact)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationArtifactName(
      String project, String location, String artifact) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setArtifact(artifact)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationApiArtifactName(
      String project, String location, String api, String artifact) {
    return newProjectLocationApiArtifactBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setArtifact(artifact)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationApiVersionArtifactName(
      String project, String location, String api, String version, String artifact) {
    return newProjectLocationApiVersionArtifactBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setVersion(version)
        .setArtifact(artifact)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationApiVersionSpecArtifactName(
      String project, String location, String api, String version, String spec, String artifact) {
    return newProjectLocationApiVersionSpecArtifactBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setVersion(version)
        .setSpec(spec)
        .setArtifact(artifact)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationApiDeploymentArtifactName(
      String project, String location, String api, String deployment, String artifact) {
    return newProjectLocationApiDeploymentArtifactBuilder()
        .setProject(project)
        .setLocation(location)
        .setApi(api)
        .setDeployment(deployment)
        .setArtifact(artifact)
        .build()
        .toString();
  }

  public static ArtifactName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_ARTIFACT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ARTIFACT.match(formattedString);
      return ofProjectLocationArtifactName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("artifact"));
    } else if (PROJECT_LOCATION_API_ARTIFACT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_API_ARTIFACT.match(formattedString);
      return ofProjectLocationApiArtifactName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("api"),
          matchMap.get("artifact"));
    } else if (PROJECT_LOCATION_API_VERSION_ARTIFACT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_API_VERSION_ARTIFACT.match(formattedString);
      return ofProjectLocationApiVersionArtifactName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("api"),
          matchMap.get("version"),
          matchMap.get("artifact"));
    } else if (PROJECT_LOCATION_API_VERSION_SPEC_ARTIFACT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_API_VERSION_SPEC_ARTIFACT.match(formattedString);
      return ofProjectLocationApiVersionSpecArtifactName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("api"),
          matchMap.get("version"),
          matchMap.get("spec"),
          matchMap.get("artifact"));
    } else if (PROJECT_LOCATION_API_DEPLOYMENT_ARTIFACT.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_API_DEPLOYMENT_ARTIFACT.match(formattedString);
      return ofProjectLocationApiDeploymentArtifactName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("api"),
          matchMap.get("deployment"),
          matchMap.get("artifact"));
    }
    throw new ValidationException("ArtifactName.parse: formattedString not in valid format");
  }

  public static List<ArtifactName> parseList(List<String> formattedStrings) {
    List<ArtifactName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ArtifactName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ArtifactName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ARTIFACT.matches(formattedString)
        || PROJECT_LOCATION_API_ARTIFACT.matches(formattedString)
        || PROJECT_LOCATION_API_VERSION_ARTIFACT.matches(formattedString)
        || PROJECT_LOCATION_API_VERSION_SPEC_ARTIFACT.matches(formattedString)
        || PROJECT_LOCATION_API_DEPLOYMENT_ARTIFACT.matches(formattedString);
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
          if (artifact != null) {
            fieldMapBuilder.put("artifact", artifact);
          }
          if (api != null) {
            fieldMapBuilder.put("api", api);
          }
          if (version != null) {
            fieldMapBuilder.put("version", version);
          }
          if (spec != null) {
            fieldMapBuilder.put("spec", spec);
          }
          if (deployment != null) {
            fieldMapBuilder.put("deployment", deployment);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ArtifactName that = ((ArtifactName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.artifact, that.artifact)
          && Objects.equals(this.api, that.api)
          && Objects.equals(this.version, that.version)
          && Objects.equals(this.spec, that.spec)
          && Objects.equals(this.deployment, that.deployment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(artifact);
    h *= 1000003;
    h ^= Objects.hashCode(api);
    h *= 1000003;
    h ^= Objects.hashCode(version);
    h *= 1000003;
    h ^= Objects.hashCode(spec);
    h *= 1000003;
    h ^= Objects.hashCode(deployment);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/artifacts/{artifact}. */
  public static class Builder {
    private String project;
    private String location;
    private String artifact;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getArtifact() {
      return artifact;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setArtifact(String artifact) {
      this.artifact = artifact;
      return this;
    }

    private Builder(ArtifactName artifactName) {
      Preconditions.checkArgument(
          Objects.equals(artifactName.pathTemplate, PROJECT_LOCATION_ARTIFACT),
          "toBuilder is only supported when ArtifactName has the pattern of projects/{project}/locations/{location}/artifacts/{artifact}");
      this.project = artifactName.project;
      this.location = artifactName.location;
      this.artifact = artifactName.artifact;
    }

    public ArtifactName build() {
      return new ArtifactName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/apis/{api}/artifacts/{artifact}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationApiArtifactBuilder {
    private String project;
    private String location;
    private String api;
    private String artifact;

    protected ProjectLocationApiArtifactBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApi() {
      return api;
    }

    public String getArtifact() {
      return artifact;
    }

    public ProjectLocationApiArtifactBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationApiArtifactBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationApiArtifactBuilder setApi(String api) {
      this.api = api;
      return this;
    }

    public ProjectLocationApiArtifactBuilder setArtifact(String artifact) {
      this.artifact = artifact;
      return this;
    }

    public ArtifactName build() {
      return new ArtifactName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/apis/{api}/versions/{version}/artifacts/{artifact}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationApiVersionArtifactBuilder {
    private String project;
    private String location;
    private String api;
    private String version;
    private String artifact;

    protected ProjectLocationApiVersionArtifactBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApi() {
      return api;
    }

    public String getVersion() {
      return version;
    }

    public String getArtifact() {
      return artifact;
    }

    public ProjectLocationApiVersionArtifactBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationApiVersionArtifactBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationApiVersionArtifactBuilder setApi(String api) {
      this.api = api;
      return this;
    }

    public ProjectLocationApiVersionArtifactBuilder setVersion(String version) {
      this.version = version;
      return this;
    }

    public ProjectLocationApiVersionArtifactBuilder setArtifact(String artifact) {
      this.artifact = artifact;
      return this;
    }

    public ArtifactName build() {
      return new ArtifactName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/apis/{api}/versions/{version}/specs/{spec}/artifacts/{artifact}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationApiVersionSpecArtifactBuilder {
    private String project;
    private String location;
    private String api;
    private String version;
    private String spec;
    private String artifact;

    protected ProjectLocationApiVersionSpecArtifactBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApi() {
      return api;
    }

    public String getVersion() {
      return version;
    }

    public String getSpec() {
      return spec;
    }

    public String getArtifact() {
      return artifact;
    }

    public ProjectLocationApiVersionSpecArtifactBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationApiVersionSpecArtifactBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationApiVersionSpecArtifactBuilder setApi(String api) {
      this.api = api;
      return this;
    }

    public ProjectLocationApiVersionSpecArtifactBuilder setVersion(String version) {
      this.version = version;
      return this;
    }

    public ProjectLocationApiVersionSpecArtifactBuilder setSpec(String spec) {
      this.spec = spec;
      return this;
    }

    public ProjectLocationApiVersionSpecArtifactBuilder setArtifact(String artifact) {
      this.artifact = artifact;
      return this;
    }

    public ArtifactName build() {
      return new ArtifactName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/apis/{api}/deployments/{deployment}/artifacts/{artifact}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationApiDeploymentArtifactBuilder {
    private String project;
    private String location;
    private String api;
    private String deployment;
    private String artifact;

    protected ProjectLocationApiDeploymentArtifactBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApi() {
      return api;
    }

    public String getDeployment() {
      return deployment;
    }

    public String getArtifact() {
      return artifact;
    }

    public ProjectLocationApiDeploymentArtifactBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationApiDeploymentArtifactBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationApiDeploymentArtifactBuilder setApi(String api) {
      this.api = api;
      return this;
    }

    public ProjectLocationApiDeploymentArtifactBuilder setDeployment(String deployment) {
      this.deployment = deployment;
      return this;
    }

    public ProjectLocationApiDeploymentArtifactBuilder setArtifact(String artifact) {
      this.artifact = artifact;
      return this;
    }

    public ArtifactName build() {
      return new ArtifactName(this);
    }
  }
}
