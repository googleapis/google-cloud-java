/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1;

import com.google.api.pathtemplate.PathTemplate;
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
public class MirroringDeploymentGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MIRRORING_DEPLOYMENT_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/mirroringDeploymentGroups/{mirroring_deployment_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String mirroringDeploymentGroup;

  @Deprecated
  protected MirroringDeploymentGroupName() {
    project = null;
    location = null;
    mirroringDeploymentGroup = null;
  }

  private MirroringDeploymentGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    mirroringDeploymentGroup = Preconditions.checkNotNull(builder.getMirroringDeploymentGroup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMirroringDeploymentGroup() {
    return mirroringDeploymentGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MirroringDeploymentGroupName of(
      String project, String location, String mirroringDeploymentGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMirroringDeploymentGroup(mirroringDeploymentGroup)
        .build();
  }

  public static String format(String project, String location, String mirroringDeploymentGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMirroringDeploymentGroup(mirroringDeploymentGroup)
        .build()
        .toString();
  }

  public static MirroringDeploymentGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MIRRORING_DEPLOYMENT_GROUP.validatedMatch(
            formattedString,
            "MirroringDeploymentGroupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("mirroring_deployment_group"));
  }

  public static List<MirroringDeploymentGroupName> parseList(List<String> formattedStrings) {
    List<MirroringDeploymentGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MirroringDeploymentGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MirroringDeploymentGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MIRRORING_DEPLOYMENT_GROUP.matches(formattedString);
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
          if (mirroringDeploymentGroup != null) {
            fieldMapBuilder.put("mirroring_deployment_group", mirroringDeploymentGroup);
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
    return PROJECT_LOCATION_MIRRORING_DEPLOYMENT_GROUP.instantiate(
        "project",
        project,
        "location",
        location,
        "mirroring_deployment_group",
        mirroringDeploymentGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MirroringDeploymentGroupName that = ((MirroringDeploymentGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.mirroringDeploymentGroup, that.mirroringDeploymentGroup);
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
    h ^= Objects.hashCode(mirroringDeploymentGroup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/mirroringDeploymentGroups/{mirroring_deployment_group}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String mirroringDeploymentGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMirroringDeploymentGroup() {
      return mirroringDeploymentGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMirroringDeploymentGroup(String mirroringDeploymentGroup) {
      this.mirroringDeploymentGroup = mirroringDeploymentGroup;
      return this;
    }

    private Builder(MirroringDeploymentGroupName mirroringDeploymentGroupName) {
      this.project = mirroringDeploymentGroupName.project;
      this.location = mirroringDeploymentGroupName.location;
      this.mirroringDeploymentGroup = mirroringDeploymentGroupName.mirroringDeploymentGroup;
    }

    public MirroringDeploymentGroupName build() {
      return new MirroringDeploymentGroupName(this);
    }
  }
}
