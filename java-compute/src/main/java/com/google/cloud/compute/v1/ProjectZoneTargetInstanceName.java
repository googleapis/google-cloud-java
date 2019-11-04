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
public final class ProjectZoneTargetInstanceName implements ResourceName {
  private final String project;
  private final String targetInstance;
  private final String zone;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "{project}/zones/{zone}/targetInstances/{targetInstance}");

  public static final String SERVICE_ADDRESS =
      "https://compute.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectZoneTargetInstanceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    targetInstance = Preconditions.checkNotNull(builder.getTargetInstance());
    zone = Preconditions.checkNotNull(builder.getZone());
  }

  public static ProjectZoneTargetInstanceName of(
      String project, String targetInstance, String zone) {
    return newBuilder().setProject(project).setTargetInstance(targetInstance).setZone(zone).build();
  }

  public static String format(String project, String targetInstance, String zone) {
    return of(project, targetInstance, zone).toString();
  }

  public String getProject() {
    return project;
  }

  public String getTargetInstance() {
    return targetInstance;
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
          fieldMapBuilder.put("targetInstance", targetInstance);
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

  public static ResourceNameFactory<ProjectZoneTargetInstanceName> newFactory() {
    return new ResourceNameFactory<ProjectZoneTargetInstanceName>() {
      public ProjectZoneTargetInstanceName parse(String formattedString) {
        return ProjectZoneTargetInstanceName.parse(formattedString);
      }
    };
  }

  public static ProjectZoneTargetInstanceName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath,
            "ProjectZoneTargetInstanceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("targetInstance"), matchMap.get("zone"));
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
    private String targetInstance;
    private String zone;

    public String getProject() {
      return project;
    }

    public String getTargetInstance() {
      return targetInstance;
    }

    public String getZone() {
      return zone;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTargetInstance(String targetInstance) {
      this.targetInstance = targetInstance;
      return this;
    }

    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    private Builder() {}

    public Builder(ProjectZoneTargetInstanceName projectZoneTargetInstanceName) {
      project = projectZoneTargetInstanceName.project;
      targetInstance = projectZoneTargetInstanceName.targetInstance;
      zone = projectZoneTargetInstanceName.zone;
    }

    public ProjectZoneTargetInstanceName build() {
      return new ProjectZoneTargetInstanceName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "project", project,
            "targetInstance", targetInstance,
            "zone", zone);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectZoneTargetInstanceName) {
      ProjectZoneTargetInstanceName that = (ProjectZoneTargetInstanceName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.targetInstance, that.getTargetInstance())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, targetInstance, zone);
  }
}
