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
public class AzureNodePoolName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AZURE_CLUSTER_AZURE_NODE_POOL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/azureClusters/{azure_cluster}/azureNodePools/{azure_node_pool}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String azureCluster;
  private final String azureNodePool;

  @Deprecated
  protected AzureNodePoolName() {
    project = null;
    location = null;
    azureCluster = null;
    azureNodePool = null;
  }

  private AzureNodePoolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    azureCluster = Preconditions.checkNotNull(builder.getAzureCluster());
    azureNodePool = Preconditions.checkNotNull(builder.getAzureNodePool());
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

  public String getAzureNodePool() {
    return azureNodePool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AzureNodePoolName of(
      String project, String location, String azureCluster, String azureNodePool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAzureCluster(azureCluster)
        .setAzureNodePool(azureNodePool)
        .build();
  }

  public static String format(
      String project, String location, String azureCluster, String azureNodePool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAzureCluster(azureCluster)
        .setAzureNodePool(azureNodePool)
        .build()
        .toString();
  }

  public static AzureNodePoolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AZURE_CLUSTER_AZURE_NODE_POOL.validatedMatch(
            formattedString, "AzureNodePoolName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("azure_cluster"),
        matchMap.get("azure_node_pool"));
  }

  public static List<AzureNodePoolName> parseList(List<String> formattedStrings) {
    List<AzureNodePoolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AzureNodePoolName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AzureNodePoolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AZURE_CLUSTER_AZURE_NODE_POOL.matches(formattedString);
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
          if (azureNodePool != null) {
            fieldMapBuilder.put("azure_node_pool", azureNodePool);
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
    return PROJECT_LOCATION_AZURE_CLUSTER_AZURE_NODE_POOL.instantiate(
        "project",
        project,
        "location",
        location,
        "azure_cluster",
        azureCluster,
        "azure_node_pool",
        azureNodePool);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AzureNodePoolName that = ((AzureNodePoolName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.azureCluster, that.azureCluster)
          && Objects.equals(this.azureNodePool, that.azureNodePool);
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
    h *= 1000003;
    h ^= Objects.hashCode(azureNodePool);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/azureClusters/{azure_cluster}/azureNodePools/{azure_node_pool}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String azureCluster;
    private String azureNodePool;

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

    public String getAzureNodePool() {
      return azureNodePool;
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

    public Builder setAzureNodePool(String azureNodePool) {
      this.azureNodePool = azureNodePool;
      return this;
    }

    private Builder(AzureNodePoolName azureNodePoolName) {
      this.project = azureNodePoolName.project;
      this.location = azureNodePoolName.location;
      this.azureCluster = azureNodePoolName.azureCluster;
      this.azureNodePool = azureNodePoolName.azureNodePool;
    }

    public AzureNodePoolName build() {
      return new AzureNodePoolName(this);
    }
  }
}
