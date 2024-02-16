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

package com.google.logging.v2;

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
public class OrganizationLocationName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/locations/{location}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;

  @Deprecated
  protected OrganizationLocationName() {
    organization = null;
    location = null;
  }

  private OrganizationLocationName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OrganizationLocationName of(String organization, String location) {
    return newBuilder().setOrganization(organization).setLocation(location).build();
  }

  public static String format(String organization, String location) {
    return newBuilder().setOrganization(organization).setLocation(location).build().toString();
  }

  public static OrganizationLocationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION.validatedMatch(
            formattedString, "OrganizationLocationName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("location"));
  }

  public static List<OrganizationLocationName> parseList(List<String> formattedStrings) {
    List<OrganizationLocationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationLocationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OrganizationLocationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION.matches(formattedString);
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
    return ORGANIZATION_LOCATION.instantiate("organization", organization, "location", location);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OrganizationLocationName that = ((OrganizationLocationName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location);
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
    return h;
  }

  /** Builder for organizations/{organization}/locations/{location}. */
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

    private Builder(OrganizationLocationName organizationLocationName) {
      this.organization = organizationLocationName.organization;
      this.location = organizationLocationName.location;
    }

    public OrganizationLocationName build() {
      return new OrganizationLocationName(this);
    }
  }
}
