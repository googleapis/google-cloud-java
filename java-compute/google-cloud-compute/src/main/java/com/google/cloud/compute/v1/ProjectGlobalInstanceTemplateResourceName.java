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
public final class ProjectGlobalInstanceTemplateResourceName implements ResourceName {
  private final String project;
  private final String resource;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/global/instanceTemplates/{resource}");

  public static final String SERVICE_ADDRESS =
      "https://compute.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalInstanceTemplateResourceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    resource = Preconditions.checkNotNull(builder.getResource());
  }

  public static ProjectGlobalInstanceTemplateResourceName of(String project, String resource) {
    return newBuilder().setProject(project).setResource(resource).build();
  }

  public static String format(String project, String resource) {
    return of(project, resource).toString();
  }

  public String getProject() {
    return project;
  }

  public String getResource() {
    return resource;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("resource", resource);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectGlobalInstanceTemplateResourceName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalInstanceTemplateResourceName>() {
      public ProjectGlobalInstanceTemplateResourceName parse(String formattedString) {
        return ProjectGlobalInstanceTemplateResourceName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalInstanceTemplateResourceName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath,
            "ProjectGlobalInstanceTemplateResourceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("resource"));
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
    private String resource;

    public String getProject() {
      return project;
    }

    public String getResource() {
      return resource;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setResource(String resource) {
      this.resource = resource;
      return this;
    }

    private Builder() {}

    public Builder(
        ProjectGlobalInstanceTemplateResourceName projectGlobalInstanceTemplateResourceName) {
      project = projectGlobalInstanceTemplateResourceName.project;
      resource = projectGlobalInstanceTemplateResourceName.resource;
    }

    public ProjectGlobalInstanceTemplateResourceName build() {
      return new ProjectGlobalInstanceTemplateResourceName(this);
    }
  }

  @Override
  public String toString() {
    return SERVICE_ADDRESS
        + PATH_TEMPLATE.instantiate(
            "project", project,
            "resource", resource);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalInstanceTemplateResourceName) {
      ProjectGlobalInstanceTemplateResourceName that =
          (ProjectGlobalInstanceTemplateResourceName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.resource, that.getResource());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, resource);
  }
}
