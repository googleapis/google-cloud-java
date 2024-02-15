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

package com.google.cloud.vmwareengine.v1;

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
public class NodeName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_PRIVATE_CLOUD_CLUSTER_NODE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/privateClouds/{private_cloud}/clusters/{cluster}/nodes/{node}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String privateCloud;
  private final String cluster;
  private final String node;

  @Deprecated
  protected NodeName() {
    project = null;
    location = null;
    privateCloud = null;
    cluster = null;
    node = null;
  }

  private NodeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    privateCloud = Preconditions.checkNotNull(builder.getPrivateCloud());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    node = Preconditions.checkNotNull(builder.getNode());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getPrivateCloud() {
    return privateCloud;
  }

  public String getCluster() {
    return cluster;
  }

  public String getNode() {
    return node;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NodeName of(
      String project, String location, String privateCloud, String cluster, String node) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateCloud(privateCloud)
        .setCluster(cluster)
        .setNode(node)
        .build();
  }

  public static String format(
      String project, String location, String privateCloud, String cluster, String node) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setPrivateCloud(privateCloud)
        .setCluster(cluster)
        .setNode(node)
        .build()
        .toString();
  }

  public static NodeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_PRIVATE_CLOUD_CLUSTER_NODE.validatedMatch(
            formattedString, "NodeName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("private_cloud"),
        matchMap.get("cluster"),
        matchMap.get("node"));
  }

  public static List<NodeName> parseList(List<String> formattedStrings) {
    List<NodeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NodeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NodeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_PRIVATE_CLOUD_CLUSTER_NODE.matches(formattedString);
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
          if (privateCloud != null) {
            fieldMapBuilder.put("private_cloud", privateCloud);
          }
          if (cluster != null) {
            fieldMapBuilder.put("cluster", cluster);
          }
          if (node != null) {
            fieldMapBuilder.put("node", node);
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
    return PROJECT_LOCATION_PRIVATE_CLOUD_CLUSTER_NODE.instantiate(
        "project",
        project,
        "location",
        location,
        "private_cloud",
        privateCloud,
        "cluster",
        cluster,
        "node",
        node);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NodeName that = ((NodeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.privateCloud, that.privateCloud)
          && Objects.equals(this.cluster, that.cluster)
          && Objects.equals(this.node, that.node);
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
    h ^= Objects.hashCode(privateCloud);
    h *= 1000003;
    h ^= Objects.hashCode(cluster);
    h *= 1000003;
    h ^= Objects.hashCode(node);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/privateClouds/{private_cloud}/clusters/{cluster}/nodes/{node}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String privateCloud;
    private String cluster;
    private String node;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPrivateCloud() {
      return privateCloud;
    }

    public String getCluster() {
      return cluster;
    }

    public String getNode() {
      return node;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPrivateCloud(String privateCloud) {
      this.privateCloud = privateCloud;
      return this;
    }

    public Builder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public Builder setNode(String node) {
      this.node = node;
      return this;
    }

    private Builder(NodeName nodeName) {
      this.project = nodeName.project;
      this.location = nodeName.location;
      this.privateCloud = nodeName.privateCloud;
      this.cluster = nodeName.cluster;
      this.node = nodeName.node;
    }

    public NodeName build() {
      return new NodeName(this);
    }
  }
}
