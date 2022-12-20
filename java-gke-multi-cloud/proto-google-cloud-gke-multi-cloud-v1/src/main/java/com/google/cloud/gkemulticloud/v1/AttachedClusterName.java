/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.gkemulticloud.v1;

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
public class AttachedClusterName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ATTACHED_CLUSTER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/attachedClusters/{attached_cluster}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String attachedCluster;

  @Deprecated
  protected AttachedClusterName() {
    project = null;
    location = null;
    attachedCluster = null;
  }

  private AttachedClusterName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    attachedCluster = Preconditions.checkNotNull(builder.getAttachedCluster());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAttachedCluster() {
    return attachedCluster;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AttachedClusterName of(String project, String location, String attachedCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAttachedCluster(attachedCluster)
        .build();
  }

  public static String format(String project, String location, String attachedCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAttachedCluster(attachedCluster)
        .build()
        .toString();
  }

  public static AttachedClusterName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ATTACHED_CLUSTER.validatedMatch(
            formattedString, "AttachedClusterName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("attached_cluster"));
  }

  public static List<AttachedClusterName> parseList(List<String> formattedStrings) {
    List<AttachedClusterName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AttachedClusterName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AttachedClusterName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ATTACHED_CLUSTER.matches(formattedString);
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
          if (attachedCluster != null) {
            fieldMapBuilder.put("attached_cluster", attachedCluster);
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
    return PROJECT_LOCATION_ATTACHED_CLUSTER.instantiate(
        "project", project, "location", location, "attached_cluster", attachedCluster);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AttachedClusterName that = ((AttachedClusterName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.attachedCluster, that.attachedCluster);
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
    h ^= Objects.hashCode(attachedCluster);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/attachedClusters/{attached_cluster}. */
  public static class Builder {
    private String project;
    private String location;
    private String attachedCluster;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAttachedCluster() {
      return attachedCluster;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAttachedCluster(String attachedCluster) {
      this.attachedCluster = attachedCluster;
      return this;
    }

    private Builder(AttachedClusterName attachedClusterName) {
      this.project = attachedClusterName.project;
      this.location = attachedClusterName.location;
      this.attachedCluster = attachedClusterName.attachedCluster;
    }

    public AttachedClusterName build() {
      return new AttachedClusterName(this);
    }
  }
}
