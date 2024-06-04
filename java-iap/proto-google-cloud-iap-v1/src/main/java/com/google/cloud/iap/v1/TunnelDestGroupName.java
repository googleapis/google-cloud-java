/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iap.v1;

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
public class TunnelDestGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DEST_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/iap_tunnel/locations/{location}/destGroups/{dest_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String destGroup;

  @Deprecated
  protected TunnelDestGroupName() {
    project = null;
    location = null;
    destGroup = null;
  }

  private TunnelDestGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    destGroup = Preconditions.checkNotNull(builder.getDestGroup());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDestGroup() {
    return destGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TunnelDestGroupName of(String project, String location, String destGroup) {
    return newBuilder().setProject(project).setLocation(location).setDestGroup(destGroup).build();
  }

  public static String format(String project, String location, String destGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDestGroup(destGroup)
        .build()
        .toString();
  }

  public static TunnelDestGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DEST_GROUP.validatedMatch(
            formattedString, "TunnelDestGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("dest_group"));
  }

  public static List<TunnelDestGroupName> parseList(List<String> formattedStrings) {
    List<TunnelDestGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TunnelDestGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TunnelDestGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DEST_GROUP.matches(formattedString);
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
          if (destGroup != null) {
            fieldMapBuilder.put("dest_group", destGroup);
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
    return PROJECT_LOCATION_DEST_GROUP.instantiate(
        "project", project, "location", location, "dest_group", destGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TunnelDestGroupName that = ((TunnelDestGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.destGroup, that.destGroup);
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
    h ^= Objects.hashCode(destGroup);
    return h;
  }

  /** Builder for projects/{project}/iap_tunnel/locations/{location}/destGroups/{dest_group}. */
  public static class Builder {
    private String project;
    private String location;
    private String destGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDestGroup() {
      return destGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDestGroup(String destGroup) {
      this.destGroup = destGroup;
      return this;
    }

    private Builder(TunnelDestGroupName tunnelDestGroupName) {
      this.project = tunnelDestGroupName.project;
      this.location = tunnelDestGroupName.location;
      this.destGroup = tunnelDestGroupName.destGroup;
    }

    public TunnelDestGroupName build() {
      return new TunnelDestGroupName(this);
    }
  }
}
