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

package com.google.cloud.osconfig.v1;

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
public class PatchDeploymentName implements ResourceName {
  private static final PathTemplate PROJECT_PATCH_DEPLOYMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/patchDeployments/{patch_deployment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String patchDeployment;

  @Deprecated
  protected PatchDeploymentName() {
    project = null;
    patchDeployment = null;
  }

  private PatchDeploymentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    patchDeployment = Preconditions.checkNotNull(builder.getPatchDeployment());
  }

  public String getProject() {
    return project;
  }

  public String getPatchDeployment() {
    return patchDeployment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PatchDeploymentName of(String project, String patchDeployment) {
    return newBuilder().setProject(project).setPatchDeployment(patchDeployment).build();
  }

  public static String format(String project, String patchDeployment) {
    return newBuilder().setProject(project).setPatchDeployment(patchDeployment).build().toString();
  }

  public static PatchDeploymentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_PATCH_DEPLOYMENT.validatedMatch(
            formattedString, "PatchDeploymentName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("patch_deployment"));
  }

  public static List<PatchDeploymentName> parseList(List<String> formattedStrings) {
    List<PatchDeploymentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PatchDeploymentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PatchDeploymentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_PATCH_DEPLOYMENT.matches(formattedString);
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
          if (patchDeployment != null) {
            fieldMapBuilder.put("patch_deployment", patchDeployment);
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
    return PROJECT_PATCH_DEPLOYMENT.instantiate(
        "project", project, "patch_deployment", patchDeployment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PatchDeploymentName that = ((PatchDeploymentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.patchDeployment, that.patchDeployment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(patchDeployment);
    return h;
  }

  /** Builder for projects/{project}/patchDeployments/{patch_deployment}. */
  public static class Builder {
    private String project;
    private String patchDeployment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getPatchDeployment() {
      return patchDeployment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setPatchDeployment(String patchDeployment) {
      this.patchDeployment = patchDeployment;
      return this;
    }

    private Builder(PatchDeploymentName patchDeploymentName) {
      this.project = patchDeploymentName.project;
      this.patchDeployment = patchDeploymentName.patchDeployment;
    }

    public PatchDeploymentName build() {
      return new PatchDeploymentName(this);
    }
  }
}
