/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2.models;

import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.Cluster;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.protobuf.util.FieldMaskUtil;
import javax.annotation.Nonnull;

/**
 * Model class to create an autoscaling config for creating or updating a cluster. When creating
 * this config, min nodes, max nodes, and CPU utilization must all be set.
 */
public class ClusterAutoscalingConfig {
  private final String clusterId;
  private final String instanceId;
  private final com.google.bigtable.admin.v2.PartialUpdateClusterRequest.Builder builder =
      com.google.bigtable.admin.v2.PartialUpdateClusterRequest.newBuilder();
  private final com.google.bigtable.admin.v2.Cluster.ClusterConfig.Builder clusterConfigBuilder =
      com.google.bigtable.admin.v2.Cluster.ClusterConfig.newBuilder();

  public static ClusterAutoscalingConfig of(@Nonnull String instanceId, @Nonnull String clusterId) {
    return new ClusterAutoscalingConfig(instanceId, clusterId);
  }

  private ClusterAutoscalingConfig(@Nonnull String instanceId, @Nonnull String clusterId) {
    Preconditions.checkNotNull(instanceId, "instanceId can't be null");
    Preconditions.checkNotNull(clusterId, "clusterId can't be null");
    this.instanceId = instanceId;
    this.clusterId = clusterId;
  }

  /** The cluster id to set autoscaling on */
  public String getClusterId() {
    return clusterId;
  }

  /** The instance id of the cluster to set autoscaling on */
  public String getInstanceId() {
    return instanceId;
  }

  /** Set the minimum number of nodes to scale down to. */
  public ClusterAutoscalingConfig setMinNodes(int minNodes) {
    builder.setUpdateMask(
        FieldMaskUtil.union(
            builder.getUpdateMask(),
            FieldMaskUtil.fromString(
                Cluster.class,
                "cluster_config.cluster_autoscaling_config.autoscaling_limits.min_serve_nodes")));
    clusterConfigBuilder
        .getClusterAutoscalingConfigBuilder()
        .getAutoscalingLimitsBuilder()
        .setMinServeNodes(minNodes);
    return this;
  }

  /** Set the maximum number of nodes to scale up to. */
  public ClusterAutoscalingConfig setMaxNodes(int maxNodes) {
    builder.setUpdateMask(
        FieldMaskUtil.union(
            builder.getUpdateMask(),
            FieldMaskUtil.fromString(
                Cluster.class,
                "cluster_config.cluster_autoscaling_config.autoscaling_limits.max_serve_nodes")));
    clusterConfigBuilder
        .getClusterAutoscalingConfigBuilder()
        .getAutoscalingLimitsBuilder()
        .setMaxServeNodes(maxNodes);
    return this;
  }

  /**
   * Set the CPU utilization that the Autoscaler should be trying to achieve. This number is on a
   * scale from 0 (no utilization) to 100 (total utilization).
   */
  public ClusterAutoscalingConfig setCpuUtilizationTargetPercent(int cpuUtilizationTargetPercent) {
    builder.setUpdateMask(
        FieldMaskUtil.union(
            builder.getUpdateMask(),
            FieldMaskUtil.fromString(
                Cluster.class,
                "cluster_config.cluster_autoscaling_config.autoscaling_targets.cpu_utilization_percent")));
    clusterConfigBuilder
        .getClusterAutoscalingConfigBuilder()
        .getAutoscalingTargetsBuilder()
        .setCpuUtilizationPercent(cpuUtilizationTargetPercent);
    return this;
  }

  /** Get the minimum number of nodes to scale down to. */
  public int getMinNodes() {
    return clusterConfigBuilder
        .getClusterAutoscalingConfig()
        .getAutoscalingLimits()
        .getMinServeNodes();
  }

  /** Get the maximum number of nodes to scale up to. */
  public int getMaxNodes() {
    return clusterConfigBuilder
        .getClusterAutoscalingConfig()
        .getAutoscalingLimits()
        .getMaxServeNodes();
  }

  /**
   * Get the CPU utilization that the Autoscaler should be trying to achieve. This number is on a
   * scale from 0 (no utilization) to 100 (total utilization).
   */
  public int getCpuUtilizationTargetPercent() {
    return clusterConfigBuilder
        .getClusterAutoscalingConfig()
        .getAutoscalingTargets()
        .getCpuUtilizationPercent();
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.PartialUpdateClusterRequest toProto(String projectId) {
    // Empty field mask implies full resource replacement, which would clear all fields in an empty
    // update request.

    this.builder
        .getClusterBuilder()
        .setName(NameUtil.formatClusterName(projectId, instanceId, clusterId))
        .setClusterConfig(clusterConfigBuilder.build());

    return this.builder.build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClusterAutoscalingConfig that = (ClusterAutoscalingConfig) o;
    return Objects.equal(
            clusterConfigBuilder
                .getClusterAutoscalingConfig()
                .getAutoscalingLimits()
                .getMaxServeNodes(),
            that.clusterConfigBuilder
                .getClusterAutoscalingConfig()
                .getAutoscalingLimits()
                .getMaxServeNodes())
        && Objects.equal(
            clusterConfigBuilder
                .getClusterAutoscalingConfig()
                .getAutoscalingLimits()
                .getMinServeNodes(),
            that.clusterConfigBuilder
                .getClusterAutoscalingConfig()
                .getAutoscalingLimits()
                .getMinServeNodes())
        && Objects.equal(
            clusterConfigBuilder
                .getClusterAutoscalingConfig()
                .getAutoscalingTargets()
                .getCpuUtilizationPercent(),
            that.clusterConfigBuilder
                .getClusterAutoscalingConfig()
                .getAutoscalingTargets()
                .getCpuUtilizationPercent())
        && Objects.equal(clusterId, that.clusterId)
        && Objects.equal(instanceId, that.instanceId);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        clusterConfigBuilder
            .getClusterAutoscalingConfig()
            .getAutoscalingLimits()
            .getMaxServeNodes(),
        clusterConfigBuilder
            .getClusterAutoscalingConfig()
            .getAutoscalingLimits()
            .getMinServeNodes(),
        clusterConfigBuilder
            .getClusterAutoscalingConfig()
            .getAutoscalingTargets()
            .getCpuUtilizationPercent(),
        clusterId,
        instanceId);
  }
}
