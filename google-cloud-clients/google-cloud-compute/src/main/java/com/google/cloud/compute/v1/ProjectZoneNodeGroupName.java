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
public final class ProjectZoneNodeGroupName implements ResourceName {
  private final String nodeGroup;
  private final String project;
  private final String zone;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/zones/{zone}/nodeGroups/{nodeGroup}");

  public static final String SERVICE_ADDRESS = "https://www.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectZoneNodeGroupName(Builder builder) {
    nodeGroup = Preconditions.checkNotNull(builder.getNodeGroup());
    project = Preconditions.checkNotNull(builder.getProject());
    zone = Preconditions.checkNotNull(builder.getZone());
  }

  public static ProjectZoneNodeGroupName of(String nodeGroup, String project, String zone) {
    return newBuilder().setNodeGroup(nodeGroup).setProject(project).setZone(zone).build();
  }

  public static String format(String nodeGroup, String project, String zone) {
    return of(nodeGroup, project, zone).toString();
  }

  public String getNodeGroup() {
    return nodeGroup;
  }

  public String getProject() {
    return project;
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
          fieldMapBuilder.put("nodeGroup", nodeGroup);
          fieldMapBuilder.put("project", project);
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

  public static ResourceNameFactory<ProjectZoneNodeGroupName> newFactory() {
    return new ResourceNameFactory<ProjectZoneNodeGroupName>() {
      public ProjectZoneNodeGroupName parse(String formattedString) {
        return ProjectZoneNodeGroupName.parse(formattedString);
      }
    };
  }

  public static ProjectZoneNodeGroupName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath, "ProjectZoneNodeGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("nodeGroup"), matchMap.get("project"), matchMap.get("zone"));
  }

  public static boolean isParsableFrom(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    return PATH_TEMPLATE.matches(resourcePath);
  }

  public static class Builder {
    private String nodeGroup;
    private String project;
    private String zone;

    public String getNodeGroup() {
      return nodeGroup;
    }

    public String getProject() {
      return project;
    }

    public String getZone() {
      return zone;
    }

    public Builder setNodeGroup(String nodeGroup) {
      this.nodeGroup = nodeGroup;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    private Builder() {}

    public Builder(ProjectZoneNodeGroupName projectZoneNodeGroupName) {
      nodeGroup = projectZoneNodeGroupName.nodeGroup;
      project = projectZoneNodeGroupName.project;
      zone = projectZoneNodeGroupName.zone;
    }

    public ProjectZoneNodeGroupName build() {
      return new ProjectZoneNodeGroupName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "nodeGroup", nodeGroup,
            "project", project,
            "zone", zone);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectZoneNodeGroupName) {
      ProjectZoneNodeGroupName that = (ProjectZoneNodeGroupName) o;
      return Objects.equals(this.nodeGroup, that.getNodeGroup())
          && Objects.equals(this.project, that.getProject())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nodeGroup, project, zone);
  }
}
