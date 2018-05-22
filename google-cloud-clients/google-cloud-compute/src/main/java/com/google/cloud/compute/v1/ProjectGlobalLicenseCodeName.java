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
public final class ProjectGlobalLicenseCodeName implements ResourceName {
  private final String licenseCode;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/global/licenseCodes/{licenseCode}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalLicenseCodeName(Builder builder) {
    licenseCode = Preconditions.checkNotNull(builder.getLicenseCode());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectGlobalLicenseCodeName of(String licenseCode, String project) {
    return newBuilder().setLicenseCode(licenseCode).setProject(project).build();
  }

  public static String format(String licenseCode, String project) {
    return of(licenseCode, project).toString();
  }

  public String getLicenseCode() {
    return licenseCode;
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
          fieldMapBuilder.put("licenseCode", licenseCode);
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

  public static ResourceNameFactory<ProjectGlobalLicenseCodeName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalLicenseCodeName>() {
      public ProjectGlobalLicenseCodeName parse(String formattedString) {
        return ProjectGlobalLicenseCodeName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalLicenseCodeName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectGlobalLicenseCodeName.parse: formattedString not in valid format");
    return of(matchMap.get("licenseCode"), matchMap.get("project"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String licenseCode;
    private String project;

    public String getLicenseCode() {
      return licenseCode;
    }

    public String getProject() {
      return project;
    }

    public Builder setLicenseCode(String licenseCode) {
      this.licenseCode = licenseCode;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder(ProjectGlobalLicenseCodeName projectGlobalLicenseCodeName) {
      licenseCode = projectGlobalLicenseCodeName.licenseCode;
      project = projectGlobalLicenseCodeName.project;
    }

    public ProjectGlobalLicenseCodeName build() {
      return new ProjectGlobalLicenseCodeName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "licenseCode", licenseCode,
        "project", project);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalLicenseCodeName) {
      ProjectGlobalLicenseCodeName that = (ProjectGlobalLicenseCodeName) o;
      return Objects.equals(this.licenseCode, that.getLicenseCode())
          && Objects.equals(this.project, that.getProject());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(licenseCode, project);
  }
}
