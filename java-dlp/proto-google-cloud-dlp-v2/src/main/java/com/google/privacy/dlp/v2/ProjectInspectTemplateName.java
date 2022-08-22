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
public class ProjectInspectTemplateName extends InspectTemplateName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/inspectTemplates/{inspect_template}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String inspectTemplate;

  public String getProject() {
    return project;
  }

  public String getInspectTemplate() {
    return inspectTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectInspectTemplateName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    inspectTemplate = Preconditions.checkNotNull(builder.getInspectTemplate());
  }

  public static ProjectInspectTemplateName of(String project, String inspectTemplate) {
    return newBuilder().setProject(project).setInspectTemplate(inspectTemplate).build();
  }

  public static String format(String project, String inspectTemplate) {
    return newBuilder().setProject(project).setInspectTemplate(inspectTemplate).build().toString();
  }

  public static ProjectInspectTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectInspectTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("inspect_template"));
  }

  public static List<ProjectInspectTemplateName> parseList(List<String> formattedStrings) {
    List<ProjectInspectTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProjectInspectTemplateName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ProjectInspectTemplateName value : values) {
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
          fieldMapBuilder.put("inspectTemplate", inspectTemplate);
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
    return PATH_TEMPLATE.instantiate("project", project, "inspect_template", inspectTemplate);
  }

  /** Builder for ProjectInspectTemplateName. */
  public static class Builder extends InspectTemplateName.Builder {

    private String project;
    private String inspectTemplate;

    public String getProject() {
      return project;
    }

    public String getInspectTemplate() {
      return inspectTemplate;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInspectTemplate(String inspectTemplate) {
      this.inspectTemplate = inspectTemplate;
      return this;
    }

    private Builder() {}

    private Builder(ProjectInspectTemplateName projectInspectTemplateName) {
      project = projectInspectTemplateName.project;
      inspectTemplate = projectInspectTemplateName.inspectTemplate;
    }

    public ProjectInspectTemplateName build() {
      return new ProjectInspectTemplateName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectInspectTemplateName) {
      ProjectInspectTemplateName that = (ProjectInspectTemplateName) o;
      return (this.project.equals(that.project))
          && (this.inspectTemplate.equals(that.inspectTemplate));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= inspectTemplate.hashCode();
    return h;
  }
}
