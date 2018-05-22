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
public final class ProjectGlobalTargetTcpProxyName implements ResourceName {
  private final String project;
  private final String targetTcpProxy;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/global/targetTcpProxies/{targetTcpProxy}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalTargetTcpProxyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    targetTcpProxy = Preconditions.checkNotNull(builder.getTargetTcpProxy());
  }

  public static ProjectGlobalTargetTcpProxyName of(String project, String targetTcpProxy) {
    return newBuilder().setProject(project).setTargetTcpProxy(targetTcpProxy).build();
  }

  public static String format(String project, String targetTcpProxy) {
    return of(project, targetTcpProxy).toString();
  }

  public String getProject() {
    return project;
  }

  public String getTargetTcpProxy() {
    return targetTcpProxy;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("targetTcpProxy", targetTcpProxy);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectGlobalTargetTcpProxyName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalTargetTcpProxyName>() {
      public ProjectGlobalTargetTcpProxyName parse(String formattedString) {
        return ProjectGlobalTargetTcpProxyName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalTargetTcpProxyName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectGlobalTargetTcpProxyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("targetTcpProxy"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String project;
    private String targetTcpProxy;

    public String getProject() {
      return project;
    }

    public String getTargetTcpProxy() {
      return targetTcpProxy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTargetTcpProxy(String targetTcpProxy) {
      this.targetTcpProxy = targetTcpProxy;
      return this;
    }

    private Builder() {}

    public Builder(ProjectGlobalTargetTcpProxyName projectGlobalTargetTcpProxyName) {
      project = projectGlobalTargetTcpProxyName.project;
      targetTcpProxy = projectGlobalTargetTcpProxyName.targetTcpProxy;
    }

    public ProjectGlobalTargetTcpProxyName build() {
      return new ProjectGlobalTargetTcpProxyName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "targetTcpProxy", targetTcpProxy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalTargetTcpProxyName) {
      ProjectGlobalTargetTcpProxyName that = (ProjectGlobalTargetTcpProxyName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.targetTcpProxy, that.getTargetTcpProxy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, targetTcpProxy);
  }
}
