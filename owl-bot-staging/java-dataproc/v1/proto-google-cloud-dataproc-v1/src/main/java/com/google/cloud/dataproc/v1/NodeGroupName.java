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

package com.google.cloud.dataproc.v1;

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
public class NodeGroupName implements ResourceName {
  private static final PathTemplate PROJECT_REGION_CLUSTER_NODE_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/regions/{region}/clusters/{cluster}/nodeGroups/{node_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String region;
  private final String cluster;
  private final String nodeGroup;

  @Deprecated
  protected NodeGroupName() {
    project = null;
    region = null;
    cluster = null;
    nodeGroup = null;
  }

  private NodeGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    nodeGroup = Preconditions.checkNotNull(builder.getNodeGroup());
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  public String getCluster() {
    return cluster;
  }

  public String getNodeGroup() {
    return nodeGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NodeGroupName of(String project, String region, String cluster, String nodeGroup) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .setNodeGroup(nodeGroup)
        .build();
  }

  public static String format(String project, String region, String cluster, String nodeGroup) {
    return newBuilder()
        .setProject(project)
        .setRegion(region)
        .setCluster(cluster)
        .setNodeGroup(nodeGroup)
        .build()
        .toString();
  }

  public static NodeGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_REGION_CLUSTER_NODE_GROUP.validatedMatch(
            formattedString, "NodeGroupName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("region"),
        matchMap.get("cluster"),
        matchMap.get("node_group"));
  }

  public static List<NodeGroupName> parseList(List<String> formattedStrings) {
    List<NodeGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NodeGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NodeGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_REGION_CLUSTER_NODE_GROUP.matches(formattedString);
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
          if (region != null) {
            fieldMapBuilder.put("region", region);
          }
          if (cluster != null) {
            fieldMapBuilder.put("cluster", cluster);
          }
          if (nodeGroup != null) {
            fieldMapBuilder.put("node_group", nodeGroup);
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
    return PROJECT_REGION_CLUSTER_NODE_GROUP.instantiate(
        "project", project, "region", region, "cluster", cluster, "node_group", nodeGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      NodeGroupName that = ((NodeGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.region, that.region)
          && Objects.equals(this.cluster, that.cluster)
          && Objects.equals(this.nodeGroup, that.nodeGroup);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(region);
    h *= 1000003;
    h ^= Objects.hashCode(cluster);
    h *= 1000003;
    h ^= Objects.hashCode(nodeGroup);
    return h;
  }

  /** Builder for projects/{project}/regions/{region}/clusters/{cluster}/nodeGroups/{node_group}. */
  public static class Builder {
    private String project;
    private String region;
    private String cluster;
    private String nodeGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getRegion() {
      return region;
    }

    public String getCluster() {
      return cluster;
    }

    public String getNodeGroup() {
      return nodeGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public Builder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public Builder setNodeGroup(String nodeGroup) {
      this.nodeGroup = nodeGroup;
      return this;
    }

    private Builder(NodeGroupName nodeGroupName) {
      this.project = nodeGroupName.project;
      this.region = nodeGroupName.region;
      this.cluster = nodeGroupName.cluster;
      this.nodeGroup = nodeGroupName.nodeGroup;
    }

    public NodeGroupName build() {
      return new NodeGroupName(this);
    }
  }
}
