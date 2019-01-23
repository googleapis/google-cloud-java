/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class ProjectZoneNodeGroupResourceName implements ResourceName {
  private final String project;
  private final String resource;
  private final String zone;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/zones/{zone}/nodeGroups/{resource}");

  public static final String SERVICE_ADDRESS = "https://www.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectZoneNodeGroupResourceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    resource = Preconditions.checkNotNull(builder.getResource());
    zone = Preconditions.checkNotNull(builder.getZone());
  }

  public static ProjectZoneNodeGroupResourceName of(String project, String resource, String zone) {
    return newBuilder().setProject(project).setResource(resource).setZone(zone).build();
  }

  public static String format(String project, String resource, String zone) {
    return of(project, resource, zone).toString();
  }

  public String getProject() {
    return project;
  }

  public String getResource() {
    return resource;
  }

  public String getZone() {
    return zone;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("resource", resource);
          fieldMapBuilder.put("zone", zone);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectZoneNodeGroupResourceName> newFactory() {
    return new ResourceNameFactory<ProjectZoneNodeGroupResourceName>() {
      public ProjectZoneNodeGroupResourceName parse(String formattedString) {
        return ProjectZoneNodeGroupResourceName.parse(formattedString);
      }
    };
  }

  public static ProjectZoneNodeGroupResourceName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath,
            "ProjectZoneNodeGroupResourceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("resource"), matchMap.get("zone"));
  }

  public static boolean isParsableFrom(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    return PATH_TEMPLATE.matches(resourcePath);
  }

  public static class Builder {
    private String project;
    private String resource;
    private String zone;

    public String getProject() {
      return project;
    }

    public String getResource() {
      return resource;
    }

    public String getZone() {
      return zone;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setResource(String resource) {
      this.resource = resource;
      return this;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    private Builder() {}

    public Builder(ProjectZoneNodeGroupResourceName projectZoneNodeGroupResourceName) {
      project = projectZoneNodeGroupResourceName.project;
      resource = projectZoneNodeGroupResourceName.resource;
      zone = projectZoneNodeGroupResourceName.zone;
    }

    public ProjectZoneNodeGroupResourceName build() {
      return new ProjectZoneNodeGroupResourceName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "resource", resource,
        "zone", zone);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectZoneNodeGroupResourceName) {
      ProjectZoneNodeGroupResourceName that = (ProjectZoneNodeGroupResourceName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.resource, that.getResource())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, resource, zone);
  }
}
