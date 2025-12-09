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
public class FrameworkAuditName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FRAMEWORK_AUDIT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/frameworkAudits/{framework_audit}");
  private static final PathTemplate ORGANIZATION_LOCATION_FRAMEWORK_AUDIT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/frameworkAudits/{framework_audit}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String frameworkAudit;
  private final String organization;

  @Deprecated
  protected FrameworkAuditName() {
    project = null;
    location = null;
    frameworkAudit = null;
    organization = null;
  }

  private FrameworkAuditName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkAudit = Preconditions.checkNotNull(builder.getFrameworkAudit());
    organization = null;
    pathTemplate = PROJECT_LOCATION_FRAMEWORK_AUDIT;
  }

  private FrameworkAuditName(OrganizationLocationFrameworkAuditBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    frameworkAudit = Preconditions.checkNotNull(builder.getFrameworkAudit());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_FRAMEWORK_AUDIT;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFrameworkAudit() {
    return frameworkAudit;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationFrameworkAuditBuilder() {
    return new Builder();
  }

  public static OrganizationLocationFrameworkAuditBuilder
      newOrganizationLocationFrameworkAuditBuilder() {
    return new OrganizationLocationFrameworkAuditBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FrameworkAuditName of(String project, String location, String frameworkAudit) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkAudit(frameworkAudit)
        .build();
  }

  public static FrameworkAuditName ofProjectLocationFrameworkAuditName(
      String project, String location, String frameworkAudit) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkAudit(frameworkAudit)
        .build();
  }

  public static FrameworkAuditName ofOrganizationLocationFrameworkAuditName(
      String organization, String location, String frameworkAudit) {
    return newOrganizationLocationFrameworkAuditBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFrameworkAudit(frameworkAudit)
        .build();
  }

  public static String format(String project, String location, String frameworkAudit) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkAudit(frameworkAudit)
        .build()
        .toString();
  }

  public static String formatProjectLocationFrameworkAuditName(
      String project, String location, String frameworkAudit) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFrameworkAudit(frameworkAudit)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationFrameworkAuditName(
      String organization, String location, String frameworkAudit) {
    return newOrganizationLocationFrameworkAuditBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFrameworkAudit(frameworkAudit)
        .build()
        .toString();
  }

  public static FrameworkAuditName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_FRAMEWORK_AUDIT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_FRAMEWORK_AUDIT.match(formattedString);
      return ofProjectLocationFrameworkAuditName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("framework_audit"));
    } else if (ORGANIZATION_LOCATION_FRAMEWORK_AUDIT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_FRAMEWORK_AUDIT.match(formattedString);
      return ofOrganizationLocationFrameworkAuditName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("framework_audit"));
    }
    throw new ValidationException("FrameworkAuditName.parse: formattedString not in valid format");
  }

  public static List<FrameworkAuditName> parseList(List<String> formattedStrings) {
    List<FrameworkAuditName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FrameworkAuditName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FrameworkAuditName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FRAMEWORK_AUDIT.matches(formattedString)
        || ORGANIZATION_LOCATION_FRAMEWORK_AUDIT.matches(formattedString);
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
          if (frameworkAudit != null) {
            fieldMapBuilder.put("framework_audit", frameworkAudit);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
      FrameworkAuditName that = ((FrameworkAuditName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.frameworkAudit, that.frameworkAudit)
          && Objects.equals(this.organization, that.organization);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(frameworkAudit);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/frameworkAudits/{framework_audit}. */
  public static class Builder {
    private String project;
    private String location;
    private String frameworkAudit;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkAudit() {
      return frameworkAudit;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFrameworkAudit(String frameworkAudit) {
      this.frameworkAudit = frameworkAudit;
      return this;
    }

    private Builder(FrameworkAuditName frameworkAuditName) {
      Preconditions.checkArgument(
          Objects.equals(frameworkAuditName.pathTemplate, PROJECT_LOCATION_FRAMEWORK_AUDIT),
          "toBuilder is only supported when FrameworkAuditName has the pattern of"
              + " projects/{project}/locations/{location}/frameworkAudits/{framework_audit}");
      this.project = frameworkAuditName.project;
      this.location = frameworkAuditName.location;
      this.frameworkAudit = frameworkAuditName.frameworkAudit;
    }

    public FrameworkAuditName build() {
      return new FrameworkAuditName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/frameworkAudits/{framework_audit}.
   */
  public static class OrganizationLocationFrameworkAuditBuilder {
    private String organization;
    private String location;
    private String frameworkAudit;

    protected OrganizationLocationFrameworkAuditBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFrameworkAudit() {
      return frameworkAudit;
    }

    public OrganizationLocationFrameworkAuditBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationFrameworkAuditBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationFrameworkAuditBuilder setFrameworkAudit(String frameworkAudit) {
      this.frameworkAudit = frameworkAudit;
      return this;
    }

    public FrameworkAuditName build() {
      return new FrameworkAuditName(this);
    }
  }
}
