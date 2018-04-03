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
public final class ProjectHttpsHealthCheckName implements com.google.api.resourcenames.ResourceName {
  private final String httpsHealthCheck;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/httpsHealthChecks/{httpsHealthCheck}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectHttpsHealthCheckName(Builder builder) {
    httpsHealthCheck = Preconditions.checkNotNull(builder.getHttpsHealthCheck());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectHttpsHealthCheckName of(
      String httpsHealthCheck,
      String project
      ) {
    return newBuilder()
    .setHttpsHealthCheck(httpsHealthCheck)
    .setProject(project)
      .build();
  }

  public static String format(
      String httpsHealthCheck,
      String project
      ) {
    return of(
        httpsHealthCheck,
        project
        )
        .toString();
  }

  public String getHttpsHealthCheck() {
    return httpsHealthCheck;
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
          fieldMapBuilder.put("httpsHealthCheck", httpsHealthCheck);
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


  public static ResourceNameFactory<ProjectHttpsHealthCheckName> newFactory() {
    return new ResourceNameFactory<ProjectHttpsHealthCheckName>() {
      public ProjectHttpsHealthCheckName parse(String formattedString) {return ProjectHttpsHealthCheckName.parse(formattedString);}
    };
  }

  public static ProjectHttpsHealthCheckName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProjectHttpsHealthCheckName.parse: formattedString not in valid format");
    return of(
      matchMap.get("httpsHealthCheck"),
      matchMap.get("project")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String httpsHealthCheck;
    private String project;

    public String getHttpsHealthCheck() {
      return httpsHealthCheck;
    }
    public String getProject() {
      return project;
    }

    public Builder setHttpsHealthCheck(String httpsHealthCheck) {
      this.httpsHealthCheck = httpsHealthCheck;
      return this;
    }
    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder (ProjectHttpsHealthCheckName projectHttpsHealthCheckName) {
      httpsHealthCheck = projectHttpsHealthCheckName.httpsHealthCheck;
      project = projectHttpsHealthCheckName.project;
    }

    public ProjectHttpsHealthCheckName build() {
      return new ProjectHttpsHealthCheckName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "httpsHealthCheck", httpsHealthCheck,
        "project", project
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectHttpsHealthCheckName) {
      ProjectHttpsHealthCheckName that = (ProjectHttpsHealthCheckName) o;
      return
          Objects.equals(this.httpsHealthCheck, that.getHttpsHealthCheck()) &&
          Objects.equals(this.project, that.getProject())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      httpsHealthCheck,
      project
    );
  }
}
