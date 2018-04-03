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
public final class ProjectBackendServiceName implements com.google.api.resourcenames.ResourceName {
  private final String backendService;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/backendServices/{backendService}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectBackendServiceName(Builder builder) {
    backendService = Preconditions.checkNotNull(builder.getBackendService());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectBackendServiceName of(
      String backendService,
      String project
      ) {
    return newBuilder()
    .setBackendService(backendService)
    .setProject(project)
      .build();
  }

  public static String format(
      String backendService,
      String project
      ) {
    return of(
        backendService,
        project
        )
        .toString();
  }

  public String getBackendService() {
    return backendService;
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
          fieldMapBuilder.put("backendService", backendService);
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


  public static ResourceNameFactory<ProjectBackendServiceName> newFactory() {
    return new ResourceNameFactory<ProjectBackendServiceName>() {
      public ProjectBackendServiceName parse(String formattedString) {return ProjectBackendServiceName.parse(formattedString);}
    };
  }

  public static ProjectBackendServiceName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProjectBackendServiceName.parse: formattedString not in valid format");
    return of(
      matchMap.get("backendService"),
      matchMap.get("project")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String backendService;
    private String project;

    public String getBackendService() {
      return backendService;
    }
    public String getProject() {
      return project;
    }

    public Builder setBackendService(String backendService) {
      this.backendService = backendService;
      return this;
    }
    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder (ProjectBackendServiceName projectBackendServiceName) {
      backendService = projectBackendServiceName.backendService;
      project = projectBackendServiceName.project;
    }

    public ProjectBackendServiceName build() {
      return new ProjectBackendServiceName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "backendService", backendService,
        "project", project
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectBackendServiceName) {
      ProjectBackendServiceName that = (ProjectBackendServiceName) o;
      return
          Objects.equals(this.backendService, that.getBackendService()) &&
          Objects.equals(this.project, that.getProject())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      backendService,
      project
    );
  }
}
