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

package com.google.cloud.servicehealth.v1;

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
public class OrganizationImpactName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_ORGANIZATION_IMPACT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/organizationImpacts/{organization_impact}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String organizationImpact;

  @Deprecated
  protected OrganizationImpactName() {
    organization = null;
    location = null;
    organizationImpact = null;
  }

  private OrganizationImpactName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    organizationImpact = Preconditions.checkNotNull(builder.getOrganizationImpact());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getOrganizationImpact() {
    return organizationImpact;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OrganizationImpactName of(
      String organization, String location, String organizationImpact) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setOrganizationImpact(organizationImpact)
        .build();
  }

  public static String format(String organization, String location, String organizationImpact) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setOrganizationImpact(organizationImpact)
        .build()
        .toString();
  }

  public static OrganizationImpactName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_ORGANIZATION_IMPACT.validatedMatch(
            formattedString, "OrganizationImpactName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"),
        matchMap.get("location"),
        matchMap.get("organization_impact"));
  }

  public static List<OrganizationImpactName> parseList(List<String> formattedStrings) {
    List<OrganizationImpactName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationImpactName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OrganizationImpactName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_ORGANIZATION_IMPACT.matches(formattedString);
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
          if (organizationImpact != null) {
            fieldMapBuilder.put("organization_impact", organizationImpact);
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
    return ORGANIZATION_LOCATION_ORGANIZATION_IMPACT.instantiate(
        "organization",
        organization,
        "location",
        location,
        "organization_impact",
        organizationImpact);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OrganizationImpactName that = ((OrganizationImpactName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.organizationImpact, that.organizationImpact);
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
    h ^= Objects.hashCode(organizationImpact);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/organizationImpacts/{organization_impact}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String organizationImpact;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getOrganizationImpact() {
      return organizationImpact;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setOrganizationImpact(String organizationImpact) {
      this.organizationImpact = organizationImpact;
      return this;
    }

    private Builder(OrganizationImpactName organizationImpactName) {
      this.organization = organizationImpactName.organization;
      this.location = organizationImpactName.location;
      this.organizationImpact = organizationImpactName.organizationImpact;
    }

    public OrganizationImpactName build() {
      return new OrganizationImpactName(this);
    }
  }
}
