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
import com.google.bigtable.admin.v2.ClusterName;
import com.google.bigtable.admin.v2.LocationName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import javax.annotation.Nonnull;

/**
 * A cluster represents the actual Cloud Bigtable service. Each cluster belongs to a single Cloud
 * Bigtable instance, and an instance can have up to 2 clusters. When your application sends
 * requests to a Cloud Bigtable instance, those requests are actually handled by one of the clusters
 * in the instance.
 */
public class Cluster {

  public enum State {
    /** The state of the cluster could not be determined. */
    NOT_KNOWN(com.google.bigtable.admin.v2.Cluster.State.STATE_NOT_KNOWN),
    /** The cluster has been successfully created and is ready to serve requests. */
    READY(com.google.bigtable.admin.v2.Cluster.State.READY),
    /**
     * The cluster is currently being created, and may be destroyed if the creation process
     * encounters an error. A cluster may not be able to serve requests while being created.
     */
    CREATING(com.google.bigtable.admin.v2.Cluster.State.CREATING),
    /**
     * The cluster is currently being resized, and may revert to its previous node count if the
     * process encounters an error. A cluster is still capable of serving requests while being
     * resized, but may exhibit performance as if its number of allocated nodes is between the
     * starting and requested states.
     */
    RESIZING(com.google.bigtable.admin.v2.Cluster.State.RESIZING),
    /**
     * The cluster has no backing nodes. The data (tables) still exist, but no operations can be
     * performed on the cluster.
     */
    DISABLED(com.google.bigtable.admin.v2.Cluster.State.DISABLED),
    /** The state of the cluster is not known by this client. Please upgrade your client. */
    UNRECOGNIZED(com.google.bigtable.admin.v2.Cluster.State.UNRECOGNIZED);

    private final com.google.bigtable.admin.v2.Cluster.State proto;

    /**
     * Wraps the protobuf. This method is considered an internal implementation detail and not meant
     * to be used by applications.
     */
    @InternalApi
    public static State fromProto(com.google.bigtable.admin.v2.Cluster.State proto) {
      for (State state : values()) {
        if (state.proto.equals(proto)) {
          return state;
        }
      }
      return UNRECOGNIZED;
    }

    State(com.google.bigtable.admin.v2.Cluster.State proto) {
      this.proto = proto;
    }

    /**
     * Creates the request protobuf. This method is considered an internal implementation detail and
     * not meant to be used by applications.
     */
    @InternalApi
    public com.google.bigtable.admin.v2.Cluster.State toProto() {
      return proto;
    }
  }

  @Nonnull private final com.google.bigtable.admin.v2.Cluster stateProto;

  /**
   * Wraps a protobuf response.
   *
   * <p>This method is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  public static Cluster fromProto(com.google.bigtable.admin.v2.Cluster proto) {
    return new Cluster(proto);
  }

  private Cluster(@Nonnull com.google.bigtable.admin.v2.Cluster proto) {
    Preconditions.checkNotNull(proto);
    Preconditions.checkArgument(!proto.getName().isEmpty(), "Name must be set");
    this.stateProto = proto;
  }

  /** Gets the cluster's id. */
  @SuppressWarnings("WeakerAccess")
  public String getId() {
    // Constructor ensures that name is not null
    ClusterName fullName =
        Verify.verifyNotNull(ClusterName.parse(stateProto.getName()), "Name can never be null");
    //noinspection ConstantConditions
    return fullName.getCluster();
  }

  /** Gets the instance id. */
  @SuppressWarnings("WeakerAccess")
  public String getInstanceId() {
    // Constructor ensures that name is not null
    ClusterName fullName =
        Verify.verifyNotNull(ClusterName.parse(stateProto.getName()), "Name can never be null");
    //noinspection ConstantConditions
    return fullName.getInstance();
  }

  /** Get the zone where this cluster is located. */
  @SuppressWarnings("WeakerAccess")
  public String getZone() {
    LocationName location = Verify.verifyNotNull(LocationName.parse(stateProto.getLocation()));
    //noinspection ConstantConditions
    return location.getLocation();
  }

  /** Gets the current state of the cluster */
  @SuppressWarnings("WeakerAccess")
  public State getState() {
    return State.fromProto(stateProto.getState());
  }

  /**
   * Get the number of nodes allocated to this cluster. More nodes enable higher throughput and more
   * consistent performance.
   */
  @SuppressWarnings("WeakerAccess")
  public int getServeNodes() {
    return stateProto.getServeNodes();
  }

  /**
   * The type of storage used by this cluster to serve its parent instance's tables, unless
   * explicitly overridden.
   */
  @SuppressWarnings("WeakerAccess")
  public StorageType getStorageType() {
    return StorageType.fromProto(stateProto.getDefaultStorageType());
  }

  /**
   * Google Cloud Key Management Service (KMS) settings for a CMEK-protected Bigtable cluster. This
   * returns the full resource name of the Cloud KMS key in the format
   * `projects/{key_project_id}/locations/{location}/keyRings/{ring_name}/cryptoKeys/{key_name}`
   */
  public String getKmsKeyName() {
    if (stateProto.hasEncryptionConfig()) {
      return stateProto.getEncryptionConfig().getKmsKeyName();
    }
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cluster cluster = (Cluster) o;
    return Objects.equal(stateProto, cluster.stateProto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(stateProto);
  }
}
