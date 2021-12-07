/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.bigtable.admin.v2.models.StorageType.SSD;

import com.google.api.core.InternalApi;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/**
 * Parameters for creating a new Bigtable cluster.
 *
 * <p>A cluster represents the actual Cloud Bigtable service. Each cluster belongs to a single Cloud
 * Bigtable instance. When your application sends requests to a Cloud Bigtable instance, those
 * requests are actually handled by one of the clusters in the instance.
 *
 * <p>Each cluster is located in a single zone. An instance's clusters must be in unique zones that
 * are within the same region. For example, if the first cluster is in us-east1-b, then us-east1-c
 * is a valid zone for the second cluster. For a list of zones and regions where Cloud Bigtable is
 * available, see <a href="https://cloud.google.com/bigtable/docs/locations">Cloud Bigtable
 * Locations</a>.
 *
 * <p>Examples:
 *
 * <pre>{@code
 * // Small production instance:
 * CreateClusterRequest clusterRequest = CreateClusterRequest.of("my-existing-instance", "my-cluster")
 *   .setZone("us-east1-c")
 *   .setServeNodes(3)
 *   .setStorageType(StorageType.SSD);
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/bigtable/docs/instances-clusters-nodes#clusters">For more
 *     details</a>
 */
public final class CreateClusterRequest {

  private final com.google.bigtable.admin.v2.CreateClusterRequest.Builder proto =
      com.google.bigtable.admin.v2.CreateClusterRequest.newBuilder();
  // instanceId and zone are short ids, which will be expanded to full names when the project name
  // is passed to toProto
  private final String instanceId;
  private String zone;

  /**
   * Builds a new request to create a new cluster to the specified instance with the specified
   * cluster id.
   */
  public static CreateClusterRequest of(String instanceId, String clusterId) {
    return new CreateClusterRequest(instanceId, clusterId);
  }

  private CreateClusterRequest(String instanceId, String clusterId) {
    this.instanceId = instanceId;
    proto.setClusterId(clusterId);
    proto.getClusterBuilder().setDefaultStorageType(SSD.toProto());
  }

  /**
   * Sets the zone where the new cluster will be located. Must be different from the existing
   * cluster.
   */
  @SuppressWarnings("WeakerAccess")
  public CreateClusterRequest setZone(String zone) {
    this.zone = zone;
    return this;
  }

  /**
   * Sets the number of nodes allocated to this cluster. More nodes enable higher throughput and
   * more consistent performance.
   *
   * @deprecated Please use CreateClusterRequest#setScalingMode instead
   */
  @SuppressWarnings("WeakerAccess")
  @Deprecated
  public CreateClusterRequest setServeNodes(int numNodes) {
    proto.getClusterBuilder().setServeNodes(numNodes);
    return this;
  }

  /**
   * Sets the scaling node to manual and sets the number of nodes allocated to this cluster. More
   * nodes enable higher throughput and more consistent performance.
   */
  public CreateClusterRequest setScalingMode(@Nonnull StaticClusterSize staticClusterSize) {
    Preconditions.checkState(staticClusterSize.getClusterSize() > 0, "Serve nodes must be > 0");
    if (proto.getCluster().getClusterConfig().hasClusterAutoscalingConfig()) {
      throw new IllegalArgumentException(
          "Autoscaling is already set. To enable manual scaling, do not set the max nodes, min nodes, and CPU percentage.");
    }
    proto.getClusterBuilder().setServeNodes(staticClusterSize.getClusterSize());
    return this;
  }

  /**
   * Sets the scaling mode to autoscaling by accepting an AutoscalingConfig where min nodes, max
   * nodes, and CPU utlization percent target are set.
   */
  public CreateClusterRequest setScalingMode(@Nonnull ClusterAutoscalingConfig autoscalingConfig) {
    int minNodes = autoscalingConfig.getMinNodes();
    int maxNodes = autoscalingConfig.getMaxNodes();
    int cpuTargetPercent = autoscalingConfig.getCpuUtilizationTargetPercent();

    proto
        .getClusterBuilder()
        .getClusterConfigBuilder()
        .getClusterAutoscalingConfigBuilder()
        .getAutoscalingLimitsBuilder()
        .setMinServeNodes(minNodes);
    proto
        .getClusterBuilder()
        .getClusterConfigBuilder()
        .getClusterAutoscalingConfigBuilder()
        .getAutoscalingLimitsBuilder()
        .setMaxServeNodes(maxNodes);
    proto
        .getClusterBuilder()
        .getClusterConfigBuilder()
        .getClusterAutoscalingConfigBuilder()
        .getAutoscalingTargetsBuilder()
        .setCpuUtilizationPercent(cpuTargetPercent);
    return this;
  }

  /**
   * Sets the type of storage used by this cluster to serve its parent instance's tables. Defaults
   * to {@code SSD}.
   */
  @SuppressWarnings("WeakerAccess")
  public CreateClusterRequest setStorageType(@Nonnull StorageType storageType) {
    Preconditions.checkNotNull(storageType);
    Preconditions.checkArgument(
        storageType != StorageType.UNRECOGNIZED, "StorageType can't be UNRECOGNIZED");

    proto.getClusterBuilder().setDefaultStorageType(storageType.toProto());
    return this;
  }

  /**
   * Sets the Google Cloud Key Management Service (KMS) key for a CMEK-protected Bigtable. This
   * requires the full resource name of the Cloud KMS key, in the format
   * `projects/{key_project_id}/locations/{location}/keyRings/{ring_name}/cryptoKeys/{key_name}`
   */
  public CreateClusterRequest setKmsKeyName(@Nonnull String kmsKeyName) {
    Preconditions.checkNotNull(kmsKeyName);
    proto.getClusterBuilder().getEncryptionConfigBuilder().setKmsKeyName(kmsKeyName);
    return this;
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.CreateClusterRequest toProto(String projectId) {
    proto.setParent(NameUtil.formatInstanceName(projectId, instanceId));
    proto.getClusterBuilder().setLocation(NameUtil.formatLocationName(projectId, zone));

    return proto.build();
  }

  /**
   * Gets the clusterId. This method is meant to be used by {@link CreateClusterRequest} and is
   * considered an internal implementation detail and not meant to be used by applications.
   *
   * <p>This method is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  String getClusterId() {
    return proto.getClusterId();
  }

  /**
   * Creates the request protobuf to be used in {@link CreateInstanceRequest}. This method is
   * considered an internal implementation detail and not meant to be used by applications.
   *
   * <p>This method is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  com.google.bigtable.admin.v2.Cluster toEmbeddedProto(String projectId) {
    proto.getClusterBuilder().setLocation(NameUtil.formatLocationName(projectId, zone));

    return proto.getClusterBuilder().build();
  }
}
