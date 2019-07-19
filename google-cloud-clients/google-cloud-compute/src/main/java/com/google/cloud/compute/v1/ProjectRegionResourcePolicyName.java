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
public final class ProjectRegionResourcePolicyName implements ResourceName {
  private final String project;
  private final String region;
  private final String resourcePolicy;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "{project}/regions/{region}/resourcePolicies/{resourcePolicy}");

  public static final String SERVICE_ADDRESS = "https://www.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectRegionResourcePolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    resourcePolicy = Preconditions.checkNotNull(builder.getResourcePolicy());
  }

  public static ProjectRegionResourcePolicyName of(
      String project, String region, String resourcePolicy) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setResourcePolicy(resourcePolicy)
        .build();
  }

  public static String format(String project, String region, String resourcePolicy) {
    return of(project, region, resourcePolicy).toString();
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  public String getResourcePolicy() {
    return resourcePolicy;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("region", region);
          fieldMapBuilder.put("resourcePolicy", resourcePolicy);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectRegionResourcePolicyName> newFactory() {
    return new ResourceNameFactory<ProjectRegionResourcePolicyName>() {
      public ProjectRegionResourcePolicyName parse(String formattedString) {
        return ProjectRegionResourcePolicyName.parse(formattedString);
      }
    };
  }

  public static ProjectRegionResourcePolicyName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath,
            "ProjectRegionResourcePolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("region"), matchMap.get("resourcePolicy"));
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
    private String region;
    private String resourcePolicy;

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getResourcePolicy() {
      return resourcePolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public Builder setResourcePolicy(String resourcePolicy) {
      this.resourcePolicy = resourcePolicy;
      return this;
    }

    private Builder() {}

    public Builder(ProjectRegionResourcePolicyName projectRegionResourcePolicyName) {
      project = projectRegionResourcePolicyName.project;
      region = projectRegionResourcePolicyName.region;
      resourcePolicy = projectRegionResourcePolicyName.resourcePolicy;
    }

    public ProjectRegionResourcePolicyName build() {
      return new ProjectRegionResourcePolicyName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "project", project,
            "region", region,
            "resourcePolicy", resourcePolicy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectRegionResourcePolicyName) {
      ProjectRegionResourcePolicyName that = (ProjectRegionResourcePolicyName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.resourcePolicy, that.getResourcePolicy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, region, resourcePolicy);
  }
}
