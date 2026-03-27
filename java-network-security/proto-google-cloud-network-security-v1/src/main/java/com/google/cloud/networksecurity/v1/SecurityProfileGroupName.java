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

package com.google.cloud.networksecurity.v1;

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
public class SecurityProfileGroupName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_SECURITY_PROFILE_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/securityProfileGroups/{security_profile_group}");
  private static final PathTemplate PROJECT_LOCATION_SECURITY_PROFILE_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/securityProfileGroups/{security_profile_group}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String securityProfileGroup;
  private final String project;

  @Deprecated
  protected SecurityProfileGroupName() {
    organization = null;
    location = null;
    securityProfileGroup = null;
    project = null;
  }

  private SecurityProfileGroupName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    securityProfileGroup = Preconditions.checkNotNull(builder.getSecurityProfileGroup());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_SECURITY_PROFILE_GROUP;
  }

  private SecurityProfileGroupName(ProjectLocationSecurityProfileGroupBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    securityProfileGroup = Preconditions.checkNotNull(builder.getSecurityProfileGroup());
    organization = null;
    pathTemplate = PROJECT_LOCATION_SECURITY_PROFILE_GROUP;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getSecurityProfileGroup() {
    return securityProfileGroup;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationSecurityProfileGroupBuilder() {
    return new Builder();
  }

  public static ProjectLocationSecurityProfileGroupBuilder
      newProjectLocationSecurityProfileGroupBuilder() {
    return new ProjectLocationSecurityProfileGroupBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecurityProfileGroupName of(
      String organization, String location, String securityProfileGroup) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityProfileGroup(securityProfileGroup)
        .build();
  }

  public static SecurityProfileGroupName ofOrganizationLocationSecurityProfileGroupName(
      String organization, String location, String securityProfileGroup) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityProfileGroup(securityProfileGroup)
        .build();
  }

  public static SecurityProfileGroupName ofProjectLocationSecurityProfileGroupName(
      String project, String location, String securityProfileGroup) {
    return newProjectLocationSecurityProfileGroupBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecurityProfileGroup(securityProfileGroup)
        .build();
  }

  public static String format(String organization, String location, String securityProfileGroup) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityProfileGroup(securityProfileGroup)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationSecurityProfileGroupName(
      String organization, String location, String securityProfileGroup) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityProfileGroup(securityProfileGroup)
        .build()
        .toString();
  }

  public static String formatProjectLocationSecurityProfileGroupName(
      String project, String location, String securityProfileGroup) {
    return newProjectLocationSecurityProfileGroupBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecurityProfileGroup(securityProfileGroup)
        .build()
        .toString();
  }

  public static SecurityProfileGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_SECURITY_PROFILE_GROUP.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_SECURITY_PROFILE_GROUP.match(formattedString);
      return ofOrganizationLocationSecurityProfileGroupName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("security_profile_group"));
    } else if (PROJECT_LOCATION_SECURITY_PROFILE_GROUP.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SECURITY_PROFILE_GROUP.match(formattedString);
      return ofProjectLocationSecurityProfileGroupName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("security_profile_group"));
    }
    throw new ValidationException(
        "SecurityProfileGroupName.parse: formattedString not in valid format");
  }

  public static List<SecurityProfileGroupName> parseList(List<String> formattedStrings) {
    List<SecurityProfileGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SecurityProfileGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SecurityProfileGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_SECURITY_PROFILE_GROUP.matches(formattedString)
        || PROJECT_LOCATION_SECURITY_PROFILE_GROUP.matches(formattedString);
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
          if (securityProfileGroup != null) {
            fieldMapBuilder.put("security_profile_group", securityProfileGroup);
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
      SecurityProfileGroupName that = ((SecurityProfileGroupName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.securityProfileGroup, that.securityProfileGroup)
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
    h ^= Objects.hashCode(securityProfileGroup);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/securityProfileGroups/{security_profile_group}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String securityProfileGroup;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getSecurityProfileGroup() {
      return securityProfileGroup;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSecurityProfileGroup(String securityProfileGroup) {
      this.securityProfileGroup = securityProfileGroup;
      return this;
    }

    private Builder(SecurityProfileGroupName securityProfileGroupName) {
      Preconditions.checkArgument(
          Objects.equals(
              securityProfileGroupName.pathTemplate, ORGANIZATION_LOCATION_SECURITY_PROFILE_GROUP),
          "toBuilder is only supported when SecurityProfileGroupName has the pattern of"
              + " organizations/{organization}/locations/{location}/securityProfileGroups/{security_profile_group}");
      this.organization = securityProfileGroupName.organization;
      this.location = securityProfileGroupName.location;
      this.securityProfileGroup = securityProfileGroupName.securityProfileGroup;
    }

    public SecurityProfileGroupName build() {
      return new SecurityProfileGroupName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/securityProfileGroups/{security_profile_group}.
   */
  public static class ProjectLocationSecurityProfileGroupBuilder {
    private String project;
    private String location;
    private String securityProfileGroup;

    protected ProjectLocationSecurityProfileGroupBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSecurityProfileGroup() {
      return securityProfileGroup;
    }

    public ProjectLocationSecurityProfileGroupBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationSecurityProfileGroupBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationSecurityProfileGroupBuilder setSecurityProfileGroup(
        String securityProfileGroup) {
      this.securityProfileGroup = securityProfileGroup;
      return this;
    }

    public SecurityProfileGroupName build() {
      return new SecurityProfileGroupName(this);
    }
  }
}
