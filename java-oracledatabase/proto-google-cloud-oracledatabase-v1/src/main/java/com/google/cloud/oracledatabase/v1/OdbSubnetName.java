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

package com.google.cloud.oracledatabase.v1;

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
public class OdbSubnetName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ODB_NETWORK_ODB_SUBNET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/odbNetworks/{odb_network}/odbSubnets/{odb_subnet}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String odbNetwork;
  private final String odbSubnet;

  @Deprecated
  protected OdbSubnetName() {
    project = null;
    location = null;
    odbNetwork = null;
    odbSubnet = null;
  }

  private OdbSubnetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    odbNetwork = Preconditions.checkNotNull(builder.getOdbNetwork());
    odbSubnet = Preconditions.checkNotNull(builder.getOdbSubnet());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getOdbNetwork() {
    return odbNetwork;
  }

  public String getOdbSubnet() {
    return odbSubnet;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OdbSubnetName of(
      String project, String location, String odbNetwork, String odbSubnet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOdbNetwork(odbNetwork)
        .setOdbSubnet(odbSubnet)
        .build();
  }

  public static String format(
      String project, String location, String odbNetwork, String odbSubnet) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOdbNetwork(odbNetwork)
        .setOdbSubnet(odbSubnet)
        .build()
        .toString();
  }

  public static OdbSubnetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ODB_NETWORK_ODB_SUBNET.validatedMatch(
            formattedString, "OdbSubnetName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("odb_network"),
        matchMap.get("odb_subnet"));
  }

  public static List<OdbSubnetName> parseList(List<String> formattedStrings) {
    List<OdbSubnetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OdbSubnetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OdbSubnetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ODB_NETWORK_ODB_SUBNET.matches(formattedString);
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
          if (odbNetwork != null) {
            fieldMapBuilder.put("odb_network", odbNetwork);
          }
          if (odbSubnet != null) {
            fieldMapBuilder.put("odb_subnet", odbSubnet);
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
    return PROJECT_LOCATION_ODB_NETWORK_ODB_SUBNET.instantiate(
        "project",
        project,
        "location",
        location,
        "odb_network",
        odbNetwork,
        "odb_subnet",
        odbSubnet);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OdbSubnetName that = ((OdbSubnetName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.odbNetwork, that.odbNetwork)
          && Objects.equals(this.odbSubnet, that.odbSubnet);
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
    h ^= Objects.hashCode(odbNetwork);
    h *= 1000003;
    h ^= Objects.hashCode(odbSubnet);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/odbNetworks/{odb_network}/odbSubnets/{odb_subnet}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String odbNetwork;
    private String odbSubnet;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getOdbNetwork() {
      return odbNetwork;
    }

    public String getOdbSubnet() {
      return odbSubnet;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setOdbNetwork(String odbNetwork) {
      this.odbNetwork = odbNetwork;
      return this;
    }

    public Builder setOdbSubnet(String odbSubnet) {
      this.odbSubnet = odbSubnet;
      return this;
    }

    private Builder(OdbSubnetName odbSubnetName) {
      this.project = odbSubnetName.project;
      this.location = odbSubnetName.location;
      this.odbNetwork = odbSubnetName.odbNetwork;
      this.odbSubnet = odbSubnetName.odbSubnet;
    }

    public OdbSubnetName build() {
      return new OdbSubnetName(this);
    }
  }
}
