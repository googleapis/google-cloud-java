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
public final class ProjectRegionAddressName implements ResourceName {
  private final String address;
  private final String project;
  private final String region;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/addresses/{address}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectRegionAddressName(Builder builder) {
    address = Preconditions.checkNotNull(builder.getAddress());
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
  }

  public static ProjectRegionAddressName of(String address, String project, String region) {
    return newBuilder().setAddress(address).setProject(project).setRegion(region).build();
  }

  public static String format(String address, String project, String region) {
    return of(address, project, region).toString();
  }

  public String getAddress() {
    return address;
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
          fieldMapBuilder.put("address", address);
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

  public static ResourceNameFactory<ProjectRegionAddressName> newFactory() {
    return new ResourceNameFactory<ProjectRegionAddressName>() {
      public ProjectRegionAddressName parse(String formattedString) {
        return ProjectRegionAddressName.parse(formattedString);
      }
    };
  }

  public static ProjectRegionAddressName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ProjectRegionAddressName.parse: formattedString not in valid format");
    return of(matchMap.get("address"), matchMap.get("project"), matchMap.get("region"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String address;
    private String project;
    private String region;

    public String getAddress() {
      return address;
    }

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public Builder setAddress(String address) {
      this.address = address;
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

    public Builder(ProjectRegionAddressName projectRegionAddressName) {
      address = projectRegionAddressName.address;
      project = projectRegionAddressName.project;
      region = projectRegionAddressName.region;
    }

    public ProjectRegionAddressName build() {
      return new ProjectRegionAddressName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "address", address,
        "project", project,
        "region", region);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectRegionAddressName) {
      ProjectRegionAddressName that = (ProjectRegionAddressName) o;
      return Objects.equals(this.address, that.getAddress())
          && Objects.equals(this.project, that.getProject())
          && Objects.equals(this.region, that.getRegion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, project, region);
  }
}
