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
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class ProjectTargetSslProxyName implements com.google.api.resourcenames.ResourceName {
  private final String project;
  private final String targetSslProxy;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/targetSslProxies/{targetSslProxy}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectTargetSslProxyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    targetSslProxy = Preconditions.checkNotNull(builder.getTargetSslProxy());
  }

  public static ProjectTargetSslProxyName of(
      String project,
      String targetSslProxy
      ) {
    return newBuilder()
    .setProject(project)
    .setTargetSslProxy(targetSslProxy)
      .build();
  }

  public static String format(
      String project,
      String targetSslProxy
      ) {
    return of(
        project,
        targetSslProxy
        )
        .toString();
  }

  public String getProject() {
    return project;
  }

  public String getTargetSslProxy() {
    return targetSslProxy;
  }


  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("targetSslProxy", targetSslProxy);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }


  public static ResourceNameFactory<ProjectTargetSslProxyName> newFactory() {
    return new ResourceNameFactory<ProjectTargetSslProxyName>() {
      public ProjectTargetSslProxyName parse(String formattedString) {return ProjectTargetSslProxyName.parse(formattedString);}
    };
  }

  public static ProjectTargetSslProxyName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProjectTargetSslProxyName.parse: formattedString not in valid format");
    return of(
      matchMap.get("project"),
      matchMap.get("targetSslProxy")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String project;
    private String targetSslProxy;

    public String getProject() {
      return project;
    }
    public String getTargetSslProxy() {
      return targetSslProxy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }
    public Builder setTargetSslProxy(String targetSslProxy) {
      this.targetSslProxy = targetSslProxy;
      return this;
    }

    private Builder() {}

    public Builder (ProjectTargetSslProxyName projectTargetSslProxyName) {
      project = projectTargetSslProxyName.project;
      targetSslProxy = projectTargetSslProxyName.targetSslProxy;
    }

    public ProjectTargetSslProxyName build() {
      return new ProjectTargetSslProxyName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "targetSslProxy", targetSslProxy
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectTargetSslProxyName) {
      ProjectTargetSslProxyName that = (ProjectTargetSslProxyName) o;
      return
          Objects.equals(this.project, that.getProject()) &&
          Objects.equals(this.targetSslProxy, that.getTargetSslProxy())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      project,
      targetSslProxy
    );
  }
}
