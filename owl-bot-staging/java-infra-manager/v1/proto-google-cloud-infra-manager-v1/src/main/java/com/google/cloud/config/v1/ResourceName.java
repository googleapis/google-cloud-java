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

package com.google.cloud.config.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class ResourceName implements com.google.api.resourcenames.ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DEPLOYMENT_REVISION_RESOURCE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/deployments/{deployment}/revisions/{revision}/resources/{resource}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String deployment;
  private final String revision;
  private final String resource;

  @Deprecated
  protected ResourceName() {
    project = null;
    location = null;
    deployment = null;
    revision = null;
    resource = null;
  }

  private ResourceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    deployment = Preconditions.checkNotNull(builder.getDeployment());
    revision = Preconditions.checkNotNull(builder.getRevision());
    resource = Preconditions.checkNotNull(builder.getResource());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDeployment() {
    return deployment;
  }

  public String getRevision() {
    return revision;
  }

  public String getResource() {
    return resource;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ResourceName of(
      String project, String location, String deployment, String revision, String resource) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeployment(deployment)
        .setRevision(revision)
        .setResource(resource)
        .build();
  }

  public static String format(
      String project, String location, String deployment, String revision, String resource) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeployment(deployment)
        .setRevision(revision)
        .setResource(resource)
        .build()
        .toString();
  }

  public static ResourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DEPLOYMENT_REVISION_RESOURCE.validatedMatch(
            formattedString, "ResourceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("deployment"),
        matchMap.get("revision"),
        matchMap.get("resource"));
  }

  public static List<ResourceName> parseList(List<String> formattedStrings) {
    List<ResourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ResourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ResourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DEPLOYMENT_REVISION_RESOURCE.matches(formattedString);
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
          if (deployment != null) {
            fieldMapBuilder.put("deployment", deployment);
          }
          if (revision != null) {
            fieldMapBuilder.put("revision", revision);
          }
          if (resource != null) {
            fieldMapBuilder.put("resource", resource);
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
    return PROJECT_LOCATION_DEPLOYMENT_REVISION_RESOURCE.instantiate(
        "project",
        project,
        "location",
        location,
        "deployment",
        deployment,
        "revision",
        revision,
        "resource",
        resource);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ResourceName that = ((ResourceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.deployment, that.deployment)
          && Objects.equals(this.revision, that.revision)
          && Objects.equals(this.resource, that.resource);
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
    h ^= Objects.hashCode(deployment);
    h *= 1000003;
    h ^= Objects.hashCode(revision);
    h *= 1000003;
    h ^= Objects.hashCode(resource);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/deployments/{deployment}/revisions/{revision}/resources/{resource}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String deployment;
    private String revision;
    private String resource;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDeployment() {
      return deployment;
    }

    public String getRevision() {
      return revision;
    }

    public String getResource() {
      return resource;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDeployment(String deployment) {
      this.deployment = deployment;
      return this;
    }

    public Builder setRevision(String revision) {
      this.revision = revision;
      return this;
    }

    public Builder setResource(String resource) {
      this.resource = resource;
      return this;
    }

    private Builder(ResourceName resourceName) {
      this.project = resourceName.project;
      this.location = resourceName.location;
      this.deployment = resourceName.deployment;
      this.revision = resourceName.revision;
      this.resource = resourceName.resource;
    }

    public ResourceName build() {
      return new ResourceName(this);
    }
  }
}
