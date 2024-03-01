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
public class AttackPathName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SIMULATION_VALUED_RESOURCE_ATTACK_PATH =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}/attackPaths/{attack_path}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String simulation;
  private final String valuedResource;
  private final String attackPath;

  @Deprecated
  protected AttackPathName() {
    organization = null;
    simulation = null;
    valuedResource = null;
    attackPath = null;
  }

  private AttackPathName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    simulation = Preconditions.checkNotNull(builder.getSimulation());
    valuedResource = Preconditions.checkNotNull(builder.getValuedResource());
    attackPath = Preconditions.checkNotNull(builder.getAttackPath());
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

  public String getAttackPath() {
    return attackPath;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AttackPathName of(
      String organization, String simulation, String valuedResource, String attackPath) {
    return newBuilder()
        .setOrganization(organization)
        .setSimulation(simulation)
        .setValuedResource(valuedResource)
        .setAttackPath(attackPath)
        .build();
  }

  public static String format(
      String organization, String simulation, String valuedResource, String attackPath) {
    return newBuilder()
        .setOrganization(organization)
        .setSimulation(simulation)
        .setValuedResource(valuedResource)
        .setAttackPath(attackPath)
        .build()
        .toString();
  }

  public static AttackPathName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_SIMULATION_VALUED_RESOURCE_ATTACK_PATH.validatedMatch(
            formattedString, "AttackPathName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"),
        matchMap.get("simulation"),
        matchMap.get("valued_resource"),
        matchMap.get("attack_path"));
  }

  public static List<AttackPathName> parseList(List<String> formattedStrings) {
    List<AttackPathName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AttackPathName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AttackPathName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SIMULATION_VALUED_RESOURCE_ATTACK_PATH.matches(formattedString);
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
          if (attackPath != null) {
            fieldMapBuilder.put("attack_path", attackPath);
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
    return ORGANIZATION_SIMULATION_VALUED_RESOURCE_ATTACK_PATH.instantiate(
        "organization",
        organization,
        "simulation",
        simulation,
        "valued_resource",
        valuedResource,
        "attack_path",
        attackPath);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AttackPathName that = ((AttackPathName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.simulation, that.simulation)
          && Objects.equals(this.valuedResource, that.valuedResource)
          && Objects.equals(this.attackPath, that.attackPath);
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
    h *= 1000003;
    h ^= Objects.hashCode(valuedResource);
    h *= 1000003;
    h ^= Objects.hashCode(attackPath);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/simulations/{simulation}/valuedResources/{valued_resource}/attackPaths/{attack_path}.
   */
  public static class Builder {
    private String organization;
    private String simulation;
    private String valuedResource;
    private String attackPath;

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

    public String getAttackPath() {
      return attackPath;
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

    public Builder setAttackPath(String attackPath) {
      this.attackPath = attackPath;
      return this;
    }

    private Builder(AttackPathName attackPathName) {
      this.organization = attackPathName.organization;
      this.simulation = attackPathName.simulation;
      this.valuedResource = attackPathName.valuedResource;
      this.attackPath = attackPathName.attackPath;
    }

    public AttackPathName build() {
      return new AttackPathName(this);
    }
  }
}
