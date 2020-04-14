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
import com.google.bigtable.admin.v2.TableName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nonnull;

/** Wrapper for {@link Table} protocol buffer object */
public final class Table {
  public enum ReplicationState {
    /** The replication state of the table is unknown in this cluster. */
    NOT_KNOWN(com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.STATE_NOT_KNOWN),
    /**
     * The cluster was recently created, and the table must finish copying over pre-existing data
     * from other clusters before it can begin receiving live replication updates and serving Data
     * API requests.
     */
    INITIALIZING(com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.INITIALIZING),
    /**
     * The table is temporarily unable to serve Data API requests from this cluster due to planned
     * internal maintenance.
     */
    PLANNED_MAINTENANCE(
        com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.PLANNED_MAINTENANCE),
    /**
     * The table is temporarily unable to serve Data API requests from this cluster due to unplanned
     * or emergency maintenance.
     */
    UNPLANNED_MAINTENANCE(
        com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.UNPLANNED_MAINTENANCE),
    /**
     * The table can serve Data API requests from this cluster. Depending on replication delay,
     * reads may not immediately reflect the state of the table in other clusters.
     */
    READY(com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.READY),

    /**
     * The table is fully created and ready for use after a restore, and is being optimized for
     * performance. When optimizations are complete, the table will transition to `READY` state.
     */
    READY_OPTIMIZING(
        com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.READY_OPTIMIZING),

    /** The replication state of table is not known by this client. Please upgrade your client. */
    UNRECOGNIZED(com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState.UNRECOGNIZED);

    private final com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState proto;

    /**
     * Wraps the protobuf. This method is considered an internal implementation detail and not meant
     * to be used by applications.
     */
    @InternalApi
    public static ReplicationState fromProto(
        com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState proto) {
      Preconditions.checkNotNull(proto);

      for (ReplicationState state : values()) {
        if (state.proto.equals(proto)) {
          return state;
        }
      }
      return UNRECOGNIZED;
    }

    ReplicationState(com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState proto) {
      this.proto = proto;
    }

    /**
     * Creates the request protobuf. This method is considered an internal implementation detail and
     * not meant to be used by applications.
     */
    @InternalApi
    public com.google.bigtable.admin.v2.Table.ClusterState.ReplicationState toProto() {
      return proto;
    }
  }

  private final String id;
  private final String instanceId;
  private final Map<String, ReplicationState> replicationStatesByClusterId;
  private final List<ColumnFamily> columnFamilies;

  @InternalApi
  public static Table fromProto(@Nonnull com.google.bigtable.admin.v2.Table proto) {
    ImmutableMap.Builder<String, ReplicationState> replicationStates = ImmutableMap.builder();

    for (Entry<String, com.google.bigtable.admin.v2.Table.ClusterState> entry :
        proto.getClusterStatesMap().entrySet()) {
      replicationStates.put(
          entry.getKey(), ReplicationState.fromProto(entry.getValue().getReplicationState()));
    }

    ImmutableList.Builder<ColumnFamily> columnFamilies = ImmutableList.builder();

    for (Entry<String, com.google.bigtable.admin.v2.ColumnFamily> entry :
        proto.getColumnFamiliesMap().entrySet()) {
      columnFamilies.add(ColumnFamily.fromProto(entry.getKey(), entry.getValue()));
    }

    return new Table(
        TableName.parse(proto.getName()), replicationStates.build(), columnFamilies.build());
  }

  private Table(
      TableName tableName,
      Map<String, ReplicationState> replicationStatesByClusterId,
      List<ColumnFamily> columnFamilies) {
    this.instanceId = tableName.getInstance();
    this.id = tableName.getTable();
    this.replicationStatesByClusterId = replicationStatesByClusterId;
    this.columnFamilies = columnFamilies;
  }

  /** Gets the table's id. */
  public String getId() {
    return id;
  }

  /** Gets the id of the instance that owns this Table. */
  public String getInstanceId() {
    return instanceId;
  }

  public Map<String, ReplicationState> getReplicationStatesByClusterId() {
    return replicationStatesByClusterId;
  }

  public List<ColumnFamily> getColumnFamilies() {
    return columnFamilies;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Table table = (Table) o;
    return Objects.equal(id, table.id)
        && Objects.equal(instanceId, table.instanceId)
        && Objects.equal(replicationStatesByClusterId, table.replicationStatesByClusterId)
        && Objects.equal(columnFamilies, table.columnFamilies);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id, instanceId, replicationStatesByClusterId, columnFamilies);
  }
}
