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
public final class TargetHttpsProxyName implements ResourceName {
  private final String project;
  private final String targetHttpsProxy;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/targetHttpsProxies/{targetHttpsProxy}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private TargetHttpsProxyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    targetHttpsProxy = Preconditions.checkNotNull(builder.getTargetHttpsProxy());
  }

  public static TargetHttpsProxyName of(
      String project,
      String targetHttpsProxy
      ) {
    return newBuilder()
    .setProject(project)
    .setTargetHttpsProxy(targetHttpsProxy)
      .build();
  }

  public static String format(
      String project,
      String targetHttpsProxy
      ) {
    return of(
        project,
        targetHttpsProxy
        )
        .toString();
  }

  public String getProject() {
    return project;
  }

  public String getTargetHttpsProxy() {
    return targetHttpsProxy;
  }


  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("targetHttpsProxy", targetHttpsProxy);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }


  public static ResourceNameFactory<TargetHttpsProxyName> newFactory() {
    return new ResourceNameFactory<TargetHttpsProxyName>() {
      public TargetHttpsProxyName parse(String formattedString) {return TargetHttpsProxyName.parse(formattedString);}
    };
  }

  public static TargetHttpsProxyName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "TargetHttpsProxyName.parse: formattedString not in valid format");
    return of(
      matchMap.get("project"),
      matchMap.get("targetHttpsProxy")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String project;
    private String targetHttpsProxy;

    public String getProject() {
      return project;
    }
    public String getTargetHttpsProxy() {
      return targetHttpsProxy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }
    public Builder setTargetHttpsProxy(String targetHttpsProxy) {
      this.targetHttpsProxy = targetHttpsProxy;
      return this;
    }

    private Builder() {}

    public Builder (TargetHttpsProxyName targetHttpsProxyName) {
      project = targetHttpsProxyName.project;
      targetHttpsProxy = targetHttpsProxyName.targetHttpsProxy;
    }

    public TargetHttpsProxyName build() {
      return new TargetHttpsProxyName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "targetHttpsProxy", targetHttpsProxy
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetHttpsProxyName) {
      TargetHttpsProxyName that = (TargetHttpsProxyName) o;
      return
          Objects.equals(this.project, that.getProject()) &&
          Objects.equals(this.targetHttpsProxy, that.getTargetHttpsProxy())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      project,
      targetHttpsProxy
    );
  }
}
