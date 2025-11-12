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
public class OdbNetworkName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ODB_NETWORK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/odbNetworks/{odb_network}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String odbNetwork;

  @Deprecated
  protected OdbNetworkName() {
    project = null;
    location = null;
    odbNetwork = null;
  }

  private OdbNetworkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    odbNetwork = Preconditions.checkNotNull(builder.getOdbNetwork());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OdbNetworkName of(String project, String location, String odbNetwork) {
    return newBuilder().setProject(project).setLocation(location).setOdbNetwork(odbNetwork).build();
  }

  public static String format(String project, String location, String odbNetwork) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setOdbNetwork(odbNetwork)
        .build()
        .toString();
  }

  public static OdbNetworkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ODB_NETWORK.validatedMatch(
            formattedString, "OdbNetworkName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("odb_network"));
  }

  public static List<OdbNetworkName> parseList(List<String> formattedStrings) {
    List<OdbNetworkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OdbNetworkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OdbNetworkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ODB_NETWORK.matches(formattedString);
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
    return PROJECT_LOCATION_ODB_NETWORK.instantiate(
        "project", project, "location", location, "odb_network", odbNetwork);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OdbNetworkName that = ((OdbNetworkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.odbNetwork, that.odbNetwork);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/odbNetworks/{odb_network}. */
  public static class Builder {
    private String project;
    private String location;
    private String odbNetwork;

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

    private Builder(OdbNetworkName odbNetworkName) {
      this.project = odbNetworkName.project;
      this.location = odbNetworkName.location;
      this.odbNetwork = odbNetworkName.odbNetwork;
    }

    public OdbNetworkName build() {
      return new OdbNetworkName(this);
    }
  }
}
