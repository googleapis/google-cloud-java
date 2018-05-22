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
public final class ProjectGlobalHealthCheckName implements ResourceName {
  private final String healthCheck;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/global/healthChecks/{healthCheck}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalHealthCheckName(Builder builder) {
    healthCheck = Preconditions.checkNotNull(builder.getHealthCheck());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectGlobalHealthCheckName of(String healthCheck, String project) {
    return newBuilder().setHealthCheck(healthCheck).setProject(project).build();
  }

  public static String format(String healthCheck, String project) {
    return of(healthCheck, project).toString();
  }

  public String getHealthCheck() {
    return healthCheck;
  }

  public String getProject() {
    return project;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("healthCheck", healthCheck);
          fieldMapBuilder.put("project", project);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectGlobalHealthCheckName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalHealthCheckName>() {
      public ProjectGlobalHealthCheckName parse(String formattedString) {
        return ProjectGlobalHealthCheckName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalHealthCheckName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectGlobalHealthCheckName.parse: formattedString not in valid format");
    return of(matchMap.get("healthCheck"), matchMap.get("project"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String healthCheck;
    private String project;

    public String getHealthCheck() {
      return healthCheck;
    }

    public String getProject() {
      return project;
    }

    public Builder setHealthCheck(String healthCheck) {
      this.healthCheck = healthCheck;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder(ProjectGlobalHealthCheckName projectGlobalHealthCheckName) {
      healthCheck = projectGlobalHealthCheckName.healthCheck;
      project = projectGlobalHealthCheckName.project;
    }

    public ProjectGlobalHealthCheckName build() {
      return new ProjectGlobalHealthCheckName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "healthCheck", healthCheck,
        "project", project);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalHealthCheckName) {
      ProjectGlobalHealthCheckName that = (ProjectGlobalHealthCheckName) o;
      return Objects.equals(this.healthCheck, that.getHealthCheck())
          && Objects.equals(this.project, that.getProject());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(healthCheck, project);
  }
}
