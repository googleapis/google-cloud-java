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
public class ValuedResourceName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SIMULATION_VALUED_RESOURCE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}");
  private static final PathTemplate ORGANIZATION_LOCATION_SIMLUATION_VALUED_RESOURCE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/simulations/{simluation}/valuedResources/{valued_resource}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String simulation;
  private final String valuedResource;
  private final String location;
  private final String simluation;

  @Deprecated
  protected ValuedResourceName() {
    organization = null;
    simulation = null;
    valuedResource = null;
    location = null;
    simluation = null;
  }

  private ValuedResourceName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    simulation = Preconditions.checkNotNull(builder.getSimulation());
    valuedResource = Preconditions.checkNotNull(builder.getValuedResource());
    location = null;
    simluation = null;
    pathTemplate = ORGANIZATION_SIMULATION_VALUED_RESOURCE;
  }

  private ValuedResourceName(OrganizationLocationSimluationValuedResourceBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    simluation = Preconditions.checkNotNull(builder.getSimluation());
    valuedResource = Preconditions.checkNotNull(builder.getValuedResource());
    simulation = null;
    pathTemplate = ORGANIZATION_LOCATION_SIMLUATION_VALUED_RESOURCE;
  }

  public String getOrganization() {
    return organization;
  }

  public String getSimulation() {
    return simulation;
  }

  public String getValuedResource() {
    return valuedResource;
  }

  public String getLocation() {
    return location;
  }

  public String getSimluation() {
    return simluation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newOrganizationSimulationValuedResourceBuilder() {
    return new Builder();
  }

  public static OrganizationLocationSimluationValuedResourceBuilder
      newOrganizationLocationSimluationValuedResourceBuilder() {
    return new OrganizationLocationSimluationValuedResourceBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ValuedResourceName of(
      String organization, String simulation, String valuedResource) {
    return newBuilder()
        .setOrganization(organization)
        .setSimulation(simulation)
        .setValuedResource(valuedResource)
        .build();
  }

  public static ValuedResourceName ofOrganizationSimulationValuedResourceName(
      String organization, String simulation, String valuedResource) {
    return newBuilder()
        .setOrganization(organization)
        .setSimulation(simulation)
        .setValuedResource(valuedResource)
        .build();
  }

  public static ValuedResourceName ofOrganizationLocationSimluationValuedResourceName(
      String organization, String location, String simluation, String valuedResource) {
    return newOrganizationLocationSimluationValuedResourceBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSimluation(simluation)
        .setValuedResource(valuedResource)
        .build();
  }

  public static String format(String organization, String simulation, String valuedResource) {
    return newBuilder()
        .setOrganization(organization)
        .setSimulation(simulation)
        .setValuedResource(valuedResource)
        .build()
        .toString();
  }

  public static String formatOrganizationSimulationValuedResourceName(
      String organization, String simulation, String valuedResource) {
    return newBuilder()
        .setOrganization(organization)
        .setSimulation(simulation)
        .setValuedResource(valuedResource)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationSimluationValuedResourceName(
      String organization, String location, String simluation, String valuedResource) {
    return newOrganizationLocationSimluationValuedResourceBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSimluation(simluation)
        .setValuedResource(valuedResource)
        .build()
        .toString();
  }

  public static ValuedResourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_SIMULATION_VALUED_RESOURCE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SIMULATION_VALUED_RESOURCE.match(formattedString);
      return ofOrganizationSimulationValuedResourceName(
          matchMap.get("organization"),
          matchMap.get("simulation"),
          matchMap.get("valued_resource"));
    } else if (ORGANIZATION_LOCATION_SIMLUATION_VALUED_RESOURCE.matches(formattedString)) {
      Map<String, String> matchMap =
          ORGANIZATION_LOCATION_SIMLUATION_VALUED_RESOURCE.match(formattedString);
      return ofOrganizationLocationSimluationValuedResourceName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("simluation"),
          matchMap.get("valued_resource"));
    }
    throw new ValidationException("ValuedResourceName.parse: formattedString not in valid format");
  }

  public static List<ValuedResourceName> parseList(List<String> formattedStrings) {
    List<ValuedResourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ValuedResourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ValuedResourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SIMULATION_VALUED_RESOURCE.matches(formattedString)
        || ORGANIZATION_LOCATION_SIMLUATION_VALUED_RESOURCE.matches(formattedString);
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
          if (simulation != null) {
            fieldMapBuilder.put("simulation", simulation);
          }
          if (valuedResource != null) {
            fieldMapBuilder.put("valued_resource", valuedResource);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (simluation != null) {
            fieldMapBuilder.put("simluation", simluation);
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
      ValuedResourceName that = ((ValuedResourceName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.simulation, that.simulation)
          && Objects.equals(this.valuedResource, that.valuedResource)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.simluation, that.simluation);
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
    h ^= Objects.hashCode(simulation);
    h *= 1000003;
    h ^= Objects.hashCode(valuedResource);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(simluation);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}.
   */
  public static class Builder {
    private String organization;
    private String simulation;
    private String valuedResource;

    protected Builder() {}

    public String getOrganization() {
      return organization;
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

    public Builder setSimulation(String simulation) {
      this.simulation = simulation;
      return this;
    }

    public Builder setValuedResource(String valuedResource) {
      this.valuedResource = valuedResource;
      return this;
    }

    private Builder(ValuedResourceName valuedResourceName) {
      Preconditions.checkArgument(
          Objects.equals(valuedResourceName.pathTemplate, ORGANIZATION_SIMULATION_VALUED_RESOURCE),
          "toBuilder is only supported when ValuedResourceName has the pattern of organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}");
      this.organization = valuedResourceName.organization;
      this.simulation = valuedResourceName.simulation;
      this.valuedResource = valuedResourceName.valuedResource;
    }

    public ValuedResourceName build() {
      return new ValuedResourceName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/simulations/{simluation}/valuedResources/{valued_resource}.
   */
  public static class OrganizationLocationSimluationValuedResourceBuilder {
    private String organization;
    private String location;
    private String simluation;
    private String valuedResource;

    protected OrganizationLocationSimluationValuedResourceBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getSimluation() {
      return simluation;
    }

    public String getValuedResource() {
      return valuedResource;
    }

    public OrganizationLocationSimluationValuedResourceBuilder setOrganization(
        String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationSimluationValuedResourceBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationSimluationValuedResourceBuilder setSimluation(String simluation) {
      this.simluation = simluation;
      return this;
    }

    public OrganizationLocationSimluationValuedResourceBuilder setValuedResource(
        String valuedResource) {
      this.valuedResource = valuedResource;
      return this;
    }

    public ValuedResourceName build() {
      return new ValuedResourceName(this);
    }
  }
}
