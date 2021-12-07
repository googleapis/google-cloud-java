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

import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.cloud.bigtable.admin.v2.internal.NameUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Parameters for creating a new Bigtable Instance.
 *
 * <p>A Cloud Bigtable instance is mostly just a container for your clusters and nodes, which do all
 * of the real work. Instances come in 2 flavors:
 *
 * <dl>
 *   <dt>Production
 *   <dd>A standard instance with either 1 or 2 clusters, as well as 3 or more nodes in each
 *       cluster. You cannot downgrade a production instance to a development instance.
 *   <dt>Development
 *   <dd>A low-cost instance for development and testing, with performance limited to the equivalent
 *       of a 1-node cluster. Development instances only support a single 1 node cluster. At any
 *       point this can be upgraded to a production instance.
 * </dl>
 *
 * When creating an Instance, you must create at least one cluster in it.
 *
 * <p>Examples:
 *
 * <pre>{@code
 * // Small production instance:
 * CreateInstanceRequest smallProdInstanceRequest = CreateInstanceRequest.of("my-small-instance")
 *   .addCluster("cluster1", "us-east1-c", 3, StorageType.SSD);
 *
 * // Development instance:
 * CreateInstanceRequest smallProdInstanceRequest = CreateInstanceRequest.of("my-dev-instance")
 *   .setType(Type.DEVELOPMENT)
 *   .addDevelopmentCluster("cluster1", "us-east1-c", StorageType.SSD);
 *
 * }</pre>
 *
 * @see <a href="https://cloud.google.com/bigtable/docs/instances-clusters-nodes#instances">For more
 *     details</a>
 */
public final class CreateInstanceRequest {
  private final com.google.bigtable.admin.v2.CreateInstanceRequest.Builder builder =
      com.google.bigtable.admin.v2.CreateInstanceRequest.newBuilder();

  private final List<CreateClusterRequest> clusterRequests = Lists.newArrayList();

  /** Builds a new request to create a new instance with the specified id. */
  public static CreateInstanceRequest of(@Nonnull String instanceId) {
    return new CreateInstanceRequest(instanceId);
  }

  private CreateInstanceRequest(@Nonnull String instanceId) {
    Preconditions.checkNotNull(instanceId, "InstanceId can't be null");

    builder.setInstanceId(instanceId);
    builder.getInstanceBuilder().setDisplayName(instanceId);
    builder.getInstanceBuilder().setType(Type.PRODUCTION);
  }

  /**
   * Sets the friendly display name of the instance. If left unspecified, it will default to the id
   */
  @SuppressWarnings("WeakerAccess")
  public CreateInstanceRequest setDisplayName(@Nonnull String displayName) {
    Preconditions.checkNotNull(displayName);
    builder.getInstanceBuilder().setDisplayName(displayName);
    return this;
  }

  /**
   * Sets the type of instance.
   *
   * <p>Can be either DEVELOPMENT or PRODUCTION. Defaults to PRODUCTION. Please see class javadoc
   * for details.
   */
  @SuppressWarnings("WeakerAccess")
  public CreateInstanceRequest setType(@Nonnull Instance.Type type) {
    Preconditions.checkNotNull(type);
    Preconditions.checkArgument(type != Instance.Type.UNRECOGNIZED, "Type is unrecognized");
    builder.getInstanceBuilder().setType(type.toProto());
    return this;
  }

  /**
   * Adds an arbitrary label to the instance.
   *
   * <p>Labels are key-value pairs that you can use to group related instances and store metadata
   * about an instance.
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/creating-managing-labels">For more
   *     details</a>
   */
  @SuppressWarnings("WeakerAccess")
  public CreateInstanceRequest addLabel(@Nonnull String key, @Nonnull String value) {
    Preconditions.checkNotNull(key, "Key can't be null");
    Preconditions.checkNotNull(value, "Value can't be null");
    builder.getInstanceBuilder().putLabels(key, value);
    return this;
  }

  /**
   * Adds a cluster to the instance request with manual scaling enabled.
   *
   * <p>All new instances must have at least one cluster. DEVELOPMENT instances must have exactly
   * one cluster.
   *
   * @param clusterId the name of the cluster.
   * @param zone the zone where the cluster will be created.
   * @param serveNodes the number of nodes that cluster will contain. DEVELOPMENT instance clusters
   *     must have exactly one node.
   * @param storageType the type of storage used by this cluster to serve its parent instance's
   *     tables.
   */
  @SuppressWarnings("WeakerAccess")
  public CreateInstanceRequest addCluster(
      @Nonnull String clusterId,
      @Nonnull String zone,
      int serveNodes,
      @Nonnull StorageType storageType) {
    CreateClusterRequest clusterRequest =
        CreateClusterRequest.of("ignored-instance-id", clusterId)
            .setZone(zone)
            .setServeNodes(serveNodes)
            .setStorageType(storageType);
    clusterRequests.add(clusterRequest);

    return this;
  }

  /**
   * Adds a cluster to the instance request with autoscaling enabled.
   *
   * <p>All new instances must have at least one cluster. DEVELOPMENT instances must have exactly
   * one cluster.
   *
   * @param clusterId the name of the cluster.
   * @param zone the zone where the cluster will be created.
   * @param clusterAutoscalingConfig the autoscaling config that sets the min serve nodes, max serve
   *     nodes, and CPU utilization percentage
   * @param storageType the type of storage used by this cluster to serve its parent instance's
   *     tables.
   */
  public CreateInstanceRequest addCluster(
      @Nonnull String clusterId,
      @Nonnull String zone,
      @Nonnull ClusterAutoscalingConfig clusterAutoscalingConfig,
      @Nonnull StorageType storageType) {
    CreateClusterRequest clusterRequest =
        CreateClusterRequest.of("ignored-instance-id", clusterId)
            .setZone(zone)
            .setScalingMode(clusterAutoscalingConfig)
            .setStorageType(storageType);
    clusterRequests.add(clusterRequest);

    return this;
  }

  /**
   * Adds a CMEK protected cluster using the specified KMS key name.
   *
   * @param clusterId the name of the cluster.
   * @param zone the zone where the cluster will be created.
   * @param serveNodes the number of nodes that cluster will contain. DEVELOPMENT instance clusters
   *     must have exactly one node.
   * @param storageType the type of storage used by this cluster to serve its parent instance's
   *     tables.
   * @param kmsKeyName the full name of the KMS key name to use in the format
   *     `projects/{key_project_id}/locations/{location}/keyRings/{ring_name}/cryptoKeys/{key_name}`
   */
  public CreateInstanceRequest addCmekCluster(
      @Nonnull String clusterId,
      @Nonnull String zone,
      int serveNodes,
      @Nonnull StorageType storageType,
      @Nonnull String kmsKeyName) {
    CreateClusterRequest clusterRequest =
        CreateClusterRequest.of("ignored-instance-id", clusterId)
            .setZone(zone)
            .setServeNodes(serveNodes)
            .setStorageType(storageType)
            .setKmsKeyName(kmsKeyName);
    clusterRequests.add(clusterRequest);

    return this;
  }

  /**
   * Adds a DEVELOPMENT cluster to the instance request.
   *
   * <p>This instance will have exactly one node cluster.
   *
   * @param clusterId the name of the cluster.
   * @param zone the zone where the cluster will be created.
   * @param storageType the type of storage used by this cluster to serve its parent instance's
   *     tables.
   */
  @SuppressWarnings("WeakerAccess")
  public CreateInstanceRequest addDevelopmentCluster(
      @Nonnull String clusterId, @Nonnull String zone, @Nonnull StorageType storageType) {
    CreateClusterRequest developmentCluster =
        CreateClusterRequest.of("ignored-instance-id", clusterId)
            .setZone(zone)
            .setStorageType(storageType);
    clusterRequests.add(developmentCluster);

    return this;
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.CreateInstanceRequest toProto(String projectId) {
    builder.setParent(NameUtil.formatProjectName(projectId)).clearClusters();

    for (CreateClusterRequest clusterRequest : clusterRequests) {
      builder.putClusters(clusterRequest.getClusterId(), clusterRequest.toEmbeddedProto(projectId));
    }

    return builder.build();
  }
}
