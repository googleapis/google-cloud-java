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
public final class ProjectRegionDiskTypeName implements ResourceName {
  private final String diskType;
  private final String project;
  private final String region;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/diskTypes/{diskType}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectRegionDiskTypeName(Builder builder) {
    diskType = Preconditions.checkNotNull(builder.getDiskType());
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
  }

  public static ProjectRegionDiskTypeName of(String diskType, String project, String region) {
    return newBuilder().setDiskType(diskType).setProject(project).setRegion(region).build();
  }

  public static String format(String diskType, String project, String region) {
    return of(diskType, project, region).toString();
  }

  public String getDiskType() {
    return diskType;
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
          fieldMapBuilder.put("diskType", diskType);
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

  public static ResourceNameFactory<ProjectRegionDiskTypeName> newFactory() {
    return new ResourceNameFactory<ProjectRegionDiskTypeName>() {
      public ProjectRegionDiskTypeName parse(String formattedString) {
        return ProjectRegionDiskTypeName.parse(formattedString);
      }
    };
  }

  public static ProjectRegionDiskTypeName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectRegionDiskTypeName.parse: formattedString not in valid format");
    return of(matchMap.get("diskType"), matchMap.get("project"), matchMap.get("region"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String diskType;
    private String project;
    private String region;

    public String getDiskType() {
      return diskType;
    }

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public Builder setDiskType(String diskType) {
      this.diskType = diskType;
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

    public Builder(ProjectRegionDiskTypeName projectRegionDiskTypeName) {
      diskType = projectRegionDiskTypeName.diskType;
      project = projectRegionDiskTypeName.project;
      region = projectRegionDiskTypeName.region;
    }

    public ProjectRegionDiskTypeName build() {
      return new ProjectRegionDiskTypeName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "diskType", diskType,
        "project", project,
        "region", region);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectRegionDiskTypeName) {
      ProjectRegionDiskTypeName that = (ProjectRegionDiskTypeName) o;
      return Objects.equals(this.diskType, that.getDiskType())
          && Objects.equals(this.project, that.getProject())
          && Objects.equals(this.region, that.getRegion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diskType, project, region);
  }
}
