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
public final class ProjectZoneName implements ResourceName {
  private final String project;
  private final String zone;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/zones/{zone}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectZoneName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    zone = Preconditions.checkNotNull(builder.getZone());
  }

  public static ProjectZoneName of(String project, String zone) {
    return newBuilder().setProject(project).setZone(zone).build();
  }

  public static String format(String project, String zone) {
    return of(project, zone).toString();
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

  public static ResourceNameFactory<ProjectZoneName> newFactory() {
    return new ResourceNameFactory<ProjectZoneName>() {
      public ProjectZoneName parse(String formattedString) {
        return ProjectZoneName.parse(formattedString);
      }
    };
  }

  public static ProjectZoneName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ProjectZoneName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("zone"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String project;
    private String zone;

    public String getProject() {
      return project;
    }

    public String getZone() {
      return zone;
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

    public Builder(ProjectZoneName projectZoneName) {
      project = projectZoneName.project;
      zone = projectZoneName.zone;
    }

    public ProjectZoneName build() {
      return new ProjectZoneName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "zone", zone);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectZoneName) {
      ProjectZoneName that = (ProjectZoneName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, zone);
  }
}
