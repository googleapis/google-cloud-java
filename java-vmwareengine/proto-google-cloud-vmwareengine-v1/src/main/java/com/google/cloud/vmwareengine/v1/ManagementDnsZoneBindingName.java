/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.vmwareengine.v1;

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
public class ManagementDnsZoneBindingName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PRIVATE_CLOUD_MANAGEMENT_DNS_ZONE_BINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/privateClouds/{private_cloud}/managementDnsZoneBindings/{management_dns_zone_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String privateCloud;
  private final String managementDnsZoneBinding;

  @Deprecated
  protected ManagementDnsZoneBindingName() {
    project = null;
    location = null;
    privateCloud = null;
    managementDnsZoneBinding = null;
  }

  private ManagementDnsZoneBindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    privateCloud = Preconditions.checkNotNull(builder.getPrivateCloud());
    managementDnsZoneBinding = Preconditions.checkNotNull(builder.getManagementDnsZoneBinding());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPrivateCloud() {
    return privateCloud;
  }

  public String getManagementDnsZoneBinding() {
    return managementDnsZoneBinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ManagementDnsZoneBindingName of(
      String project, String location, String privateCloud, String managementDnsZoneBinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateCloud(privateCloud)
        .setManagementDnsZoneBinding(managementDnsZoneBinding)
        .build();
  }

  public static String format(
      String project, String location, String privateCloud, String managementDnsZoneBinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateCloud(privateCloud)
        .setManagementDnsZoneBinding(managementDnsZoneBinding)
        .build()
        .toString();
  }

  public static ManagementDnsZoneBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PRIVATE_CLOUD_MANAGEMENT_DNS_ZONE_BINDING.validatedMatch(
            formattedString,
            "ManagementDnsZoneBindingName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("private_cloud"),
        matchMap.get("management_dns_zone_binding"));
  }

  public static List<ManagementDnsZoneBindingName> parseList(List<String> formattedStrings) {
    List<ManagementDnsZoneBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ManagementDnsZoneBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ManagementDnsZoneBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PRIVATE_CLOUD_MANAGEMENT_DNS_ZONE_BINDING.matches(formattedString);
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
          if (privateCloud != null) {
            fieldMapBuilder.put("private_cloud", privateCloud);
          }
          if (managementDnsZoneBinding != null) {
            fieldMapBuilder.put("management_dns_zone_binding", managementDnsZoneBinding);
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
    return PROJECT_LOCATION_PRIVATE_CLOUD_MANAGEMENT_DNS_ZONE_BINDING.instantiate(
        "project",
        project,
        "location",
        location,
        "private_cloud",
        privateCloud,
        "management_dns_zone_binding",
        managementDnsZoneBinding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ManagementDnsZoneBindingName that = ((ManagementDnsZoneBindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.privateCloud, that.privateCloud)
          && Objects.equals(this.managementDnsZoneBinding, that.managementDnsZoneBinding);
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
    h ^= Objects.hashCode(privateCloud);
    h *= 1000003;
    h ^= Objects.hashCode(managementDnsZoneBinding);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/privateClouds/{private_cloud}/managementDnsZoneBindings/{management_dns_zone_binding}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String privateCloud;
    private String managementDnsZoneBinding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPrivateCloud() {
      return privateCloud;
    }

    public String getManagementDnsZoneBinding() {
      return managementDnsZoneBinding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPrivateCloud(String privateCloud) {
      this.privateCloud = privateCloud;
      return this;
    }

    public Builder setManagementDnsZoneBinding(String managementDnsZoneBinding) {
      this.managementDnsZoneBinding = managementDnsZoneBinding;
      return this;
    }

    private Builder(ManagementDnsZoneBindingName managementDnsZoneBindingName) {
      this.project = managementDnsZoneBindingName.project;
      this.location = managementDnsZoneBindingName.location;
      this.privateCloud = managementDnsZoneBindingName.privateCloud;
      this.managementDnsZoneBinding = managementDnsZoneBindingName.managementDnsZoneBinding;
    }

    public ManagementDnsZoneBindingName build() {
      return new ManagementDnsZoneBindingName(this);
    }
  }
}
