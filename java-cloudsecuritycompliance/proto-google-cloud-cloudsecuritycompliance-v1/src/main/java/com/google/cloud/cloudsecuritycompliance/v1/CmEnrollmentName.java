/*
 * Copyright 2025 Google LLC
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
public class CmEnrollmentName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/cmEnrollment");
  private static final PathTemplate PROJECT_LOCATION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/cmEnrollment");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String project;

  @Deprecated
  protected CmEnrollmentName() {
    organization = null;
    location = null;
    project = null;
  }

  private CmEnrollmentName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION;
  }

  private CmEnrollmentName(ProjectLocationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    organization = null;
    pathTemplate = PROJECT_LOCATION;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationBuilder() {
    return new Builder();
  }

  public static ProjectLocationBuilder newProjectLocationBuilder() {
    return new ProjectLocationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CmEnrollmentName of(String organization, String location) {
    return newBuilder().setOrganization(organization).setLocation(location).build();
  }

  public static CmEnrollmentName ofOrganizationLocationName(String organization, String location) {
    return newBuilder().setOrganization(organization).setLocation(location).build();
  }

  public static CmEnrollmentName ofProjectLocationName(String project, String location) {
    return newProjectLocationBuilder().setProject(project).setLocation(location).build();
  }

  public static String format(String organization, String location) {
    return newBuilder().setOrganization(organization).setLocation(location).build().toString();
  }

  public static String formatOrganizationLocationName(String organization, String location) {
    return newBuilder().setOrganization(organization).setLocation(location).build().toString();
  }

  public static String formatProjectLocationName(String project, String location) {
    return newProjectLocationBuilder().setProject(project).setLocation(location).build().toString();
  }

  public static CmEnrollmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION.match(formattedString);
      return ofOrganizationLocationName(matchMap.get("organization"), matchMap.get("location"));
    } else if (PROJECT_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION.match(formattedString);
      return ofProjectLocationName(matchMap.get("project"), matchMap.get("location"));
    }
    throw new ValidationException("CmEnrollmentName.parse: formattedString not in valid format");
  }

  public static List<CmEnrollmentName> parseList(List<String> formattedStrings) {
    List<CmEnrollmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CmEnrollmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CmEnrollmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION.matches(formattedString)
        || PROJECT_LOCATION.matches(formattedString);
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
      CmEnrollmentName that = ((CmEnrollmentName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
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
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/locations/{location}/cmEnrollment. */
  public static class Builder {
    private String organization;
    private String location;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    private Builder(CmEnrollmentName cmEnrollmentName) {
      Preconditions.checkArgument(
          Objects.equals(cmEnrollmentName.pathTemplate, ORGANIZATION_LOCATION),
          "toBuilder is only supported when CmEnrollmentName has the pattern of"
              + " organizations/{organization}/locations/{location}/cmEnrollment");
      this.organization = cmEnrollmentName.organization;
      this.location = cmEnrollmentName.location;
    }

    public CmEnrollmentName build() {
      return new CmEnrollmentName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/cmEnrollment. */
  public static class ProjectLocationBuilder {
    private String project;
    private String location;

    protected ProjectLocationBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public ProjectLocationBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public CmEnrollmentName build() {
      return new CmEnrollmentName(this);
    }
  }
}
