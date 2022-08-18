/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.gsuiteaddons.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class InstallStatusName implements ResourceName {
  private static final PathTemplate PROJECT_DEPLOYMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/deployments/{deployment}/installStatus");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String deployment;

  @Deprecated
  protected InstallStatusName() {
    project = null;
    deployment = null;
  }

  private InstallStatusName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    deployment = Preconditions.checkNotNull(builder.getDeployment());
  }

  public String getProject() {
    return project;
  }

  public String getDeployment() {
    return deployment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static InstallStatusName of(String project, String deployment) {
    return newBuilder().setProject(project).setDeployment(deployment).build();
  }

  public static String format(String project, String deployment) {
    return newBuilder().setProject(project).setDeployment(deployment).build().toString();
  }

  public static InstallStatusName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_DEPLOYMENT.validatedMatch(
            formattedString, "InstallStatusName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("deployment"));
  }

  public static List<InstallStatusName> parseList(List<String> formattedStrings) {
    List<InstallStatusName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<InstallStatusName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (InstallStatusName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_DEPLOYMENT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (deployment != null) {
            fieldMapBuilder.put("deployment", deployment);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PROJECT_DEPLOYMENT.instantiate("project", project, "deployment", deployment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      InstallStatusName that = ((InstallStatusName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.deployment, that.deployment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(deployment);
    return h;
  }

  /** Builder for projects/{project}/deployments/{deployment}/installStatus. */
  public static class Builder {
    private String project;
    private String deployment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getDeployment() {
      return deployment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDeployment(String deployment) {
      this.deployment = deployment;
      return this;
    }

    private Builder(InstallStatusName installStatusName) {
      this.project = installStatusName.project;
      this.deployment = installStatusName.deployment;
    }

    public InstallStatusName build() {
      return new InstallStatusName(this);
    }
  }
}
