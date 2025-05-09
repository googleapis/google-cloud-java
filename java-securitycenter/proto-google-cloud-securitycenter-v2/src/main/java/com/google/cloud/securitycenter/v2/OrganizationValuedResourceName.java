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
public class OrganizationValuedResourceName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_SIMULATION_VALUED_RESOURCE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/simulations/{simulation}/valuedResources/{valued_resource}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String simulation;
  private final String valuedResource;

  @Deprecated
  protected OrganizationValuedResourceName() {
    organization = null;
    location = null;
    simulation = null;
    valuedResource = null;
  }

  private OrganizationValuedResourceName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    simulation = Preconditions.checkNotNull(builder.getSimulation());
    valuedResource = Preconditions.checkNotNull(builder.getValuedResource());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getSimulation() {
    return simulation;
  }

  public String getValuedResource() {
    return valuedResource;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OrganizationValuedResourceName of(
      String organization, String location, String simulation, String valuedResource) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSimulation(simulation)
        .setValuedResource(valuedResource)
        .build();
  }

  public static String format(
      String organization, String location, String simulation, String valuedResource) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSimulation(simulation)
        .setValuedResource(valuedResource)
        .build()
        .toString();
  }

  public static OrganizationValuedResourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_SIMULATION_VALUED_RESOURCE.validatedMatch(
            formattedString,
            "OrganizationValuedResourceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"),
        matchMap.get("location"),
        matchMap.get("simulation"),
        matchMap.get("valued_resource"));
  }

  public static List<OrganizationValuedResourceName> parseList(List<String> formattedStrings) {
    List<OrganizationValuedResourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationValuedResourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OrganizationValuedResourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_SIMULATION_VALUED_RESOURCE.matches(formattedString);
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
          if (simulation != null) {
            fieldMapBuilder.put("simulation", simulation);
          }
          if (valuedResource != null) {
            fieldMapBuilder.put("valued_resource", valuedResource);
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
    return ORGANIZATION_LOCATION_SIMULATION_VALUED_RESOURCE.instantiate(
        "organization",
        organization,
        "location",
        location,
        "simulation",
        simulation,
        "valued_resource",
        valuedResource);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OrganizationValuedResourceName that = ((OrganizationValuedResourceName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.simulation, that.simulation)
          && Objects.equals(this.valuedResource, that.valuedResource);
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
    h ^= Objects.hashCode(simulation);
    h *= 1000003;
    h ^= Objects.hashCode(valuedResource);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/simulations/{simulation}/valuedResources/{valued_resource}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String simulation;
    private String valuedResource;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getSimulation() {
      return simulation;
    }

    public String getValuedResource() {
      return valuedResource;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSimulation(String simulation) {
      this.simulation = simulation;
      return this;
    }

    public Builder setValuedResource(String valuedResource) {
      this.valuedResource = valuedResource;
      return this;
    }

    private Builder(OrganizationValuedResourceName organizationValuedResourceName) {
      this.organization = organizationValuedResourceName.organization;
      this.location = organizationValuedResourceName.location;
      this.simulation = organizationValuedResourceName.simulation;
      this.valuedResource = organizationValuedResourceName.valuedResource;
    }

    public OrganizationValuedResourceName build() {
      return new OrganizationValuedResourceName(this);
    }
  }
}
