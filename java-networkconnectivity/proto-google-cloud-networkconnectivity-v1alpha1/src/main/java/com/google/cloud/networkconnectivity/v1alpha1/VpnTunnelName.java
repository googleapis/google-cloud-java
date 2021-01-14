/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.networkconnectivity.v1alpha1;

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
public class VpnTunnelName implements ResourceName {
  private static final PathTemplate PROJECT_REGION_RESOURCE_ID =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/vpnTunnels/{resource_id}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String region;
  private final String resourceId;

  @Deprecated
  protected VpnTunnelName() {
    project = null;
    region = null;
    resourceId = null;
  }

  private VpnTunnelName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    resourceId = Preconditions.checkNotNull(builder.getResourceId());
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  public String getResourceId() {
    return resourceId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static VpnTunnelName of(String project, String region, String resourceId) {
    return newBuilder().setProject(project).setRegion(region).setResourceId(resourceId).build();
  }

  public static String format(String project, String region, String resourceId) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setResourceId(resourceId)
        .build()
        .toString();
  }

  public static VpnTunnelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_REGION_RESOURCE_ID.validatedMatch(
            formattedString, "VpnTunnelName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("region"), matchMap.get("resource_id"));
  }

  public static List<VpnTunnelName> parseList(List<String> formattedStrings) {
    List<VpnTunnelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<VpnTunnelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (VpnTunnelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_REGION_RESOURCE_ID.matches(formattedString);
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
          if (region != null) {
            fieldMapBuilder.put("region", region);
          }
          if (resourceId != null) {
            fieldMapBuilder.put("resource_id", resourceId);
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
    return PROJECT_REGION_RESOURCE_ID.instantiate(
        "project", project, "region", region, "resource_id", resourceId);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      VpnTunnelName that = ((VpnTunnelName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.region, that.region)
          && Objects.equals(this.resourceId, that.resourceId);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(region);
    h *= 1000003;
    h ^= Objects.hashCode(resourceId);
    return h;
  }

  /** Builder for projects/{project}/regions/{region}/vpnTunnels/{resource_id}. */
  public static class Builder {
    private String project;
    private String region;
    private String resourceId;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getResourceId() {
      return resourceId;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public Builder setResourceId(String resourceId) {
      this.resourceId = resourceId;
      return this;
    }

    private Builder(VpnTunnelName vpnTunnelName) {
      project = vpnTunnelName.project;
      region = vpnTunnelName.region;
      resourceId = vpnTunnelName.resourceId;
    }

    public VpnTunnelName build() {
      return new VpnTunnelName(this);
    }
  }
}
