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

package com.google.cloud.securitycenter.v2;

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
public class ResourceValueConfigName implements ResourceName {
  private static final PathTemplate ORGANIZATION_RESOURCE_VALUE_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/resourceValueConfigs/{resource_value_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String resourceValueConfig;

  @Deprecated
  protected ResourceValueConfigName() {
    organization = null;
    resourceValueConfig = null;
  }

  private ResourceValueConfigName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    resourceValueConfig = Preconditions.checkNotNull(builder.getResourceValueConfig());
  }

  public String getOrganization() {
    return organization;
  }

  public String getResourceValueConfig() {
    return resourceValueConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
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

  public static String format(String organization, String resourceValueConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setResourceValueConfig(resourceValueConfig)
        .build()
        .toString();
  }

  public static ResourceValueConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_RESOURCE_VALUE_CONFIG.validatedMatch(
            formattedString, "ResourceValueConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("resource_value_config"));
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
    return ORGANIZATION_RESOURCE_VALUE_CONFIG.matches(formattedString);
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
    return ORGANIZATION_RESOURCE_VALUE_CONFIG.instantiate(
        "organization", organization, "resource_value_config", resourceValueConfig);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ResourceValueConfigName that = ((ResourceValueConfigName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.resourceValueConfig, that.resourceValueConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(resourceValueConfig);
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
      this.organization = resourceValueConfigName.organization;
      this.resourceValueConfig = resourceValueConfigName.resourceValueConfig;
    }

    public ResourceValueConfigName build() {
      return new ResourceValueConfigName(this);
    }
  }
}
