/*
 * Copyright 2018 Google LLC
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
public final class ProjectRegionInstanceGroupManagerName implements ResourceName {
  private final String instanceGroupManager;
  private final String project;
  private final String region;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectRegionInstanceGroupManagerName(Builder builder) {
    instanceGroupManager = Preconditions.checkNotNull(builder.getInstanceGroupManager());
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
  }

  public static ProjectRegionInstanceGroupManagerName of(
      String instanceGroupManager, String project, String region) {
    return newBuilder()
        .setInstanceGroupManager(instanceGroupManager)
        .setProject(project)
        .setRegion(region)
        .build();
  }

  public static String format(String instanceGroupManager, String project, String region) {
    return of(instanceGroupManager, project, region).toString();
  }

  public String getInstanceGroupManager() {
    return instanceGroupManager;
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("instanceGroupManager", instanceGroupManager);
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("region", region);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectRegionInstanceGroupManagerName> newFactory() {
    return new ResourceNameFactory<ProjectRegionInstanceGroupManagerName>() {
      public ProjectRegionInstanceGroupManagerName parse(String formattedString) {
        return ProjectRegionInstanceGroupManagerName.parse(formattedString);
      }
    };
  }

  public static ProjectRegionInstanceGroupManagerName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectRegionInstanceGroupManagerName.parse: formattedString not in valid format");
    return of(
        matchMap.get("instanceGroupManager"), matchMap.get("project"), matchMap.get("region"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String instanceGroupManager;
    private String project;
    private String region;

    public String getInstanceGroupManager() {
      return instanceGroupManager;
    }

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public Builder setInstanceGroupManager(String instanceGroupManager) {
      this.instanceGroupManager = instanceGroupManager;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    private Builder() {}

    public Builder(ProjectRegionInstanceGroupManagerName projectRegionInstanceGroupManagerName) {
      instanceGroupManager = projectRegionInstanceGroupManagerName.instanceGroupManager;
      project = projectRegionInstanceGroupManagerName.project;
      region = projectRegionInstanceGroupManagerName.region;
    }

    public ProjectRegionInstanceGroupManagerName build() {
      return new ProjectRegionInstanceGroupManagerName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "instanceGroupManager", instanceGroupManager,
        "project", project,
        "region", region);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectRegionInstanceGroupManagerName) {
      ProjectRegionInstanceGroupManagerName that = (ProjectRegionInstanceGroupManagerName) o;
      return Objects.equals(this.instanceGroupManager, that.getInstanceGroupManager())
          && Objects.equals(this.project, that.getProject())
          && Objects.equals(this.region, that.getRegion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceGroupManager, project, region);
  }
}
