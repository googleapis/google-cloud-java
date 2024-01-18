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

package com.google.privacy.dlp.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ProjectDeidentifyTemplateName extends DeidentifyTemplateName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/deidentifyTemplates/{deidentify_template}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String deidentifyTemplate;

  public String getProject() {
    return project;
  }

  public String getDeidentifyTemplate() {
    return deidentifyTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectDeidentifyTemplateName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    deidentifyTemplate = Preconditions.checkNotNull(builder.getDeidentifyTemplate());
  }

  public static ProjectDeidentifyTemplateName of(String project, String deidentifyTemplate) {
    return newBuilder().setProject(project).setDeidentifyTemplate(deidentifyTemplate).build();
  }

  public static String format(String project, String deidentifyTemplate) {
    return newBuilder()
        .setProject(project)
        .setDeidentifyTemplate(deidentifyTemplate)
        .build()
        .toString();
  }

  public static ProjectDeidentifyTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectDeidentifyTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("deidentify_template"));
  }

  public static List<ProjectDeidentifyTemplateName> parseList(List<String> formattedStrings) {
    List<ProjectDeidentifyTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectDeidentifyTemplateName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectDeidentifyTemplateName value : values) {
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
          fieldMapBuilder.put("deidentifyTemplate", deidentifyTemplate);
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
    return PATH_TEMPLATE.instantiate("project", project, "deidentify_template", deidentifyTemplate);
  }

  /** Builder for ProjectDeidentifyTemplateName. */
  public static class Builder extends DeidentifyTemplateName.Builder {

    private String project;
    private String deidentifyTemplate;

    public String getProject() {
      return project;
    }

    public String getDeidentifyTemplate() {
      return deidentifyTemplate;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDeidentifyTemplate(String deidentifyTemplate) {
      this.deidentifyTemplate = deidentifyTemplate;
      return this;
    }

    private Builder() {}

    private Builder(ProjectDeidentifyTemplateName projectDeidentifyTemplateName) {
      project = projectDeidentifyTemplateName.project;
      deidentifyTemplate = projectDeidentifyTemplateName.deidentifyTemplate;
    }

    public ProjectDeidentifyTemplateName build() {
      return new ProjectDeidentifyTemplateName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectDeidentifyTemplateName) {
      ProjectDeidentifyTemplateName that = (ProjectDeidentifyTemplateName) o;
      return (this.project.equals(that.project))
          && (this.deidentifyTemplate.equals(that.deidentifyTemplate));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= deidentifyTemplate.hashCode();
    return h;
  }
}
