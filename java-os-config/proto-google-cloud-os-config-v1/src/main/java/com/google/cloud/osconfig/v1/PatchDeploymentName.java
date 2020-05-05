/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.osconfig.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class PatchDeploymentName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/patchDeployments/{patch_deployment}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String patchDeployment;

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

  private PatchDeploymentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    patchDeployment = Preconditions.checkNotNull(builder.getPatchDeployment());
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
        PATH_TEMPLATE.validatedMatch(
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("patchDeployment", patchDeployment);
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
    return PATH_TEMPLATE.instantiate("project", project, "patch_deployment", patchDeployment);
  }

  /** Builder for PatchDeploymentName. */
  public static class Builder {

    private String project;
    private String patchDeployment;

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

    private Builder() {}

    private Builder(PatchDeploymentName patchDeploymentName) {
      project = patchDeploymentName.project;
      patchDeployment = patchDeploymentName.patchDeployment;
    }

    public PatchDeploymentName build() {
      return new PatchDeploymentName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PatchDeploymentName) {
      PatchDeploymentName that = (PatchDeploymentName) o;
      return (this.project.equals(that.project))
          && (this.patchDeployment.equals(that.patchDeployment));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= patchDeployment.hashCode();
    return h;
  }
}
