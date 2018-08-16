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

import com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState;
import com.google.common.base.MoreObjects;

// TODO(igorbernstein2): remove this class and promote Replication State to Table.
/** Wrapper for {@link ClusterState} protocol buffer object */
public final class ClusterState {
  private final String id;
  private final ReplicationState replicationState;

  public static ClusterState fromProto(String clusterId, com.google.bigtable.admin.v2.Table.ClusterState proto) {
    return new ClusterState(clusterId, proto.getReplicationState());
  }

  private ClusterState(String id, ReplicationState replicationState) {
    this.id = id;
    this.replicationState = replicationState;
  }

  /**
   * Gets the cluster Id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the ReplicationState of this cluster
   */
  public ReplicationState getReplicationState() {
    return replicationState;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("replicationState", replicationState)
        .toString();
  }
}
