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

package com.google.cloud.parametermanager.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class TemplateVersionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_TEMPLATE_TEMPLATE_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/templates/{template}/versions/{template_version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String template;
  private final String templateVersion;

  @Deprecated
  protected TemplateVersionName() {
    project = null;
    location = null;
    template = null;
    templateVersion = null;
  }

  private TemplateVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    template = Preconditions.checkNotNull(builder.getTemplate());
    templateVersion = Preconditions.checkNotNull(builder.getTemplateVersion());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getTemplate() {
    return template;
  }

  public String getTemplateVersion() {
    return templateVersion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TemplateVersionName of(
      String project, String location, String template, String templateVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTemplate(template)
        .setTemplateVersion(templateVersion)
        .build();
  }

  public static String format(
      String project, String location, String template, String templateVersion) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTemplate(template)
        .setTemplateVersion(templateVersion)
        .build()
        .toString();
  }

  public static @Nullable TemplateVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_TEMPLATE_TEMPLATE_VERSION.validatedMatch(
            formattedString, "TemplateVersionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("template"),
        matchMap.get("template_version"));
  }

  public static List<TemplateVersionName> parseList(List<String> formattedStrings) {
    List<TemplateVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable TemplateVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TemplateVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_TEMPLATE_TEMPLATE_VERSION.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (template != null) {
            fieldMapBuilder.put("template", template);
          }
          if (templateVersion != null) {
            fieldMapBuilder.put("template_version", templateVersion);
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
    return PROJECT_LOCATION_TEMPLATE_TEMPLATE_VERSION.instantiate(
        "project",
        project,
        "location",
        location,
        "template",
        template,
        "template_version",
        templateVersion);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TemplateVersionName that = ((TemplateVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.template, that.template)
          && Objects.equals(this.templateVersion, that.templateVersion);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(template);
    h *= 1000003;
    h ^= Objects.hashCode(templateVersion);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/templates/{template}/versions/{template_version}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String template;
    private String templateVersion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTemplate() {
      return template;
    }

    public String getTemplateVersion() {
      return templateVersion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTemplate(String template) {
      this.template = template;
      return this;
    }

    public Builder setTemplateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }

    private Builder(TemplateVersionName templateVersionName) {
      this.project = templateVersionName.project;
      this.location = templateVersionName.location;
      this.template = templateVersionName.template;
      this.templateVersion = templateVersionName.templateVersion;
    }

    public TemplateVersionName build() {
      return new TemplateVersionName(this);
    }
  }
}
