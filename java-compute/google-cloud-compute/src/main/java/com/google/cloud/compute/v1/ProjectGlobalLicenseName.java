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
public final class ProjectGlobalLicenseName implements ResourceName {
  private final String license;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/global/licenses/{license}");

  public static final String SERVICE_ADDRESS = "https://www.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalLicenseName(Builder builder) {
    license = Preconditions.checkNotNull(builder.getLicense());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectGlobalLicenseName of(String license, String project) {
    return newBuilder().setLicense(license).setProject(project).build();
  }

  public static String format(String license, String project) {
    return of(license, project).toString();
  }

  public String getLicense() {
    return license;
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
          fieldMapBuilder.put("license", license);
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

  public static ResourceNameFactory<ProjectGlobalLicenseName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalLicenseName>() {
      public ProjectGlobalLicenseName parse(String formattedString) {
        return ProjectGlobalLicenseName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalLicenseName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath, "ProjectGlobalLicenseName.parse: formattedString not in valid format");
    return of(matchMap.get("license"), matchMap.get("project"));
  }

  public static boolean isParsableFrom(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    return PATH_TEMPLATE.matches(resourcePath);
  }

  public static class Builder {
    private String license;
    private String project;

    public String getLicense() {
      return license;
    }

    public String getProject() {
      return project;
    }

    public Builder setLicense(String license) {
      this.license = license;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder(ProjectGlobalLicenseName projectGlobalLicenseName) {
      license = projectGlobalLicenseName.license;
      project = projectGlobalLicenseName.project;
    }

    public ProjectGlobalLicenseName build() {
      return new ProjectGlobalLicenseName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "license", license,
        "project", project);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalLicenseName) {
      ProjectGlobalLicenseName that = (ProjectGlobalLicenseName) o;
      return Objects.equals(this.license, that.getLicense())
          && Objects.equals(this.project, that.getProject());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(license, project);
  }
}
