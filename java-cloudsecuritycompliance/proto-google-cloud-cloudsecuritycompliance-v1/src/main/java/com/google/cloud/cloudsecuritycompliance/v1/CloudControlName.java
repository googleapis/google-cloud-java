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
public class CloudControlName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_CLOUD_CONTROL =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/cloudControls/{cloud_control}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String cloudControl;

  @Deprecated
  protected CloudControlName() {
    organization = null;
    location = null;
    cloudControl = null;
  }

  private CloudControlName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    cloudControl = Preconditions.checkNotNull(builder.getCloudControl());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getCloudControl() {
    return cloudControl;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CloudControlName of(String organization, String location, String cloudControl) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setCloudControl(cloudControl)
        .build();
  }

  public static String format(String organization, String location, String cloudControl) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setCloudControl(cloudControl)
        .build()
        .toString();
  }

  public static CloudControlName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_CLOUD_CONTROL.validatedMatch(
            formattedString, "CloudControlName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"), matchMap.get("location"), matchMap.get("cloud_control"));
  }

  public static List<CloudControlName> parseList(List<String> formattedStrings) {
    List<CloudControlName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CloudControlName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CloudControlName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_CLOUD_CONTROL.matches(formattedString);
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
          if (cloudControl != null) {
            fieldMapBuilder.put("cloud_control", cloudControl);
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
    return ORGANIZATION_LOCATION_CLOUD_CONTROL.instantiate(
        "organization", organization, "location", location, "cloud_control", cloudControl);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CloudControlName that = ((CloudControlName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cloudControl, that.cloudControl);
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
    h ^= Objects.hashCode(cloudControl);
    return h;
  }

  /**
   * Builder for organizations/{organization}/locations/{location}/cloudControls/{cloud_control}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String cloudControl;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getCloudControl() {
      return cloudControl;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCloudControl(String cloudControl) {
      this.cloudControl = cloudControl;
      return this;
    }

    private Builder(CloudControlName cloudControlName) {
      this.organization = cloudControlName.organization;
      this.location = cloudControlName.location;
      this.cloudControl = cloudControlName.cloudControl;
    }

    public CloudControlName build() {
      return new CloudControlName(this);
    }
  }
}
