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

package com.google.cloud.securitycenter.v2;

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
public class ResourceValueConfigName implements ResourceName {
  private static final PathTemplate ORGANIZATION_RESOURCE_VALUE_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/resourceValueConfigs/{resource_value_config}");
  private static final PathTemplate ORGANIZATION_LOCATION_RESOURCE_VALUE_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/resourceValueConfigs/{resource_value_config}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String resourceValueConfig;
  private final String location;

  @Deprecated
  protected ResourceValueConfigName() {
    organization = null;
    resourceValueConfig = null;
    location = null;
  }

  private ResourceValueConfigName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    resourceValueConfig = Preconditions.checkNotNull(builder.getResourceValueConfig());
    location = null;
    pathTemplate = ORGANIZATION_RESOURCE_VALUE_CONFIG;
  }

  private ResourceValueConfigName(OrganizationLocationResourceValueConfigBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    resourceValueConfig = Preconditions.checkNotNull(builder.getResourceValueConfig());
    pathTemplate = ORGANIZATION_LOCATION_RESOURCE_VALUE_CONFIG;
  }

  public String getOrganization() {
    return organization;
  }

  public String getResourceValueConfig() {
    return resourceValueConfig;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationResourceValueConfigBuilder() {
    return new Builder();
  }

  public static OrganizationLocationResourceValueConfigBuilder
      newOrganizationLocationResourceValueConfigBuilder() {
    return new OrganizationLocationResourceValueConfigBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ResourceValueConfigName of(String organization, String resourceValueConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setResourceValueConfig(resourceValueConfig)
        .build();
  }

  public static ResourceValueConfigName ofOrganizationResourceValueConfigName(
      String organization, String resourceValueConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setResourceValueConfig(resourceValueConfig)
        .build();
  }

  public static ResourceValueConfigName ofOrganizationLocationResourceValueConfigName(
      String organization, String location, String resourceValueConfig) {
    return newOrganizationLocationResourceValueConfigBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setResourceValueConfig(resourceValueConfig)
        .build();
  }

  public static String format(String organization, String resourceValueConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setResourceValueConfig(resourceValueConfig)
        .build()
        .toString();
  }

  public static String formatOrganizationResourceValueConfigName(
      String organization, String resourceValueConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setResourceValueConfig(resourceValueConfig)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationResourceValueConfigName(
      String organization, String location, String resourceValueConfig) {
    return newOrganizationLocationResourceValueConfigBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setResourceValueConfig(resourceValueConfig)
        .build()
        .toString();
  }

  public static ResourceValueConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_RESOURCE_VALUE_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_RESOURCE_VALUE_CONFIG.match(formattedString);
      return ofOrganizationResourceValueConfigName(
          matchMap.get("organization"), matchMap.get("resource_value_config"));
    } else if (ORGANIZATION_LOCATION_RESOURCE_VALUE_CONFIG.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_RESOURCE_VALUE_CONFIG.match(formattedString);
      return ofOrganizationLocationResourceValueConfigName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("resource_value_config"));
    }
    throw new ValidationException(
        "ResourceValueConfigName.parse: formattedString not in valid format");
  }

  public static List<ResourceValueConfigName> parseList(List<String> formattedStrings) {
    List<ResourceValueConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ResourceValueConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ResourceValueConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_RESOURCE_VALUE_CONFIG.matches(formattedString)
        || ORGANIZATION_LOCATION_RESOURCE_VALUE_CONFIG.matches(formattedString);
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
          if (resourceValueConfig != null) {
            fieldMapBuilder.put("resource_value_config", resourceValueConfig);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ResourceValueConfigName that = ((ResourceValueConfigName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.resourceValueConfig, that.resourceValueConfig)
          && Objects.equals(this.location, that.location);
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
    h ^= Objects.hashCode(resourceValueConfig);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for organizations/{organization}/resourceValueConfigs/{resource_value_config}. */
  public static class Builder {
    private String organization;
    private String resourceValueConfig;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getResourceValueConfig() {
      return resourceValueConfig;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setResourceValueConfig(String resourceValueConfig) {
      this.resourceValueConfig = resourceValueConfig;
      return this;
    }

    private Builder(ResourceValueConfigName resourceValueConfigName) {
      Preconditions.checkArgument(
          Objects.equals(resourceValueConfigName.pathTemplate, ORGANIZATION_RESOURCE_VALUE_CONFIG),
          "toBuilder is only supported when ResourceValueConfigName has the pattern of"
              + " organizations/{organization}/resourceValueConfigs/{resource_value_config}");
      this.organization = resourceValueConfigName.organization;
      this.resourceValueConfig = resourceValueConfigName.resourceValueConfig;
    }

    public ResourceValueConfigName build() {
      return new ResourceValueConfigName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/resourceValueConfigs/{resource_value_config}.
   */
  public static class OrganizationLocationResourceValueConfigBuilder {
    private String organization;
    private String location;
    private String resourceValueConfig;

    protected OrganizationLocationResourceValueConfigBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getResourceValueConfig() {
      return resourceValueConfig;
    }

    public OrganizationLocationResourceValueConfigBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationResourceValueConfigBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationResourceValueConfigBuilder setResourceValueConfig(
        String resourceValueConfig) {
      this.resourceValueConfig = resourceValueConfig;
      return this;
    }

    public ResourceValueConfigName build() {
      return new ResourceValueConfigName(this);
    }
  }
}
