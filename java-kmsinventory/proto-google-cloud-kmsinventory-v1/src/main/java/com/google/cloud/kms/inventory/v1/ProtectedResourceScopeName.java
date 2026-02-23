/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.kms.inventory.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class ProtectedResourceScopeName implements ResourceName {
  private static final PathTemplate ORGANIZATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/protectedResourceScope");
  private static final PathTemplate PROJECT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/protectedResourceScope");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String project;

  @Deprecated
  protected ProtectedResourceScopeName() {
    organization = null;
    project = null;
  }

  private ProtectedResourceScopeName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    project = null;
    pathTemplate = ORGANIZATION;
  }

  private ProtectedResourceScopeName(ProjectBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    organization = null;
    pathTemplate = PROJECT;
  }

  public String getOrganization() {
    return organization;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationBuilder() {
    return new Builder();
  }

  public static ProjectBuilder newProjectBuilder() {
    return new ProjectBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProtectedResourceScopeName of(String organization) {
    return newBuilder().setOrganization(organization).build();
  }

  public static ProtectedResourceScopeName ofOrganizationName(String organization) {
    return newBuilder().setOrganization(organization).build();
  }

  public static ProtectedResourceScopeName ofProjectName(String project) {
    return newProjectBuilder().setProject(project).build();
  }

  public static String format(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  public static String formatOrganizationName(String organization) {
    return newBuilder().setOrganization(organization).build().toString();
  }

  public static String formatProjectName(String project) {
    return newProjectBuilder().setProject(project).build().toString();
  }

  public static ProtectedResourceScopeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION.match(formattedString);
      return ofOrganizationName(matchMap.get("organization"));
    } else if (PROJECT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT.match(formattedString);
      return ofProjectName(matchMap.get("project"));
    }
    throw new ValidationException(
        "ProtectedResourceScopeName.parse: formattedString not in valid format");
  }

  public static List<ProtectedResourceScopeName> parseList(List<String> formattedStrings) {
    List<ProtectedResourceScopeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProtectedResourceScopeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProtectedResourceScopeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION.matches(formattedString) || PROJECT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProtectedResourceScopeName that = ((ProtectedResourceScopeName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.project, that.project);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/protectedResourceScope. */
  public static class Builder {
    private String organization;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    private Builder(ProtectedResourceScopeName protectedResourceScopeName) {
      Preconditions.checkArgument(
          Objects.equals(protectedResourceScopeName.pathTemplate, ORGANIZATION),
          "toBuilder is only supported when ProtectedResourceScopeName has the pattern of"
              + " organizations/{organization}/protectedResourceScope");
      this.organization = protectedResourceScopeName.organization;
    }

    public ProtectedResourceScopeName build() {
      return new ProtectedResourceScopeName(this);
    }
  }

  /** Builder for projects/{project}/protectedResourceScope. */
  public static class ProjectBuilder {
    private String project;

    protected ProjectBuilder() {}

    public String getProject() {
      return project;
    }

    public ProjectBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProtectedResourceScopeName build() {
      return new ProtectedResourceScopeName(this);
    }
  }
}
