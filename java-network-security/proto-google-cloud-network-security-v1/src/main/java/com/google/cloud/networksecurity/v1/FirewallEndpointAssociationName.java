/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.networksecurity.v1;

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
public class FirewallEndpointAssociationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_FIREWALL_ENDPOINT_ASSOCIATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/firewallEndpointAssociations/{firewall_endpoint_association}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String firewallEndpointAssociation;

  @Deprecated
  protected FirewallEndpointAssociationName() {
    project = null;
    location = null;
    firewallEndpointAssociation = null;
  }

  private FirewallEndpointAssociationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    firewallEndpointAssociation =
        Preconditions.checkNotNull(builder.getFirewallEndpointAssociation());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getFirewallEndpointAssociation() {
    return firewallEndpointAssociation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FirewallEndpointAssociationName of(
      String project, String location, String firewallEndpointAssociation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFirewallEndpointAssociation(firewallEndpointAssociation)
        .build();
  }

  public static String format(String project, String location, String firewallEndpointAssociation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setFirewallEndpointAssociation(firewallEndpointAssociation)
        .build()
        .toString();
  }

  public static FirewallEndpointAssociationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_FIREWALL_ENDPOINT_ASSOCIATION.validatedMatch(
            formattedString,
            "FirewallEndpointAssociationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("firewall_endpoint_association"));
  }

  public static List<FirewallEndpointAssociationName> parseList(List<String> formattedStrings) {
    List<FirewallEndpointAssociationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FirewallEndpointAssociationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FirewallEndpointAssociationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_FIREWALL_ENDPOINT_ASSOCIATION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (firewallEndpointAssociation != null) {
            fieldMapBuilder.put("firewall_endpoint_association", firewallEndpointAssociation);
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
    return PROJECT_LOCATION_FIREWALL_ENDPOINT_ASSOCIATION.instantiate(
        "project",
        project,
        "location",
        location,
        "firewall_endpoint_association",
        firewallEndpointAssociation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      FirewallEndpointAssociationName that = ((FirewallEndpointAssociationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.firewallEndpointAssociation, that.firewallEndpointAssociation);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(firewallEndpointAssociation);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/firewallEndpointAssociations/{firewall_endpoint_association}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String firewallEndpointAssociation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getFirewallEndpointAssociation() {
      return firewallEndpointAssociation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setFirewallEndpointAssociation(String firewallEndpointAssociation) {
      this.firewallEndpointAssociation = firewallEndpointAssociation;
      return this;
    }

    private Builder(FirewallEndpointAssociationName firewallEndpointAssociationName) {
      this.project = firewallEndpointAssociationName.project;
      this.location = firewallEndpointAssociationName.location;
      this.firewallEndpointAssociation =
          firewallEndpointAssociationName.firewallEndpointAssociation;
    }

    public FirewallEndpointAssociationName build() {
      return new FirewallEndpointAssociationName(this);
    }
  }
}
