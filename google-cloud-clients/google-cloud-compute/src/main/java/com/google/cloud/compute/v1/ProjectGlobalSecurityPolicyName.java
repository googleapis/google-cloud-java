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
public final class ProjectGlobalSecurityPolicyName implements ResourceName {
  private final String project;
  private final String securityPolicy;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/global/securityPolicies/{securityPolicy}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalSecurityPolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    securityPolicy = Preconditions.checkNotNull(builder.getSecurityPolicy());
  }

  public static ProjectGlobalSecurityPolicyName of(String project, String securityPolicy) {
    return newBuilder().setProject(project).setSecurityPolicy(securityPolicy).build();
  }

  public static String format(String project, String securityPolicy) {
    return of(project, securityPolicy).toString();
  }

  public String getProject() {
    return project;
  }

  public String getSecurityPolicy() {
    return securityPolicy;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("securityPolicy", securityPolicy);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectGlobalSecurityPolicyName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalSecurityPolicyName>() {
      public ProjectGlobalSecurityPolicyName parse(String formattedString) {
        return ProjectGlobalSecurityPolicyName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalSecurityPolicyName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectGlobalSecurityPolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("securityPolicy"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String project;
    private String securityPolicy;

    public String getProject() {
      return project;
    }

    public String getSecurityPolicy() {
      return securityPolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSecurityPolicy(String securityPolicy) {
      this.securityPolicy = securityPolicy;
      return this;
    }

    private Builder() {}

    public Builder(ProjectGlobalSecurityPolicyName projectGlobalSecurityPolicyName) {
      project = projectGlobalSecurityPolicyName.project;
      securityPolicy = projectGlobalSecurityPolicyName.securityPolicy;
    }

    public ProjectGlobalSecurityPolicyName build() {
      return new ProjectGlobalSecurityPolicyName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "securityPolicy", securityPolicy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalSecurityPolicyName) {
      ProjectGlobalSecurityPolicyName that = (ProjectGlobalSecurityPolicyName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.securityPolicy, that.getSecurityPolicy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, securityPolicy);
  }
}
