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
public class CloudControlDeploymentName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_CLOUD_CONTROL_DEPLOYMENT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/cloudControlDeployments/{cloud_control_deployment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String cloudControlDeployment;

  @Deprecated
  protected CloudControlDeploymentName() {
    organization = null;
    location = null;
    cloudControlDeployment = null;
  }

  private CloudControlDeploymentName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    cloudControlDeployment = Preconditions.checkNotNull(builder.getCloudControlDeployment());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getCloudControlDeployment() {
    return cloudControlDeployment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CloudControlDeploymentName of(
      String organization, String location, String cloudControlDeployment) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setCloudControlDeployment(cloudControlDeployment)
        .build();
  }

  public static String format(String organization, String location, String cloudControlDeployment) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setCloudControlDeployment(cloudControlDeployment)
        .build()
        .toString();
  }

  public static CloudControlDeploymentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_CLOUD_CONTROL_DEPLOYMENT.validatedMatch(
            formattedString,
            "CloudControlDeploymentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"),
        matchMap.get("location"),
        matchMap.get("cloud_control_deployment"));
  }

  public static List<CloudControlDeploymentName> parseList(List<String> formattedStrings) {
    List<CloudControlDeploymentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CloudControlDeploymentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CloudControlDeploymentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_CLOUD_CONTROL_DEPLOYMENT.matches(formattedString);
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
          if (cloudControlDeployment != null) {
            fieldMapBuilder.put("cloud_control_deployment", cloudControlDeployment);
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
    return ORGANIZATION_LOCATION_CLOUD_CONTROL_DEPLOYMENT.instantiate(
        "organization",
        organization,
        "location",
        location,
        "cloud_control_deployment",
        cloudControlDeployment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CloudControlDeploymentName that = ((CloudControlDeploymentName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cloudControlDeployment, that.cloudControlDeployment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(cloudControlDeployment);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/cloudControlDeployments/{cloud_control_deployment}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String cloudControlDeployment;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getCloudControlDeployment() {
      return cloudControlDeployment;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCloudControlDeployment(String cloudControlDeployment) {
      this.cloudControlDeployment = cloudControlDeployment;
      return this;
    }

    private Builder(CloudControlDeploymentName cloudControlDeploymentName) {
      this.organization = cloudControlDeploymentName.organization;
      this.location = cloudControlDeploymentName.location;
      this.cloudControlDeployment = cloudControlDeploymentName.cloudControlDeployment;
    }

    public CloudControlDeploymentName build() {
      return new CloudControlDeploymentName(this);
    }
  }
}
