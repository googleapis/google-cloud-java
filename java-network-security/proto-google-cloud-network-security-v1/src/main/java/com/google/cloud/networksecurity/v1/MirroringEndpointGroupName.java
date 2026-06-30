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
public class MirroringEndpointGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MIRRORING_ENDPOINT_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/mirroringEndpointGroups/{mirroring_endpoint_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String mirroringEndpointGroup;

  @Deprecated
  protected MirroringEndpointGroupName() {
    project = null;
    location = null;
    mirroringEndpointGroup = null;
  }

  private MirroringEndpointGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    mirroringEndpointGroup = Preconditions.checkNotNull(builder.getMirroringEndpointGroup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMirroringEndpointGroup() {
    return mirroringEndpointGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MirroringEndpointGroupName of(
      String project, String location, String mirroringEndpointGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMirroringEndpointGroup(mirroringEndpointGroup)
        .build();
  }

  public static String format(String project, String location, String mirroringEndpointGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMirroringEndpointGroup(mirroringEndpointGroup)
        .build()
        .toString();
  }

  public static MirroringEndpointGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MIRRORING_ENDPOINT_GROUP.validatedMatch(
            formattedString,
            "MirroringEndpointGroupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("mirroring_endpoint_group"));
  }

  public static List<MirroringEndpointGroupName> parseList(List<String> formattedStrings) {
    List<MirroringEndpointGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MirroringEndpointGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MirroringEndpointGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MIRRORING_ENDPOINT_GROUP.matches(formattedString);
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
          if (mirroringEndpointGroup != null) {
            fieldMapBuilder.put("mirroring_endpoint_group", mirroringEndpointGroup);
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
    return PROJECT_LOCATION_MIRRORING_ENDPOINT_GROUP.instantiate(
        "project",
        project,
        "location",
        location,
        "mirroring_endpoint_group",
        mirroringEndpointGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MirroringEndpointGroupName that = ((MirroringEndpointGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.mirroringEndpointGroup, that.mirroringEndpointGroup);
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
    h ^= Objects.hashCode(mirroringEndpointGroup);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/mirroringEndpointGroups/{mirroring_endpoint_group}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String mirroringEndpointGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMirroringEndpointGroup() {
      return mirroringEndpointGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMirroringEndpointGroup(String mirroringEndpointGroup) {
      this.mirroringEndpointGroup = mirroringEndpointGroup;
      return this;
    }

    private Builder(MirroringEndpointGroupName mirroringEndpointGroupName) {
      this.project = mirroringEndpointGroupName.project;
      this.location = mirroringEndpointGroupName.location;
      this.mirroringEndpointGroup = mirroringEndpointGroupName.mirroringEndpointGroup;
    }

    public MirroringEndpointGroupName build() {
      return new MirroringEndpointGroupName(this);
    }
  }
}
