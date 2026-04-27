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

package com.google.cloud.cloudsecuritycompliance.v1;

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
public class FrameworkName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_FRAMEWORK =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/frameworks/{framework}");
  private static final PathTemplate PROJECT_LOCATION_FRAMEWORK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/frameworks/{framework}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String framework;
  private final String project;

  @Deprecated
  protected FrameworkName() {
    organization = null;
    location = null;
    framework = null;
    project = null;
  }

  private FrameworkName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    framework = Preconditions.checkNotNull(builder.getFramework());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_FRAMEWORK;
  }

  private FrameworkName(ProjectLocationFrameworkBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    framework = Preconditions.checkNotNull(builder.getFramework());
    organization = null;
    pathTemplate = PROJECT_LOCATION_FRAMEWORK;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getFramework() {
    return framework;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationFrameworkBuilder() {
    return new Builder();
  }

  public static ProjectLocationFrameworkBuilder newProjectLocationFrameworkBuilder() {
    return new ProjectLocationFrameworkBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FrameworkName of(String organization, String location, String framework) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFramework(framework)
        .build();
  }

  public static FrameworkName ofOrganizationLocationFrameworkName(
      String organization, String location, String framework) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFramework(framework)
        .build();
  }

  public static FrameworkName ofProjectLocationFrameworkName(
      String project, String location, String framework) {
    return newProjectLocationFrameworkBuilder()
        .setProject(project)
        .setLocation(location)
        .setFramework(framework)
        .build();
  }

  public static String format(String organization, String location, String framework) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFramework(framework)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationFrameworkName(
      String organization, String location, String framework) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFramework(framework)
        .build()
        .toString();
  }

  public static String formatProjectLocationFrameworkName(
      String project, String location, String framework) {
    return newProjectLocationFrameworkBuilder()
        .setProject(project)
        .setLocation(location)
        .setFramework(framework)
        .build()
        .toString();
  }

  public static FrameworkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_FRAMEWORK.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_FRAMEWORK.match(formattedString);
      return ofOrganizationLocationFrameworkName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("framework"));
    } else if (PROJECT_LOCATION_FRAMEWORK.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_FRAMEWORK.match(formattedString);
      return ofProjectLocationFrameworkName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("framework"));
    }
    throw new ValidationException("FrameworkName.parse: formattedString not in valid format");
  }

  public static List<FrameworkName> parseList(List<String> formattedStrings) {
    List<FrameworkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FrameworkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FrameworkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_FRAMEWORK.matches(formattedString)
        || PROJECT_LOCATION_FRAMEWORK.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (framework != null) {
            fieldMapBuilder.put("framework", framework);
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
      FrameworkName that = ((FrameworkName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.framework, that.framework)
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(framework);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/locations/{location}/frameworks/{framework}. */
  public static class Builder {
    private String organization;
    private String location;
    private String framework;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFramework() {
      return framework;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFramework(String framework) {
      this.framework = framework;
      return this;
    }

    private Builder(FrameworkName frameworkName) {
      Preconditions.checkArgument(
          Objects.equals(frameworkName.pathTemplate, ORGANIZATION_LOCATION_FRAMEWORK),
          "toBuilder is only supported when FrameworkName has the pattern of"
              + " organizations/{organization}/locations/{location}/frameworks/{framework}");
      this.organization = frameworkName.organization;
      this.location = frameworkName.location;
      this.framework = frameworkName.framework;
    }

    public FrameworkName build() {
      return new FrameworkName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/frameworks/{framework}. */
  public static class ProjectLocationFrameworkBuilder {
    private String project;
    private String location;
    private String framework;

    protected ProjectLocationFrameworkBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFramework() {
      return framework;
    }

    public ProjectLocationFrameworkBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationFrameworkBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationFrameworkBuilder setFramework(String framework) {
      this.framework = framework;
      return this;
    }

    public FrameworkName build() {
      return new FrameworkName(this);
    }
  }
}
