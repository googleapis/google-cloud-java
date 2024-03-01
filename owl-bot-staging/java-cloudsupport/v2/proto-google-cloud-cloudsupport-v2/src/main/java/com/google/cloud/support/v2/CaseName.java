/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.support.v2;

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
public class CaseName implements ResourceName {
  private static final PathTemplate ORGANIZATION_CASE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/cases/{case}");
  private static final PathTemplate PROJECT_CASE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/cases/{case}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String case_;
  private final String project;

  @Deprecated
  protected CaseName() {
    organization = null;
    case_ = null;
    project = null;
  }

  private CaseName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    case_ = Preconditions.checkNotNull(builder.getCase());
    project = null;
    pathTemplate = ORGANIZATION_CASE;
  }

  private CaseName(ProjectCaseBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    case_ = Preconditions.checkNotNull(builder.getCase());
    organization = null;
    pathTemplate = PROJECT_CASE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getCase() {
    return case_;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationCaseBuilder() {
    return new Builder();
  }

  public static ProjectCaseBuilder newProjectCaseBuilder() {
    return new ProjectCaseBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CaseName of(String organization, String case_) {
    return newBuilder().setOrganization(organization).setCase(case_).build();
  }

  public static CaseName ofOrganizationCaseName(String organization, String case_) {
    return newBuilder().setOrganization(organization).setCase(case_).build();
  }

  public static CaseName ofProjectCaseName(String project, String case_) {
    return newProjectCaseBuilder().setProject(project).setCase(case_).build();
  }

  public static String format(String organization, String case_) {
    return newBuilder().setOrganization(organization).setCase(case_).build().toString();
  }

  public static String formatOrganizationCaseName(String organization, String case_) {
    return newBuilder().setOrganization(organization).setCase(case_).build().toString();
  }

  public static String formatProjectCaseName(String project, String case_) {
    return newProjectCaseBuilder().setProject(project).setCase(case_).build().toString();
  }

  public static CaseName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_CASE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_CASE.match(formattedString);
      return ofOrganizationCaseName(matchMap.get("organization"), matchMap.get("case"));
    } else if (PROJECT_CASE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CASE.match(formattedString);
      return ofProjectCaseName(matchMap.get("project"), matchMap.get("case"));
    }
    throw new ValidationException("CaseName.parse: formattedString not in valid format");
  }

  public static List<CaseName> parseList(List<String> formattedStrings) {
    List<CaseName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CaseName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CaseName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_CASE.matches(formattedString) || PROJECT_CASE.matches(formattedString);
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
          if (case_ != null) {
            fieldMapBuilder.put("case", case_);
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
      CaseName that = ((CaseName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.case_, that.case_)
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
    h ^= Objects.hashCode(case_);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/cases/{case}. */
  public static class Builder {
    private String organization;
    private String case_;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getCase() {
      return case_;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setCase(String case_) {
      this.case_ = case_;
      return this;
    }

    private Builder(CaseName caseName) {
      Preconditions.checkArgument(
          Objects.equals(caseName.pathTemplate, ORGANIZATION_CASE),
          "toBuilder is only supported when CaseName has the pattern of organizations/{organization}/cases/{case}");
      this.organization = caseName.organization;
      this.case_ = caseName.case_;
    }

    public CaseName build() {
      return new CaseName(this);
    }
  }

  /** Builder for projects/{project}/cases/{case}. */
  public static class ProjectCaseBuilder {
    private String project;
    private String case_;

    protected ProjectCaseBuilder() {}

    public String getProject() {
      return project;
    }

    public String getCase() {
      return case_;
    }

    public ProjectCaseBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectCaseBuilder setCase(String case_) {
      this.case_ = case_;
      return this;
    }

    public CaseName build() {
      return new CaseName(this);
    }
  }
}
