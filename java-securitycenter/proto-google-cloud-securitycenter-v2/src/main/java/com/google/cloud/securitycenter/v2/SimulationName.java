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
public class SimulationName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SIMULATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/simulations/{simulation}");
  private static final PathTemplate ORGANIZATION_LOCATION_SIMLUATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/simulations/{simluation}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String simulation;
  private final String location;
  private final String simluation;

  @Deprecated
  protected SimulationName() {
    organization = null;
    simulation = null;
    location = null;
    simluation = null;
  }

  private SimulationName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    simulation = Preconditions.checkNotNull(builder.getSimulation());
    location = null;
    simluation = null;
    pathTemplate = ORGANIZATION_SIMULATION;
  }

  private SimulationName(OrganizationLocationSimluationBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    simluation = Preconditions.checkNotNull(builder.getSimluation());
    simulation = null;
    pathTemplate = ORGANIZATION_LOCATION_SIMLUATION;
  }

  public String getOrganization() {
    return organization;
  }

  public String getSimulation() {
    return simulation;
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

  public static Builder newOrganizationSimulationBuilder() {
    return new Builder();
  }

  public static OrganizationLocationSimluationBuilder newOrganizationLocationSimluationBuilder() {
    return new OrganizationLocationSimluationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SimulationName of(String organization, String simulation) {
    return newBuilder().setOrganization(organization).setSimulation(simulation).build();
  }

  public static SimulationName ofOrganizationSimulationName(
      String organization, String simulation) {
    return newBuilder().setOrganization(organization).setSimulation(simulation).build();
  }

  public static SimulationName ofOrganizationLocationSimluationName(
      String organization, String location, String simluation) {
    return newOrganizationLocationSimluationBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSimluation(simluation)
        .build();
  }

  public static String format(String organization, String simulation) {
    return newBuilder().setOrganization(organization).setSimulation(simulation).build().toString();
  }

  public static String formatOrganizationSimulationName(String organization, String simulation) {
    return newBuilder().setOrganization(organization).setSimulation(simulation).build().toString();
  }

  public static String formatOrganizationLocationSimluationName(
      String organization, String location, String simluation) {
    return newOrganizationLocationSimluationBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setSimluation(simluation)
        .build()
        .toString();
  }

  public static SimulationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_SIMULATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SIMULATION.match(formattedString);
      return ofOrganizationSimulationName(matchMap.get("organization"), matchMap.get("simulation"));
    } else if (ORGANIZATION_LOCATION_SIMLUATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_SIMLUATION.match(formattedString);
      return ofOrganizationLocationSimluationName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("simluation"));
    }
    throw new ValidationException("SimulationName.parse: formattedString not in valid format");
  }

  public static List<SimulationName> parseList(List<String> formattedStrings) {
    List<SimulationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SimulationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SimulationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SIMULATION.matches(formattedString)
        || ORGANIZATION_LOCATION_SIMLUATION.matches(formattedString);
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
      SimulationName that = ((SimulationName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.simulation, that.simulation)
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(simluation);
    return h;
  }

  /** Builder for organizations/{organization}/simulations/{simulation}. */
  public static class Builder {
    private String organization;
    private String simulation;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSimulation() {
      return simulation;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setSimulation(String simulation) {
      this.simulation = simulation;
      return this;
    }

    private Builder(SimulationName simulationName) {
      Preconditions.checkArgument(
          Objects.equals(simulationName.pathTemplate, ORGANIZATION_SIMULATION),
          "toBuilder is only supported when SimulationName has the pattern of organizations/{organization}/simulations/{simulation}");
      this.organization = simulationName.organization;
      this.simulation = simulationName.simulation;
    }

    public SimulationName build() {
      return new SimulationName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}/simulations/{simluation}. */
  public static class OrganizationLocationSimluationBuilder {
    private String organization;
    private String location;
    private String simluation;

    protected OrganizationLocationSimluationBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getSimluation() {
      return simluation;
    }

    public OrganizationLocationSimluationBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationSimluationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationSimluationBuilder setSimluation(String simluation) {
      this.simluation = simluation;
      return this;
    }

    public SimulationName build() {
      return new SimulationName(this);
    }
  }
}
