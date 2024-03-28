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
public class SimulationName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SIMULATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/simulations/{simulation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String simulation;

  @Deprecated
  protected SimulationName() {
    organization = null;
    simulation = null;
  }

  private SimulationName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    simulation = Preconditions.checkNotNull(builder.getSimulation());
  }

  public String getOrganization() {
    return organization;
  }

  public String getSimulation() {
    return simulation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SimulationName of(String organization, String simulation) {
    return newBuilder().setOrganization(organization).setSimulation(simulation).build();
  }

  public static String format(String organization, String simulation) {
    return newBuilder().setOrganization(organization).setSimulation(simulation).build().toString();
  }

  public static SimulationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_SIMULATION.validatedMatch(
            formattedString, "SimulationName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("simulation"));
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
    return ORGANIZATION_SIMULATION.matches(formattedString);
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
    return ORGANIZATION_SIMULATION.instantiate(
        "organization", organization, "simulation", simulation);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SimulationName that = ((SimulationName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.simulation, that.simulation);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(simulation);
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
      this.organization = simulationName.organization;
      this.simulation = simulationName.simulation;
    }

    public SimulationName build() {
      return new SimulationName(this);
    }
  }
}
