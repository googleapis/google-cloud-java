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
public class FirewallEndpointName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_FIREWALL_ENDPOINT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/firewallEndpoints/{firewall_endpoint}");
  private static final PathTemplate PROJECT_LOCATION_FIREWALL_ENDPOINT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/firewallEndpoints/{firewall_endpoint}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String firewallEndpoint;
  private final String project;

  @Deprecated
  protected FirewallEndpointName() {
    organization = null;
    location = null;
    firewallEndpoint = null;
    project = null;
  }

  private FirewallEndpointName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    firewallEndpoint = Preconditions.checkNotNull(builder.getFirewallEndpoint());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_FIREWALL_ENDPOINT;
  }

  private FirewallEndpointName(ProjectLocationFirewallEndpointBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    firewallEndpoint = Preconditions.checkNotNull(builder.getFirewallEndpoint());
    organization = null;
    pathTemplate = PROJECT_LOCATION_FIREWALL_ENDPOINT;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getFirewallEndpoint() {
    return firewallEndpoint;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationLocationFirewallEndpointBuilder() {
    return new Builder();
  }

  public static ProjectLocationFirewallEndpointBuilder newProjectLocationFirewallEndpointBuilder() {
    return new ProjectLocationFirewallEndpointBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FirewallEndpointName of(
      String organization, String location, String firewallEndpoint) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFirewallEndpoint(firewallEndpoint)
        .build();
  }

  public static FirewallEndpointName ofOrganizationLocationFirewallEndpointName(
      String organization, String location, String firewallEndpoint) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFirewallEndpoint(firewallEndpoint)
        .build();
  }

  public static FirewallEndpointName ofProjectLocationFirewallEndpointName(
      String project, String location, String firewallEndpoint) {
    return newProjectLocationFirewallEndpointBuilder()
        .setProject(project)
        .setLocation(location)
        .setFirewallEndpoint(firewallEndpoint)
        .build();
  }

  public static String format(String organization, String location, String firewallEndpoint) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFirewallEndpoint(firewallEndpoint)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationFirewallEndpointName(
      String organization, String location, String firewallEndpoint) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setFirewallEndpoint(firewallEndpoint)
        .build()
        .toString();
  }

  public static String formatProjectLocationFirewallEndpointName(
      String project, String location, String firewallEndpoint) {
    return newProjectLocationFirewallEndpointBuilder()
        .setProject(project)
        .setLocation(location)
        .setFirewallEndpoint(firewallEndpoint)
        .build()
        .toString();
  }

  public static FirewallEndpointName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_FIREWALL_ENDPOINT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_FIREWALL_ENDPOINT.match(formattedString);
      return ofOrganizationLocationFirewallEndpointName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("firewall_endpoint"));
    } else if (PROJECT_LOCATION_FIREWALL_ENDPOINT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_FIREWALL_ENDPOINT.match(formattedString);
      return ofProjectLocationFirewallEndpointName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("firewall_endpoint"));
    }
    throw new ValidationException(
        "FirewallEndpointName.parse: formattedString not in valid format");
  }

  public static List<FirewallEndpointName> parseList(List<String> formattedStrings) {
    List<FirewallEndpointName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FirewallEndpointName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FirewallEndpointName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_FIREWALL_ENDPOINT.matches(formattedString)
        || PROJECT_LOCATION_FIREWALL_ENDPOINT.matches(formattedString);
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
          if (firewallEndpoint != null) {
            fieldMapBuilder.put("firewall_endpoint", firewallEndpoint);
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
      FirewallEndpointName that = ((FirewallEndpointName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.firewallEndpoint, that.firewallEndpoint)
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
    h ^= Objects.hashCode(firewallEndpoint);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/firewallEndpoints/{firewall_endpoint}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String firewallEndpoint;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getFirewallEndpoint() {
      return firewallEndpoint;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFirewallEndpoint(String firewallEndpoint) {
      this.firewallEndpoint = firewallEndpoint;
      return this;
    }

    private Builder(FirewallEndpointName firewallEndpointName) {
      Preconditions.checkArgument(
          Objects.equals(
              firewallEndpointName.pathTemplate, ORGANIZATION_LOCATION_FIREWALL_ENDPOINT),
          "toBuilder is only supported when FirewallEndpointName has the pattern of"
              + " organizations/{organization}/locations/{location}/firewallEndpoints/{firewall_endpoint}");
      this.organization = firewallEndpointName.organization;
      this.location = firewallEndpointName.location;
      this.firewallEndpoint = firewallEndpointName.firewallEndpoint;
    }

    public FirewallEndpointName build() {
      return new FirewallEndpointName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/firewallEndpoints/{firewall_endpoint}. */
  public static class ProjectLocationFirewallEndpointBuilder {
    private String project;
    private String location;
    private String firewallEndpoint;

    protected ProjectLocationFirewallEndpointBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFirewallEndpoint() {
      return firewallEndpoint;
    }

    public ProjectLocationFirewallEndpointBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationFirewallEndpointBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationFirewallEndpointBuilder setFirewallEndpoint(String firewallEndpoint) {
      this.firewallEndpoint = firewallEndpoint;
      return this;
    }

    public FirewallEndpointName build() {
      return new FirewallEndpointName(this);
    }
  }
}
