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
public final class ProjectTargetHttpProxyName implements ResourceName {
  private final String project;
  private final String targetHttpProxy;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/targetHttpProxies/{targetHttpProxy}");

  public static final String SERVICE_ADDRESS = "https://www.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectTargetHttpProxyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    targetHttpProxy = Preconditions.checkNotNull(builder.getTargetHttpProxy());
  }

  public static ProjectTargetHttpProxyName of(String project, String targetHttpProxy) {
    return newBuilder().setProject(project).setTargetHttpProxy(targetHttpProxy).build();
  }

  public static String format(String project, String targetHttpProxy) {
    return of(project, targetHttpProxy).toString();
  }

  public String getProject() {
    return project;
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

  public static ResourceNameFactory<ProjectTargetHttpProxyName> newFactory() {
    return new ResourceNameFactory<ProjectTargetHttpProxyName>() {
      public ProjectTargetHttpProxyName parse(String formattedString) {
        return ProjectTargetHttpProxyName.parse(formattedString);
      }
    };
  }

  public static ProjectTargetHttpProxyName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath, "ProjectTargetHttpProxyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("targetHttpProxy"));
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
    private String targetHttpProxy;

    public String getProject() {
      return project;
    }

    public String getTargetHttpProxy() {
      return targetHttpProxy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTargetHttpProxy(String targetHttpProxy) {
      this.targetHttpProxy = targetHttpProxy;
      return this;
    }

    private Builder() {}

    public Builder(ProjectTargetHttpProxyName projectTargetHttpProxyName) {
      project = projectTargetHttpProxyName.project;
      targetHttpProxy = projectTargetHttpProxyName.targetHttpProxy;
    }

    public ProjectTargetHttpProxyName build() {
      return new ProjectTargetHttpProxyName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "targetHttpProxy", targetHttpProxy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectTargetHttpProxyName) {
      ProjectTargetHttpProxyName that = (ProjectTargetHttpProxyName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.targetHttpProxy, that.getTargetHttpProxy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, targetHttpProxy);
  }
}
