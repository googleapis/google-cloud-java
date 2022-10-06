/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.gkemulticloud.v1;

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
public class AzureClusterName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AZURE_CLUSTER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/azureClusters/{azure_cluster}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String azureCluster;

  @Deprecated
  protected AzureClusterName() {
    project = null;
    location = null;
    azureCluster = null;
  }

  private AzureClusterName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    azureCluster = Preconditions.checkNotNull(builder.getAzureCluster());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAzureCluster() {
    return azureCluster;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AzureClusterName of(String project, String location, String azureCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAzureCluster(azureCluster)
        .build();
  }

  public static String format(String project, String location, String azureCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAzureCluster(azureCluster)
        .build()
        .toString();
  }

  public static AzureClusterName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AZURE_CLUSTER.validatedMatch(
            formattedString, "AzureClusterName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("azure_cluster"));
  }

  public static List<AzureClusterName> parseList(List<String> formattedStrings) {
    List<AzureClusterName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AzureClusterName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AzureClusterName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AZURE_CLUSTER.matches(formattedString);
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
          if (azureCluster != null) {
            fieldMapBuilder.put("azure_cluster", azureCluster);
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
    return PROJECT_LOCATION_AZURE_CLUSTER.instantiate(
        "project", project, "location", location, "azure_cluster", azureCluster);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AzureClusterName that = ((AzureClusterName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.azureCluster, that.azureCluster);
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
    h ^= Objects.hashCode(azureCluster);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/azureClusters/{azure_cluster}. */
  public static class Builder {
    private String project;
    private String location;
    private String azureCluster;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAzureCluster() {
      return azureCluster;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAzureCluster(String azureCluster) {
      this.azureCluster = azureCluster;
      return this;
    }

    private Builder(AzureClusterName azureClusterName) {
      this.project = azureClusterName.project;
      this.location = azureClusterName.location;
      this.azureCluster = azureClusterName.azureCluster;
    }

    public AzureClusterName build() {
      return new AzureClusterName(this);
    }
  }
}
