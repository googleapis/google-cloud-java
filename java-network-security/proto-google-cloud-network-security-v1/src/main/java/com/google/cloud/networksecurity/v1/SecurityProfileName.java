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
public class SecurityProfileName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_SECURITY_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/securityProfiles/{security_profile}");
  private static final PathTemplate PROJECT_LOCATION_SECURITY_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/securityProfiles/{security_profile}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String securityProfile;
  private final String project;

  @Deprecated
  protected SecurityProfileName() {
    organization = null;
    location = null;
    securityProfile = null;
    project = null;
  }

  private SecurityProfileName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    securityProfile = Preconditions.checkNotNull(builder.getSecurityProfile());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_SECURITY_PROFILE;
  }

  private SecurityProfileName(ProjectLocationSecurityProfileBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    securityProfile = Preconditions.checkNotNull(builder.getSecurityProfile());
    organization = null;
    pathTemplate = PROJECT_LOCATION_SECURITY_PROFILE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getSecurityProfile() {
    return securityProfile;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationSecurityProfileBuilder() {
    return new Builder();
  }

  public static ProjectLocationSecurityProfileBuilder newProjectLocationSecurityProfileBuilder() {
    return new ProjectLocationSecurityProfileBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecurityProfileName of(
      String organization, String location, String securityProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityProfile(securityProfile)
        .build();
  }

  public static SecurityProfileName ofOrganizationLocationSecurityProfileName(
      String organization, String location, String securityProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityProfile(securityProfile)
        .build();
  }

  public static SecurityProfileName ofProjectLocationSecurityProfileName(
      String project, String location, String securityProfile) {
    return newProjectLocationSecurityProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecurityProfile(securityProfile)
        .build();
  }

  public static String format(String organization, String location, String securityProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityProfile(securityProfile)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationSecurityProfileName(
      String organization, String location, String securityProfile) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSecurityProfile(securityProfile)
        .build()
        .toString();
  }

  public static String formatProjectLocationSecurityProfileName(
      String project, String location, String securityProfile) {
    return newProjectLocationSecurityProfileBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecurityProfile(securityProfile)
        .build()
        .toString();
  }

  public static SecurityProfileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_SECURITY_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_SECURITY_PROFILE.match(formattedString);
      return ofOrganizationLocationSecurityProfileName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("security_profile"));
    } else if (PROJECT_LOCATION_SECURITY_PROFILE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SECURITY_PROFILE.match(formattedString);
      return ofProjectLocationSecurityProfileName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("security_profile"));
    }
    throw new ValidationException("SecurityProfileName.parse: formattedString not in valid format");
  }

  public static List<SecurityProfileName> parseList(List<String> formattedStrings) {
    List<SecurityProfileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SecurityProfileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SecurityProfileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_SECURITY_PROFILE.matches(formattedString)
        || PROJECT_LOCATION_SECURITY_PROFILE.matches(formattedString);
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
          if (securityProfile != null) {
            fieldMapBuilder.put("security_profile", securityProfile);
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
      SecurityProfileName that = ((SecurityProfileName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.securityProfile, that.securityProfile)
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
    h ^= Objects.hashCode(securityProfile);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/securityProfiles/{security_profile}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String securityProfile;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getSecurityProfile() {
      return securityProfile;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSecurityProfile(String securityProfile) {
      this.securityProfile = securityProfile;
      return this;
    }

    private Builder(SecurityProfileName securityProfileName) {
      Preconditions.checkArgument(
          Objects.equals(securityProfileName.pathTemplate, ORGANIZATION_LOCATION_SECURITY_PROFILE),
          "toBuilder is only supported when SecurityProfileName has the pattern of"
              + " organizations/{organization}/locations/{location}/securityProfiles/{security_profile}");
      this.organization = securityProfileName.organization;
      this.location = securityProfileName.location;
      this.securityProfile = securityProfileName.securityProfile;
    }

    public SecurityProfileName build() {
      return new SecurityProfileName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/securityProfiles/{security_profile}. */
  public static class ProjectLocationSecurityProfileBuilder {
    private String project;
    private String location;
    private String securityProfile;

    protected ProjectLocationSecurityProfileBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSecurityProfile() {
      return securityProfile;
    }

    public ProjectLocationSecurityProfileBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationSecurityProfileBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationSecurityProfileBuilder setSecurityProfile(String securityProfile) {
      this.securityProfile = securityProfile;
      return this;
    }

    public SecurityProfileName build() {
      return new SecurityProfileName(this);
    }
  }
}
