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
public final class ProjectRegionDiskName implements ResourceName {
  private final String disk;
  private final String project;
  private final String region;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/regions/{region}/disks/{disk}");

  public static final String SERVICE_ADDRESS =
      "https://compute.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectRegionDiskName(Builder builder) {
    disk = Preconditions.checkNotNull(builder.getDisk());
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
  }

  public static ProjectRegionDiskName of(String disk, String project, String region) {
    return newBuilder().setDisk(disk).setProject(project).setRegion(region).build();
  }

  public static String format(String disk, String project, String region) {
    return of(disk, project, region).toString();
  }

  public String getDisk() {
    return disk;
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
          fieldMapBuilder.put("disk", disk);
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

  public static ResourceNameFactory<ProjectRegionDiskName> newFactory() {
    return new ResourceNameFactory<ProjectRegionDiskName>() {
      public ProjectRegionDiskName parse(String formattedString) {
        return ProjectRegionDiskName.parse(formattedString);
      }
    };
  }

  public static ProjectRegionDiskName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath, "ProjectRegionDiskName.parse: formattedString not in valid format");
    return of(matchMap.get("disk"), matchMap.get("project"), matchMap.get("region"));
  }

  public static boolean isParsableFrom(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    return PATH_TEMPLATE.matches(resourcePath);
  }

  public static class Builder {
    private String disk;
    private String project;
    private String region;

    public String getDisk() {
      return disk;
    }

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public Builder setDisk(String disk) {
      this.disk = disk;
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

    public Builder(ProjectRegionDiskName projectRegionDiskName) {
      disk = projectRegionDiskName.disk;
      project = projectRegionDiskName.project;
      region = projectRegionDiskName.region;
    }

    public ProjectRegionDiskName build() {
      return new ProjectRegionDiskName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "disk", disk,
            "project", project,
            "region", region);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectRegionDiskName) {
      ProjectRegionDiskName that = (ProjectRegionDiskName) o;
      return Objects.equals(this.disk, that.getDisk())
          && Objects.equals(this.project, that.getProject())
          && Objects.equals(this.region, that.getRegion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(disk, project, region);
  }
}
