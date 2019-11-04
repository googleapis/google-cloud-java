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
public final class ProjectRegionTargetHttpProxyName implements ResourceName {
  private final String project;
  private final String region;
  private final String targetHttpProxy;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "{project}/regions/{region}/targetHttpProxies/{targetHttpProxy}");

  public static final String SERVICE_ADDRESS =
      "https://compute.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectRegionTargetHttpProxyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    targetHttpProxy = Preconditions.checkNotNull(builder.getTargetHttpProxy());
  }

  public static ProjectRegionTargetHttpProxyName of(
      String project, String region, String targetHttpProxy) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setTargetHttpProxy(targetHttpProxy)
        .build();
  }

  public static String format(String project, String region, String targetHttpProxy) {
    return of(project, region, targetHttpProxy).toString();
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  public String getTargetHttpProxy() {
    return targetHttpProxy;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("region", region);
          fieldMapBuilder.put("targetHttpProxy", targetHttpProxy);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectRegionTargetHttpProxyName> newFactory() {
    return new ResourceNameFactory<ProjectRegionTargetHttpProxyName>() {
      public ProjectRegionTargetHttpProxyName parse(String formattedString) {
        return ProjectRegionTargetHttpProxyName.parse(formattedString);
      }
    };
  }

  public static ProjectRegionTargetHttpProxyName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath,
            "ProjectRegionTargetHttpProxyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("region"), matchMap.get("targetHttpProxy"));
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
    private String region;
    private String targetHttpProxy;

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getTargetHttpProxy() {
      return targetHttpProxy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public Builder setTargetHttpProxy(String targetHttpProxy) {
      this.targetHttpProxy = targetHttpProxy;
      return this;
    }

    private Builder() {}

    public Builder(ProjectRegionTargetHttpProxyName projectRegionTargetHttpProxyName) {
      project = projectRegionTargetHttpProxyName.project;
      region = projectRegionTargetHttpProxyName.region;
      targetHttpProxy = projectRegionTargetHttpProxyName.targetHttpProxy;
    }

    public ProjectRegionTargetHttpProxyName build() {
      return new ProjectRegionTargetHttpProxyName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "project", project,
            "region", region,
            "targetHttpProxy", targetHttpProxy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectRegionTargetHttpProxyName) {
      ProjectRegionTargetHttpProxyName that = (ProjectRegionTargetHttpProxyName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.targetHttpProxy, that.getTargetHttpProxy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, region, targetHttpProxy);
  }
}
