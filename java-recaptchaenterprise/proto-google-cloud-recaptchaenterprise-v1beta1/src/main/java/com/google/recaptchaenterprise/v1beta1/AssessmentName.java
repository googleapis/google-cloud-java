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

package com.google.recaptchaenterprise.v1beta1;

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
public class AssessmentName implements ResourceName {
  private static final PathTemplate PROJECT_ASSESSMENT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/assessments/{assessment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String assessment;

  @Deprecated
  protected AssessmentName() {
    project = null;
    assessment = null;
  }

  private AssessmentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    assessment = Preconditions.checkNotNull(builder.getAssessment());
  }

  public String getProject() {
    return project;
  }

  public String getAssessment() {
    return assessment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AssessmentName of(String project, String assessment) {
    return newBuilder().setProject(project).setAssessment(assessment).build();
  }

  public static String format(String project, String assessment) {
    return newBuilder().setProject(project).setAssessment(assessment).build().toString();
  }

  public static AssessmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_ASSESSMENT.validatedMatch(
            formattedString, "AssessmentName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("assessment"));
  }

  public static List<AssessmentName> parseList(List<String> formattedStrings) {
    List<AssessmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AssessmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AssessmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_ASSESSMENT.matches(formattedString);
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
          if (assessment != null) {
            fieldMapBuilder.put("assessment", assessment);
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
    return PROJECT_ASSESSMENT.instantiate("project", project, "assessment", assessment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AssessmentName that = ((AssessmentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.assessment, that.assessment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(assessment);
    return h;
  }

  /** Builder for projects/{project}/assessments/{assessment}. */
  public static class Builder {
    private String project;
    private String assessment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getAssessment() {
      return assessment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setAssessment(String assessment) {
      this.assessment = assessment;
      return this;
    }

    private Builder(AssessmentName assessmentName) {
      this.project = assessmentName.project;
      this.assessment = assessmentName.assessment;
    }

    public AssessmentName build() {
      return new AssessmentName(this);
    }
  }
}
